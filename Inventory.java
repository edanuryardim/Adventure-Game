public class Inventory {
    private Weapon weapon;
    private Armour armour;

    public Inventory() {
     this.weapon = new Weapon("punch",-1,0,0);
     this.armour= new Armour(-1,"None",0,0);
    }

    public Armour getArmour() {
        return armour;
    }

    public void setArmour(Armour armour) {
        this.armour = armour;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
