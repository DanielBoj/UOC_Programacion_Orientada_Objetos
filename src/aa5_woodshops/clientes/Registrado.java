package aa5_woodshops.clientes;

/**
 * La Clase Registrado es una subclase de la superclase Cliente y, a su vez, se especializa en las Clases Profesional y
 * WoodFriend. Esta Clase representa a los clientes que están registrados como clientes profesionales o fidelizados de
 * la empresa WoodShops.
 *
 * @see Cliente
 * @see aa5_woodshops.centros.SedeCentral
 */
public abstract class Registrado extends Cliente {

    /**
     * Superconstructor de la superclase Registrado que hereda del constructor de la superclase Cliente y a su vez es heredado
     * por las subclases Profesional y WooFriend. Recibe y envía por parámetro el NIF y el nombre del Cliente.
     *
     * @param nif    String NIF del cliente.
     * @param nombre String Nombre del cliente.
     * @see Cliente
     * @see Profesional
     * @see WoodFriend
     */
    public Registrado(String nif, String nombre) {
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
        return "Cliente Registrado!\n" +
                super.toString();
    }
}