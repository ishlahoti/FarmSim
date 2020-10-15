import javafx.scene.control.Label;

import java.util.Random;

public class Farm {
    private static Farm farm;
    private String[] plots;

    private Farm() {
        plots = new String[10];
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

    }

    public String[] getPlots() {
        return plots;
    }

    public void editPlot(int index, String val) {
        if (index >= plots.length) return;
        plots[index] = val;
    }
}
