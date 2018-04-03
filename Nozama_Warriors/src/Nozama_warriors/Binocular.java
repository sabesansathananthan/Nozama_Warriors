package Nozama_warriors;

/**
 * Created by 160538L on 8/22/2017.
 */
public class Binocular {
    /**
     * @param lake this is the lake
     *             It contains Inhabitant
     * @param newx current location x axis value of  Warrior
     * @param newy current location y axis value of warrior
     * @return a boolean value
     */

    public boolean view(Grid lake, int newx, int newy) {
        try {
            //see the flowers in the nearest line crossings
            if ((lake.checkLotus(newx + 1, newy)) || (lake.checkLotus(newx, newy + 1)) || (lake.checkLotus(newx - 1, newy))
                    || (lake.checkLotus(newx, newy - 1))) {
                return true;
            } else {
                return false;
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            return false;
        }
    }
}