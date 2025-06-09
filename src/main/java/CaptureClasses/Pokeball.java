package CaptureClasses;

public  abstract class Pokeball {
    protected final String nombreBall;

    public Pokeball(){
        this.nombreBall= "PokeBall";
        
    }
 

    public Pokeball (String nombreBall){
        this.nombreBall=nombreBall;
    }


    public String getNombreBall() {
        return this.nombreBall;
    }


public abstract double getMultiplicadorPokeball();

}
