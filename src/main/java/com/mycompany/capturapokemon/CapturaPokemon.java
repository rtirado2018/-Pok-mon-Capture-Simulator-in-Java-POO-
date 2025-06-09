/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.capturapokemon;
import CaptureClasses.*;

import java.util.Scanner;

/**
 *
 * @author rosita
 */
public class CapturaPokemon {

    public static void main(String[] args) {
        Captura captura = new Captura();

        System.out.println("\n--CAPTURA POKEMON--");
        Scanner sc =new Scanner(System.in);
        System.out.println("Nombre del Pokémon:--(Pokémon a elegir: -Bulbasaur-Charmander-Squirtle-Pikachu-Mewtwo-Articuno)");
        //1.Capturamos el nombre:
        String nombrePokemon=sc.nextLine();
        System.out.println("Nivel del Pokémon:--(1-100)");
        int nivelPokemon=sc.nextInt();
        Pokemon pokemon = new Pokemon();
                pokemon.setNombre(nombrePokemon);
        pokemon.setNivel(nivelPokemon);
        pokemon.setPSMax(0); // ¡Forzamos el recálculo con el nombre y nivel ya puestos!
        System.out.println("PS actuales del Pokémon:--(1-"+pokemon.getPSMax()+")");
        int PSActuales=sc.nextInt();
        System.out.println("Estado:--(Ninguno, Paralizado, Envenenado, Quemado, Congelado,Dormido)");
        sc.nextLine(); // <-- IMPORTANTE: limpiar el buffer después de nextInt()
        String estadoPokemon=sc.nextLine();
        System.out.println("Pokéball:--(PokéBall, SuperBall, Ultraball, VelozBall, TurnoBall, BuceoBall)");
        
        String tipoBall=sc.nextLine();
        
        //2.Creamos un Pokémon


        pokemon.setPSActual(PSActuales);
        
        //Creamos un objeto Estado
        pokemon.setEstado(Captura.parsearEstado(estadoPokemon));
        
        //Creamos una Pokeball
        Pokeball pokeball = Captura.parsearPokeball(tipoBall);
        captura.setPokeball(pokeball); // 🪄 ¡asignamos la Pokéball al objeto Captura!

        
        
        
        //3.Lo metemos en el obejto captura:
        captura.setPokemon(pokemon);
        //4.Comprobamos que haya salido bien:
        System.out.println("¡Un "+captura.getPokemon().getNombre()+" salvaje apareció!");
        System.out.print(captura.getPokemon().getNombre()+" Lvl: "+captura.getPokemon().getNivel()+"  ||  " );
        System.out.print("PS: " + pokemon.getPSActual() +"/ "+pokemon.getPSMax()+"  ||  ");
        System.out.println("Estado: " + pokemon.getEstado());
        System.out.println("Lanzas una " + pokeball.getNombreBall());
        
        


        
        

    }
}
