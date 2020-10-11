import java.util.Hashtable;

/**
 * This class is only for the new seeds being introduced in
 * the game.
 */
public class Items {

    private Game game;
    private Hashtable<String, Integer> plants; //key == name; value == quantity

    private Items() {
        plants = new Hashtable<>();
        plants.put("Raspberry Crop", game.getRaspberryCropQ());
        plants.put("Strawberry Crop", game.getStrawberryCropQ());
        plants.put("PassionFruit Crop", game.getPassionFruitCropQ());
        plants.put("GrapeFruit Crop", game.getGrapeFruitCropQ());
        plants.put("DragonFruit Crop", game.getDragCropQ());
        plants.put("Watermelon Crop", game.getWatCropQ());
        plants.put("Pineapple Crop", game.getPinCropQ());
        plants.put("Bean Crop", game.getBeanCropQ());

        plants.put("Raspberry Seed", game.getRaspberrySeedQuantity());
        plants.put("Strawberry Seed", game.getStrawberrySeedQuantity());
        plants.put("PassionFruit Seed", game.getPassionFruitSeedQuantity());
        plants.put("GrapeFruit Seed", game.getGrapeSeedQuantity());
        plants.put("DragonFruit Seed", game.getDragSeedQ());
        plants.put("Watermelon Seed", game.getWatSeedQ());
        plants.put("Pineapple Seed", game.getPinSeedQ());
        plants.put("Bean Seed", game.getBeanSeedQ());
    }

    public int getQuantity(String plant) {
        return plants.get("plant");
    }
    public void setQuantity(String plant, int quantity) {
        plants.replace(plant, quantity);
    }
    public Hashtable getPlants() {
        return plants;
    }





}