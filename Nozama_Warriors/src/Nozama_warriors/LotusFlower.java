package Nozama_warriors;

/**
 * Created by 160538L on 8/22/2017.
 */
public class LotusFlower extends Inhabitant {
    private static int petal = 100;

    public LotusFlower(String name) {
        super(name);
    }

    public void pickPetal(Warrior warrior) {
        if (petal >= 1) {
            warrior.setImmortal(true);                                                                                      //Set Immortal
            System.out.println(warrior.getName()
                    + " picked the petal and Became Immortal...\n");                                                        //print Picked the petal
            petal--;
        }
        /*if all of the flowers are eaten by other warriors */
        else if (petal < 1) {
            warrior.setImmortal(false);                                                                                      //Set Immortal flase
            System.out.println(warrior.getName()
                    + " , Sorry all of the flowers are eaten by others...\n");
        }
    }
}
