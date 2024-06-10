package Otros;

public class GeneradorID {

    private static int contador = 0;

    public static int generarId() {
        int nuevaId = contador;
        contador++;
        return nuevaId;
    }
}
