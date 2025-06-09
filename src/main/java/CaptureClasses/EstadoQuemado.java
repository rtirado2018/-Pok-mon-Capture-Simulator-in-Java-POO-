package CaptureClasses;

public class EstadoQuemado extends Estado {
    public EstadoQuemado(){
        super("Quemado"); 
     }
 
     @Override
     public double getMultiplicador(){
         return 1.5;
     }
     @Override
    public String toString() {
        return "Quemado";
    }
}
