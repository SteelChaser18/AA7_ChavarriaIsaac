import java.util.ArrayList;

public abstract class Tour {
    public static final String PREFIJO_CODIGO = "TOUR-";
    public static final double PORCENTAJE_DESCUENTO_NACIONAL = 0.20;
    public static final int CANTIDAD_PERSONAS_POR_OMISION = 1;

    private static int cantidadTours;

    private String codigo;
    private String nombre;
    protected double precioBase;
    private int cupoMaximo;
    private Guia guia;
    protected ArrayList<Atractivo> atractivos;
    private ArrayList<Reserva> reservas;

    public Tour(String pNombre, double pPrecioBase, int pCupoMaximo, Guia pGuia) {
        cantidadTours++;
        codigo = PREFIJO_CODIGO + cantidadTours;
        nombre = pNombre;
        precioBase = pPrecioBase;
        cupoMaximo = pCupoMaximo;
        guia = pGuia;
        atractivos = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public abstract double calcularPrecioPorPersona();

    public final double calcularIngresoTotal() {
        double total = 0;
        for (Reserva r : reservas) {
            total += r.getMonto();
        }
        return total;
    }

    public void agregarAtractivo(Atractivo a) {
        if (!atractivos.contains(a)) {
            atractivos.add(a);
        }
    }

    public void cambiarGuia(Guia pGuia) {
        guia = pGuia;
    }

    public void registrarReserva(Cliente c, int cantidadPersonas) {
        if (esReservaValida(cantidadPersonas)) {
            int numero = calcularSiguienteNumeroReserva();
            double monto = calcularMontoReserva(c, cantidadPersonas);
            reservas.add(new Reserva(numero, c.getNombre(), cantidadPersonas, monto));
        }
    }

    public void registrarReserva(Cliente c) {
        registrarReserva(c, CANTIDAD_PERSONAS_POR_OMISION);
    }

    public int calcularCuposDisponibles() {
        int ocupados = 0;
        for (Reserva r : reservas) {
            ocupados += r.getCantidadPersonas();
        }
        return cupoMaximo - ocupados;
    }

    public String consultarNombresAtractivos() {
        String s = "";
        for (int i = 0; i < atractivos.size(); i++) {
            if (i > 0) {
                s = s + ", ";
            }
            s = s + atractivos.get(i).getNombre();
        }
        return s;
    }

    public String consultarNombreGuia() {
        return guia.getNombreCompleto();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public static int getCantidadTours() {
        return cantidadTours;
    }

    private boolean esReservaValida(int cantidadPersonas) {
        return cantidadPersonas > 0 && cantidadPersonas <= calcularCuposDisponibles();
    }

    private int calcularSiguienteNumeroReserva() {
        return reservas.size() + 1;
    }

    private double calcularMontoReserva(Cliente c, int cantidadPersonas) {
        double monto = calcularPrecioPorPersona() * cantidadPersonas;
        if (c.esNacional()) {
            monto = monto - (monto * PORCENTAJE_DESCUENTO_NACIONAL);
        }
        return monto;
    }

    public String toString() {
        String s = "Código: " + codigo + "\n" +
                   "Nombre: " + nombre + "\n" +
                   "Guía: " + consultarNombreGuia() + "\n" +
                   "Precio base: " + precioBase + "\n" +
                   "Precio por persona: " + calcularPrecioPorPersona() + "\n" +
                   "Cupo máximo: " + cupoMaximo + "\n" +
                   "Cupos disponibles: " + calcularCuposDisponibles() + "\n" +
                   "Atractivos: " + consultarNombresAtractivos() + "\n" +
                   "Reservas (" + reservas.size() + "):\n";
        for (Reserva r : reservas) {
            s = s + "- " + r + "\n";
        }
        s = s + "Ingreso total: " + calcularIngresoTotal() + "\n";
        return s;
    }
}
