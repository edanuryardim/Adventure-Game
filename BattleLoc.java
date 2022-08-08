import org.w3c.dom.ls.LSOutput;

import java.util.Locale;
import java.util.Random;

public abstract class BattleLoc extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObs;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award,int maxObs) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObs=maxObs;
    }

    @Override
    Boolean onLocation() {
        int obsNumber= this.randomObsNumber();
        System.out.println("Your Location: " + this.getName());
        System.out.println("Be careful! max " + obsNumber + " " + this.getObstacle().getName() + " may alive here!!!");
        System.out.println("F - Fight  or   R- Run");
        String selectCasee = sc.nextLine();
        selectCasee = selectCasee.toUpperCase(Locale.ROOT);
        if(selectCasee.equals("F")){
            if(combat(obsNumber)){
                System.out.println( this.getName() +"you defeated all the enemies");
                return true;
            }
        }
        if(this.getPlayer().getHealth()<0){
            System.out.println("You died. ");
            return false;
        }
        return true;

    }
    public boolean combat(int obsNumber){
        for(int i=1;i<=obsNumber;i++){
            playerStats();
            obstacleStats();
            while(this.getPlayer().getHealth()>0 &&this.getObstacle().getHealth()>0){
                System.out.println("<H>it   or   <R>un ");
                String selectCombat = sc.nextLine().toUpperCase(Locale.ROOT);
                if(selectCombat.equals("H")){
                    System.out.println("you hitted! ");
                    this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());
                    afterHit();
                    if(this.getObstacle().getHealth()>0){
                        System.out.println();
                        System.out.println("Obstacle hitted you. !!");
                        int obstacleDamage=this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmour().getBlock();
                        if(obstacleDamage<0){
                            obstacleDamage=0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
                        afterHit();
                    }
                }
            }
        }
        return false;
    }
    public void afterHit(){
        System.out.println("Health: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + "'s Health: " + this.getObstacle().getHealth());
        System.out.println();
    }
    public void obstacleStats(){
        System.out.println(this.getObstacle().getName() + " Values: \n------------------------------------------");
        System.out.println("Health: " + this.getObstacle().getHealth());
        System.out.println("Damage: " + this.getObstacle().getDamage());
        System.out.println("Award: " + this.getObstacle().getAward());
    }
    public void playerStats(){
        System.out.println("player values \n ----------------------------------");
        System.out.println("Health: " + this.getPlayer().getHealth() +
                " Damage: " + this.getPlayer().getTotalDamage()+
                        "Weapon: " + this.getPlayer().getInventory().getWeapon().getName()+
                "Armour: " + this.getPlayer().getInventory().getArmour().getName()+
                "Shield: " + this.getPlayer().getInventory().getArmour().getBlock()+
                " Money: " + this.getPlayer().getMoney());



    }
    public int randomObsNumber(){
        Random random=new Random();
        return random.nextInt(this.getMaxObs())+1;
    }

    public int getMaxObs() {
        return maxObs;
    }

    public void setMaxObs(int maxObs) {
        this.maxObs = maxObs;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
