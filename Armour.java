public class Armour {
    private int id;
    private String name;
    private int block;
    private int price;

    public Armour(int id, String name, int block, int price) {
        this.id = id;
        this.name = name;
        this.block = block;
        this.price = price;
    }
    public static Armour[] armours(){
        Armour[] armourList = new Armour[3];
        armourList[0]= new Armour(1,"Weak",1,5);
        armourList[1]= new Armour(2,"Medium" , 3,7);
        armourList[2]=new Armour(3,"Heavy",5,9);

        return armourList;
    }
    public static Armour getArmourObj(int id ){
        for (Armour a : Armour.armours()) {
            if (a.getId() == id) {
                return a;
            }

        } return null;}

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
