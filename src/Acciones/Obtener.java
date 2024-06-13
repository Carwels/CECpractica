package Acciones;

import Clases.Expedicion;
import Clases.Montaña;
import Clases.Usuarios.Excursionista;
import Clases.Usuarios.Medico;

import java.util.Scanner;

import static BaseDeDatos.BD.*;
import static BaseDeDatos.BD.listaExcursionistas;
import static Otros.Ansi.*;


public class Obtener {
    public static void verMontanas(){
        if(listaMontañas.isEmpty()){
            System.out.println(ANSI_RED_BACKGROUND + "No hay montanas que mostrar" + ANSI_RESET_BACK);
            return;
        }
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        System.out.println(YELLOW + "||        LISTA DE MONTANAS      ||" + RESET);
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        for(Montaña m : listaMontañas){
            System.out.println(m.getNombre());
        }
        if(editar()) Editar.editarMontaña();

    }

    public static void verExpediciones(){
        if(listaExpediciones.isEmpty()){
            System.out.println(ANSI_RED_BACKGROUND + "No hay expediciones que mostrar" + ANSI_RESET_BACK);
            return;
        }
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        System.out.println(YELLOW + "||      LISTA DE EXPEDICIONES    ||" + RESET);
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        for(Expedicion e : listaExpediciones){
            System.out.println(e.getNombre());
        }
        if(editar())Editar.editarExpedicion();

    }

    public static void verExcursionistas(){
        if(listaExcursionistas.isEmpty()){
            System.out.println(ANSI_RED_BACKGROUND + "No hay excursionistas que mostrar" + ANSI_RESET_BACK);
            return;
        }
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        System.out.println(YELLOW + "||    LISTA DE EXCURSIONISTAS    ||" + RESET);
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        for(Excursionista e : listaExcursionistas){
            System.out.println(listaExcursionistas.indexOf(e) + " : " + e.getNombre());
            if(e instanceof Medico) System.out.println("Tipo: Medico");
            else System.out.println("Tipo: Alpinista");
        }
        if(editar())Editar.editarExcursionista();
    }

    public static boolean editar(){
        Scanner kb = new Scanner(System.in);
        while(true){
            System.out.println(YELLOW + "Editar? Y/N" + RESET);
            String input = kb.nextLine().toLowerCase();
            if(input.matches("y")){
                return true;
            }
            if (input.matches("n")) return false;
        }
    }

}
