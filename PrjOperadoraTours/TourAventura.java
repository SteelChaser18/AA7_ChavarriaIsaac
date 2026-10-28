public class TourAventura extends Tour {
    public static final double PORCENTAJE_SEGURO_AVENTURA = 0.15;
    public static final String DIFICULTAD_BAJO = "bajo";
    public static final String DIFICULTAD_MEDIO = "medio";
    public static final String DIFICULTAD_ALTO = "alto";
    public static final String DIFICULTAD_POR_OMISION = DIFICULTAD_MEDIO;

    private String nivelDificultad;

    public TourAventura(String pNombre, double pPrecioBase, int pCupoMaximo, Guia pGuia, String pNivelDificultad) {
        super(pNombre, pPrecioBase, pCupoMaximo, pGuia);
        nivelDificultad = pNivelDificultad;
    }

    public TourAventura(String pNombre, double pPrecioBase, int pCupoMaximo, Guia pGuia) {
        this(pNombre, pPrecioBase, pCupoMaximo, pGuia, DIFICULTAD_POR_OMISION);
    }

    public double calcularPrecioPorPersona() {
        return precioBase + (precioBase * PORCENTAJE_SEGURO_AVENTURA);
    }

    public String toString() {
        String s = super.toString();
        s = s + "Tipo de tour: Aventura\n" +
                "Nivel de dificultad: " + nivelDificultad + "\n";
        return s;
    }
}
