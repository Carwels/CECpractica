package Acciones;

import static BaseDeDatos.BD.*;

import Clases.Expedicion;
import Clases.Montaña;
import Clases.Usuarios.Alpinista;
import Clases.Usuarios.Excursionista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Otros.Ansi.PURPLE;
import static Otros.Ansi.RESET;

public class Editar {

    public static void editarExpedicion(){
        Expedicion expedicion = null;
        int seleccion = -1;

        while(expedicion == null){
            Scanner input = new Scanner(System.in);
            System.out.println(PURPLE + "Selecciona la expedicion a editar:" + RESET);
            String nombre = input.nextLine().toLowerCase();
            for(Expedicion e : listaExpediciones){
                if(e.getNombre().equals(nombre)) expedicion = e;
            }
            if(expedicion == null) System.err.println("Expedicion no encontrada");
        }
        while(seleccion == -1){
            System.out.println("1) Editar nombre");
            System.out.println("2) Anadir excursionista");
            System.out.println("3) Eliminar excursionista");
            System.out.println("4) Expedicion completada");
            System.out.println("5) Eliminar");
            System.out.println("0) Cancelar");
            seleccion = recogerInput(5);
        }
        Scanner input = new Scanner(System.in);
        switch (seleccion){
            case 0:
                break;
            case 1:
                expedicion.setNombre(input.nextLine().toLowerCase());
                System.out.println(PURPLE + "Nombre actualizado" + RESET);
                break;
            case 2:
                while(true){
                    List<Excursionista> listaExc = new ArrayList<>();
                    System.out.println(PURPLE + "Selecciona el excursionista a anadir:" + RESET);
                    for(Excursionista e : listaExcursionistas){
                        if(!expedicion.getListaExcursionista().contains(e)){
                            listaExc.add(e);
                            System.out.println(e.getNombre());
                        }
                    }
                    if(listaExc.isEmpty()){
                        System.err.println("No hay mas excursionistas disponibles");
                        return;
                    }
                    String nombre = input.nextLine().toLowerCase();
                    for(Excursionista e : listaExcursionistas){
                        if(e.getNombre().equals(nombre)){
                            expedicion.setListaExcursionista(e);
                            e.setListaExpedicion(expedicion);
                            return;
                        }
                    }
                }
            case 3:
                while(true){
                    System.out.println(PURPLE + "Selecciona el excursionista a eliminar:" + RESET);
                    for(Excursionista e : expedicion.getListaExcursionista()){
                        System.out.println(e.getNombre());
                    }
                    String nombre = input.nextLine().toLowerCase();
                    for(Excursionista e : expedicion.getListaExcursionista()){
                        if(e.getNombre().equals(nombre)) {
                            e.getListaExpedicion().remove(expedicion);
                            expedicion.getListaExcursionista().remove(e);
                            return;
                        }
                    }
                    System.err.println("Excursionista no encontrado");
                }
            case 4:
                List<Alpinista> listaAlps = new ArrayList<>();
                expedicion.setFinalizada(true);
                for(Excursionista e : expedicion.getListaExcursionista()){
                    if(e instanceof Alpinista) listaAlps.add((Alpinista) e);
                }
                for(Alpinista a : listaAlps){
                    System.out.println(PURPLE + a.getNombre() + RESET);
                    System.out.println(PURPLE + "¿Ha llegado a la cima? :" + RESET);
                    seleccion = -1;
                    while (seleccion == -1){
                        System.out.println("0) NO");
                        System.out.println("1) SI");
                        seleccion = recogerInput(1);
                    }
                    if(seleccion == 1){
                        for (Montaña m : listaMontañas){
                            if(expedicion.getMontañaId() == m.getId()){
                                m.setListaAlpinista(a);
                                a.setListaMontañas(m);

                            }
                        }
                    }
                }
                break;

            case 5:
                eliminarExpedicion(expedicion);
                break;
        }
    }



    public static void editarMontaña(){
        Montaña montaña = null;
        int seleccion = -1;

        while(montaña == null){
            Scanner input = new Scanner(System.in);
            System.out.println(PURPLE + "Selecciona la montaña a editar:" + RESET);
            String nombre = input.nextLine().toLowerCase();
            for(Montaña m : listaMontañas){
                if(m.getNombre().equals(nombre)) montaña = m;
            }
            if(montaña == null) System.err.println("Montaña no encontrada");
        }
        while(seleccion == -1){
            System.out.println("1) Editar nombre");
            System.out.println("2) Editar lista de alpinistas");
            System.out.println("3) Eliminar");
            System.out.println("0) Cancelar");
            seleccion = recogerInput(3);
        }
        Scanner input = new Scanner(System.in);
        switch (seleccion){
            case 0:
                break;
            case 1:
                montaña.setNombre(input.nextLine().toLowerCase());
                System.out.println(PURPLE + "Nombre actualizado" + RESET);
                break;
            case 2:
                if(montaña.getListaAlpinista().isEmpty()){
                    System.err.println("Ningun alpinista ha llegado a la cima");
                    return;
                }
                while(true){
                    System.out.println(PURPLE + "Selecciona el excursionista a eliminar:" + RESET);
                    for(Alpinista a : montaña.getListaAlpinista()){
                        System.out.println(a.getNombre());
                    }
                    String nombre = input.nextLine().toLowerCase();
                    for(Alpinista e : montaña.getListaAlpinista()){
                        if(e.getNombre().equals(nombre)) {
                            e.getListaMontañas().remove(montaña);
                            montaña.getListaAlpinista().remove(e);
                            return;
                        }
                    }
                    System.err.println("Excursionista no encontrado");
                }
            case 3:
                eliminarMontaña(montaña);
                break;
        }
    }

    public static void editarExcursionista(){
        Excursionista excursionista = null;
        int seleccion = -1;

        while(excursionista == null){
            Scanner input = new Scanner(System.in);
            System.out.println(PURPLE + "Selecciona el excursionista a editar:" + RESET);
            String nombre = input.nextLine().toLowerCase();
            for(Excursionista e : listaExcursionistas){
                if(e.getNombre().equals(nombre)) excursionista = e;
            }
            if(excursionista == null) System.err.println("Excursionista no encontrado");
        }
        while(seleccion == -1){
            System.out.println("1) Editar nombre");
            System.out.println("2) Eliminar expedicion");
            System.out.println("3) Eliminar");
            if(excursionista instanceof Alpinista) System.out.println("4) Editar lista montanas");
            System.out.println("0) Cancelar");
            if(excursionista instanceof Alpinista) seleccion = recogerInput(4);
            else seleccion = recogerInput(3);
        }
        Scanner input = new Scanner(System.in);
        switch (seleccion){
            case 0:
                break;
            case 1:
                excursionista.setNombre(input.nextLine().toLowerCase());
                System.out.println(PURPLE + "Nombre actualizado" + RESET);
                break;
            case 2:
                if(excursionista.getListaExpedicion().isEmpty()) {
                    System.err.println("No hay expediciones");
                    return;
                }
                System.out.println(PURPLE + "Introduce el nombre de la expedicion a eliminar" + RESET);
                for(Expedicion e : excursionista.getListaExpedicion()){
                    System.out.println(e.getNombre());
                }
                String expedicion = input.nextLine().toLowerCase();
                List<Expedicion> expedicionEliminar = new ArrayList<>();
                while(expedicionEliminar.isEmpty()) {
                    for(Expedicion e : excursionista.getListaExpedicion()){
                        if(e.getNombre().matches(expedicion)) expedicionEliminar.add(e);
                    }

                    for(Expedicion exp : expedicionEliminar) {
                        excursionista.getListaExpedicion().remove(exp);
                    }
                    if(!expedicionEliminar.isEmpty()) {
                        expedicionEliminar.get(0).getListaExcursionista().remove(excursionista);
                    }
                    if(expedicionEliminar.isEmpty()) System.err.println("Expedicion no encontrada");
                }
                break;
            case 3:
                eliminarExcursionista(excursionista);
                break;
            case 4:
                while(true){
                    Alpinista alpinista = (Alpinista) excursionista;
                    if(alpinista.getListaMontañas().isEmpty()){
                        System.out.println("El excursionista no ha llegado a ninguna cima");
                        break;
                    }
                    System.out.println(PURPLE + "Selecciona la montana a eliminar:" + RESET);
                    for(Montaña m : alpinista.getListaMontañas()){
                        System.out.println(m.getNombre());
                    }
                    String nombre = input.nextLine().toLowerCase();
                    for(Montaña m : alpinista.getListaMontañas()){
                        if(m.getNombre().equals(nombre)) {
                            m.getListaAlpinista().remove(alpinista);
                            alpinista.getListaMontañas().remove(m);
                            return;
                        }
                    }
                    System.err.println("Montana no encontrada");
                }
        }

    }

    public static void eliminarMontaña(Montaña montaña){
        listaMontañas.remove(montaña);
        catalogo.getListaMontaña().remove(montaña);
        for(Expedicion e : montaña.getListaExpedicion()){
            eliminarExpedicion(e);
        }
        for(Excursionista e : listaExcursionistas){
            if(e instanceof Alpinista) ((Alpinista) e).getListaMontañas().remove(montaña);
        }
    }

    public static void eliminarExpedicion(Expedicion expedicion){
        for(Excursionista e : listaExcursionistas){
            List<Expedicion> expeEliminar = new ArrayList<>();
            for(Expedicion ex : e.getListaExpedicion()){
                if(expedicion.getId() == ex.getId()){
                    expeEliminar.add(ex);
                }
            }
            if(expeEliminar.isEmpty());
            else for(Expedicion exp : expeEliminar){
                e.getListaExpedicion().remove(exp);
            }

        }
        listaExpediciones.remove(expedicion);
        for(Montaña m : listaMontañas){
            if(m.getId() == expedicion.getMontañaId()){
                m.getListaExpedicion().remove(expedicion);
                return;
            }
        }
    }

    public static void eliminarExcursionista(Excursionista excursionista){
        listaExcursionistas.remove(excursionista);
        for(Expedicion e : listaExpediciones){
            for(Expedicion ex : excursionista.getListaExpedicion()){
                if(ex.getId() == e.getId()) e.getListaExcursionista().remove(excursionista);
            }
        }
        if(excursionista instanceof Alpinista){
            Alpinista alpinista = (Alpinista) excursionista;
            for(Montaña m : listaMontañas){
                for(Montaña mo : alpinista.getListaMontañas()){
                    if(m.getId() == mo.getId()) m.getListaAlpinista().remove(excursionista);
                }
            }
        }
    }

    private static int recogerInput(int numeroOpciones){
        Scanner kb = new Scanner(System.in);
        int input = -1;
        while(input < 0 || input > numeroOpciones){
            try{
                input = Integer.parseInt(kb.nextLine());
            }
            catch (NumberFormatException e){
                System.out.println("Introduce un número \n");

            }
            if(input < 0 || input > 6){
                System.out.println("Introduce un número dentro de la seleccion");
            }
        }
        return input;
    }
}
