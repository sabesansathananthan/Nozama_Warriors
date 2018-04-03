package Nozama_warriors;

/**
 * Created by 160538L on 8/22/2017.
 */
public abstract class Fish extends Inhabitant implements Observer {
    private SwimFin[] swimfin;
    private int SwimFinCount;

    public Fish(String name, int age) {
        super(name, age);
        swimfin = new SwimFin[2];
        SwimFinCount = 0;
    }

    public void eatSwimFin(Warrior warrior) {
        if (SwimFinCount <= 8) {
            SwimFinCount++;
            swimfin[0]= warrior.looseSwimmingFin();                                                                    //loosing Swimfin
        }
        System.out.println(getName() + " ate the Swim Fin of "
                + warrior.getName());                                                                                   //print ate the Swimfin
        System.out.println(warrior.getName() + " Becomes Inmobile...\n");
        Warrior.immobile_warrior++;
    }

    @Override
    public void update(Warrior warrior) {
    }
}
