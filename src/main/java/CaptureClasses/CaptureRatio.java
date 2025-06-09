package CaptureClasses;

import java.util.HashMap;
import java.util.Map;

public class CaptureRatio {
    private static final Map<String, Integer> ratios = new HashMap<>();

    static {
        ratios.put("Bulbasaur", 45);
        ratios.put("Pikachu", 190);
        ratios.put("Mewtwo", 3);
        // añade más pokes
    }

    public static int getOrDefault(String nombre, int valorPorDefecto) {
        return ratios.getOrDefault(nombre, valorPorDefecto);
    }
}
