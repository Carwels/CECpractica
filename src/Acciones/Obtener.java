package Acciones;

import Clases.Expedicion;
import Clases.Montaña;
import Clases.Usuarios.Excursionista;
import Clases.Usuarios.Medico;

import static BaseDeDatos.BD.*;
import static BaseDeDatos.BD.listaExcursionistas;
import static Otros.Ansi.RESET;
import static Otros.Ansi.YELLOW;

public class Obtener {
    public static void verMontanas(){
        if(listaMontañas.isEmpty()){
            System.err.println("No hay montanas que mostrar");
            return;
        }
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        System.out.println(YELLOW + "||        LISTA DE MONTANAS      ||" + RESET);
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        for(Montaña m : listaMontañas){
            System.out.println(m.getNombre());
        }
        Editar.editarMontaña();
    }

    public static void verExpediciones(){
        if(listaExpediciones.isEmpty()){
            System.err.println("No hay expediciones que mostrar");
            return;
        }
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        System.out.println(YELLOW + "||      LISTA DE EXPEDICIONES    ||" + RESET);
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        for(Expedicion e : listaExpediciones){
            System.out.println(e.getNombre());
        }
        Editar.editarExpedicion();

    }

    public static void verExcursionistas(){
        if(listaExcursionistas.isEmpty()){
            System.err.println("No hay excursionistas que mostrar");
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
        Editar.editarExcursionista();
    }
}
