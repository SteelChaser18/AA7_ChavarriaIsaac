public class Particular extends Vehiculo {

    public static final double MONTO_PEAJE = 100;
    public static final String TIPO = "Particular";

    public Particular(String pPlaca, String pMarca, String pModelo, int pAnnio) {
        super(pPlaca, pMarca, pModelo, pAnnio);
    }

    public double calcularMontoPeaje() {
        return MONTO_PEAJE;
    }

    public String toString() {
        return super.toString() + "\nTipo= " + TIPO;
    }
}
