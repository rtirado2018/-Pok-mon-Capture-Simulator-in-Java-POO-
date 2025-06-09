package CaptureClasses;

public class EstadoParalizado extends Estado {
    public EstadoParalizado(){
        super("Paralizado");
    }

    @Override
    public double getMultiplicador(){
        return 1.5;
    }
    @Override
    public String toString() {
        return "Paralizado";
    }
    
}
