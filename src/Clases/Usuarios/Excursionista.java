package Clases.Usuarios;

import Clases.Expedicion;
import Otros.GeneradorID;

import java.util.ArrayList;
import java.util.List;

public abstract class Excursionista {

    private final int id;
    private String nombre;

    private List<Expedicion> listaExpedicion = new ArrayList<>();

    public Excursionista(String nombre) {
        this.nombre = nombre;
        this.id = GeneradorID.generarId();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Expedicion> getListaExpedicion() {
        return listaExpedicion;
    }

    public void setListaExpedicion(Expedicion expedicion) {
        this.listaExpedicion.add(expedicion);
    }
}
