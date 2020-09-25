public class Game {
    private static Game game;
    private String name = "";
    private String difficulty = "Medium";
    private String season = "Fall";
    private String seed;
    private double money = 0.0D;
    private int day = 1;

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
        this.money = (double)money;
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
}