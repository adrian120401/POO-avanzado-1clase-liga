package LigaFutbol;

import LigaFutbol.Modelos.Equipo;
import LigaFutbol.Modelos.Jugador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static List<Jugador> jugadores = new ArrayList<>();
    public static List<Equipo> equipos = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        Equipo equipo = new Equipo("Uruguay");
        Equipo equipo1 = new Equipo("Argentina");
        Equipo equipo2 = new Equipo("Brasil");
        Equipo equipo3 = new Equipo("Colombia");

        Jugador jugador = new Jugador("Adrian", equipo);
        Jugador jugador1 = new Jugador("Nico", equipo1);
        Jugador jugador2 = new Jugador("Juan", equipo2);
        Jugador jugador3 = new Jugador("Carlos", equipo3);

        jugadores.add(jugador);
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);

        equipos.add(equipo);
        equipos.add(equipo1);
        equipos.add(equipo2);

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearJugador();
                    break;
                case 2:
                    crearEquipo();
                    break;
                case 3:
                    asignarJugadorAEquipo();
                    break;
                case 4:
                    mostrarListaJugadores();
                    break;
                case 5:
                    mostrarListaEquipos();
                    break;
                case 6:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
                    break;
            }
        } while (opcion != 6);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú de Gestión de Liga de Fútbol ---");
        System.out.println("1. Crear jugador");
        System.out.println("2. Crear equipo");
        System.out.println("3. Asignar jugador a equipo");
        System.out.println("4. Mostrar lista de jugadores");
        System.out.println("5. Mostrar lista de equipos");
        System.out.println("6. Salir");
        System.out.print("Selecciona una opción: ");
    }

    public static void crearJugador(){
        System.out.println("Ingresa el nombre del jugador");
        String nombre = scanner.nextLine();

        mostrarListaEquipos();
        System.out.println("Ingresa el numero de equipo");
        int numEquipo = scanner.nextInt() -1 ;

        Equipo equipo = equipos.get(numEquipo);

        Jugador jugador = new Jugador(nombre, equipo);
        jugadores.add(jugador);

        System.out.println("Jugador creado correctamente");
    }

    public static void crearEquipo(){
        System.out.println("Ingresa el nombre del equipo");
        String nombre = scanner.nextLine();

        Equipo equipo = new Equipo(nombre);
        equipos.add(equipo);

        System.out.println("Equipo creado correctamente");
    }

    public static void asignarJugadorAEquipo(){
        mostrarListaJugadores();
        System.out.println("Ingresa el numero de jugador");
        int numJugador = scanner.nextInt() - 1;

        Jugador jugador = jugadores.get(numJugador);

        mostrarListaEquipos();
        System.out.println("Ingresa el numero de equipo");
        int numEquipo = scanner.nextInt() - 1;

        Equipo equipo = equipos.get(numEquipo);

        jugador.setEquipo(equipo);
    }

    public static void mostrarListaJugadores(){
        for (Jugador jugador : jugadores) {
            System.out.println(jugadores.indexOf(jugador) + 1 + "-" + jugador.getNombre() + " pertenece a " + jugador.getEquipo().getNombre());
        }
    }

    public static void mostrarListaEquipos(){
        for (Equipo equipo : equipos) {
            System.out.println(equipos.indexOf(equipo) + 1 + ".-" + equipo.getNombre());
        }
    }
}
