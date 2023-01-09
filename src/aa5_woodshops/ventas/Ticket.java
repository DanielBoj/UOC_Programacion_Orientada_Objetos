package aa5_woodshops.ventas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * La Clase Ticket representa un ticket de compra asociado a una instancia de la Clase Venta a través de la Clase Asociativa
 * DetalleVenta que representa cada una de la líneas del ticket. Almacena un número de ticket que se asigna de forma
 * automática durante la creación de la instancia; la fecha de venta, que se gestiona mediante LocalDate ya que forma parte
 * de la librería java.time, una librería actualizada que moderniza las funciones de gestión de fechas y tiempo desde
 * Java 8, y una ArrayList de tipo DetalleVenta con las diferentes líneas de venta que, además, es una Clase Asociativa
 * para relacionar una instancia de Venta con una instancia de Ticket.
 *
 * @see Venta
 * @see DetalleVenta
 */
public class Ticket {

    private String numTicket;
    private LocalDate fecha;
    private ArrayList<DetalleVenta> detalleLineas;

    private static int actualNumTicket = 0;

    /**
     * Constructor genérico para Clase Ticket, no recibe datos por parámetro ya que automatiza la inicialización de la
     * instancia.
     * Genera un nuevo número de ticket y actualiza el contador estático.
     * Asigna la fecha actual a la fecha de venta a través de LocalDate.now().
     * Inicializa el ArrayList de tipo DetalleVenta.
     *
     * @see Venta
     * @see DetalleVenta
     */
    public Ticket() {
        numTicket = "TCK" + Integer.toString(++actualNumTicket);
        fecha = LocalDate.now();
        detalleLineas = new ArrayList<>();
    }

    /* AA5 */

    /**
     * Override del constructor genérico que permite generar una venta en una fecha específica.
     *
     * @param date String Fecha de la venta en formato dd-MM-yyyy.
     */
    public Ticket(String date) {
        numTicket = "TCK" + Integer.toString(++actualNumTicket);
        detalleLineas = new ArrayList<>();

        /* generamos la fecha */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            this.fecha = LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("No se ha podido generar la venta.");
            return;
        }
    }

    /* Getters & Setters */

    /**
     * Método Getter que devuelve el número de Ticket.
     *
     * @return String Número de ticket.
     */
    public String getNumTicket() {
        return numTicket;
    }

    /**
     * Método Getter que devuelve la fecha del ticket.
     *
     * @return LocalDate Fecha del ticket.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Método Getter que devuelve un ArrayList del tipo DetalleVenta con todas la líneas de venta.
     *
     * @return ArrayList ArrayList del tipo DetalleVenta
     * @see DetalleVenta
     */
    public ArrayList<DetalleVenta> getDetalleLineas() {
        return detalleLineas;
    }

    /**
     * Método Getter que devuelve el valor actual del contador estático de número de tickets totales asociados a una
     * tienda.
     *
     * @return int Número actual del contador de tickets.
     */
    public static int getActualNumTicket() {
        return actualNumTicket;
    }

    /**
     * Método Setter que permite modificar el número de ticket.
     *
     * @param numTicket String Número de Ticket.
     */
    public void setNumTicket(String numTicket) {
        this.numTicket = numTicket;
    }

    /**
     * Método Setter que permite modificar la fecha del ticket.
     *
     * @param fecha LocalDate Fecha de venta.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Método Setter que permite modificar el valor del contador estático de tickets.
     *
     * @param actualNumTicket int Valor del contador de tickets.
     */
    public static void setActualNumTicket(int actualNumTicket) {
        Ticket.actualNumTicket = actualNumTicket;
    }

    /**
     * Override del método toString() para convertir los campos de una instancia de Ticket en un String.
     *
     * @return String Valores de los campos de un ticket.
     */
    @Override
    public String toString() {
        return "Ticket{" +
                "numTicket='" + numTicket + '\'' +
                ", fecha=" + fecha +
                ", detalleLineas=" + detalleLineas +
                '}';
    }

    /**
     * El método addDetalleVenta() añade una instancia de la Clase DetalleVenta al ArrayList de tipo DetalleVenta de una
     * instancia de Ticket. Representa las diferentes líneas de venta. DetalleVenta es una clase asociativa que relaciona
     * una instancia de venta con una instanica de Ticket a través de las distintas líneas de venta. La misma instancia
     * DetalleVenta se almacena en un ArrayList de cada una de las Instancias de Venta y Ticket implicadas en la asociación
     * y pueden comunicarse entre ellas a través de la Clase Asociativa.
     * La función hace uso del método de la Clase ArrayList add() que añade un nuevo elemento como última posición de la
     * lista.
     *
     * @param detalleVenta DetalleVenta Instancia de DetalleVenta con la información de una línea del ticket de venta.
     * @see Ticket
     * @see DetalleVenta
     */
    public void addDetalleVenta(DetalleVenta detalleVenta) {
        detalleLineas.add(detalleVenta);
    }

    /**
     * El método printTicket() dad formato a los datos de un ticket para imprimirlos por pantalla. Usa la clase
     * DateTimeFormater para crear un formateador para las fechas a través de un patrón, de este modo, un usuario hispanohablante
     * se sentirá más cómodo con el formato de estas. Para manejar las fechas, usa la LocalDate de la librería
     * java.time ya que implementa funciones más modernas y adaptados a los requisitos actuales desde Java 8.
     * Usa la función printAllDetalles() para acceder a las diferentes líneas de producto, instancias de la Clase
     * DetalleVenta almacenadas en el ArrayList "ventas" e imprimer las líneas del ticket.
     *
     * @see DetalleVenta
     */
    public void printTicketInfo() {

        String pattern = "dd-MM-yyyy";
        DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);

        String formattedFecha = fecha.format(format);

        System.out.println("-----------------------------------------------------");
        System.out.println("Numero de ticket: " + numTicket + "\tFecha de compra " + formattedFecha);
        System.out.println("Producto\t" + "Unidades\t" + "Precio\t" + "Subtotal");
        printAllDetalles();
        System.out.println("-----------------------------------------------------");
    }

    /**
     * El método prinAllDetalles accede a las distintas líneas de venta, instancias de la Clase DetalleVenta, almacenadas
     * en el ArrayList "ventas" y muestra los detalles de cada línea por pantalla. Para ello, delega en la Clase
     * DetalleVenta usando la función printDetalle().
     *
     * @see DetalleVenta
     */
    public void printAllDetalles() {

        for (DetalleVenta linea : detalleLineas) {
            linea.printDetalle();
        }
    }
}
