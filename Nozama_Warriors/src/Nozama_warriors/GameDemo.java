package Nozama_warriors;

import javax.swing.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GameDemo extends Thread {
    public static GUI gui;
    public static void main(String[] args) throws Exception {

        //Defining Random Numbers
        Random randomGenerator = new Random();
        int randomx;                                                                                                    //To get random x
        int randomy;                                                                                                    //To get random y
        int randomno;

        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating lake of Nozama
        Grid lake = new Grid();
        // printing introductions
        printWithDelay("Shady Studio Presents \n\n", TimeUnit.MILLISECONDS, 100);
        printWithDelay("<<<< NOZAMA WARRIORS >>>>\n\n", TimeUnit.MILLISECONDS, 150);
        printWithDelay("LOADING", TimeUnit.MILLISECONDS, 100);
        printWithDelay(".", TimeUnit.MILLISECONDS, 200);
        printWithDelay(".", TimeUnit.MILLISECONDS, 400);
        printWithDelay(".", TimeUnit.MILLISECONDS, 600);
        printWithDelay(".", TimeUnit.MILLISECONDS, 800);
        printWithDelay(".", TimeUnit.MILLISECONDS, 1000);
        gui = new GUI(jf);
        SuperWarrior sw[];
        sw = new SuperWarrior[2];
        sw[0] = new SuperWarrior("Shady", 21, lake);                                                          //creating Super Warrior
        sw[1] = new SuperWarrior("Mady", 31, lake);                                                           //creating Super Warrior
        printWithDelay("\n\nSuper Warriors start their Journey\n", TimeUnit.MILLISECONDS, 100);
        int i = 0;                                                                                                      // Starting Value
        while (i < 2) {                                                                                                 // 2 warriors
            int randomDecide = randomGenerator.nextInt(4);
            switch (randomDecide) {
                case 0:
                    randomno = randomGenerator.nextInt(11);                                                       // take coordinate below 11
                    if (!(lake.checkcordinate(0, randomno))) {                                                        //Checking whether the coordinate has
                        lake.addInhabitant(sw[i], 0, randomno, 1,                                             // Adding Inhabitant
                                sw[i].getName());
                        System.out.println("Super warrior " + (sw[i].getName()
                                + " placed on " + "(" + (sw[i].getX())
                                + "," + (sw[i].getY())) + ")....");
                        i++;                                                                                            // update value if warrior placed
                    }
                    break;
                case 1:
                    randomno = randomGenerator.nextInt(11);
                    if (!(lake.checkcordinate(randomno, 0))) {
                        lake.addInhabitant(sw[i], randomno, 0, 1, sw[i].getName());
                        System.out.println("Super warrior " + (sw[i].getName()
                                + " placed on " + "(" + (sw[i].getX()) + ","
                                + (sw[i].getY())) + ")....");
                        i++;
                    }
                    break;
                case 2:
                    randomno = randomGenerator.nextInt(11);
                    if (!(lake.checkcordinate(10, randomno))) {
                        lake.addInhabitant(sw[i], 10, randomno, 1, sw[i].getName());
                        System.out.println("Super warrior " + (sw[i].getName()
                                + " placed on " + "(" + (sw[i].getX()) + ","
                                + (sw[i].getY())) + ")....");
                        i++;
                    }
                    break;
                case 3:
                    randomno = randomGenerator.nextInt(11);
                    if (!(lake.checkcordinate(randomno, 10))) {
                        lake.addInhabitant(sw[i], randomno, 10, 1, sw[i].getName());
                        System.out.println("Super warrior " + (sw[i].getName()
                                + " placed on " + "(" + (sw[i].getX()) + ","
                                + (sw[i].getY())) + ")....");
                        i++;
                    }
                    break;
            }
        }
        gui.paintAgain();
        NormalWarrior nw[];
        nw = new NormalWarrior[2];                                                                                      //creating Normal Warrior
        nw[0] = new NormalWarrior("Ram", 20, lake);
        nw[1] = new NormalWarrior("Sri", 22, lake);
        printWithDelay("\nNormal Warriors start their Journey \n", TimeUnit.MILLISECONDS, 100);
        i = 0;
        while (i < 2) {                                                                                                 // 2 NormalWarrior warriors
            int randomDecide = randomGenerator.nextInt(4);
            switch (randomDecide) {
                case 0:
                    randomno = randomGenerator.nextInt(11);                                                       // take coordinate below 11
                    if (!(lake.checkcordinate(0, randomno))) {
                        lake.addInhabitant(nw[i], 0, randomno, 2, nw[i].getName());
                        System.out.println("Normal warrior " + (nw[i].getName()
                                + " placed on " + "(" + (nw[i].getX())
                                + "," + (nw[i].getY())) + ")....");
                        i++;
                    }
                    break;
                case 1:
                    randomno = randomGenerator.nextInt(11);
                    if (!(lake.checkcordinate(0, randomno))) {
                        lake.addInhabitant(nw[i], randomno, 0, 2, nw[i].getName());
                        System.out.println("Normal warrior " + (nw[i].getName()
                                + " placed on " + "(" + (nw[i].getX()) + ","
                                + (nw[i].getY())) + ")....");
                        i++;
                    }
                    break;
                case 2:
                    randomno = randomGenerator.nextInt(11);
                    if (!(lake.checkcordinate(0, randomno))) {
                        lake.addInhabitant(nw[i], 10, randomno, 2, nw[i].getName());
                        System.out.println("Normal warrior " + (nw[i].getName()
                                + " placed on " + "(" + (nw[i].getX()) + ","
                                + (nw[i].getY())) + ")....");
                        i++;
                    }
                    break;
                case 3:
                    randomno = randomGenerator.nextInt(11);
                    if (!(lake.checkcordinate(randomno, 10))) {
                        lake.addInhabitant(nw[i], randomno, 10, 2, nw[i].getName());
                        System.out.println("Normal warrior " + (nw[i].getName()
                                + " placed on " + "(" + (nw[i].getX()) + ","
                                + (nw[i].getY())) + ")....");
                        i++;
                    }
                    break;
            }
        }
        gui.paintAgain();
        KillerFish kf[];
        kf = new KillerFish[2];
        kf[0] = new KillerFish("Shark", 5);                                                                   //creating Killer fish
        kf[1] = new KillerFish("Whale", 7);

        RubberEatFish ref[];
        ref = new RubberEatFish[2];
        ref[0] = new RubberEatFish("Tuna", 2);                                                                //creating Rubber Eat Fish
        ref[1] = new RubberEatFish("Skate", 3);

        InnocentFish inf[];
        inf = new InnocentFish[2];
        inf[0] = new InnocentFish("Dolphin", 10,lake);                                                             //creating Innocent Fish
        inf[1] = new InnocentFish("Eelpout", 9,lake);

        printWithDelay("\nKiller Fishes take their positions \n", TimeUnit.MILLISECONDS, 100);
        i = 0;
        while (i < 2) {
            randomy = randomGenerator.nextInt(11);                                                                //get randomx
            randomx = randomGenerator.nextInt(11);                                                                //get random y
            if (!(lake.checkcordinate(randomx, randomy))
                    && (randomx != 5 && randomy != 5))                                                                  //Omit (5,5) coordinate
            {
                lake.addInhabitant(kf[i], randomx, randomy, 3, kf[i].getName());                                 //adding Killer Fish
                System.out.println("Killer Fish " + (kf[i].getName()                                                    //Printing status
                        + " placed on " + "(" + (kf[i].getX()) + ","
                        + (kf[i].getY())) + ")....");
                i++;
            }
        }
        gui.paintAgain();
        printWithDelay("\nRubber Eat Fishes take their positions \n", TimeUnit.MILLISECONDS, 100);
        i = 0;
        while (i < 2) {
            randomy = randomGenerator.nextInt(11);                                                                //placing Rubber Eat Fish
            randomx = randomGenerator.nextInt(11);
            if (!(lake.checkcordinate(randomx, randomy))
                    && (randomx != 5 && randomy != 5)) {
                lake.addInhabitant(ref[i], randomx, randomy, 4, ref[i].getName());
                System.out.println("Rubber Eat Fish " + (ref[i].getName()
                        + " placed on " + "(" + (ref[i].getX())
                        + "," + (ref[i].getY())) + ")....");
                i++;
            }
        }
        gui.paintAgain();
        printWithDelay("\nInnocent Fishes take their positions \n", TimeUnit.MILLISECONDS, 100);
        i = 0;
        while (i < 2) {
            randomy = randomGenerator.nextInt(11);                                                                //placing innocent Fish
            randomx = randomGenerator.nextInt(11);
            if (!(lake.checkcordinate(randomx, randomy))
                    && (randomx != 5 && randomy != 5)) {
                lake.addInhabitant(inf[i], randomx, randomy, 5, inf[i].getName());
                System.out.println("InnocentFish " + (inf[i].getName()
                        + " placed on " + "(" + (inf[i].getX())
                        + "," + (inf[i].getY())) + ")....");
                i++;
            }
        }
        gui.paintAgain();
        printWithDelay("\nLotus Flowers are blooming now\n", TimeUnit.MILLISECONDS, 100);
        LotusFlower lf[];
        lf = new LotusFlower[5];
        lf[0] = new LotusFlower("LF0");                                                                            //Creating Lotus Flower
        lf[1] = new LotusFlower("LF1");
        lf[2] = new LotusFlower("LF2");
        lf[3] = new LotusFlower("LF3");
        lf[4] = new LotusFlower("LF4");

        i = 0;
        while (i < 5) {                                                                                                 //placing Lotus Flower
            randomy = randomGenerator.nextInt(11);
            randomx = randomGenerator.nextInt(11);
            if (!(lake.checkcordinate(randomx, randomy))
                    && (randomx != 5 && randomy != 5)) {
                lake.addInhabitant(lf[i], randomx, randomy, 6, lf[i].getName());
                printWithDelay("Lotus Flower " + (lf[i].getName()
                        + " placed on " + "(" + (lf[i].getX()) + ","
                        + (lf[i].getY())) + ")....\n", TimeUnit.MILLISECONDS, 25);
                i++;
            } else {

            }
        }
        gui.paintAgain();
        System.out.println();
        printWithDelay("\nNo Inhabitant    : 0\n", TimeUnit.MILLISECONDS, 25);
        printWithDelay("Super Warrior    : 1\n", TimeUnit.MILLISECONDS, 25);
        printWithDelay("Normal Warrior   : 2\n", TimeUnit.MILLISECONDS, 25);
        printWithDelay("Killer Fish      : 3\n", TimeUnit.MILLISECONDS, 25);
        printWithDelay("Rubber eat Fish  : 4\n", TimeUnit.MILLISECONDS, 25);
        printWithDelay("Innocent Fish    : 5\n", TimeUnit.MILLISECONDS, 25);
        printWithDelay("Lotus Flower     : 6\n\n", TimeUnit.MILLISECONDS, 25);

        for (int a = 0; a < 11; a++) {
            for (int b = 0; b < 11; b++) {
                printWithDelay(" " + lake.getobjID(b,  a) + " ", TimeUnit.MILLISECONDS, 50);
            }
            printWithDelay("\n", TimeUnit.MILLISECONDS, 50);
        }
        System.out.println();
        System.out.println("    y");
        System.out.println("    ˄");
        System.out.println("    ¦");
        printWithDelay("    └-- > x\n", TimeUnit.MILLISECONDS, 50);


        printWithDelay("\nWarriors Start Swimming .....\n\n",
                TimeUnit.MILLISECONDS, 150);

        /**Starting the Thread
        * Super Warrior has higher priority
        * Normal warrior has Normal prioriy
         * */

        Thread sw0 = new Thread(sw[0]);                                                                                 //creating thread
        sw0.setPriority(sw0.MAX_PRIORITY);                                                                              //setting the priority
        sw0.start();                                                                                                    //starting the thread
        Thread sw1 = new Thread(sw[1]);
        sw1.setPriority(sw1.MAX_PRIORITY);
        sw1.start();
        Thread nw0 = new Thread(nw[0]);
        nw0.setPriority(nw0.NORM_PRIORITY);
        nw0.start();
        Thread nw1 = new Thread(nw[1]);
        nw1.setPriority(nw1.NORM_PRIORITY);
        nw1.start();
    }
    /**
     * Method to iterate and print with delay
     * @param data data refer that the string which we want to print
     * @param delay the particular time interval in here I used only MILLISECONDS unit
     * @param unit  the period of time in long
     */
    public static void printWithDelay(String data, TimeUnit unit, long delay)
            throws InterruptedException {
        for (char ch : data.toCharArray()) {                                                                            //iterate
            System.out.print(ch);                                                                                       //print Character
            unit.sleep(delay);                                                                                          //print with delay
        }
    }
}