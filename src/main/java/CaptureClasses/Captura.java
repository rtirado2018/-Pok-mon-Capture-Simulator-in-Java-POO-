package CaptureClasses;

import java.text.Normalizer;

public class Captura {

    private Pokemon pokemon;
    private Pokeball pokeball;

    public Captura() {
        this.pokemon = new Pokemon();
        this.pokeball = new PokeBall();
    }

    public Captura(Pokemon pokemon, Pokeball pokeball) {
        this.pokemon = pokemon;
        this.pokeball = pokeball;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void setPokeball(Pokeball pokeball) {
        this.pokeball = pokeball;
    }

    public Pokemon getPokemon() {
        return this.pokemon;
    }

    public Pokeball getPokeball() {
        return this.pokeball;
    }

    public boolean intentarCaptura() {
        int PSMax = pokemon.getPSMax();
        int PSActual = pokemon.getPSActual();
        int ratioCaptura = pokemon.getRatioCaptura();
        double multiplicadorBall = pokeball.getMultiplicadorPokeball();
        double multiplicadorEstado = pokemon.getEstado().getMultiplicador();

        double fraccionVida = (3.0 * PSMax - 2.0 * PSActual) / (3.0 * PSMax);
        double a = fraccionVida * ratioCaptura * multiplicadorBall * multiplicadorEstado;

        System.out.println("CAPTURANDO A " + pokemon.getNombre() + "...");
        System.out.println("Probabilidad de captura (valor 'a'): " + a);

        if (a >= 255) {
            return true; // Captura automática
        }

        double b = 1048560 / Math.sqrt(Math.sqrt(16711680 / a));
        for (int i = 1; i <= 4; i++) {
            System.out.println("Bote " + (i - 1));
            int dado = (int) (Math.random() * 65536);
            if (dado >= b) {
                return false;
            }
        }

        return true;
    }

    public static Estado parsearEstado(String estadoTexto) {
        estadoTexto = estadoTexto.trim().toLowerCase();

        switch (estadoTexto) {
            case "paralizado":
                return new EstadoParalizado();
            case "envenenado":
                return new EstadoEnvenenado();
            case "quemado":
                return new EstadoQuemado();
            case "congelado":
                return new EstadoCongelado();
            case "dormido":
                return new EstadoDormido();
            default:
                return new EstadoNinguno(); // Estado por defecto
        }

    }

    public static Pokeball parsearPokeball(String tipoBall) {
        switch (tipoBall.toLowerCase()) {
            case "superball":
                return new SuperBall();
            case "ultraball":
                return new UltraBall();
            case "velozball":
                return new VelozBall();
            case "turnoball":
                return new BuceoBall();
            case "buceoball":
                return new TurnoBall();

            case "pokeball":
            default:
                return new PokeBall(); // tu clase concreta
        }
    }

    public static boolean esNombreValido(String nombre) {
        String[] pokemonesValidos = {
            "Bulbasaur", "Charmander", "Squirtle", "Pikachu", "Mewtwo", "Articuno"
        };

        for (String p : pokemonesValidos) {
            if (p.equalsIgnoreCase(nombre.trim())) {
                return true;
            }
        }
        return false;
    }

    public static boolean esEstadoValido(String estadoTexto) {
        String[] estadosValidos = {
            "Ninguno", "Paralizado", "Envenenado", "Congelado", "Dormido", "Quemado"
        };

        for (String p : estadosValidos) {
            if (p.equalsIgnoreCase(estadoTexto.trim())) {
                return true;
            }
        }
        return false;
    }
    
public static boolean esPokeballValida(String pokeballTexto) {
    String[] pokeballValidas = {
        "Pokeball", "SuperBall", "UltraBall", "VelozBall", "BuceoBall", "TurnoBall"
    };

    // Quitamos tildes y pasamos todo a minúsculas
    String textoNormalizado = normalizar(pokeballTexto);

    for (String p : pokeballValidas) {
        if (normalizar(p).equalsIgnoreCase(textoNormalizado)) {
            return true;
        }
    }
    return false;
}

private static String normalizar(String texto) {
    return Normalizer.normalize(texto, Normalizer.Form.NFD)
                     .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "")
                     .toLowerCase().trim();
}

}
