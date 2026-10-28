public class Carga extends Vehiculo {

    public static final double MONTO_PEAJE = 500;
    public static final String TIPO = "Carga";

    public Carga(String pPlaca, String pMarca, String pModelo, int pAnnio) {
        super(pPlaca, pMarca, pModelo, pAnnio);
    }

    public double calcularMontoPeaje() {
        return MONTO_PEAJE;
    }

    public String toString() {
        return super.toString() + "\nTipo= " + TIPO;
    }
}
