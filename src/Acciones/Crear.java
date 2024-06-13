package Acciones;

import Clases.Catalogo;
import Clases.Expedicion;
import Clases.Montaña;
import Clases.Usuarios.Alpinista;
import Clases.Usuarios.Excursionista;
import Clases.Usuarios.Medico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static BaseDeDatos.BD.*;
import static Otros.Ansi.*;
import static Otros.Ansi.RESET;

public class Crear {


    public static void nuevaMontaña(){
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        System.out.println(YELLOW + "||         NUEVA MONTANA         ||" + RESET);
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        Scanner input = new Scanner(System.in);

        System.out.println(YELLOW + "Introduce el nombre: " + RESET);
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        String nombre = input.nextLine().toLowerCase();

        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        System.out.println(GREEN + "Montana creada: " + nombre + RESET);
        System.out.println(YELLOW + "||-------------------------------||" + RESET);

        Montaña nuevaMontaña = new Montaña(nombre, catalogo.getId());
        listaMontañas.add(nuevaMontaña);
        catalogo.setListaMontaña(nuevaMontaña);
    }

    public static void nuevaExpedicion(){
        Medico medico = null;
        Montaña montaña = null;

        if(listaMontañas.isEmpty()){
            System.out.println(ANSI_RED_BACKGROUND + "No existen montanas" + ANSI_RESET_BACK);
            return;
        } else if (listaExcursionistas.isEmpty()) {
            System.out.println(ANSI_RED_BACKGROUND + "No existen excursionistas" + ANSI_RESET_BACK);
            return;
        }

        List<Medico> listaMedicos = new ArrayList<>();
        for(Excursionista e : listaExcursionistas){
            if(e instanceof Medico) listaMedicos.add((Medico) e);
        }

        if (listaMedicos.isEmpty()){
            System.out.println(ANSI_RED_BACKGROUND + "No hay medicos disponibles" + ANSI_RESET_BACK);
            return;
        }
        else{
            while(medico == null){
                Scanner input = new Scanner(System.in);
                System.out.println(YELLOW + "Anade un medico para crear la expedicion: " + RESET);
                for(Medico m : listaMedicos){
                    System.out.println(m.getNombre());
                }
                String nombreMedico = input.nextLine().toLowerCase();
                for(Medico m : listaMedicos){
                    if(m.getNombre().matches(nombreMedico)) medico = m;

                }
                if(medico == null) System.out.println(ANSI_RED_BACKGROUND + "Medico no encontrado" + ANSI_RESET_BACK);
            }
        }

        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        System.out.println(YELLOW + "||         NUEVA EXPEDICION      ||" + RESET);
        System.out.println(YELLOW + "||-------------------------------||" + RESET);




        while(montaña == null){
            Scanner input = new Scanner(System.in);
            System.out.println(YELLOW + "Escribe el nombre de la montana: " + RESET);
            for(Montaña m : listaMontañas){
                System.out.println(m.getNombre());
            }
            String nombreMontaña = input.nextLine().toLowerCase();
            for(Montaña m : listaMontañas){
                if(m.getNombre().matches(nombreMontaña)) montaña = m;

            }
            if(montaña == null) System.out.println(ANSI_RED_BACKGROUND + "Montana no encontrada" + ANSI_RESET_BACK);
        }


        Scanner input = new Scanner(System.in);
        System.out.println(YELLOW + "Introduce el nombre de la expedicion: " + RESET);
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        String nombre = input.nextLine().toLowerCase();

        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        System.out.println(GREEN + "Expedicion creada: " + nombre + RESET);
        System.out.println(YELLOW + "||-------------------------------||" + RESET);

        Expedicion expedicion = new Expedicion(nombre, montaña.getId(), medico);
        listaExpediciones.add(expedicion);
        medico.setListaExpedicion(expedicion);
        montaña.setListaExpedicion(expedicion);
    }

    public static void nuevoExcursionista(){
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        System.out.println(YELLOW + "||        NUEVO EXCURSIONISTA    ||" + RESET);
        System.out.println(YELLOW + "||-------------------------------||" + RESET);

        Scanner input = new Scanner(System.in);
        System.out.println(YELLOW + "Introduce el nombre del excursionista: " + RESET);
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        String nombre = input.nextLine().toLowerCase();

        Excursionista excursionista = null;

        while(excursionista == null){
            System.out.println(PURPLE + "Introduce el tipo de excursionista: MEDICO o ALPINISTA" + RESET);
            String i = input.nextLine().toLowerCase();
            if(i.matches("medico")) excursionista = new Medico(nombre);
            else if (i.matches("alpinista")) excursionista = new Alpinista(nombre);
            else System.out.println(ANSI_RED_BACKGROUND + "Tipo no reconocido" + ANSI_RESET_BACK);
        }
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        System.out.println(GREEN + "Excursionista creado: " + nombre + RESET);
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        listaExcursionistas.add(excursionista);
    }
}
