package Clases;

import Clases.Usuarios.Excursionista;
import Clases.Usuarios.Medico;
import Otros.GeneradorID;

import java.util.ArrayList;
import java.util.List;

public class Expedicion {
    private final int id;
    private String nombre;

    private int montañaId;

    private List<Excursionista> listaExcursionista = new ArrayList<>();

    private boolean finalizada = false;

    public Expedicion(String nombre, int montañaId, Medico medico) {
        this.nombre = nombre;
        this.montañaId = montañaId;
        this.id = GeneradorID.generarId();
        setListaExcursionista(medico);
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

    public int getMontañaId() {
        return montañaId;
    }

    public void setMontañaId(int montañaId) {
        this.montañaId = montañaId;
    }

    public List<Excursionista> getListaExcursionista() {
        return listaExcursionista;
    }

    public void setListaExcursionista(Excursionista excursionista) {
        this.listaExcursionista.add(excursionista);
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }
}
