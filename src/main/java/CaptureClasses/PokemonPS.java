package CaptureClasses;

import java.util.HashMap;
import java.util.Map;

public class PokemonPS {
    private static final Map<String, Integer> basePSPorNombre = new HashMap<>();

    static {
        basePSPorNombre.put("Bulbasaur", 45);
        basePSPorNombre.put("Charmander", 39);
        basePSPorNombre.put("Squirtle", 44);
        basePSPorNombre.put("Pikachu", 35);
        basePSPorNombre.put("Mewtwo", 106);
        basePSPorNombre.put("Articuno", 90);
        basePSPorNombre.put("MissingNO.", 33);
    }

    public static int getBasePS(String nombre) {
        return basePSPorNombre.getOrDefault(nombre, 50);
    }

    public static int calcularPSMax(String nombre, int nivel) {
        int basePS = getBasePS(nombre);
        return ((2 * basePS * nivel) / 100) + nivel + 10;
    }


    
}
