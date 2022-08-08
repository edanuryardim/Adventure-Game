public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    Boolean onLocation() {
        System.out.println("welcome to Tool Store! ");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1 - Weapons");
            System.out.println("2 - Armour");
            System.out.println("3 - Exit");
            System.out.println("your choice: ");
            int selectCase = Location.sc.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Invalid... enter again: ");
                selectCase = Location.sc.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapons();
                    buyWeapon();
                    break;
                case 2:
                    printArmour();
                    buyArmour();
                    break;
                case 3:
                    System.out.println("Exitting...");
                    showMenu = false;
                    break;
            }

        }
        return true;
    }
    public void printWeapons(){
        System.out.println("-----WEAPONS-----");
        for(Weapon w: Weapon.weapons()){
            System.out.println(w.getId() + " - " + w.getName() + "Price: " + w.getPrice()+ "  Damage: " + w.getDamage());
        }
        System.out.println("0 - Exit");
    }
    public void buyWeapon(){
        System.out.println("select a weapon: ");
        int selectedWeaponId =sc.nextInt();
        while(selectedWeaponId<0 || selectedWeaponId>Weapon.weapons().length ){
            System.out.println("Invalid... enter again: ");
            selectedWeaponId= sc.nextInt();
        }
        if(selectedWeaponId!=0){
            Weapon selectedWeapon = Weapon.getWeaponObj(selectedWeaponId);
            if(selectedWeapon!=null){
                if(selectedWeapon.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("you dont have enough money. ");
                }
                else {
                    System.out.println(selectedWeapon.getName() + " is bought");
                    int balance = this.getPlayer().getMoney()-selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Remaining money: " + this.getPlayer().getMoney());
                    System.out.println("previous weapon: " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("current weapon: " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }

    }
    public void printArmour(){
        System.out.println("-----ARMOURS-----");
        for(Armour a: Armour.armours()){
            System.out.println(a.getId() + " - " + a.getName() + " Shiel: " + a.getBlock()+ "  Price: " + a.getPrice());
        }
        System.out.println("0 - Exit");
    }
    public void buyArmour(){
        System.out.println("select a armour: ");
        int selectedArmourId =sc.nextInt();
        while(selectedArmourId<0 || selectedArmourId>Armour.armours().length ){
            System.out.println("Invalid... enter again: ");
            selectedArmourId= sc.nextInt();
        }
        if(selectedArmourId!=0){
            Armour selectedArmour = Armour.getArmourObj(selectedArmourId);
            if(selectedArmour!=null){
                if(selectedArmour.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("you dont have enough money. ");
                }
                else{
                    System.out.println(selectedArmour.getName() + " is bought");
                    int balance = this.getPlayer().getMoney()-selectedArmour.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Remaining money: " + this.getPlayer().getMoney());
                    System.out.println("previous Armour: " + this.getPlayer().getInventory().getArmour().getName());
                    this.getPlayer().getInventory().setArmour(selectedArmour);
                    System.out.println("current Armour: " + this.getPlayer().getInventory().getArmour().getName());
                }
            }
        }

    }
}
