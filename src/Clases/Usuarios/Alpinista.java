package Clases.Usuarios;

import Clases.Montaña;

import java.util.ArrayList;
import java.util.List;

public class Alpinista extends Excursionista {
    private List<Montaña> listaMontañas = new ArrayList<>();
    public Alpinista(String nombre) {
        super(nombre);
    }

    public List<Montaña> getListaMontañas() {
        return listaMontañas;
    }

    public void setListaMontañas(Montaña montaña) {
        this.listaMontañas.add(montaña);
    }
}
