package aa5_woodshops.clientes;


import aa5_woodshops.centros.SedeCentral;
import aa5_woodshops.ventas.Oferta;

import java.util.ArrayList;

/**
 * La subclase WoodFriend es una subclase de la Clase Registrado que, a su vez, deriva de la Clase Cliente.
 * Representa a un cliente fidelizado de la empresa WoodShops y alamacena un código único que identifica al cliente.
 * Como se trata de un código único generado de forma automática, no hay método Setter para cambiarlo.
 * Por último, almacena las diferentes ofertas aplicadas al cliente en un ArrayList del tipo Oferta.
 *
 * @see Cliente
 * @see aa5_woodshops.centros.SedeCentral
 */
public class WoodFriend extends Registrado {

    private String codigoCliente;
    private ArrayList<Oferta> ofertas;

    /**
     * Constructor genérico para la Clase WoodFriend que herada del constructor de la superclase Registrado que, a su vez.
     * hereda de la superclase Cliente. Recibe por parámetro el nif y el nombre completo del cliente fidelizado y los
     * envía al superconstructor. Finalmente inicializa el ArrayList que contiene las ofertas aplicadas al cliente.
     *
     * @param nif    String NIF del cliente.
     * @param nombre String Nombre completo del cliente.
     * @see Cliente
     * @see Registrado
     */
    public WoodFriend(String nif, String nombre) {
        super(nif, nombre);
        codigoCliente = obtenerCodigoCliente(nif);
        ofertas = new ArrayList<>();
    }

    /* Getters & Setters */

    /**
     * Método Getter que permite obtener el código del cliente.
     *
     * @return String Código de cliente.
     */
    public String getCodigoCliente() {
        return codigoCliente;
    }

    /**
     * Método Getter que devuelve un ArrayList del tipo Oferta con las ofertas que se le aplican al CLiente.
     *
     * @return ArrayList ArrayList del tipo Oferta
     */
    public ArrayList<Oferta> getOfertas() {
        return ofertas;
    }

    /**
     * Método Setter que permite añadir un ArrayList del tipo Oferta con las ofertas aplicadas a un cliente.
     *
     * @param ofertas ArrayList ArrayList del tipo Oferta.
     */
    public void setOfertas(ArrayList<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    /**
     * Override del método toString() que hereda de la superclase Registrado que a su vez hereda de la superclase Cliente.
     * Muestra la información común del cliente y el valor del codigoCliente.
     *
     * @return String Información del cliente.
     * @see Cliente
     * @see Registrado
     */
    @Override
    public String toString() {
        return "Socio WoodFriend: " + "\n" +
                super.toString() +
                "Código de socio: " + codigoCliente + "\n";
    }

    /* Métodos de clase */

    /**
     * El método obtenerCodigoCliente() implementa el prototipo declarado en la superclase Cliente y crea y obtiene un
     * código único de cliente para una instancia de la subclase WooFriend.
     * Delega en el método adjudicarCodigoCLiente() de la Clase SedeCentral al que le pasa una llave para obtener el código
     * Hash que obtiene como parámetro.
     *
     * @param key String Llave para obtene rel Hash key.
     * @return String Código único de cliente.
     * @see SedeCentral
     * @see Cliente
     * @see Registrado
     */
    public static String obtenerCodigoCliente(String key) {
        return SedeCentral.adjudicarCodigoCliente(key);
    }

    /**
     * El método mostrarCodigoCliente() implementa el prototipo declarado en la superclase Cliente y permite obtener el
     * código de cliente único asociado a una instancia de Cliente.
     *
     * @return String Código único de Cliente.
     * @see Cliente
     * @see Registrado
     */
    @Override
    public String mostrarCodigoCLiente() {
        return getCodigoCliente();
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
