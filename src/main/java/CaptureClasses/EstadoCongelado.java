package CaptureClasses;

public class EstadoCongelado extends Estado {

    public EstadoCongelado() {
        super("Congelado");
    }

    @Override
    public double getMultiplicador() {
        return 2.5;
    }
@Override
    public String toString() {
        return "Congelado";
    }
}
