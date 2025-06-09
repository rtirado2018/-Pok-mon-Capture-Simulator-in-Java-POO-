package CaptureClasses;

public class EstadoEnvenenado extends Estado {
    public EstadoEnvenenado(){
        super("Envenenado"); 
     }
 
     @Override
     public double getMultiplicador(){
         return 1.5;
     }
     @Override
    public String toString() {
        return "Envenenado";
    }
}
