package aa5_woodshops.items;

import aa5_woodshops.centros.Almacen;
import aa5_woodshops.centros.Proveedor;
import aa5_woodshops.centros.Tienda;
import aa5_woodshops.generadores_codigos_unicos.CodeList;

import java.util.ArrayList;

/**
 * La clase Producto es una superclase para las clases Tablero, Barniz y Articulo que permiten instanciar un Objeto que
 * representa un artículo para añadir al del Stock de una instacia de Almacén asociada a una instancia de
 * Tienda. Igualmente, se relaciona con una instancia de Proveedor a través del atributo proveedor.
 *
 * @see Tablero
 * @see Barniz
 * @see Articulo
 * @see Almacen
 * @see Proveedor
 * @see Stock
 */
public abstract class Producto {

    private String codigoProducto;
    private String descripcion;
    private Proveedor proveedor;
    private ArrayList<Stock> stocks;

    private static CodeList codigosProducto = new CodeList();

    /**
     * Constructor genérico para la Clase Producto, es un superconstructor que se usará en las
     * subclases y recibe los atributos coincidentes de todos los tipos de artículos.
     * Además inicializa la lista de códigos de producto y genera un código único para el producto de
     * forma automática.
     *
     * @param descripcion String Descripción del Producto.
     * @param proveedor   Proveedor Instancia de Proveedor del Producto.
     * @param tipo        String Tipo de subclase en formato String para generar el código de producto.
     */
    public Producto(String descripcion, Proveedor proveedor, String tipo) {
        this.descripcion = descripcion;
        this.proveedor = proveedor;
        this.codigoProducto = codigosProducto.addCodigoProducto(descripcion.concat(proveedor.getNombre().concat(tipo)));
        proveedor.addProducto(this);
        stocks = new ArrayList<>();
    }

    /* Getters & Setters */

    /**
     * Método getter que devuelve el código único del producto.
     *
     * @return String Sódigo único de producto.
     * @see CodeList
     */
    public String getCodigoProducto() {
        return codigoProducto;
    }

    /**
     * Método getter que devuelve la descripción del producto.
     *
     * @return String Descripción del producto.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método getter que devuelve una instancia de Proveedor con el proveedor asociado al producto.
     *
     * @return Proveedor Instancia de tipo proveedor.
     * @see Proveedor
     */
    public Proveedor getProveedor() {
        return proveedor;
    }

    /**
     * Método getter que devuelve un ArrayList de tipo Stock con todos los stocks que hay asociados a una
     * instancia de tipo Producto. A través de esta listas, puede saber en qué instancia de Almacen se ha
     * generado el producto, que cantidad de unidades hay en ese almacén y a qué precio se vende el producto
     * en la Tienda asociada al Almacen.
     *
     * @return ArrayList Lista de tipo Stock.
     * @see Stock
     * @see Almacen
     * @see Tienda
     */
    public ArrayList<Stock> getStocks() {
        return stocks;
    }

    /**
     * Método getter para obtener una lista de todos los código de producto generados.
     * Es un método static que depende de la Clase y no de las instancias.
     *
     * @return CodeList Instancia de tipo CodeList desde donde podemos recuperar todos los
     * códigos de producto que se han generado en forma de Array y la cantidad de códigos generados
     * como un int.
     * @see CodeList
     */
    public static CodeList getCodigosProducto() {
        return codigosProducto;
    }

    /**
     * Método setter que permite asignar una descripción para el producto.
     *
     * @param descripcion String Descripción del producto.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método setter que permite asignar un proveedor para el producto a través de una instancia de
     * tipo Proveedor que recibe como parámetro.
     *
     * @param proveedor Proveedor Instancia de tipo Proveedor.
     * @see Proveedor
     */
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * Override del método toString() que imprime por pantalla la información de una instancia de
     * tipo Producto.
     *
     * @return String Información del producto.
     */
    @Override
    public String toString() {
        return "\nCodigo de Producto: " + codigoProducto + '\n';
        /*return "Producto: \"" + descripcion + "\" Codigo: " + codigoProducto + "\n";*/
    }

    /* Métodos de clase */

    /**
     * El método equals() es el supermétodo de clase para comparar productos. En cada subclase
     * se sobrecarga con las atributos particulares de cada tipo de producto.
     *
     * @param producto Producto Instancia de Producto a comparar.
     * @return boolean Devuelve cierto si lso productos coinciden y falso si no.
     */
    public boolean equals(Producto producto) {
        return this.descripcion.equals(producto.getDescripcion())
                && this.proveedor.equals(producto.getProveedor());
    }

    /**
     * Como usamos una clase Asociativa, Stock, cuando generamos la relación entre un producto y
     * un almacén, lo almacenamos también en Producto y podemos acceder a la información del Stock,
     * la cantidad de artículos y la instancia de Almacén a la que estamos asociando el Producto.
     * Así, podriamos generar históricos si fuera necesario.
     *
     * @param stock Stock Instancia de tipo Stock con la información de la asociación entre Almacén y Producto.
     */
    public void addStock(Stock stock) {
        stocks.add(stock);
    }
}