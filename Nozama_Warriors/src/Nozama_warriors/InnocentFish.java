package Nozama_warriors;

import java.util.Random;

/**
 * Created by 160538L on 8/22/2017.
 */
public class InnocentFish extends Fish {
    private final Grid lake;
    public InnocentFish(String name, int age,Grid lake) {
        super(name, age);
        this.lake = lake;
    }
/**
 * warrior want to move, after he meet the innicent fish
 * after he want to move so we update if warrior meet innocent fish then move */

    @Override
    public void update(Warrior warrior) {
        System.out.println( "Warrior "+warrior.getName() + " meet " +"Innocent Fish "+getName()
                + "\n");
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
                        if (!(lake.move(warrior, oldx, oldy, oldx - 1, oldy))) {                                   // tell Grid that he is swming
                            break;                                                                                      //if swam it will try to swim again
                        }
                    }
                } else if (randomno == 1) {
                    if ((oldy - 1) > -1) {                                                                              //(x,y-1)
                        if (!lake.move(warrior, oldx, oldy, oldx, oldy - 1)) {
                            break;
                        }
                    }
                }
            } else if (oldx >= 5 && oldy <= 5) {
                randomno = randomGenerator.nextInt(2);
                if (randomno == 0) {
                    if ((oldx - 1) > -1) {                                                                              //(x-1,y)
                        if (!lake.move(warrior, oldx, oldy, oldx - 1, oldy)) {
                            break;
                        }
                    }
                } else if (randomno == 1) {
                    if ((oldy + 1) < 10) {                                                                              //(x,y+1)
                        if (!lake.move(warrior, oldx, oldy, oldx, oldy + 1)) {
                            break;
                        }
                    }
                }

            } else if (oldx <= 5 && oldy >= 5) {
                randomno = randomGenerator.nextInt(2);
                if (randomno == 0) {
                    if ((oldx + 1) < 10) {                                                                              //(x+1,y)

                        if (!lake.move(warrior, oldx, oldy, oldx + 1, oldy)) {
                            break;
                        }
                    }
                } else if (randomno == 1) {
                    if ((oldy - 1) < 10) {                                                                              //(x,y-1)
                        if (!lake.move(warrior, oldx, oldy, oldx, oldy - 1)) {
                            break;
                        }
                    }
                }
            } else {
                randomno = randomGenerator.nextInt(2);
                if (randomno == 0) {
                    if ((oldx + 1) < 10) {                                                                              //(x+1,y)
                        if (!lake.move(warrior, oldx, oldy, oldx + 1, oldy)) {
                            break;
                        }
                    }
                } else if (randomno == 1) {
                    if ((oldy + 1) < 10) {                                                                              //(x,y+1)
                        if (!lake.move(warrior, oldx, oldy, oldx, oldy + 1)) {
                            break;
                        }
                    }
                }
            }
        }
    }
}

