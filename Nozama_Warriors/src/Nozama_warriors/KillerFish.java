package Nozama_warriors;

/**
 * Created by 160538L on 8/22/2017.
 */
public class KillerFish extends Fish {
    public KillerFish(String name, int age) {                                                                           //setting the name and age for killer Fish
        super(name, age);
    }

    public void kill(Warrior warrior) {
        warrior.setDead(true);
        System.out.println(getName() + " Killed " + warrior.getName()
                + "\n");
    }

    @Override
    public void update(Warrior warrior) {
        if (warrior.isImmortal()) {                                                                                     //Check warriors cannot be killed
            eatSwimFin(warrior);
        } else {                                                                                                        //if yes
            eatSwimFin(warrior);                                                                                        //eating Swimfin
            kill(warrior);                                                                                              //Killing Warrior
            MakeSound makeSoundfinish = new MakeSound();
            makeSoundfinish.playSound("./assets/audio/Kill.wav");
            Warrior.no_of_warrior--;
        }
    }
}
