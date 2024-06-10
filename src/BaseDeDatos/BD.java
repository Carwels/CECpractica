package BaseDeDatos;

import Clases.Catalogo;
import Clases.Expedicion;
import Clases.Montaña;
import Clases.Usuarios.Excursionista;

import java.util.ArrayList;
import java.util.List;

public class BD {

    public static List<Montaña> listaMontañas = new ArrayList<>();
    public static List<Expedicion> listaExpediciones = new ArrayList<>();
    public static List<Excursionista> listaExcursionistas = new ArrayList<>();
    public static Catalogo catalogo;
}
