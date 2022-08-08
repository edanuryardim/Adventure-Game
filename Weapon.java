public class Weapon {
    private int id;
    private int damage;
    private int price;
    private String name;

    public Weapon(String name,int id, int damage, int price ) {
        this.id = id;
        this.damage = damage;
        this.price = price;
        this.name = name;
    }
    public static Weapon[] weapons(){
        Weapon[] weaponList = new Weapon[3];
        weaponList[0]=new Weapon("Revolver",1,2,8);
        weaponList[1]=new Weapon("Blade",2,3,6);
        weaponList[2]= new Weapon("Rifle",3,7,4);
        return weaponList;
    }
    public static Weapon getWeaponObj(int id) {
        for (Weapon w : Weapon.weapons()) {
            if (w.getId() == id) {
                return w;
            }

        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
