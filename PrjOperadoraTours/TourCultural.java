public class TourCultural extends Tour {
    private String idioma;

    public TourCultural(String pNombre, double pPrecioBase, int pCupoMaximo, Guia pGuia, String pIdioma) {
        super(pNombre, pPrecioBase, pCupoMaximo, pGuia);
        idioma = pIdioma;
    }

    public double calcularPrecioPorPersona() {
        double precio = precioBase;
        for (Atractivo a : atractivos) {
            precio += a.getMontoEntrada();
        }
        return precio;
    }

    public String toString() {
        String s = super.toString();
        s = s + "Tipo de tour: Cultural\n" +
                "Idioma: " + idioma + "\n";
        return s;
    }
}
