package CaptureClasses;

public class EstadoDormido extends Estado {

 
    
    public EstadoDormido(){
       super("Dormido"); 
    }

    @Override
    public double getMultiplicador(){
        return 2.5;
    }

    
@Override
    public String toString() {
        return "Dormido";
    }
}
