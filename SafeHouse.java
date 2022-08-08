public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    Boolean onLocation() {
        System.out.println("You are at Safe House");
        System.out.println("Your health is fulled! ");
        return true;
    }
}
