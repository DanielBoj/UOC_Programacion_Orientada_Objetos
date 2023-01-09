package aa5_woodshops.centros;

import aa5_woodshops.clientes.*;
import aa5_woodshops.generadores_codigos_unicos.CodeList;
import aa5_woodshops.items.Producto;
import aa5_woodshops.items.Stock;
import aa5_woodshops.ventas.*;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * La Clase Sede Central representa la Sede Central de la empresa, en este caso WoodShops.
 * La Sede está compuesta por las diferentes tiendas asociadas, con lo cual se incluyen mediante una relación de composición,
 * es decir, son una parte que compone Sede y si eliminamos la Sede, deben eliminarse también las diferentes tiendas
 * asocioadas. Para ello, debemos instanciar los Objetos del tipo Tienda dentro de la clase contenedora. Además, la clase
 * sede está definida por los campos nombre y nif. El campo nif es un campo único que puede servir como identificador único
 * para cada instancia. Finalmente, almacena los diferentes clientes de la empresa en un ArrayList del tipo Cliente y los
 * códigos de los clientes fidelizados de la subclase WoodFriend en el ArrayList socios.
 *
 * @see Tienda
 * @see Cliente
 * @see CodeList
 */
public class SedeCentral {

    private String nombre;
    private String nif;
    private ArrayList<Tienda> tiendas;
    private CatalogoProveedores proveedores;
    private int numTiendas;

    /**
     * Este atributo genera la asociación que permite adjudicar y guardar códigos únicos para los
     * almacenes de las diferentes tiendas.
     *
     * @see CodeList
     * @see Tienda
     * @see Almacen
     */
    private static CodeList codigosAlmacenes;

    /* AA4*/
    private ArrayList<Cliente> clientes;
    private ArrayList<DetalleOferta> detalleOfertas;

    /**
     * Este atributo genera la asociación que permite adjudicar y guardar códigos únicos para los
     * clientes fidelizados de a subclase WoodFriend.
     *
     * @see CodeList
     * @see Registrado
     * @see WoodFriend
     */
    private static CodeList socios;

    /**
     * Constructor genérico para la clase.
     * Recibimos por parámetro el nombre y el nif de la empresa e inicializamos el ArrayList del tipo Tienda que contendrá
     * las diferentes tiendas, "parte" que componen la empresa. Las tiendas, clase parte, solo se podrán añadir desde
     * la clase "todo", Sede. El campo tiendas, además, no tendrá Setter, ya que depende de la Clase Todo. incializa también
     * el ArrayList de tipo Cliente y una instacia CodeList para asignar y almacenar los códigos únicos de los clientes
     * fidelizados.
     *
     * @param nombre String Nombre de la empresa.
     * @param nif    String NIF d ela empresa.
     */
    public SedeCentral(String nombre, String nif) {
        this.nombre = nombre;
        this.nif = nif;
        tiendas = new ArrayList<>();
        codigosAlmacenes = new CodeList();

        /* AA4 */
        clientes = new ArrayList<>();
        socios = new CodeList();
        numTiendas = 0;
        detalleOfertas = new ArrayList<>();
    }

    /* Getters & Setters */

    /**
     * Método GETTER que devuelve el atributo nombre de SedeCentral
     *
     * @return String Devuelve el nombre de la empresa
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método GETTER que devuelve el atributo nif de SedeCentral
     *
     * @return String Devuelve el NIF d ela empresa
     */
    public String getNif() {
        return nif;
    }

    /**
     * Método GETTER que devuelve un ArrayList de Objetos del tipo Tienda que contiene una lista con todas las tiendas
     * que componen SedeCentral.
     *
     * @return ArrayList Devuelve un ArrayList de Objetos de tipo Tienda con una lista de todas las tiendas de la empresa.
     */
    public ArrayList<Tienda> getTiendas() {
        return tiendas;
    }

    /**
     * Getter que devuelve un Objeto del tipo CatalogoProveedores con todos los proveedores asignados a una empresa
     *
     * @return CatalogoProveedores Instancia de CatalogoProveedores con todos los proveedores asociados a la empresa.
     * @see CatalogoProveedores
     */
    public CatalogoProveedores getProveedores() {
        return proveedores;
    }

    /**
     * Getter que devuelve el número de tiendas de la empresa
     *
     * @return int Número de tiendas de la empresa.
     */
    public int getNumTiendas() {
        return numTiendas;
    }

    /**
     * Método Getter que devuelve una instancias de CodeList donde se almacenan los codigos de los almacenes de las Tiendes
     * de la empresa.
     *
     * @return CodeList Instancia de la Clase CodeList.
     */
    public CodeList getCodigosAlmacenes() {
        return codigosAlmacenes;
    }

    /* AA4 */

    /**
     * Método Getter que devuelve un ArrayList de instancias de la clase Clientes.
     * Representa la lista de clientes de la empresa.
     *
     * @return ArrayList Lista de instancias de la Clase Cliente.
     * @see Cliente
     */
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    /**
     * Método Getter que devuelve una instancia de la Clase CodeList con la lista de los códigos de los clientes fidelizados.
     *
     * @return CodeList Instancia de la Clase CodeList.
     * @see CodeList
     */
    public CodeList getSocios() {
        return socios;
    }

    /**
     * Método getter que devuelve un ArrayList de elementos del Tipo DetalleOferta que representa las ofertas de la empresa.
     *
     * @return ArrayList Lista de instancias de la Clase DetalleVenta.
     * @see DetalleVenta
     */
    public ArrayList<DetalleOferta> getDetalleOfertas() {
        return detalleOfertas;
    }

    /**
     * Método SETTER que recibe un String por parámetro y permite asignar el campo nombre de SedeCentral
     *
     * @param nombre String Nombre de la empresa.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método SETTER que recibe un String por parámetro y permite asignar el campo nif de SedeCentral
     *
     * @param nif String NIF de la empresa.
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * Setter para asignar una instancia de CatalogoProveedores con todos los proveedores que queremos asociar a la empresa.
     *
     * @param proveedores CatalogoProveedores Instancia de CatalogoProveedores
     * @see CatalogoProveedores
     */
    public void setProveedores(CatalogoProveedores proveedores) {
        this.proveedores = proveedores;
    }

    /**
     * Método Setter para añadir una lista de clientes.
     *
     * @param clientes ArrayList ArrayList del tipo Cliente.
     */
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     * Método Setter para añadir una instancia de DetalleOferta, una Clase Asociativa que relaciona una instancia de Oferta
     * y una de SedeCentral.
     *
     * @param detalleOfertas DetalleOferta Instancia de Detalleoferta.
     */
    public void setDetalleOfertas(ArrayList<DetalleOferta> detalleOfertas) {
        this.detalleOfertas = detalleOfertas;
    }

    /**
     * Override del método de la Clase Object, muestra la información de cada instancia de la Clase SedeCentral.
     * Tiendas heredará el método toString() de su clase, Tienda.
     *
     * @return String Información de la empresa incluyendo una lista de las tiendas que la componen
     * @see Tienda
     * @see CodeList
     * @see Proveedor
     * @see Cliente
     */
    @Override
    public String toString() {
        return "SedeCentral{" +
                "nombre='" + nombre + '\'' +
                ", nif='" + nif + '\'' +
                ", tiendas=" + tiendas +
                ", proveedores=" + proveedores +
                ", numTiendas=" + numTiendas +
                ", clientes=" + clientes +
                '}';
    }
    /* Métodos de clase */

    /**
     * El método addTienda permite añadir un Objeto de tipo Tienda al ArrayList tiendas.
     * Representa a una de las tiendas que componen la empresa principal, por ello, se instancia
     * la clase parte dentro de la clase todo, no fuera de esta.
     *
     * @param nombre    String Nombre de la tienda
     * @param localidad String Localidad donde se ubica la tienda
     * @see Tienda
     * @see Almacen
     */
    public void addTienda(String nombre, String localidad) {
        Tienda actualTienda = new Tienda(nombre, localidad);
        tiendas.add(actualTienda);
        numTiendas++;
    }

    /**
     * Sobrecarga del método que permite añadir un almacén si ya lo tenemos creado.
     *
     * @param nombre    String Nombre de la tienda
     * @param localidad String Localidad donde se ubica la tienda
     * @param almacen   Almacen Añade una instancia de tipo Almacén
     * @see Tienda
     * @see Almacen
     */
    public void addTienda(String nombre, String localidad, Almacen almacen) {
        Tienda actualTienda = new Tienda(nombre, localidad, almacen);
        tiendas.add(actualTienda);
        numTiendas++;
    }

    /**
     * Como las instancias de Tienda son una parte componente de SedeCentral, guardamos la lista
     * de códigos de almacén en la instancia de SedeCentral. El método adjudicarCodigoAlmacen() deriva
     * la creación del código durante la instanciación de un Objeto de tipo Almacen a
     * la clase SedeCentral. Además, el método en el que recae la generación del código, addCodigoAlmacen()
     * añade el código a la lista de códigos, con lo que estaremos realizando la tares de crear el código
     * y de guardarlo. La clase Almacen se encarga de adjudicarlo.
     *
     * @param key String Key es la llave para generar la clave Hash que será parte del código de almacén.
     * @return String Devuelve un código que se adjudica al almacén en su instanciación.
     * @see CodeList
     */
    public static String adjudicarCodigoAlmacen(String key) {
        return codigosAlmacenes.addCodigoAlmacen(key);
    }

    /**
     * El método buscarTiendaPorNombre() recibe por parámetro el nombre de una tienda y lo busca en el ArrayList de
     * tiendas devolviendo el índice de la tienda si lo encuentra.
     *
     * @param nombre String Nombre de la tienda a buscar en el ArrayList
     * @return int Entero que marca el índice de posición del objeto buscado.
     * @see Tienda
     */
    public int buscarTiendaPorNombre(String nombre) {

        int position = -1;
        boolean isFound = false;

        ListIterator<Tienda> iteradorTiendas = tiendas.listIterator();

        try {
            while (iteradorTiendas.hasNext() && !isFound) {
                if (iteradorTiendas.next().getNombre().equals(nombre)) {
                    position = iteradorTiendas.previousIndex();
                    isFound = true;
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println(e + "La tienda no existe!");
            return -1;
        }


        return position;
    }

    /**
     * EL método addProductoTienda() añade una instancia de tipo Producto a una instancia de
     * tipo Almacen asociada con una instancia de tipo Tienda buscándola a través del nombre que
     * recibe por parámetro.
     * Usa el método auxiliar buscarTiendaPorNombre().
     * Delega en Tienda.
     *
     * @param nombreTienda String Nombre de la instancia del tipo Tienda a buscar.
     * @param producto     Producto Instancia de tipo Producto a añadir en el Almacén de la Tienda.
     * @param precioVenta  double Precio de venta del Producto en la Tienda asociada a la instancia
     *                     de Almacen.
     * @param cantidad     int Cantida de unidades del Producto que vamos a añadir.
     * @see Tienda
     * @see Almacen
     * @see Producto
     * @see Stock
     */
    public void addProductoTienda(String nombreTienda, Producto producto, double precioVenta, int cantidad) {
        int positionOfTienda = buscarTiendaPorNombre(nombreTienda);
        Tienda actualTienda = tiendas.get(positionOfTienda);
        actualTienda.addProducto(producto, precioVenta, cantidad);
    }

    /**
     * EL método listInfoTiendas() imprime por pantalla toda la información de cada instancia de
     * Tienda almacenada en el ArrayList tiendas. Incluye la información de la instancia de Almacén
     * asociada a cada instancia de Tienda.
     *
     * @see Tienda
     * @see Almacen
     */
    public void listInfoTiendas() {
        for (Tienda tienda : tiendas) {
            System.out.println(tienda);
        }
    }

    /**
     * El método listarNombreTiendas imprime por pantalla los nombres y la localidad de todas las tienda del ArrayList
     * de tipo Tienda asociado a una instancia de SedeCentral.
     *
     * @see Tienda
     */
    public void listNombreTiendas() {
        int ind = 0;

        for (Tienda tienda : tiendas) {
            System.out.println("-----------------------");
            System.out.println(++ind + ". " +
                    tienda.getNombre() + " " +
                    tienda.getLocalidad());
        }
        System.out.println("-----------------------");
    }

    /**
     * El método listarProductosTiendaPorTipo() imprime por pantalla todos los productos asociados a una instancia de Tienda
     * que sean de un tipo concreto que recibe por parámetro.
     * Delega en Tienda.
     *
     * @param nombreTienda String Nombre de la tienda.
     * @param tipo         String Tipo de producto a buscar.
     * @see Tienda
     * @see Almacen
     * @see Producto
     */
    public void listarProductosTiendaPorTipo(String nombreTienda, String tipo) {
        int ind = buscarTiendaPorNombre(nombreTienda);
        tiendas.get(ind).listarProductosPorTipo(tipo);
    }

    /**
     * El método listarStockProductosEnTienda() imprime por pantalla una lista con la información
     * del stock de un producto concreto que busca por su código y recibe por el parámetro codigo en
     * las tiendas asociadas a una empresa.
     * Delega en Tienda.
     *
     * @param codigo String Codigo del producto
     * @see Tienda
     * @see Almacen
     * @see Producto
     */
    public void listarStockProductoEnTienda(String codigo) {
        for (Tienda tienda : tiendas) {
            tienda.listarStockProducto(codigo);
        }
    }

    /**
     * El método listarCodigosProducto() imprime por pantalla todos los productos de una empresa mostrando su tipo,
     * nombre y código.
     * Delega en CatalogoProveedores.
     *
     * @see CatalogoProveedores
     * @see Producto
     */
    public void listarCodigosProducto() {
        proveedores.listAllProductos();
    }

    /* AA4 */
    /* Gestión de clientes */

    /**
     * EL método addCliente() añade una nueva instancia que recibe por parámetro al ArrayList de clientes,
     *
     * @param cliente Cliente Instancia de Cliente.
     * @see Cliente
     */
    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    /**
     * El método searchCliente() busca si una instancia de la clase Cliente se encuentra dentro de de la lista de Objetos
     * tipo Cliente. Si lo encuentra, devuelve el índice de posición de este, si no, devuelve -1.
     *
     * @param cliente Cliente Instancia de la clase Cliente a buscar.
     * @return int Índice de posición de la instancia de CLiente encontrada o -1.
     * @see Cliente
     */
    public int searchCliente(Cliente cliente) {

        if (clientes.isEmpty()) {
            System.out.println("Error: La lista está vacía!");
            return -1;
        }

        ListIterator<Cliente> iterator = clientes.listIterator();
        ClienteComparator comparator = new ClienteComparator();

        try {
            while (iterator.hasNext()) {
                if (comparator.compare(cliente, iterator.next()) == 0) {
                    return iterator.previousIndex();
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage() + ". La tienda no existe!");
        }

        return -1;
    }

    /**
     * Overrride del métododo searchCliente) que busca una instancia de Cliente dentro de una lista de Objetos de tipo
     * Cliente comparándolas por el campo nif. SI encuentra el elemento, devuelve su posición, si no, devuelve 0.
     *
     * @param nif String NIF del cliente a buscar, valor del campo nif de la instancia de Cliente.
     * @return int Índice de posición de la instancia de CLiente encontrada o -1.
     * @see Cliente
     */
    public int searchCliente(String nif) {

        if (clientes.isEmpty()) {
            System.out.println("Error: La lista está vacía!");
            return -1;
        }

        ListIterator<Cliente> iterator = clientes.listIterator();

        try {
            while (iterator.hasNext()) {
                if (iterator.next().getNif().equals(nif)) {
                    return iterator.previousIndex();
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage() + ". La tienda no existe!");
        }

        return -1;
    }

    /**
     * Override del método searchCliente() que, recibiendo por parámetro el nombre y nif de un cliente, lo convierte en un
     * objeto temporal de tipo Cliente y realiza una búsqueda de este objeto. Devuelve el índice de posición de la instancia
     * dentro de una lista de objetos de tipo Cliente o -1 si no existe.
     *
     * @param nif    String NIF del cliente, valor del campo nif de la instancia de Cliente.
     * @param nombre String Nombre del cliente, valor del campo cliente de la instancia de Cliente.
     * @return int Índice de posicio del elemento si lo ha encontrado o -1 si no lo ha encontrado.
     * @see Cliente
     */
    public int searchCliente(String nif, String nombre) {

        //ListIterator<Cliente> iterator = clientes.listIterator();
        ClienteComparator comparator = new ClienteComparator();

        Cliente tempCliente = new NoRegistrado(nif, nombre);

        return searchCliente(tempCliente);
    }

    /**
     * El método removeCliente() elimina una instancia de Cliente de una lista de objetos de tipo Cliente dado su índice de
     * posición que recibe por porámetro.
     *
     * @param ind int Índice de posición del elemento a eliminar.
     * @see Cliente
     */
    public void removeCliente(int ind) {
        try {
            clientes.remove(ind);
            Cliente.setActualClientes(Cliente.getActualClientes() - 1);
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * El método clearClientes() elimina todas las instancias de Cliente de una lista de objetos de tipo Cliente.
     *
     * @see Cliente
     */
    public void clearClientes() {

        if (clientes.isEmpty()) {
            System.out.println("Error: La lista está vacía!");
            return;
        }

        try {
            clientes.clear();
            Cliente.setActualClientes(0);
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Se han eliminado todos los elementos de la lista.");
    }

    /**
     * EL método printClientes() muestra por pantalla todos los datos de cada una de las instancias de tipo CLiente dentro
     * de un ArrayList de estas. Para mostrar los datos usa el preformato construido dentro de la cunficón toString() de
     * la superclase Cliente y de sus subclases.
     *
     * @see Cliente
     * @see NoRegistrado
     * @see Registrado
     * @see Profesional
     * @see WoodFriend
     */
    public void printClientes() {

        for (Cliente cliente : clientes) {

            String tipo = cliente.getClass().getSimpleName();

            System.out.println("====================================================");
            System.out.println("Tipo de cliente: " + tipo + "\n" +
                    cliente);
            System.out.println("====================================================");
        }
    }

    /**
     * El método AdjudicarCodigoCliente() delega la creación del código durante la instanciación de un Objeto de tipo
     * Cliente a la clase SedeCentral. Además, el método en el que recae la generación del código, addCodigoCliente()
     * añade el código a la lista de códigos, con lo que estaremos realizando la tares de crear el código y de guardarlo.
     * La clase CLiente se encarga de adjudicarlo.
     *
     * @param key String La llave que se usa para generar el codigo Hash.
     * @return String el código de cliente generado.
     * @see Cliente
     */
    public static String adjudicarCodigoCliente(String key) {
        return socios.addCodigoWoodFriend(key);
    }

    /* Extras */

    /**
     * El método addOferta() carga una instancia de DetalleOferta que actua como Clase Asociativa entre SedeCentral y Oferta.
     *
     * @param oferta DetalleOferta Instancia de la Clase Asociativa DetalleOferta que relacina las Clases Oferta y SedeCentral.
     *
     * @return boolean Devuelve cierto si la carga se ejecuta de forma satisfactoria.
     * @see Oferta
     * @see DetalleOferta
     */
    public boolean addOferta(DetalleOferta oferta) {

        try {
            detalleOfertas.add(Objects.requireNonNull(oferta));
        } catch (Exception e) {
            System.out.println("Error: No se ha podido añadir la oferta.");
            return false;
        }

        return true;
    }

    /**
     * El método searchOferta() busca una oferta a través del código que recibe por parámetro.
     * El método obtiene las ofertas accediendo a cada uno de las instancias de DetalleOferta de la lista detalleOfertas
     * y capturando la oferta a través de la relación de la Clase Asociativa.
     *
     * @param codigo String Código de la oferta buscada.
     * @return int Índice de posición de la oferta. Devuelve -1 si la oferta no existe.
     * @see DetalleOferta
     * @see Oferta
     */
    public int searchOferta(String codigo) {

        /* Creamos un iterador */
        ListIterator<DetalleOferta> iterator = detalleOfertas.listIterator();

        Oferta actualOferta = null;
        int posInd = -1;
        boolean isFound = false;

        /* Comprobamos los elementos de la lista */
        while (iterator.hasNext() && !isFound) {

            /* Obtenemos la oferta */
            try {
                actualOferta = iterator.next().getOferta();
            } catch (NullPointerException e) {
                System.out.println("Error: No hay ninguna oferta guardada.");
            }

            /* Comparamos la oferta */
            isFound = actualOferta.compareOferta(Objects.requireNonNull(codigo));

            if (isFound) {
                posInd = iterator.previousIndex();
            }
        }

        return posInd;
    }

    /**
     * El método modificarOferta() permite cambiar la descripción y fecha de fin de una instancia de Oferta ya existente.
     * Capturamos la Oferta a través de la Clase Asociativa DetalleOferta usando el método searchOferta() para comprobar si existe.
     *
     * @param codigo String Codigo de la oferta.
     * @param descripcion String Nueva descripción de la oferta.
     * @param fechaFin String Nueva fecha de finalización de la oferta.
     * @return boolean Devuelve cierto si se ha podido modificar la oferta.
     * @see Oferta
     * @see DetalleOferta
     */
    public boolean modificarOferta(String codigo, String descripcion, String fechaFin) {

        int ind = -1;
        Oferta actualOferta;

        /* Buscamos la Oferta */
        ind = searchOferta(Objects.requireNonNull(codigo));

        try {
            actualOferta = detalleOfertas.get(ind).getOferta();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: No se ha podido modificar la oferta.");
            return false;
        }

        /* Modificamos la oferta */
        try {
            actualOferta.modificarOferta(descripcion, fechaFin);

        } catch (Exception e) {
            System.out.println("Error: No se ha podido modificar la oferta.");
            return false;
        }

        if (actualOferta != null) {
            detalleOfertas.get(ind).getOferta().modificarOferta(actualOferta);
            return true;
        } else { return false; }
    }

    /**
     * El método deleteOferat() elimina una oferta indicada por el código de oferta que recibe por parámetro.
     * Para obtener la oferta, se usa la Clase Asociativa DetalleOferta y el método de búsqueda searchOferta().
     * Al eliminar la Clase Asociativa, se borran las referencias y así el recolector de basura eliminará automáticamente
     * la instancia de la Clase Oferta asociada.
     *
     * @param codigo String Código de la oferta que queremos eliminar.
     * @return Oferta Instancia de la Clase Oferta que eliminamos.
     * @see Oferta
     * @see DetalleOferta
     */
    public Oferta deleteOferta(String codigo) {

        int posInd = -1;
        Oferta deletedOferta;

        /* Comprobamos si existe la oferta */
        posInd = searchOferta(codigo);

        try {
            deletedOferta = detalleOfertas.get(posInd).getOferta();
            detalleOfertas.remove(posInd);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: No ha podido eliminarse la oferta indicada.");
            return null;
        }

        return deletedOferta;
    }

    /**
     * El método listOfertas() muestra una lista con todas las instancias de la Clase Oferta relacionadas con los distintos
     * elementos del tipo DetalleOferta asociados guardados en la Lista DetalleOfertas.
     *
     * @see Oferta
     * @see DetalleOferta
     */
    public void listOfertas() {

        if (!detalleOfertas.isEmpty()) {
            for (DetalleOferta oferta : detalleOfertas) {
                System.out.println("\n------------------------------------------------------");
                System.out.println(oferta.getOferta());
                System.out.println("------------------------------------------------------\n");
            }
        } else {
            System.out.println("\n------------------------------------------------------");
            System.out.println("No existen ofertas que mostrar.");
            System.out.println("------------------------------------------------------\n");
        }
    }
}
