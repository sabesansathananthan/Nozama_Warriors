package Nozama_warriors;

/**
 * Created by 160538L on 8/22/2017.
 */
public class RubberEatFish extends Fish {                                                                               //setting the name and age for Rubber Eat Fish
    public RubberEatFish(String name, int age) {
        super(name, age);
    }

    public void update(Warrior warrior) {                                                                               //eating Swimfin
        eatSwimFin(warrior);
    }
}
