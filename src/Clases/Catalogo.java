package Clases;

import Otros.GeneradorID;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {

    private final int id;
    private String nombreEmpresa;

    private String nombreCatalogo;

    private List<Montaña> listaMontaña = new ArrayList<>();

    public Catalogo(String nombreEmpresa, String nombreCatalogo) {
        this.nombreEmpresa = nombreEmpresa;
        this.nombreCatalogo = nombreCatalogo;
        this.id = GeneradorID.generarId();
    }

    public int getId() {
        return id;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombreCatalogo() {
        return nombreCatalogo;
    }

    public void setNombreCatalogo(String nombreCatalogo) {
        this.nombreCatalogo = nombreCatalogo;
    }

    public List<Montaña> getListaMontaña() {
        return listaMontaña;
    }

    public void setListaMontaña(Montaña montaña) {
        this.listaMontaña.add(montaña);
    }
}
