public class Game {
    private final int startingSeedQuantity = 3;
    private static Game game;
    private String name = "";
    private String difficulty = "Easy";
    private String season = "Spring";
    private String startingSeed;
    private double money = 0.00D;
    private int day = 1;
    private final int inventoryCapacity = 20;
    private int inventoryQuantity = 0;

    private int raspberrySeedQuantity;
    private int strawberrySeedQuantity;
    private int passionFruitSeedQuantity;
    private int grapeSeedQuantity;
    private int strawberryCropQ;
    private int raspberryCropQ;
    private int passionFruitCropQ;
    private int grapeCropQ;
    private int watCropQ;
    private int pinCropQ;
    private int dragCropQ;
    private int beanCropQ;
    private int watSeedQ;
    private int pinSeedQ;
    private int dragSeedQ;
    private int beanSeedQ;

    private int raspberrySeedQuantityMarket = 3;
    private int strawberrySeedQuantityMarket = 3;
    private int passionFruitSeedQuantityMarket = 3;
    private int grapeSeedQuantityMarket = 3;
    private int strawberryCropQMarket = 1;
    private int raspberryCropQMarket = 1;
    private int passionFruitCropQMarket = 1;
    private int grapeCropQMarket = 1;
    private int watCropQMarket = 0;
    private int pinCropQMarket = 0;
    private int dragCropQMarket = 0;
    private int beanCropQMarket = 0;
    private int watSeedQMarket = 2;
    private int pinSeedQMarket = 2;
    private int dragSeedQMarket = 2;
    private int beanSeedQMarket = 2;


    private Game() {
    }

    public static Game factory() {
        if (game == null) {
            game = new Game();
        }

        return game;
    }

    public int getStartingSeedQuantity() {
        return startingSeedQuantity;
    }
    public int getInventoryCapacity() {
        return inventoryCapacity;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getDifficulty() {
        return this.difficulty;
    }

    public void setSeed(String seed) {
        this.startingSeed = seed;
    }

    public String getSeed() {
        return this.startingSeed;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getSeason() {
        return this.season;
    }

    public void setMoney(int money) {
        this.money = (double) money;
    }

    public double getMoney() {
        return this.money;
    }

    public void incrementDay() {
        ++this.day;
    }

    public int getDay() {
        return this.day;
    }
    public int getRaspberrySeedQuantity() {
        return raspberrySeedQuantity;
    }
    public int getStrawberrySeedQuantity() {
        return strawberrySeedQuantity;
    }
    public int getPassionFruitSeedQuantity() {
        return passionFruitSeedQuantity;
    }
    public int getGrapeSeedQuantity() {
        return grapeSeedQuantity;
    }
    public int getStrawberryCropQ() {
        return strawberryCropQ;
    }
    public int getRaspberryCropQ() {
        return raspberryCropQ;
    }
    public int getPassionFruitCropQ() {
        return passionFruitCropQ;
    }
    public int getGrapeFruitCropQ() {
        return grapeCropQ;
    }
    public int getWatCropQ() {
        return watCropQ;
    }
    public int getWatSeedQ() {
        return watSeedQ;
    }
    public int getPinCropQ() {
        return pinCropQ;
    }
    public int getPinSeedQ() {
        return pinSeedQ;
    }
    public int getDragCropQ() {
        return dragCropQ;
    }
    public int getDragSeedQ() {
        return dragSeedQ;
    }
    public int getBeanCropQ() {
        return beanCropQ;
    }
    public int getBeanSeedQ() {
        return beanSeedQ;
    }
    public int getRaspberrySeedQuantityMarket() {
        return raspberrySeedQuantityMarket;
    }

    public int getStrawberrySeedQuantityMarket() {
        return strawberrySeedQuantityMarket;
    }

    public int getPassionFruitSeedQuantityMarket() {
        return passionFruitSeedQuantityMarket;
    }

    public int getGrapeSeedQuantityMarket() {
        return grapeSeedQuantityMarket;
    }

    public int getStrawberryCropQMarket() {
        return strawberryCropQMarket;
    }

    public int getRaspberryCropQMarket() {
        return raspberryCropQMarket;
    }

    public int getPassionFruitCropQMarket() {
        return passionFruitCropQMarket;
    }

    public int getGrapeCropQMarket() {
        return grapeCropQMarket;
    }

    public int getWatCropQMarket() {
        return watCropQMarket;
    }

    public int getPinCropQMarket() {
        return pinCropQMarket;
    }

    public int getDragCropQMarket() {
        return dragCropQMarket;
    }

    public int getBeanCropQMarket() {
        return beanCropQMarket;
    }

    public int getWatSeedQMarket() {
        return watSeedQMarket;
    }

    public int getPinSeedQMarket() {
        return pinSeedQMarket;
    }

    public int getDragSeedQMarket() {
        return dragSeedQMarket;
    }

    public int getBeanSeedQMarket() {
        return beanSeedQMarket;
    }
    // incrementer for each item in market
    public void changeRaspberrySeedQuantityMarket(int raspberrySeedQuantityMarket) {
        this.raspberrySeedQuantityMarket += raspberrySeedQuantityMarket;
    }

    public void changeStrawberrySeedQuantityMarket(int strawberrySeedQuantityMarket) {
        this.strawberrySeedQuantityMarket += strawberrySeedQuantityMarket;
    }

    public void changePassionFruitSeedQuantityMarket(int passionFruitSeedQuantityMarket) {
        this.passionFruitSeedQuantityMarket += passionFruitSeedQuantityMarket;
    }

    public void changeGrapeSeedQuantityMarket(int grapeSeedQuantityMarket) {
        this.grapeSeedQuantityMarket += grapeSeedQuantityMarket;
    }

    public void changeStrawberryCropQMarket(int strawberryCropQMarket) {
        this.strawberryCropQMarket += strawberryCropQMarket;
    }

    public void changeRaspberryCropQMarket(int raspberryCropQMarket) {
        this.raspberryCropQMarket += raspberryCropQMarket;
    }

    public void changePassionFruitCropQMarket(int passionFruitCropQMarket) {
        this.passionFruitCropQMarket += passionFruitCropQMarket;
    }

    public void changeGrapeCropQMarket(int grapeCropQMarket) {
        this.grapeCropQMarket += grapeCropQMarket;
    }

    public void changeWatCropQMarket(int watCropQMarket) {
        this.watCropQMarket += watCropQMarket;
    }

    public void changePinCropQMarket(int pinCropQMarket) {
        this.pinCropQMarket += pinCropQMarket;
    }

    public void changeDragCropQMarket(int dragCropQMarket) {
        this.dragCropQMarket += dragCropQMarket;
    }

    public void changeBeanCropQMarket(int beanCropQMarket) {
        this.beanCropQMarket += beanCropQMarket;
    }

    public void changeWatSeedQMarket(int watSeedQMarket) {
        this.watSeedQMarket += watSeedQMarket;
    }

    public void changePinSeedQMarket(int pinSeedQMarket) {
        this.pinSeedQMarket += pinSeedQMarket;
    }

    public void changeDragSeedQMarket(int dragSeedQMarket) {
        this.dragSeedQMarket += dragSeedQMarket;
    }

    public void changeBeanSeedQMarket(int beanSeedQMarket) {
        this.beanSeedQMarket += beanSeedQMarket;
    }
    //made add method for each item in inventory
    public void addRaspberrySeed(int x) {
        if (inventoryQuantity + x > inventoryCapacity) {
            return;
        }
        raspberrySeedQuantity += x;
        inventoryQuantity += x;
    }
    public void addStrawberrySeed(int x) {
        if (inventoryQuantity + x > inventoryCapacity) {
            return;
        }
        strawberrySeedQuantity += x;
        inventoryQuantity += x;
    }
    public void addPassionFruitSeed(int x) {
        if (inventoryQuantity + x > inventoryCapacity) {
            return;
        }
        passionFruitSeedQuantity += x;
        inventoryQuantity += x;
    }
    public void addGrapeSeed(int x) {
        if (inventoryQuantity + x > inventoryCapacity) {
            return;
        }
        grapeSeedQuantity += x;
        inventoryQuantity += x;
    }
    public void addStrawberryCrop(int x) {
        if (inventoryQuantity + x > inventoryCapacity) {
            return;
        }
        strawberryCropQ += x;
        inventoryQuantity += x;
    }
    public void addRaspberryCrop(int x) {
        if (inventoryQuantity + x > inventoryCapacity) {
            return;
        }
        raspberryCropQ += x;
        inventoryQuantity += x;
    }
    public void addPassionFruitCrop(int x) {
        if (inventoryQuantity + x > inventoryCapacity) {
            return;
        }
        passionFruitCropQ += x;
        inventoryQuantity += x;
    }
    public void addGrapeCrop(int x) {
        if (inventoryQuantity + x > inventoryCapacity) {
            return;
        }
        grapeCropQ += x;
        inventoryQuantity += x;
    }
    public void addBeanCrop(int x) {
        if (inventoryQuantity + x > inventoryCapacity) {
            return;
        }
        beanCropQ += x;
        inventoryQuantity += x;
    }
    public void addBeanSeed(int x) {
        if (inventoryQuantity + x > inventoryCapacity) {
            return;
        }
        beanSeedQ += x;
        inventoryQuantity += x;
    }

    public void addPinCrop(int x) {
        if (inventoryQuantity + x > inventoryCapacity) {
            return;
        }
        pinCropQ += x;
        inventoryQuantity += x;
    }
    public void addPinSeed(int x) {
        if (inventoryQuantity + x > inventoryCapacity) {
            return;
        }
        pinSeedQ += x;
        inventoryQuantity += x;
    }

    public void addWatCrop(int x) {
        if (inventoryQuantity + x > inventoryCapacity) {
            return;
        }
        watCropQ += x;
        inventoryQuantity += x;
    }

    public void addWatSeed(int x) {
        if (inventoryQuantity + x > inventoryCapacity) {
            return;
        }
        watSeedQ += x;
        inventoryQuantity += x;
    }
    public void addDragCrop(int x) {
        if (inventoryQuantity + x > inventoryCapacity) {
            return;
        }
        dragCropQ += x;
        inventoryQuantity += x;
    }
    public void addDragSeed(int x) {
        if (inventoryQuantity + x > inventoryCapacity) {
            return;
        }
        dragSeedQ += x;
        inventoryQuantity += x;
    }

    public int getTotalInventoryQuantity() {
        return inventoryQuantity;
    }

    public int getTotalMarketQuantity() {
        return raspberrySeedQuantityMarket
            + strawberrySeedQuantityMarket
            + passionFruitSeedQuantityMarket
            + grapeSeedQuantityMarket
            + strawberryCropQMarket
            + raspberryCropQMarket
            + passionFruitCropQMarket
            + grapeCropQMarket
            + watCropQMarket
            + pinCropQMarket
            + dragCropQMarket
            + beanCropQMarket
            + watSeedQMarket
            + pinSeedQMarket
            + dragSeedQMarket
            + beanSeedQMarket;
    }
}
