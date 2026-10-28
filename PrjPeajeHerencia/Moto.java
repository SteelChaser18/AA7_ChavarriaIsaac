public class Moto extends Vehiculo {

    public static final double MONTO_PEAJE = 75;
    public static final String TIPO = "Moto";

    public Moto(String pPlaca, String pMarca, String pModelo, int pAnnio) {
        super(pPlaca, pMarca, pModelo, pAnnio);
    }

    public double calcularMontoPeaje() {
        return MONTO_PEAJE;
    }

    public String toString() {
        return super.toString() + "\nTipo= " + TIPO;
    }
}
