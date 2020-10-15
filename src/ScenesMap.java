import javafx.scene.Scene;
import java.util.HashMap;
import java.util.Map;

public class ScenesMap {
    private static Map scenesMap = new HashMap<String, Scene>();

    public static Map getScenesMap() {
        return scenesMap;
    }

    public static void addScene(String name, Scene scene) {
        ScenesMap.scenesMap.put(name, scene);
    }
}
