package Nozama_warriors;

/**
 * Created by 160538L on 8/22/2017.
 */
public abstract class Warrior extends Inhabitant  {

    public static int no_of_warrior = 0;
    public static int immobile_warrior = 0;
    public static int immobile_supper_warrior = 0;
    boolean Swim = true;
    SwimFin swimfin = new SwimFin();
    private boolean immortal = false;
    private boolean dead = false;

    public Warrior(String name, int age) {
        super(name, age);
    }

    public SwimFin looseSwimmingFin() {
        Swim = false;
        SwimFin tempswimFin = swimfin;
        swimfin = null;
        return tempswimFin;
    }

    //getter
    public boolean isImmortal() {
        return immortal;
    }

    //setter
    public void setImmortal(boolean immortal) {
        this.immortal = immortal;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isSwim() {
        return Swim;
    }

    public void setSwim(boolean swim) {
        this.Swim = swim;
    }

    public void update(LotusFlower lotusFlower) {
        lotusFlower.pickPetal(this);
    }
}
