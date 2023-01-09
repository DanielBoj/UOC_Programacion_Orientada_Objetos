package aa5_woodshops.ventas;

import aa5_woodshops.centros.Tienda;
import aa5_woodshops.clientes.Cliente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * La Clase Venta representa una venta realizada por una instancia de la Clase Tienda, perteneciente a la empresa.
 * Contiene los datos asociados a la venta: La instancia de la Clase Tienda que realiza la venta, una instancia de la Clase
 * Cliente que representa a un cliente de la lista de clientes de la empresa que realiza la compra y un ArrayList de tipo
 * DetalleVenta que es una Clase Asociativa que guarda las líneas de detalle de una venta y asocia la actual instancia de
 * la Clase Venta con una instancia de la Clase Ticket.
 *
 * @see Tienda
 * @see Cliente
 * @see Ticket
 * @see DetalleVenta
 */
public class Venta {

    private Tienda tienda;
    private Cliente cliente;
    private ArrayList<DetalleVenta> detalleLineas;

    /**
     * Constructor genérico para la Clase Venta, recive por parámetro una instancia de la Clase Tienda, la tienda desde
     * donde se realiza la compra, y una instancia de la Clase Cliente, el cliente que realiza la compra. Además, inicializa
     * un ArrayList de tipo DetalleVenta que almacenará todas las líneas de venta.
     *
     * @param tienda  Tienda Instancia de la Clase Tienda que representa la tienda desde donde se realiza la compra.
     * @param cliente Cliente Instancia de la Clase Cliente que representa al cliente que realiza la compra.
     * @see Tienda
     * @see Cliente
     * @see DetalleVenta
     */
    public Venta(Tienda tienda, Cliente cliente) {
        this.tienda = tienda;
        this.cliente = cliente;
        detalleLineas = new ArrayList<>();
    }

    /* Getters & Setters */

    /**
     * Metodo Getter que devuelve una instancia de Tienda, representa la tienda desde donde se realiza la venta.
     *
     * @return Tienda Instancia de la Clase Tienda.
     * @see Tienda
     */
    public Tienda getTienda() {
        return tienda;
    }

    /**
     * Método Getter que devuelve una instancia de la Clase Cliente que representa el cliente que realiza la compra.
     *
     * @return Cliente Instancia de la Clase Cliente.
     * @see Cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Método Getter que devuelve un ArrayList de tipo DetalleVenta que contiene las líneas de detalle de la venta.
     *
     * @return ArrayList Lista de tipo DetallesVenta.
     * @see DetalleVenta
     */
    public ArrayList<DetalleVenta> getDetalleLineas() {
        return detalleLineas;
    }

    /**
     * Método Setter que permite asignar una instancia de Tienda a la Venta.
     *
     * @param tienda Tienda Instancia de la Clase Tienda.
     * @see Tienda
     */
    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    /**
     * Mñetodo Setter que permite asignar una instancia de Cliente a la Venta.
     *
     * @param cliente Cliente Instancia de la Clase Cliente.
     * @see Cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Override del método to String para convertir los diferentes campos de una instancia de Venta en un String.
     *
     * @return String Información de la venta.
     */
    @Override
    public String toString() {
        return "Venta{" +
                "tienda=" + tienda +
                ", cliente=" + cliente +
                ", detalleLineas=" + detalleLineas +
                '}';
    }

    /**
     * El método addDetalleVente() añade una nueva instancia de DetalleVentas, una línea de venta, al ArrayList de tipo
     * DetalleVenta de una instancia de Venta. Contiene el producto y la cantidad de unidades vendidas.
     * DetalleVenta es una Clase Asociativa que contiene la información de una línea de venta y asocia una instancia de Venta
     * con una instancia de Ticket.
     *
     * @param detalleVenta DetallVenta Instancia de DetalleVenta a añadir en el ArrayList.
     * @see DetalleVenta
     * @see Ticket
     */
    public void addDetalleVenta(DetalleVenta detalleVenta) {
        detalleLineas.add(detalleVenta);
    }

    /**
     * El método printVenta() muestra por pantalla la información de una instancia de Venta, o sea, toda la información de
     * un ticket completo de venta, accediendo a las líneas de venta y al ticket asociados a través de las relaciones establecidad
     * por la Clase Asociativa DetalleVenta. Las línea de venta se almacenan en el ArrayList de tipo DetalleVenta de la
     * instancia actual de Venta.
     * Realiza las diferentes comprobaciones sobre los datos para personalizar la información:
     * Identifica el tipo de cliente.
     * Aplica el descuento si es un cliente profesional.
     * Calcula el valor total de la venta.
     * Delega en métodos de la clase Cliente para obtener el descuento o el código de cliente si fuera necesario,
     * mostrarCodigoCliente() y obtenerDescuento().
     *
     * @param ticket Ticket Instancia de la Clase Ticket asociada a la instancia actual de Venta.
     * @see Ticket
     * @see DetalleVenta
     * @see Cliente
     */
    public void printVenta(Ticket ticket) {

        double descuento = 0.0;

        System.out.println("Bienvenido a WoodShops\t" + tienda.getNombre());

        /* Comprobamos que el cliente esté registrado */
        if (!cliente.getClass().getSimpleName().equals("NoRegistrado")) {
            System.out.println("Cliente: " + cliente.getNombre());

            /* Comprobamos si el cliente es un WoodFriend */
            if (cliente.getClass().getSimpleName().equals("WoodFriend")) {
                System.out.println("Codigo de Cliente: " + cliente.mostrarCodigoCLiente());
            }

            /* Comprobamos si es un cliente profesiones */
            if (cliente.getClass().getSimpleName().equals("Profesional")) {
                descuento = cliente.obtenerDescuento();
                System.out.println("Descuento profesional: " + descuento);
            }

            ticket.printTicketInfo();
            System.out.println("Total: " + calcularTotal());
        } else {
            System.out.println("Cliente: " + cliente.getNombre());
            System.out.println("Cliente no registrado");

            ticket.printTicketInfo();
            System.out.println("Total: " + calcularTotal());
        }

        System.out.println("Muchas gracias por su compra!");

    }

    /**
     * El método printResumenVenta() muestra por pantalla la información resumida de una instancia de Venta accediendo a
     * los elementos de DetalleVenta y al Ticket asociados.
     * Realiza las comprobaciones sobre los datos para conocer la subclase de Cliente y adaptar la información mostrada.
     * Formatea la salida de la fecha para pasarla a un String con un formato más amigable para un usuario español.
     * Delega en los métodos de la Clase Cliente obtenerDescuento() para conocer el descuento aplicado a un Cliente de la
     * subclase Profesional.
     * Usa la función calculatTotal() para obtener el valor total de la venta.
     *
     * @param ticket Ticket Instancia de Ticket de venta asociada a la instancia de Venta, la asociaciómn se recupera en la
     *               llamada a la función mediante el acceso a las instancias de DetalleVenta almacenadas en la lista que
     *               asocian ambas instancias, Venta y Ticket.
     * @see Ticket
     * @see DetalleVenta
     * @see Cliente
     */
    public void printResumenVenta(Ticket ticket) {

        String pattern = "dd-MM-yyyy";
        DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
        LocalDate auxFecha = ticket.getFecha();

        String formattedFecha = auxFecha.format(format);

        System.out.println("-----------------------------------------------");
        System.out.println("Numero de ticket: " + ticket.getNumTicket());
        System.out.println("Fecha de venta: " + formattedFecha);

        /* Comprobamos si el cliente está registrado */
        if (!cliente.getClass().getSimpleName().equals("NoRegistrado")) {
            System.out.println(getCliente());
        }

        System.out.println("Importe Total: " + calcularTotal());
    }

    /**
     * El método calcularTotal() usa un iterador sonbre los diferentes elementos de un ArrayList de tipo DetalleVenta para
     * obtener los diferentes costes de cada línea de venta y los suma para calcular el valor total de la venta.
     *
     * @return double Valor total de una venta.
     * @see DetalleVenta
     * @see Ticket
     */
    public double calcularTotal() {

        ListIterator<DetalleVenta> iterator = detalleLineas.listIterator();

        double total = 0.0;

        while (iterator.hasNext()) {
            total += iterator.next().totalLinea();
        }

        return total;
    }
}
