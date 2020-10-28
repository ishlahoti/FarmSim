import java.util.Random;

public class Farm {
    private static Farm farm;
    private Game game;
    private String[] plots;
    private String[] waterPlots;
    private int waterPlotLevel;
    private int fertilizeLevel;
    private String[] fertilizePlots;
    private String plantInPlot;

    public static void reset() {
        farm = null;
    }

    private Farm() {
        game = Game.factory();
        plots = new String[10];
        waterPlots = new String[10];
        fertilizePlots = new String[10];
        initializePlots();
    }

    public static Farm factory() {
        if (farm == null) {
            farm = new Farm();
        }
        return farm;
    }

    private void initializePlots() {
        String startingSeed = game.getSeed();
        String[] plantTypes = new String[5];
        plantTypes[0] = startingSeed + " " + "Seed";
        plantTypes[1] = startingSeed + " " + "Sprout";
        plantTypes[2] = "Immature " + startingSeed + " Plant";
        plantTypes[3] = "Ripening " + startingSeed + " Plant";
        plantTypes[4] = "Mature " + startingSeed + " Plant";

        for (int i = 0; i < plots.length; i++) {
            plots[i] = plantTypes[(new Random()).nextInt(plantTypes.length)];
        }
        for (int i = 0; i < waterPlots.length; i++) {
            waterPlots[i] = "" + 10;
        }
        for (int i = 0; i < fertilizePlots.length; i++) {
            fertilizePlots[i] = "" + 0;
        }
    }

    public String[] getPlots() {
        return plots;
    }

    public String[] getWaterPlots() {
        return waterPlots;
    }

    public String[] getFertilizePlots() {
        return fertilizePlots;
    }

    public int getWaterPlotLevel(int x) {
        waterPlotLevel = Integer.parseInt(waterPlots[x]);
        return waterPlotLevel;
    }

    public int getFertilizeLevel(int x) {
        fertilizeLevel = Integer.parseInt(fertilizePlots[x]);
        return fertilizeLevel;
    }
    public boolean isFertilized(int x) {
        fertilizeLevel = Integer.parseInt(fertilizePlots[x]);
        return fertilizeLevel > 0;
    }

    public String getPlantInPlot(int x) {
        if (plots[x].contains("Seed")) {
            return plots[x].substring(0, plots[x].length() - 5);
        } else if (plots[x].contains("Sprout")) {
            return plots[x].substring(0, plots[x].length() - 6);
        } else if (plots[x].contains("Immature")) {
            return plots[x].substring(9, plots[x].length() - 6);
        } else if (plots[x].contains("Ripening")) {
            return plots[x].substring(9, plots[x].length() - 6);
        } else if (plots[x].contains("Mature")) {
            return plots[x].substring(7, plots[x].length() - 6);
        } else if (plots[x].contains("Dead")) {
            return plots[x].substring(5, plots[x].length() - 6);
        } else {
            return "Empty";
        }
    }

    public void editPlot(int index, String val) {
        if (index >= plots.length) {
            return;
        }
        plots[index] = val;
    }

    public void editWaterPlot(int index, String val) {
        if (index >= waterPlots.length) {
            return;
        }
        waterPlots[index] = val;
    }

    public void editFertilizePlot(int index, String val) {
        if (index >= fertilizePlots.length) {
            return;
        }
        fertilizePlots[index] = val;
    }

    public void evaporateWaterPlots() {
        for (int i = 0; i < waterPlots.length; i++) {
            if (getWaterPlotLevel(i) > 0) {
                editWaterPlot(i, "" + (getWaterPlotLevel(i) - 1));
            }
        }
    }

    public void evaporateFertilizePlots() {
        for (int i = 0; i < fertilizePlots.length; i++) {
            if (getFertilizeLevel(i) > 0) {
                editFertilizePlot(i, "" + (getFertilizeLevel(i) - 1));
            }
        }
    }
}
