package Nozama_warriors;

import java.util.Random;

/**
 * Created by 160538L on 8/22/2017.
 */
public class NormalWarrior extends Warrior implements HumanAction,Runnable{
    private final Grid lake;

    public NormalWarrior(String name, int age, Grid lake) {
        super(name, age);
        this.lake = lake;
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
            int randomno;
            oldx = getX();                                                                                              //getting warrior's x
            oldy = getY();                                                                                              //getting warrior's y

            if (oldx >= 5 && oldy >= 5) {                                                                               // Checking the warriors node
                randomno = randomGenerator.nextInt(2);
                if (randomno == 0) {
                    if ((oldx - 1) > -1) {                                                                              //(x-1,y)
                        if (!(lake.move(this, oldx, oldy, oldx - 1, oldy))) {                                   // tell Grid that he is swming
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