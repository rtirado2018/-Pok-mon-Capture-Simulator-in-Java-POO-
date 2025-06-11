package CaptureClasses;

public class Pokemon {
    private String nombre;
    private int nivel;
    private int PSMax;
    private int PSActual;
    private int ratioCaptura;
    private Estado estado = new EstadoNinguno();

    public Pokemon() {
        this.nombre = "MissingNO.";
        this.nivel = 255;
        this.PSMax = 999;
        this.PSActual = 999;
        this.ratioCaptura = 255;
        this.estado = new EstadoNinguno();

    }

    public Pokemon(String nombre, int nivel, int PSActual, Estado estado) {
        this.nombre = nombre;
        this.nivel = Math.max(1, Math.min(nivel, 100));
        this.PSMax = PokemonPS.calcularPSMax(nombre, nivel);
        this.PSActual = Math.max(1, Math.min(PSActual, this.PSMax));
        this.ratioCaptura = CaptureRatio.getOrDefault(nombre, 100);
        this.estado = estado;

    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return this.nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPSMax() {
        return this.PSMax;
    }

    public void setPSMax(int PSMax) {
        this.PSMax = PokemonPS.calcularPSMax(nombre, nivel);
    }

    public int getPSActual() {
        return this.PSActual;
    }

    public void setPSActual(int PSActual) {
        this.PSActual = Math.max(1, Math.min(PSActual, this.PSMax));
    }

    public int getRatioCaptura() {
        return this.ratioCaptura;
    }

    public void setRatioCaptura(int ratioCaptura) {
        this.ratioCaptura = CaptureRatio.getOrDefault(nombre, 100);
    }

    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    public void recalcularPSMax() {
    this.PSMax = PokemonPS.calcularPSMax(nombre, nivel);
}
    
    
    


}