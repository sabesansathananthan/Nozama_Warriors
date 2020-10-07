package Nozama_warriors;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Grid implements Observable {

    public static boolean notreached = true;
    public Node[][] node;
    TreasureChest treasureChest;
    private static final Object lock1 = new Object();                                                                   //Static lock to To avoid racing conditions
    private static final Object lock2 = new Object();                                                                   //Static lock to To avoid racing conditions

    public Grid() {
        node = new Node[11][11];
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                node[i][j] = new Node(i, j, 0);
                node[i][j].setCheckobj(false);
            }
        }
    }

    public void addInhabitant(Inhabitant inhabitant, int x, int y, int objectid, String inhabitantname) {
        if (node[x][y].isCheckobj() == false) {
            node[x][y].add(objectid, inhabitant, inhabitantname);
        }
    }

    //Function to Add New Inhabitant to node
    public void settemp(Inhabitant inhabitant, int x, int y) {
        inhabitant.setX(x);
        inhabitant.setY(y);
    }

    //Reset the coordinate to null object
    public void resetcoordinate(int x, int y) {
        if (node[x][y].getInhabitant() instanceof Warrior) {
            node[x][y].setInhabitant(null);
            node[x][y].setCheckobj(false);
            node[x][y].setObjectid(0);
        }
    }

    //getter object ID
    public int getobjID(int x, int y) {
        return node[x][y].getObjectid();
    }

    //getter Inhabitant
    public Inhabitant getinhabitant(int x, int y) {
        return node[x][y].getInhabitant();
    }

    //clear the node
    public void clearnode(int x, int y) {
        node[x][y].add(0, null, null);
    }

    //Return if any objects in the coordinate
    public boolean checkcordinate(int x, int y) {
        return node[x][y].isCheckobj();
    }

    //Return if any Warriors in the coordinate
    public boolean checkWarrior(int x, int y) {
        return node[x][y].getObjectid() == 1 || node[x][y].getObjectid() == 2;
    }

    //Return if any NormalWarrior in the coordinate
    public boolean checkNormalWarrior(int x, int y) {
        return node[x][y].getObjectid() == 2;
    }

    // Return if any SuperWarrior in the coordinate
    public boolean checkSuperWariors(int x, int y) {
        return node[x][y].getObjectid() == 1;
    }

    //Return if any Fish in the coordinate
    public boolean checkFish(int x, int y) {
        return node[x][y].getInhabitant() instanceof Fish;
    }

    //Return if any Lotus Flower in the coordinate
    public boolean checkLotus(int x, int y) {
        return node[x][y].getInhabitant() instanceof LotusFlower;
    }

    /**
     * I wrote a method move
     * this method give the statement of warriors moments.
     * @param w    is refer a warrior
     * @param oldx is the previous x axis location of the warrior
     * @param oldy is the previous y axis location of the warrior
     * @param newx is the current x axis location of the warrior
     * @param newy is the current y axis location of the warrior
     */
    public boolean move(Warrior w, int oldx, int oldy, int newx, int newy) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Warrior.class.getName()).log(Level.SEVERE, null, ex);
        }
        GameDemo.gui.paintAgain();
        MakeSound makeSoundswim = new MakeSound();
        makeSoundswim.playSound("./assets/audio/Swim.wav");
        if (checkFish(newx, newy) && (notreached)) {
            System.out.println(w.getName() + " Swims From (" + oldx + "," + oldy + ") To (" + (newx) + "," + newy + ")");
            notifyFish(((Fish) getinhabitant(newx, newy)), w);
            Warrior.immobile_warrior++;
            settemp(w, newx, newy);
            resetcoordinate(oldx, oldy);

            if ((Warrior.immobile_warrior == 4)
                    && (Warrior.immobile_supper_warrior == 2)) {
                System.out.println("Misson Failed...");
            }
            return false;
        }

        // If warrior reached 5,5
        else if ((newx == 5 && newy == 5) && (notreached)) {
            synchronized (lock1) {
                if (notreached) {
                    System.out.println(w.getName() + " Swims From (" + oldx
                            + "," + oldy + ") To (5,5)- Swam to TreasureChest\n"
                            + notifyTreasureChest(w));
                    resetcoordinate(oldx, oldy);
                    addInhabitant(w, 5, 5, 1, w.getName());
                    GameDemo.gui.paintAgain();
                    MakeSound makeSoundfinish = new MakeSound();
                    makeSoundfinish.playSound("./assets/audio/Finish.wav");
                }
                return false;
            }
        } else if ((checkLotus(newx, newy)) && (notreached) && (getinhabitant(newx, newy) instanceof NormalWarrior)) {  // If normal warrior reached in to Lotus Flower
            ((LotusFlower) getinhabitant(newx, newy)).pickPetal(w);
            System.out.println(w.getName() + " Swims From (" + oldx + ","
                    + oldy + ") To (" + (newx) + "," + (newy) + ")...");
            settemp(w, newx, newy);
            notifyWarrior(((LotusFlower) getinhabitant(newx, newy)), w);
            return true;
        }

        //If there are warriors in adjacent coordinates
        else if ((checkWarrior((newx), (newy))) && (notreached)) {
            return true;                                                                                                // Return you can't move
        }

        //If threre are no inhabitants in adjacent coordinates
        else if ((!(checkWarrior((newx), (newy)))) && (notreached)) {
            synchronized (lock2) {
                System.out.println(w.getName() + " Swims From (" + oldx + ","
                        + oldy + ") To (" + (newx) + "," + newy + ")...\n");
                resetcoordinate(oldx, oldy);                                                                            //Resetting Coordinate
                addInhabitant(w, (newx), newy, 2, w.getName());
                return true;
            }
        } else {
            return true;
        }
    }

    public void lookforLotus(Warrior w, int oldx, int oldy) {
        GameDemo.gui.paintAgain();
        if (((SuperWarrior) w).useBinocular(this, oldx, oldy)) {                                          //Super Warrior used Binocular to see Lotus Flower
            if (checkLotus(oldx + 1, oldy)) {
                System.out.println(w.getName() + " Swims From (" + w.getX()
                        + "," + w.getY() + ") To ("
                        + (w.getX() + 1) + "," + (w.getY()) + ")");                                                     //printing he moved to that place
                settemp(w, oldx + 1, oldy);                                                                           //Set temporary Location
                notifyWarrior(((LotusFlower) getinhabitant(oldx + 1, oldy)), w);                                        //tellig the Warrior
            } else if (checkLotus(oldx, oldy + 1)) {
                System.out.println(w.getName() + " Swims From ("
                        + w.getX() + "," + w.getY() + ") To ("
                        + (w.getX()) + "," + (w.getY() + 1) + ")");
                settemp(w, oldx, oldy + 1);
                notifyWarrior(((LotusFlower) getinhabitant(oldx, oldy + 1)), w);
            } else if (checkLotus(oldx - 1, oldy)) {
                ((LotusFlower) getinhabitant(oldx - 1, oldy)).pickPetal(w);
                System.out.println(w.getName() + " Swims From ("
                        + w.getX() + "," + w.getY() + ") To ("
                        + (w.getX() - 1) + "," + (w.getY()) + ")");
                settemp(w, oldx - 1, oldy);
                notifyWarrior(((LotusFlower) getinhabitant(oldx - 1, oldy)), w);
            } else if (checkLotus(oldx, oldy - 1)) {
                System.out.println(w.getName() + " Swims From ("
                        + w.getX() + "," + w.getY() + ") To (" + (w.getX())
                        + "," + (w.getY() - 1) + ")");
                settemp(w, oldx, oldy - 1);
                notifyWarrior(((LotusFlower) getinhabitant(oldx, oldy - 1)), w);
            }
        }
    }

    //telling the special characters
    @Override
    public void notifyFish(Fish fish, Warrior warrior) {
        GameDemo.gui.paintAgain();
        //if Fish is innocent
        if (fish instanceof InnocentFish) {
            ((InnocentFish) fish).update(warrior);
        }
        // If Fish is Killer
        else if (fish instanceof KillerFish) {
            ((KillerFish) fish).update(warrior);
        } // If Fish is RubberEat
        else {
            ((RubberEatFish) fish).update(warrior);
        }
    }

    @Override
    public void notifyWarrior(LotusFlower lotusFlower, Warrior warrior) {
        warrior.update(lotusFlower);
    }

    @Override
    public String notifyTreasureChest(Warrior warrior) {
        treasureChest = new TreasureChest();
        return (treasureChest.update(warrior));
    }
}