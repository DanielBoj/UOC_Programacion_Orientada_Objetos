package aa5_woodshops.ventas;

import aa5_woodshops.items.Producto;
import aa5_woodshops.items.Stock;

/**
 * La Clase DetalleVenta es una clase Asociativa que relaciona una instancia de la Clase Venta con una de la Clase Ticket
 * a través de los detalles de sus diferentes líneas de venta. Cada linea de venta, una instancia de esta Clase, se relaciona
 * una instancia de la Clase Producto, un producto que compra el cliente y almacena el número de unidades vendidas. Además,
 * guarda una instancia de la Clase Venta y otra de la Clase Ticket que relaciona entre ellas. Cada una de las instancias
 * de DetalleVente se guarda en un ArrayList tanto en Ticket como en Venta, relacionando y permitiendo la comunicación entre
 * ambas clases.
 *
 * @see Venta
 * @see Ticket
 * @see Producto
 */
public class DetalleVenta {

    private Producto producto;
    private int unidades;
    private Venta venta;
    private Ticket ticket;

    /**
     * Constructor genérico para la clase DetalleVenta.
     * Recibe una instancia de la Clase Producto y un entero por parámetros que representan el producto vendido y las unidades
     * vendidas. Ademas recibe una instancia de Venta y una instancia de Ticket que quedan relacionadas así entre ellas.
     *
     * @param producto Producto Instancia de la clase Producto que representa el producto vendido.
     * @param unidades int Número de unidades del producto vendidas.
     * @param venta    Venta Instancia de la Clase Venta que representa una venta realizada por una tienda.
     * @param ticket   Ticket Insatancia de la Clase Ticket que representa el ticket de una venta.
     * @see Producto
     * @see Venta
     * @see Ticket
     */
    public DetalleVenta(Producto producto, int unidades, Venta venta, Ticket ticket) {
        this.producto = producto;
        this.unidades = unidades;
        this.venta = venta;
        this.ticket = ticket;
    }

    /* Getters & Setters */

    /**
     * Método Getter que obtiene una instancia de la Clase Producto que representa el producto comprado.
     *
     * @return Producto Instancia de la Clase Producto.
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Método Getter que obtiene el número de unidades vendidas del Producto.
     *
     * @return int Número de unidades vendidas.
     */
    public int getUnidades() {
        return unidades;
    }

    /**
     * Método Getter que retorna una instancia de la Clase Venta que representa la venta relacionada por una tienda y
     * permite relacionar Venta y Ticket.
     *
     * @return Venta Instancia de la Clase Venta.
     * @see Venta
     */
    public Venta getVenta() {
        return venta;
    }

    /**
     * Método Getter que retorna una instancia de la Clase Ticket que implementa el ticket de compra de una venta.
     *
     * @return Ticket Instancia de la Clase Ticket.
     * @see Ticket
     */
    public Ticket getTicket() {
        return ticket;
    }

    /**
     * Método Setter que permite asignar una instancia de la Clase Producto a una línea de venta.
     *
     * @param producto Producto Instancia de la Clase Producto que representa el producto vendido.
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * Método Setter que permite asignar el número de unidades vendidas.
     *
     * @param unidades int Número de unidades vendidas.
     */
    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    /**
     * Override del método toString() que formatea los datos de una instancia de DetalleVenta en un String para presentar
     * toda la información.
     *
     * @return String Datos de una instancia de DetalleVenta.
     */
    @Override
    public String toString() {
        return "DetalleVenta{" +
                "producto=" + producto +
                ", unidades=" + unidades +
                ", venta=" + venta +
                ", ticket=" + ticket +
                '}';
    }

    /**
     * El método totalLinea() calcula el subtotal de una línea de venta. Usa la relación con la instancia de Venta para
     * acceder a la Tienda, así puede acceder a la instancia de Almacen relacionada con la Tienda. De la instancia Almacen
     * puede obtener el inventario de producto, accediento a la instancia de Stock almacenada en la lista.
     * Del mismo modo, a través de estas relaciones, accede a la función buscarProductoPorCodigo(), delegando en la Clase
     * Almacén, y accede a la Clase Producto para usar su Getter y obtene rel precio de venta. Es decir, nos aprovechamos
     * de las Clases Asociativas que hemos ido creando.
     *
     * @return double Valor de venta, subtotal, de una línea.
     * @see aa5_woodshops.centros.Tienda
     * @see aa5_woodshops.centros.Almacen
     * @see Venta
     */
    public double totalLinea() {

        /* Obtenemos el precio de venta de producto */
        double precioVenta = venta.getTienda().getAlmacen().getInventario().get(venta.getTienda().getAlmacen().buscarProductoPorCodigo(producto.getCodigoProducto())).getPrecioVenta();
        double total = 0.0;

        if (venta.getCliente().getClass().getSimpleName().equals("Profesional")) {
            double descuento = venta.getCliente().obtenerDescuento();
            total = (unidades * precioVenta) - ((descuento / 100) * (unidades * precioVenta));
        } else {
            total = unidades * precioVenta;
        }

        return total;
    }

    /**
     * El método printDetalle() obtiene los datos necesarios de un Producto asociado a una línea de venta, a través de las
     * relaciones establecidas entre la Clase Venta con la Clase Tienda; a través de la Clase Tienda podemos acceder a la
     * instancia de Almacén relacionada donde guardamos, en el ArrayList "inventario", las instancias de la Clase Asociativa
     * Stock desde donde podemos obtener toda la información sobre el producto vendido.
     * Por otro lado, mostramos la información de la línea de venta: El código de producto, las unidades vendidas y el precio
     * de venta del producto.
     * A continuación, discriminamos si se trata de un cliente Profesional o no para saber si debemos aplicar el descuento.
     * Lo conseguimos obteniendo el nombre simplificado de la clase. Si es así, obtenemos el descuento asociado al cliente
     * y calculamos el subtotal de la línea. Si no, calculamos el subtotal sin descuentos. El valor se parsea de double a
     * String para imprimirlo por pantalla.
     *
     * @see Producto
     * @see aa5_woodshops.centros.Tienda
     * @see aa5_woodshops.centros.Almacen
     * @see Producto
     * @see Stock
     */
    public void printDetalle() {

        double precioVenta = venta.getTienda().getAlmacen().getInventario().get(venta.getTienda().getAlmacen().buscarProductoPorCodigo(producto.getCodigoProducto())).getPrecioVenta();
        String strBase, strPlus;

        strBase = (producto.getCodigoProducto() + "\t\t" +
                unidades + "\t\t\t" + precioVenta + '\t');

        if (venta.getCliente().getClass().getSimpleName().equals("Profesional")) {
            double descuento = venta.getCliente().obtenerDescuento();
            double total = (unidades * precioVenta) - ((descuento / 100) * (unidades * precioVenta));
            strPlus = String.valueOf(total);
        } else {
            strPlus = String.valueOf((unidades * precioVenta));
        }

        System.out.println(strBase + strPlus + '\n' + producto.getDescripcion());

        /* Esperamos a la lectura de los datos */

    }
}