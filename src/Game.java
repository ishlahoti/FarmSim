public class Game {
    private static Game game;
    private String name = "";
    private String difficulty = "Medium";
    private String season = "Fall";
    private String seed;
    private double money = 0.0D;
    private int day = 1;
    private int raspberrySeedQuantity = 1;
    private int strawberrySeedQuantity = 1;
    private int passionFruitSeedQuantity = 1;
    private int grapeSeedQuantity = 1;
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
    final int capacity = 20;
    private int size = 4;

    private Game() {
    }

    public static Game factory() {
        if (game == null) {
            game = new Game();
        }

        return game;
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
        this.seed = seed;
    }

    public String getSeed() {
        return this.seed;
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
    public int getRaspberrySeedQuantity(){ return raspberrySeedQuantity;}
    public int getStrawberrySeedQuantity(){ return strawberrySeedQuantity;}
    public int getPassionFruitSeedQuantity() { return passionFruitSeedQuantity;}
    public int getGrapeSeedQuantity() { return grapeSeedQuantity;}
    public int getStrawberryCropQ() { return strawberryCropQ;}
    public int getRaspberryCropQ(){return raspberryCropQ;}
    public int getPassionFruitCropQ(){return passionFruitCropQ;}
    public int getGrapeFruitCropQ() {return grapeCropQ;}
    public int getWatCropQ() {return watCropQ;}
    public int getWatSeedQ(){return watSeedQ;}
    public int getPinCropQ(){return pinCropQ;}
    public int getPinSeedQ(){return pinSeedQ;}
    public int getDragCropQ(){return dragCropQ;}
    public int getDragSeedQ(){return dragSeedQ;}
    public int getBeanCropQ(){return beanCropQ;}
    public int getBeanSeedQ(){return beanSeedQ;}


    //made add & remove for each item in inventory
    public void addRaspberrySeed(int x) {
        if (size + x >= capacity) {
            //for market, should have error message pop up when trying to buy
        }
       raspberrySeedQuantity+=x;
        size+=x;
    }
    public void removeRaspberrySeed() {
        raspberrySeedQuantity--;
        size--;
    }
    public void addStrawberrySeed(int x) {
        if (size + x >= capacity) {
            //for market, should have error message pop up when trying to buy
        }
        strawberrySeedQuantity+=x;
        size+=x;
    }
    public void removeStrawberrySeed() {
        strawberrySeedQuantity--;
        size--;
    }
    public void addPassionFruitSeed(int x) {
        if (size + x >= capacity) {
            //for market, should have error message pop up when trying to buy
        }
        passionFruitSeedQuantity+=x;
        size+=x;
    }
    public void removePassionFruitSeed() {
        passionFruitSeedQuantity--;
        size--;
    }
    public void addGrapeSeed(int x) {
        if (size + x >= capacity) {
            //for market, should have error message pop up when trying to buy
        }
        grapeSeedQuantity+=x;
        size+=x;
    }
    public void removeGrapeSeed() {
        grapeSeedQuantity--;
        size--;
    }
    public void addStrawberryCrop(int x) {
        if (size + x >= capacity) {
            //for market, should have error message pop up when trying to buy
        }
        strawberryCropQ+=x;
        size+=x;
    }
    public void removeStrawberryCrop() {
        strawberryCropQ--;
        size--;
    }
    public void addRaspberryCrop(int x) {
        if (size + x >= capacity) {
            //for market, should have error message pop up when trying to buy
        }
        raspberryCropQ+=x;
        size+=x;
    }
    public void removeRaspberryCrop() {
        raspberryCropQ--;
        size--;
    }
    public void addPassionFruitCrop(int x) {
        if (size + x >= capacity) {
            //for market, should have error message pop up when trying to buy
        }
        passionFruitCropQ+=x;
        size+=x;
    }
    public void removePassionFruitCrop() {
        passionFruitCropQ--;
        size--;
    }
    public void addGrapeCrop(int x) {
        if (size + x >= capacity) {
            //for market, should have error message pop up when trying to buy
        }
        grapeCropQ+=x;
        size+=x;
    }
    public void removeGrapeCrop() {
        grapeCropQ--;
        size--;
    }
    public void addBeanCrop(int x) {
        if (size + x >= capacity) {
            //for market, should have error message pop up when trying to buy
        }
        beanCropQ+=x;
        size+=x;
    }
    public void removeBeanCrop() {
        beanCropQ--;
        size--;
    }
    public void addBeanSeed(int x) {
        if (size + x >= capacity) {
            //for market, should have error message pop up when trying to buy
        }
        beanSeedQ+=x;
        size+=x;
    }
    public void removeBeanSeed() {
        beanSeedQ--;
        size--;
    }
    public void addPinCrop(int x) {
        if (size + x >= capacity) {
            //for market, should have error message pop up when trying to buy
        }
        pinCropQ+=x;
        size+=x;
    }
    public void removePinCrop() {
        pinCropQ--;
        size--;
    }
    public void addPinSeed(int x) {
        if (size + x >= capacity) {
            //for market, should have error message pop up when trying to buy
        }
        pinSeedQ+=x;
        size+=x;
    }
    public void removePinSeed() {
        pinSeedQ--;
        size--;
    }
    public void addWatCrop(int x) {
        if (size + x >= capacity) {
            //for market, should have error message pop up when trying to buy
        }
        watCropQ+=x;
        size+=x;
    }
    public void removeWatCrop() {
        watCropQ--;
        size--;
    }
    public void addWatSeed(int x) {
        if (size + x >= capacity) {
            //for market, should have error message pop up when trying to buy
        }
        watSeedQ+=x;
        size+=x;
    }
    public void removeWatSeed() {
        watSeedQ--;
        size--;
    }
    public void addDragCrop(int x) {
        if (size + x >= capacity) {
            //for market, should have error message pop up when trying to buy
        }
        dragCropQ+=x;
        size+=x;
    }
    public void removeDragCrop() {
        dragCropQ--;
        size--;
    }
    public void addDragSeed(int x) {
        if (size + x >= capacity) {
            //for market, should have error message pop up when trying to buy
        }
        dragSeedQ+=x;
        size+=x;
    }
    public void removeDragSeed() {
        dragSeedQ--;
        size--;
    }

}
