package Clases;

import Clases.Usuarios.Alpinista;
import Otros.GeneradorID;

import java.util.ArrayList;
import java.util.List;

public class Montaña {
    private final int id;
    private String nombre;
    private int idCatalogo;

    private List<Alpinista> listaAlpinista = new ArrayList<>();
    private List<Expedicion> listaExpedicion = new ArrayList<>();

    public Montaña(String nombre, int idCatalogo) {
        this.nombre = nombre;
        this.idCatalogo = idCatalogo;
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

    public int getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(int idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public List<Alpinista> getListaAlpinista() {
        return listaAlpinista;
    }

    public void setListaAlpinista(Alpinista alpinista) {
        this.listaAlpinista.add(alpinista);
    }

    public List<Expedicion> getListaExpedicion() {
        return listaExpedicion;
    }

    public void setListaExpedicion(Expedicion expedicion) {
        this.listaExpedicion.add(expedicion);
    }

}
