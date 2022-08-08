import java.util.Scanner;

public class Game {
     Scanner sc=new Scanner(System.in);
    public void start() {
        System.out.println("Welcome to the adventure game! ");
        System.out.println("enter the name: ");
        String playerName = sc.next();
        Player player = new Player(playerName);
        System.out.println(player.getName() + " welcome to this dark island!!");
        player.selectChar();
        Location location= null;
       while(true){
           player.printInfo();
           System.out.println("Locations");
           System.out.println(" 1 - Safe House\n 2 - Tool Store\n 3 - Cave \n 4 - Forest \n 5-River \n 0 - Exit");
           System.out.println("enter location number you want to go: ");
           int selectLoc = sc.nextInt();

           switch (selectLoc){
               case 0:
                   location=null;
                   break;
               case 1:
                   location = new SafeHouse(player);
                   break;
               case 2:
                   location = new ToolStore(player);
                   break;
               case 3:
                   location=new Cave(player);
                   break;
               case 4:
                   location=new Forest(player);
                   break;
               case 5:
                   location=new River(player);
                   break;
               default:
                   System.out.println("please enter a valid location...");
           }
           if ( location==null){
               System.out.println("You gave up. What a shame! ");
               break;
           }else{
           if(!location.onLocation()) {
               System.out.println("GAME OVER! GET OUT HERE ! ");
               break;
           }}
       }
    }
}
