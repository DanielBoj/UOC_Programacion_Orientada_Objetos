package aa5_woodshops.clientes;

/**
 * La CLase Profesional es una subclase de la superclase Registrado que a la vez desciende de Cliente.
 * Representa un cliente profesional de la empresa WoodShops y tiene asociado un descuento profesional.
 *
 * @see Cliente
 * @see Registrado
 * @see aa5_woodshops.centros.SedeCentral
 */
public class Profesional extends Registrado {

    private static final double DESCUENTO_BASE = 5.0;

    private double descuento;

    /**
     * Constructor genérico para clase Profesional. Hereda del Constructor de la Clase Registrado que, a su vez, hereda
     * de Cliente. Recibe los atributos comunes y el descuento que se le aplicará al cliente profesional.
     *
     * @param nif       String NIF del cliente.
     * @param nombre    String Nombre completo del cliente.
     * @param descuento double Descuento que se le aplica al cliente.
     */
    public Profesional(String nif, String nombre, double descuento) {
        super(nif, nombre);
        this.descuento = descuento;
    }

    /**
     * Sobrecarga del método constructor. Aplica un descuento por defecto si solo pasamos por parámetro el nif y el nombre
     * del cliente profesional.
     *
     * @param nif    String NIF del cliente.
     * @param nombre String Nombre completo del cliente.
     * @see Cliente
     * @see Registrado
     */
    public Profesional(String nif, String nombre) {
        super(nif, nombre);
        descuento = DESCUENTO_BASE;
    }

    /* Getters & Setters */

    /**
     * Método Getter que devuelve el descuento que se le aplica al cliente profesional.
     *
     * @return double Descuento que se le aplica al cliente profesional.
     */
    public double getDescuento() {
        return descuento;
    }

    /**
     * Método Setter que permite cambiar el descuento que se le aplica a un cliente profesional.
     *
     * @param descuento double Valor de descuento aplicado al cliente.
     */
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    /**
     * Override del método toString() que hereda de la superclase Registrado que a su vez hereda de la superclase Cliente.
     * Muestra la información común del cliente y el valor del campo descuento.
     *
     * @return String Información del cliente.
     * @see Cliente
     * @see Registrado
     */
    @Override
    public String toString() {
        return "Cuenta Profesional:" + "\n" +
                super.toString() +
                "Descuento profesional: " + descuento + "\n";
    }

    /**
     * El método obtenerDescuento() implementa el prototipo declarado en la superclase Cliente para obtener
     * el descuento asociado a un cliente de la subclase Profesional.
     *
     * @return double valor de descuento aplicado al cliente.
     */
    @Override
    public double obtenerDescuento() {
        return getDescuento();
    }

    /**
     * Método de superclase que no se implementa en esta subclase.
     *
     * @return Null
     */
    @Override
    public String mostrarCodigoCLiente() {
        return null;
    }
}
