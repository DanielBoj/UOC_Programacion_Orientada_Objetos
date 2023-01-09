package aa5_woodshops.centros;

import aa5_woodshops.items.Producto;
import aa5_woodshops.items.Stock;
import aa5_woodshops.ventas.DetalleVenta;
import aa5_woodshops.ventas.Ticket;
import aa5_woodshops.ventas.Venta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * La clase Tienda representa cada una de las tiendas que componen la SedeCentral.
 * Es una clase del tipo parte que compone a la clase todo SedeCentral y se asocia a las tiendas que forman la empresa
 * representada por SedeCentral. Por ello, cada Objeto del tipo Tienda solo se puede instanciar desde un Objeto del tipo
 * SedeCentral, siguiendo los principios de composición parte-todo. Cada tienda está identificada por los atributos
 * nombre de tipo String, que indica el nombre de la franquicia, y localidad también del tipo String, que indica
 * la ciudad donde se encuentra la franquicia.
 * Cada tienda dispone de un almacén, representado mediante una asociación con la clase Almacen, donde se guarda
 * el stock de productos disponibles.
 * Finalmente, las ventas a los clientes se realizan desde cada instancia de Tienda. Así, implementamos los diferentes métodos
 * necesarios y creamos un ArrayList del tipo Venta para almacenar las diferentes instancis de la Clase Venta que se crean
 * y relacionan con una instancia de Tienda y representan las ventas de la tienda.
 *
 * @see SedeCentral
 * @see Almacen
 * @see Venta
 */
public class Tienda {

    private String nombre;
    private String localidad;
    private Almacen almacen;

    /* AA4 */
    private ArrayList<Venta> ventas;

    /**
     * Constructor por defecto para una instancia de tipo Tienda.
     * Recibe por parámetros el nombre y la ubicación y genera un almacén aosciado a la tienda.
     *
     * @param nombre    String Nombre de la tienda.
     * @param localidad String Ubicación de la tienda.
     * @see SedeCentral
     * @see Almacen
     */
    public Tienda(String nombre, String localidad) {
        this.nombre = nombre;
        this.localidad = localidad;
        almacen = new Almacen(nombre.concat(localidad));
        /* AA4 */
        ventas = new ArrayList<>();
    }

    /**
     * Sobrecarga del constructor que permite añadir una instancia de tipo Almacen ya creada a la tienda.
     *
     * @param nombre    String Nombre de la tienda.
     * @param localidad String Ubicación de la tienda.
     * @param almacen   Almacen Instancia de tipo Almacen a asociar a la tienda.
     */
    public Tienda(String nombre, String localidad, Almacen almacen) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.almacen = almacen;
        ventas = new ArrayList<>();
    }

    /* Getters & Setters */

    /**
     * Getter que devuelve el nombre de la tienda.
     *
     * @return String Nombre de la tienda.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter que devuelve la ubicación de la tienda.
     *
     * @return String Ubicación de la tienda.
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * Getter que devuelve la instancia de tipo Almacen asociada a la tienda.
     *
     * @return Alacen Instancia tipo Almacen.
     * @see Almacen
     */
    public Almacen getAlmacen() {
        return almacen;
    }

    /* AA4 */

    /**
     * Método Getter que devuelve un ArrayList del tipo Venta que almacena todas las ventas relacionadas con la tienda.
     *
     * @return ArrayList ArrayList del tipo Venta.
     */
    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    /**
     * Setter que permite asignar un nombre a la tienda.
     *
     * @param nombre String Nombre de la tienda.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Setter que permite asignar una ubicación a la tienda.
     *
     * @param localidad String Ubicación de la tienda.
     */
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    /**
     * Setter que permite asignar una Instancia de Almacén a la Tienda.
     *
     * @param almacen Almacen Instancia de tipo Almacen.
     * @see Almacen
     */
    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    /**
     * Método Setter que permite asignar un ArrayList del tipo Venta con todas las ventas realizadas por una tienda.
     *
     * @param ventas ArrayList Lista de instancias de la Clase Venta.
     */
    public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }

    /**
     * Override del método toString() que muestra toda la información de la tienda.
     *
     * @return String Información de una instancia de tipo Tienda.
     */
    @Override
    public String toString() {
        return "WoodShops\nPunto de venta: " + nombre + "\t" + localidad +
                "\tCodigo de Almacen: " + almacen.getCodigoAlmacen();
    }

    /* Métodos de Clase */

    /**
     * El método addProducto() añade un producto a la instancia Almacén asociada a una
     * instancia de tipo Tienda.
     * Si el producto ya existe en el inventario de la tienda, actualiza su cantidad.
     *
     * @param producto    Producto Objeto de tipo Producto para añadir al Almacen
     * @param precioVenta double Precio de venta del Producto en la Tienda asociaada a la instancia
     *                    de Almacen.
     * @param cantidad    int Cantidad de artículos que añadimos al almacén
     * @see Almacen
     * @see Stock
     * @see Producto
     */
    public void addProducto(Producto producto, double precioVenta, int cantidad) {

        if (almacen.checkProducto(producto) != -1) {
            updateProducto(producto, almacen.checkProducto(producto), cantidad, precioVenta);
            return;
        }

        Stock actualStock = new Stock(this.almacen, producto, precioVenta, cantidad);
        almacen.addStock(actualStock);
        producto.addStock(actualStock);
    }

    /**
     * El método updateProductoCantidad() es un método auxiliar para actualizar la cantidad de un
     * producto que ya se encuentra en una instancia de Almacén asociada a una instancia de Tienda.
     * Delega en la instancia de Almacén.
     *
     * @param producto    Producto Instacncia de Producto que usamos para comparar y actualizar la información.
     * @param ind         int Índice de localización del producto en el ArrayList inventarios de la instancia
     *                    de Almacén asociada a la instancia de Tienda.
     * @param cantidad    int Cantida de artículos a añadir en el inventario.
     * @param precioVenta double Precio de venta del producto.
     * @see Almacen
     */
    public void updateProducto(Producto producto, int ind, int cantidad, double precioVenta) {
        almacen.updateStock(producto, ind, cantidad, precioVenta);
    }

    /**
     * El método listarProductosPorTipo permite obtener una lista de los productos de una tienda que se
     * corresponden con el tipo de Producto obtenido por parámetro.
     * Delega en la clase Almacén.
     *
     * @param tipo String Tipo de producto del que queremos obtener el stock, puede ser Tablero, Barniz
     *             o Articulo.
     * @see Almacen
     * @see Producto
     */
    public void listarProductosPorTipo(String tipo) {
        almacen.listarByTipo(tipo);
    }

    /**
     * El método listarStockProducto recibe por parámetro un cñodgio de producto, lo busca en cada
     * instancia de Almacen asociada a cada instancia de Tienda y, si hay unidades, devuelve la cantidad
     * de unidades y la información sobre el producto.
     * Delega en la clase Almacen.
     *
     * @param codigo String Código único del producto a buscar.
     * @see Almacen
     * @see Producto
     * @see Stock
     */
    public void listarStockProducto(String codigo) {
        int cantidadStock = almacen.listarStock(codigo);
        if (cantidadStock != -1) {
            System.out.println("La tienda " + nombre +
                    " dispone de " + cantidadStock +
                    " unidades del producto con código " +
                    codigo);
            System.out.println(almacen.obtenerProductoPorCodigo(codigo));
        } else {
            System.out.println("La tienda " + nombre +
                    " no dispone del producto o este no existe.");
        }
    }

    /***
     * El método listarStock() delega en la instancia de Almacen relacionada con la tienda y usa la función
     * listarInventario() para mostrar por pantalla una lista con todos los productos en stock.
     *
     * @see Almacen
     */
    public void listarStock() {
        this.getAlmacen().listarInventario();
    }

    /**
     * El método addVenta() añade una isntancia de la Clase Venta al ArrayList de tipo Venta que almacena las diferentes
     * ventas de la Tienda. Hace uso del método de la Clase ArrayList add().
     *
     * @param venta Venta Instancia de la Clase Venta que representa una venta de la tienda.
     * @see Venta
     */
    public void addVenta(Venta venta) {
        ventas.add(venta);
    }

    /**
     * El método filterVentas() toma el ArrayList del tipo Venta, hace un recorrido por todos sus elementos y los filtra
     * segun un rango de fechas que obtiene por parámetros, la fecha mínima y la fecha máxima. Si el elemento cumple los
     * requisitos de filtrado lo almacena en un nuevo ArrayList del tipo Venta que contendrá todos los elementos que
     * cumplan las condiciones. Finalmente, devuelve el ArrayList filtrado.
     * Para poder realizar las comparaciones, accede a la instancia de Ticket relacionada con la instancia de Venta a través
     * de la Clase Asociativa DetalleVenta. En la instancia de Ticket, se encuentra la fecha de la venta. Una vez realizado
     * el acceso a los datos, realizamos la comparación mediante los métodos de la librería java.time isBefore() e isAfter().
     *
     * @param fechaIn  LocalDate Fecha mínima para el filtrado.
     * @param fechaFin LocalDate Fecha máxima para el filtrado.
     * @return ArrayList ArrayList del tipo venta con los elementos filtrados.
     * @see Ticket
     * @see DetalleVenta
     */
    public ArrayList<Venta> filterVentas(LocalDate fechaIn, LocalDate fechaFin) {

        /* Lista auxiliar */
        ArrayList<Venta> ventasFiltradas = new ArrayList<>();

        for (Venta venta : ventas) {

            /* Comprobamos si la fecha esta dentro del rango */
            if (!venta.getDetalleLineas().get(0).getTicket().getFecha().isBefore(fechaIn) &&
                    !venta.getDetalleLineas().get(0).getTicket().getFecha().isAfter(fechaFin)) {

                /* Añadimos la venta a la lista filtrada */
                ventasFiltradas.add(venta);
            }
        }

        return ventasFiltradas;
    }

    /**
     * La función resumenTotalVentas() muestra obtiene por parámetro un ArrayList con diferentes instancias de la Clase Venta
     * y suma el valor total de las ventas. Además muestra el resultado por pantalla y también el número total de ventas.
     *
     * @param ventas ArrayList Lista de instancia de la Clase Venta con todas las ventas de una tienda filtradas en un periodo de tiempo.
     */
    public void resumenTotalVentas(ArrayList<Venta> ventas) {

        /* Creamos un iterador */
        ListIterator<Venta> iterador = ventas.listIterator();

        /* Declaramos e inicializamos la variable de resultado */
        int ventasDescProfesional = 0;
        double totalAmount = 0.0;

        if (iterador.hasNext()) {
            while (iterador.hasNext()) {
                /* Actualizamos la información */

                try {
                    totalAmount += iterador.next().calcularTotal();
                    if (iterador.next().getCliente().getClass().getSimpleName().equals("Profesional")) {
                        ventasDescProfesional++;
                    }
                } catch (NoSuchElementException e) {
                    break;
                }
            }
        } else {
            System.out.println("No hay ventas para mostrar.");
        }

        /* Mostramos los resultados por pantalla */
        if (ventasDescProfesional > 0) {
            System.out.println("Número de ventas totales: " + ventas.size() +
                    "\tNúmero de ventas con descuento profesional: " + ventasDescProfesional +
                    "\nSuma total de los importes: " + totalAmount);
        } else {
            System.out.println("Número de ventas totales: " + ventas.size() +
                    "\nSuma total de los importes: " + totalAmount);
        }
    }
}