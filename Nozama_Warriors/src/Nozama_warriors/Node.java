package Nozama_warriors;

public class Node {
    private int x;
    private int y;
    private boolean checkobj;                                                                                           //Is  a object in node
    private int objectid;
    private Inhabitant inhabitant;                                                                                      //object in node
    private String inhabitantname;                                                                                      //node's inhabitant name

    public Node(int x, int y, int objectid) {
        this.x = x;
        this.y = y;
        this.objectid = objectid;
        checkobj = false;
    }

    //Get Object Cordinate
    public String getnode() {
        return x + " " + y;
    }

    //getter
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getObjectid() {
        return objectid;
    }

    public void setObjectid(int objectid) {
        this.objectid = objectid;
    }

    public String getInhabitantname() {
        return inhabitantname;
    }

    public Inhabitant getInhabitant() {
        return inhabitant;
    }


    //setter
    public void setInhabitantname(String inhabitantname) {
        this.inhabitantname = inhabitantname;
    }

    public void setInhabitant(Inhabitant inhabitant) {
        this.inhabitant = inhabitant;
    }

    public boolean isCheckobj() {
        return checkobj;
    }

    public void setCheckobj(boolean checkobj) {
        this.checkobj = checkobj;
    }

    /**
     * @param objectid every inhabitant has a object id
     *                 0- No Inhabitant
     *                 1- Super Warrior
     *                 2- Normal Warrior
     *                 3- Killer Fish
     *                 4- Rubber Eat Fish
     *                 5- Innocent Fish
     *                 6- Lotus Flower
     *@param inhabitant this is indicate the inhabitant object
     *@param inhabitantname every fish and warrior has a name
     */
    public void add(int objectid, Inhabitant inhabitant, String inhabitantname) {
        this.objectid = objectid;
        this.inhabitant = inhabitant;
        inhabitant.setX(x);
        inhabitant.setY(y);
        this.inhabitantname = inhabitantname;
        checkobj = true;
    }
}
