package aa5_woodshops.clientes;

/**
 * La Clase Cliente es la clase padre, representa a los clientes de la empresa WoodShops y se especializa en clientes
 * registrados y clientes no registrados. Almacena los datos generales comunes a todas las subclases, sean del tipo que
 * sen e implementa, igualmente, los métodos comunes a todas las subclases.
 * Almacena el nif del cliente y su nombre. Se ha añadido un contador de clientes.
 *
 * @see aa5_woodshops.centros.SedeCentral
 */
public abstract class Cliente {

    private String nif;
    private String nombre;
    private int clientNum;

    private static int actualClientes = 0;

    /**
     * Superconstructor que heredarán todas las clases descendientes de la superclase Cliente. Recibe los atributos
     * comunes a todas las subclases por parámero, el nif del cliente y su nombre completo.
     *
     * @param nif    String NIF del cliente.
     * @param nombre String Nombre del cliente.
     */
    public Cliente(String nif, String nombre) {
        this.nif = nif;
        this.nombre = nombre;
        clientNum = ++actualClientes;
    }

    /* Getters & Setters */

    /**
     * Método Getter que devueleve el NIF de un cliente.
     *
     * @return String NIF del cliente.
     */
    public String getNif() {
        return nif;
    }

    /**
     * Método Getter que devuelve el nombre del cliente.
     *
     * @return String Nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método Getter que devuelve el número de cliente de una instancia.
     *
     * @return int Número de cliente.
     */
    public int getClientNum() {
        return clientNum;
    }

    /**
     * Método Getter que devuelve el número total de clientes.
     *
     * @return int Número total de clientes.
     */
    public static int getActualClientes() {
        return actualClientes;
    }

    /**
     * Método Setter que permite cambiar el NIF del cliente.
     *
     * @param nif String EL NIF del cliente.
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * Método Setter que permite cambiar el nombre del Cliente.
     *
     * @param nombre String Nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    /**
     * Método setter para poder variar el contador de clientes, lo usarán métodos que trabajan con la lista de clientes.
     *
     * @param actualClientes int Número total de clientes.
     */
    public static void setActualClientes(int actualClientes) {
        Cliente.actualClientes = actualClientes;
    }

    /**
     * Override del método toString() para mostrar por pantalla de forma formateada toda la información de un cliente.
     * Muestra el número de cliente, el nombre y el nif.
     *
     * @return String Información del cliente.
     */
    @Override
    public String toString() {
        return "Cliente: " + clientNum + "\n" +
                "Nombre: " + nombre + "\n" +
                "NIF: " + nif + "\n";
    }

    /**
     * El método changeTotalClientes() permite realizar una modificación del número de clientes si fuera necesario.
     * Lo he incluido pensando en la necesidad de un posible borrado o reseteo de datos.
     *
     * @param count int Número actual de clientes.
     */
    public void changeTotalClientes(int count) {
        setActualClientes(count);
    }

    /* Prototipos */

    /**
     * El método obtenerCodigoCliente() permitirá adjudicar un código de cliente a una instancia de Cliente de la subclase
     * WoodFriend y se implementa en esta subclase.
     *
     * @param key String Llave para generar el código Hash.
     * @return String Código único de cliente.
     * @see WoodFriend
     */
    public static String obtenerCodigoCliente(String key) {
        return null;
    }

    /**
     * El método mostrarCodigoCliente() se implementará en una instancia de la subclase WoodShop y permite mostrar el
     * código único de cliente.
     *
     * @return String Código único de clienta.
     * @see WoodFriend
     */
    public abstract String mostrarCodigoCLiente();

    /**
     * El método obtenerDescuento() se implementará en una instancia d ela subclase Profesional y permite mostrar el tanto
     * porciento de descuento asociado a un cliente profesional.
     *
     * @return double Tanto porciento de descuento.
     * @see Profesional
     */
    public abstract double obtenerDescuento();
}
