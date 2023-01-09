package aa5_woodshops.centros;

import aa5_woodshops.items.Producto;
import aa5_woodshops.items.Stock;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * La clase Alamacen instancia un Objeto que representa el almacén de cada una de las Tiendas de la empresa, Objetos
 * del tipo Tienda.
 * La instancia se identifica a través de un código de almacén que obtine a través de la clase SedeCentral que guarda
 * una lista con todos lso códigos de los almacenes. Cada alamacén contiene un stock con todos los productos de que
 * dispone.
 * No hay setter para el código porque se genera de forma automática y no debe cambiarse, ni para inventario
 * ya que depende de la Clase Asociativa Stock y está ha de estar relacionada con la instancia de Almacen y la
 * de Producto forzosamente.
 */
public class Almacen {

    private String codigoAlmacen;
    private ArrayList<Stock> inventario;

    /**
     * Constructor genérico para la Clase Almacen. El método de adjudicación de código se recibe
     * de la Clase SedeCentral que contiene las instancias de Tienda que se asocian a cada instancia
     * de Almacen.
     * El constructor tambiñen inicia el ArrayList de tipo Stock para almacenar las asociaciones
     * entre Almacen y Producto.
     *
     * @param key String Clave que se usará para generar el código único de almacén
     * @see aa5_woodshops.generadores_codigos_unicos.CodeList
     */
    public Almacen(String key) {
        this.codigoAlmacen = SedeCentral.adjudicarCodigoAlmacen(key);
        inventario = new ArrayList<>();
    }

    /* Getters y Setters */

    /**
     * Método getter que devuelve el código único del Almacén.
     *
     * @return String Código único de Almacén.
     */
    public String getCodigoAlmacen() {
        return codigoAlmacen;
    }

    /**
     * Método getter que devueleve el ArrayList de Stock, o sea, los Productos en el Almacén
     * de la tienda con su precio y cantidad.
     *
     * @return ArrayList Lista de instancias de Stock que contienen la relación de Productos en la
     * asociación con la instancia de Almacen.
     */
    public ArrayList<Stock> getInventario() {
        return inventario;
    }

    /**
     * Override del método toString para imprimir la información de una instancia de Almacen.
     *
     * @return String Información de la instancia de Almacen.
     */
    @Override
    public String toString() {
        return "Almacen{" +
                "codigoAlmacen='" + codigoAlmacen + '\'' +
                ", inventario=" + inventario +
                '}';
    }

    /* Métodos de Clase */

    /**
     * El método listar inventario imprime por pantalla la información sobre las instancias de
     * Producto almacenadas en el ArrayList Inventario a través de la calse asociativa Stock que
     * se almacena en este ArrayList.
     *
     * @see Stock
     * @see Producto
     */
    public void listarInventario() {
        for (Stock stock : inventario) {
            System.out.println(stock);
        }
    }

    /**
     * El método addStock() añade una instancia de la Clase Asociativa Stock que contiene un Producto
     * para añadir en el ArrayList Inventario, es decir, añade un Producto al Almacén.
     *
     * @param stock Stock Instancia de la Clase Asociativa Stock que contiene una Instancia de la clase
     *              Producto y la cantidad de artículos que se añaden al inventario.
     * @see Stock
     * @see Producto
     */
    public void addStock(Stock stock) {
        inventario.add(stock);
    }

    /**
     * El método listarProductosPorTipo permite obtener una lista de los productos de una tienda que se
     * corresponden con el tipo de Producto obtenido por parámetro.
     *
     * @param tipo String Tipo de producto del que queremos obtener el stock, puede ser Tablero, Barniz
     *             o Articulo.
     * @see Tienda
     * @see Producto
     */
    public void listarByTipo(String tipo) {
        for (Stock stock : inventario) {
            if (stock.getProducto().getClass().getSimpleName().equals(tipo)) {
                System.out.println(stock);
            }
        }
    }

    /**
     * El método checkProducto() comprueba si una instancia de Producto que se recibe por parámetro
     * ya existe en el ArrayList Inventario de una instancia del tipo Almacén. Si existe, devuelve su
     * índice de posición, si no, -1. Utiliza un iterador para comprobar todos los productos que existen
     * en el Inventario.
     *
     * @param producto Producto Instancia de la Clase Producto
     * @return int Índice de posición del Producto en el Inventario del Almacén de la Tienda.
     * @see Producto
     * @see Stock
     * @see Tienda
     */
    public int checkProducto(Producto producto) {

        int indPosition = -1;
        boolean isFound = false;

        ListIterator<Stock> iteradorInventario = inventario.listIterator();

        try {
            while (iteradorInventario.hasNext() && !isFound) {
                if (iteradorInventario.next().getProducto().equals(producto)) {
                    indPosition = iteradorInventario.previousIndex();
                    isFound = true;
                }
            }
        } catch (NullPointerException e) {
            return indPosition;
        }

        return indPosition;

    }

    /**
     * El método updateProductoCantidad() es un método auxiliar para actualizar la cantidad de un
     * producto que ya se encuentra en una instancia de Almacén asociada a una instancia de Tienda.
     *
     * @param producto    Producto Instacncia de Producto que usamos para comparar y actualizar la información.
     * @param ind         int Índice de localización del producto en el ArrayList inventarios de la instancia
     *                    de Almacén asociada a la instancia de Tienda.
     * @param cantidad    int Cantidad de artículos a añadir en el inventario.
     * @param precioVenta double Precio de venta del producto.
     * @see Tienda
     * @see Producto
     */
    public void updateStock(Producto producto, int ind, int cantidad, double precioVenta) {
        Stock actualStock = inventario.get(ind);
        actualStock.setCantidad(actualStock.getCantidad() + cantidad);
        actualStock.setPrecioVenta(precioVenta);
        inventario.set(ind, actualStock);

        System.out.println("Nueva cantidad: " + inventario.get(ind).getCantidad());
    }

    /**
     * El método listarStockProducto recibe por parámetro un código de producto, lo busca en cada
     * instancia de Almacen asociada a cada instancia de Tienda y, si hay unidades, devuelve la cantidad
     * de unidades y la información sobre el producto.
     * Usa el método auxilia buscarProductoPorCodigo().
     * Devuelve la cantidad de unidades de un Producto almacenado en el Inventario a través de
     * la Clase Asociativa Stock o -1 si el producto no se encuentra en el inventario.
     *
     * @param codigo String Código único del producto a buscar.
     * @return int Cantidad d eunidades del producto.
     * @see Tienda
     * @see Producto
     * @see Stock
     */
    public int listarStock(String codigo) {

        int indProducto = buscarProductoPorCodigo(codigo);
        if (indProducto != -1) {
            return (inventario.get(indProducto).getCantidad());
        }

        return -1;
    }

    /**
     * El método buscarProductoPorCodigo() usa un iterador para buscar una instancia de
     * Producto dentro del ArrayList inventario que contiene instancias de la Clase
     * Asociativa Stock identificándola por el código de producto que recibe por
     * parámetro. Si encuentra el producto, devuelve el índice de posición de este
     * en el ArrayList inventario. Si no, devuelve -1.
     *
     * @param codigo String Codigo único del producto a buscar.
     * @return int Índice de posiciñon del producto en el ArrayList inventario.
     * @see Tienda
     * @see Stock
     * @see Producto
     */
    public int buscarProductoPorCodigo(String codigo) {


        boolean isFound = false;
        ListIterator<Stock> iteradorInventario = inventario.listIterator();

        while (iteradorInventario.hasNext() && !isFound) {
            if (iteradorInventario.next().getProducto().getCodigoProducto().equals(codigo)) {
                return iteradorInventario.previousIndex();
            }
        }

        return -1;
    }

    /**
     * El método obtenerProductoPorCodigo() usar el método buscarProdcutoPorCodigo() para
     * localizar un Producto en el ArrayList inventario a través del código de producto que
     * recibe por parámetro y lo devuelve a través del índice de posición obtenido.
     *
     * @param codigo String Código único del producto.
     * @return Producto Instancia de Producto.
     * @see Producto
     * @see Tienda
     * @see Stock
     */
    public Producto obtenerProductoPorCodigo(String codigo) {
        int indProducto = buscarProductoPorCodigo(codigo);

        try {
            return inventario.get(indProducto).getProducto();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("El producto no existe o no se encuentra en el almacén!");
            return null;
        }
    }
}
