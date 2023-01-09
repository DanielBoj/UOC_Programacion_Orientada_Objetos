package aa5_woodshops.items;

import aa5_woodshops.centros.Almacen;
import aa5_woodshops.centros.Tienda;

/**
 * La Clase Stock es una Clase Asociativa que relaciona una instancia de Producto con una instancia de Almacen
 * cuando se realiza una asociación entre estos dos.
 * Esta clase guarda la cantidad de unidades del Producto que se añaden al Almacen y el precio de venta
 * de ese producto para la instancia de Tienda asociada a la instancia de Almacen donde se asocia el
 * Producto.
 * Como es una clase asociativa, no implementamos Setters para almacen ni para producto.
 *
 * @see Producto
 * @see Almacen
 * @see Tienda
 */
public class Stock {

    private int cantidad;
    private double precioVenta;
    private Producto producto;
    private Almacen almacen;

    /**
     * Constructor genérico para la Clase Asociativa Stock.
     * Recibe por parámetro las Instancias de Almacen y de Producto con las que se relaciona y los atributos
     * específicos de cantida y precio de venta.
     *
     * @param almacen     Almacen Instancia de Almacen que se asocia a la instancia de Producto.
     * @param producto    Producto Instancia de Producto que se asocia a la instancia de Almacen.
     * @param precioVenta double Precio de venta del Producto.
     * @param cantidad    int Cantida de unidades que añadimos al Almacen.
     */
    public Stock(Almacen almacen, Producto producto, double precioVenta, int cantidad) {
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.producto = producto;
        this.almacen = almacen;
    }

    /* Getters */

    /**
     * Método getter que devueleve la cantidad de unidades del Producto asociado al Almacen.
     *
     * @return int Cantidad de unidades del Producto
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Método getter que devuele el precio de venta del Producto asociado al Almacen.
     *
     * @return double Precio de venta del Producto.
     */
    public double getPrecioVenta() {
        return precioVenta;
    }

    /**
     * Método getter que devuelve la instancia Producto asociada al Almacén
     *
     * @return Producto Instancia de Producto asociada al Almacen.
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Método getter que devuelve la instancia de Almacén a la que se asocia el Producto.
     *
     * @return Almacen Instancia de Almacen relacionada con el Producto.
     */
    public Almacen getAlmacen() {
        return almacen;
    }

    /* Setters */

    /**
     * Método setter que cambia la cantidad del producto en el inventario del Almacen asociado.
     *
     * @param cantidad int Cantidad de unidades.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Método setter que cambia el precio de venta del Producto en el inventario del Almacen asociado.
     *
     * @param precioVenta double Precio de venta del producto.
     */
    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    /**
     * Override del método toString para imprimir la información de la instancia de Stock.
     *
     * @return String Información de la instancia de Stock.
     */
    @Override
    public String toString() {
        return "------------------------------------------------------\n" +
                "Stock en " + almacen.getCodigoAlmacen() + "\n" +
                producto +
                "Precio: " + precioVenta + "\tCantidad " + cantidad +
                "\n-----------------------------------------------------\n";
    }
}
