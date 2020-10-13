import java.util.Hashtable;

public enum Items {

    RASPBERRYC(2),
    STRAWBERRYC(3),
    PASSIONC(4),
    GRAPEC(5),
    DRAGONC(6),
    WATERMELONC(1),
    PINEAPPLEC(2),
    BEANC(2),
    RASPBERRYS(3),
    STRAWBERRYS(4),
    PASSIONS(5),
    GRAPES(3),
    DRAGONS(2),
    WATERMELONS(4),
    PINEAPPLES(5),
    BEANS(1);

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice() {
        this.basePrice = basePrice;
    }

    private Items(int basePrice) {
        this.basePrice = basePrice;
    }
    private Game game;
    private int basePrice;


}
