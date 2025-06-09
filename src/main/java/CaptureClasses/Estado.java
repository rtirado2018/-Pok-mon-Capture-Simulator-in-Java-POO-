package CaptureClasses;

public abstract class Estado {
    protected String nombreEstado;

    public Estado() {
        this.nombreEstado = "Ninguno";
    }

    public Estado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public String getNombreEstado(){
        return this.nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public abstract double getMultiplicador();

}