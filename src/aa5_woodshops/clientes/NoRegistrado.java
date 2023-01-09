package aa5_woodshops.clientes;

/**
 * La Clase NoRegistrado es una subclase de la superclase Cliente.
 * Representa a un cliente no registrado de la empresa WoodShops pero del cuál necesitamos los datos
 * compartidos para poder realizar el ticket.
 *
 * @see Cliente
 */
public class NoRegistrado extends Cliente {

    /**
     * Constructor genérico de la Clase, hace una llamada al constructor de la superclase Cliente y le pasa el nombre y el
     * nif del cliente por parámetro.
     *
     * @param nif    String NIF del cliente.
     * @param nombre String Nombre del cliente.
     * @see Cliente
     */
    public NoRegistrado(String nif, String nombre) {
        super(nif, nombre);
    }

    /**
     * Override del método toString() de la superclase Cliente que muestra la información del cliente por pantalla.
     * Usa los datos comunes, no recibe nueva información.
     *
     * @return String Datos del cliente.
     * @see Cliente
     */
    @Override
    public String toString() {
        return "Cliente no registrado!\n" +
                super.toString();
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

    /**
     * Método de superclase que no se implementa en esta subclase.
     *
     * @return 0
     */
    @Override
    public double obtenerDescuento() {
        return 0;
    }
}
