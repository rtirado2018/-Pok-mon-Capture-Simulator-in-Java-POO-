package CaptureClasses;

public class EstadoNinguno extends Estado {
    public EstadoNinguno(){
        super("Ninguno"); 
     }
 
     @Override
     public double getMultiplicador(){
         return 1;
     }
     @Override
    public String toString() {
        return "Ninguno";
    }
}
