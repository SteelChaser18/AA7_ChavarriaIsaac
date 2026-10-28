public class Reserva {
    private int numero;
    private String nombreCliente;
    private int cantidadPersonas;
    private double monto;

    public Reserva(int pNumero, String pNombreCliente, int pCantidadPersonas, double pMonto) {
        numero = pNumero;
        nombreCliente = pNombreCliente;
        cantidadPersonas = pCantidadPersonas;
        monto = pMonto;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public double getMonto() {
        return monto;
    }

    public String toString() {
        return "Reserva número= " + numero +
               " Cliente= " + nombreCliente +
               " Personas= " + cantidadPersonas +
               " Monto= " + monto;
    }
}
