package CaptureClasses;

public class SuperBall extends Pokeball{
    public SuperBall(){
        super("SuperBall");
    }
    @Override
    public double getMultiplicadorPokeball(){
        return 1.5;
    }
    
}
