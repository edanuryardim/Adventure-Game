import java.util.Scanner;

public class Player {
    Scanner sc=new Scanner(System.in);
    private int damage;
    private int health;
    private int money;
    private String charName;
    private String name;
    private Inventory inventory;

    public Player(String name){
        this.name=name;
        this.inventory=new Inventory();
    }

    public void selectChar(){

        GameChar[] charList = {new Archer(),new Samurai(),new Knight()};
        System.out.println("CHARACTERS\n-----------------------------------------------------------------");
        for (GameChar gameChar: charList) {
            System.out.println("ID: " + gameChar.getId() + "\tCharacter: " + gameChar.getName()+ "\t Damage: " + gameChar.getDamage() + "\t Health: " + gameChar.getHealth()+ "\t Money: " + gameChar.getMoney());
        }
        System.out.println("Please enter a character id:\n-----------------------------------------------------------------");
        int selectChar= sc.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Archer());
                break;
            case 2:
                initPlayer(new Samurai());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("your character: " + this.getCharName());
    }

    public void initPlayer(GameChar gameChar){
        this.setCharName(gameChar.getName());
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
    }
    public void printInfo(){
        System.out.println("Weapon: " + this.getInventory().getWeapon().getName()+
                " Armour: " + this.getInventory().getArmour().getName()+
                " Shiel: " + this.getInventory().getArmour().getBlock()
                +" Damage: " + this.getTotalDamage()+
                " Health: " + this.getHealth() +
                " Money: " + this.getMoney());
    }

    public int getTotalDamage(){
        return damage+this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
