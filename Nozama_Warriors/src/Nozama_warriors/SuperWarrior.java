package Nozama_warriors;

import java.util.Random;

/**
 * Created by 160538L on 8/22/2017.
 */
public class SuperWarrior extends Warrior implements HumanAction,Runnable {
    private final Binocular binocular;
    private final Grid lake;


    public SuperWarrior(String Name, int Age, Grid lake) {
        super(Name, Age);
        binocular = new Binocular();
        this.lake = lake;
    }

    public boolean useBinocular(Grid lake, int newx, int newy) {
        return binocular.view(lake, newx, newy);
    }

    @Override
    public void run() {
    swim();

    }

    @Override
    public void eat() {
    }

    @Override
    public void sleep() {
    }

    @Override
    public void swim() {
        int oldx;
        int oldy;
        while (Grid.notreached) {
            Random randomGenerator = new Random();
            int randomno;                                                                                               // getting Random no to check 4 probabilities
            oldx = getX();                                                                                              //getting warrior's x
            oldy = getY();                                                                                              //getting warrior's Y
            lake.lookforLotus(this, oldx, oldy);                                                                     // Before Moving Check for lotus
            if (oldx >= 5 && oldy >= 5) {
                randomno = randomGenerator.nextInt(2);
                if (randomno == 0) {
                    if ((oldx - 1) > -1) {                                                                              //(x-1,y)
                        if (!(lake.move(this, oldx, oldy, oldx - 1, oldy))) {                                   // tell Grid that Super Warrior is Swimming
                            break;                                                                                      //if swam it will try to swim again
                        }
                    }
                } else if (randomno == 1) {
                    if ((oldy - 1) > -1) {                                                                              //(x,y-1)
                        if (!lake.move(this, oldx, oldy, oldx, oldy - 1)) {
                            break;
                        }
                    }
                }
            } else if (oldx >= 5 && oldy <= 5) {
                randomno = randomGenerator.nextInt(2);
                if (randomno == 0) {
                    if ((oldx - 1) > -1) {                                                                              //(x-1,y)
                        if (!lake.move(this, oldx, oldy, oldx - 1, oldy)) {
                            break;
                        }
                    }
                } else if (randomno == 1) {
                    if ((oldy + 1) < 10) {                                                                              //(x,y+1)
                        if (!lake.move(this, oldx, oldy, oldx, oldy + 1)) {
                            break;
                        }
                    }
                }
            } else if (oldx <= 5 && oldy >= 5) {
                randomno = randomGenerator.nextInt(2);
                if (randomno == 0) {
                    if ((oldx + 1) < 10) {                                                                              //(x+1,y)
                        if (!lake.move(this, oldx, oldy, oldx + 1, oldy)) {
                            break;
                        }
                    }
                } else if (randomno == 1) {
                    if ((oldy - 1) < 10) {                                                                              //(x,y-1)
                        if (!lake.move(this, oldx, oldy, oldx, oldy - 1)) {
                            break;
                        }
                    }
                }
            } else {
                randomno = randomGenerator.nextInt(2);
                if (randomno == 0) {
                    if ((oldx + 1) < 10) {                                                                              //(x+1,y)
                        if (!lake.move(this, oldx, oldy, oldx + 1, oldy)) {
                            break;
                        }
                    }
                } else if (randomno == 1) {
                    if ((oldy + 1) < 10) {                                                                              //(x,y+1)
                        if (!lake.move(this, oldx, oldy, oldx, oldy + 1)) {
                            break;
                        }
                    }
                }
            }
        }
    }
}
