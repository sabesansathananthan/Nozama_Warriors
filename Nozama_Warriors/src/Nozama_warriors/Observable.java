package Nozama_warriors;

public interface Observable {
    void notifyFish(Fish fish, Warrior warrior);
    void notifyWarrior(LotusFlower lotusFlower, Warrior warrior);
    String notifyTreasureChest(Warrior warrior);
}
