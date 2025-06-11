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
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre del Pokémon:--(Pokémon a elegir: -Bulbasaur-Charmander-Squirtle-Pikachu-Mewtwo-Articuno)");

        //1.Capturamos el nombre:
        String nombrePokemon = sc.nextLine();

        while (!Captura.esNombreValido(nombrePokemon)) {
            System.out.println("Nombre inválido, por favor elige un Pokémon válido:");
            nombrePokemon = sc.nextLine();
        }
        Pokemon pokemon;

        if (nombrePokemon.trim().isEmpty()) {
            // Si el nombre está vacío, usamos el constructor por defecto
            pokemon = new Pokemon();
            System.out.println("⚠️ No introdujiste nombre, se usará Pokémon por defecto: " + pokemon.getNombre());
        } else {
            int nivelPokemon;
            do {
                System.out.println("Nivel del Pokémon(1-100):");
                while (!sc.hasNextInt()) {
                    System.out.println("⚠ Introduce un número válido:");
                    sc.next();
                }
                nivelPokemon = sc.nextInt();
                if (nivelPokemon < 1 || nivelPokemon > 100) {
                    System.out.println("⚠ Introduce un número del 1 al 100:");

                }
            } while (nivelPokemon < 1 || nivelPokemon > 100);

            Pokemon tempPokemon = new Pokemon();
            tempPokemon.setNombre(nombrePokemon);

            tempPokemon.setNivel(nivelPokemon);
            tempPokemon.setPSMax(0); // ¡Forzamos el recálculo con el nombre y nivel ya puestos!

            System.out.println("PS actuales del Pokémon:--(1-" + tempPokemon.getPSMax() + ")");
            int PSActuales = sc.nextInt();

            sc.nextLine();// <-- IMPORTANTE: limpiar el buffer después de nextInt()

            System.out.println("Estado:--(Ninguno, Paralizado, Envenenado, Quemado, Congelado,Dormido)");
            String estadoPokemon = sc.nextLine();

            while (!Captura.esEstadoValido(estadoPokemon)) {
                System.out.println("Estado inválido, por favor elige un estado válido:");
                estadoPokemon = sc.nextLine();
            }

            pokemon = new Pokemon(nombrePokemon, nivelPokemon, PSActuales, Captura.parsearEstado(estadoPokemon));

        }

        System.out.println("Pokéball:--(PokéBall, SuperBall, Ultraball, VelozBall, TurnoBall, BuceoBall)");

        String tipoBall = sc.nextLine();
        while (!Captura.esPokeballValida(tipoBall)) {
            System.out.println("Pokéball inválida, por favor elige una Pokéball válida:");
            tipoBall = sc.nextLine();
        }

        //Creamos una Pokeball
        Pokeball pokeball = Captura.parsearPokeball(tipoBall);
        captura.setPokeball(pokeball); // 🪄 ¡asignamos la Pokéball al objeto Captura!

        //3.Lo metemos en el obejto captura:
        captura.setPokemon(pokemon);
        //4.Comprobamos que haya salido bien:
        System.out.println("\n---------------------------------------");
        System.out.println("¡Un " + captura.getPokemon().getNombre() + " salvaje apareció!");
        System.out.print(captura.getPokemon().getNombre() + " Lvl: " + captura.getPokemon().getNivel() + "  ||  ");
        System.out.print("PS: " + pokemon.getPSActual() + "/ " + pokemon.getPSMax() + "  ||  ");
        System.out.println("Estado: " + pokemon.getEstado());
        System.out.println("Lanzas una " + pokeball.getNombreBall());
        System.out.println("---------------------------------------\n");

// Intentar captura
boolean capturado;
boolean seguirIntentando = true;
int intentos = 0;

do {
    capturado = captura.intentarCaptura();
    intentos++;

    if (capturado) {
        System.out.println("🎉 ¡Felicidades, has capturado a " + pokemon.getNombre() + "! 🎉");
        System.out.println("Intentos: " + intentos);
        seguirIntentando = false; // ¡Fin del combate!
    } else {
        System.out.println("💨 " + pokemon.getNombre() + " se ha escapado... ¡sigue intentándolo!");
        System.out.println("¿Lanzar otra " + pokeball.getNombreBall() + "?\n---Y=Sí / N= No");
        char respuesta = sc.nextLine().trim().toUpperCase().charAt(0);

        if (respuesta == 'Y') {
            seguirIntentando = true;
        } else {
            System.out.println(pokemon.getNombre() + " ha huido...");
            seguirIntentando = false; // El/la entrenadora se rinde 🫠
        }
        System.out.println("----------------");
    }
} while (!capturado && seguirIntentando);


    }
}
