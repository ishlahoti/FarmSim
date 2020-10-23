import java.util.Random;

public class Farm {
    private static Farm farm;
    private String[] plots;
    private String[] waterPlots;
    private int waterPlotLevel;

    private Farm() {
        plots = new String[10];
        waterPlots = new String[10];
        initializePlots();
    }

    public static Farm factory() {
        if (farm == null) {
            farm = new Farm();
        }
        return farm;
    }

    private void initializePlots() {
        String[] plantTypes = new String[3];
        plantTypes[0] = "seed";
        plantTypes[1] = "immature";
        plantTypes[2] = "mature";

        for (int i = 0; i < plots.length; i++) {
            plots[i] = plantTypes[(new Random()).nextInt(plantTypes.length)];
        }
        for (int i = 0; i < waterPlots.length; i++) {
            waterPlots[i] = "" + 10;
        }

    }

    public String[] getPlots() {
        return plots;
    }
    public String[] getWaterPlots() {
        return waterPlots;
    }

    public int getWaterPlotLevel(int x) {
        waterPlotLevel = Integer.parseInt(waterPlots[x]);
        return waterPlotLevel;
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

}
