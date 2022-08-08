import java.util.Scanner;

public abstract class Location {
    private Player player;
    private String name;
    static Scanner sc = new Scanner(System.in);

    public Location(Player player, String name) {
        this.player = player;
        this.name = name;
    }
  abstract Boolean onLocation();
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
