package aa5_woodshops.drivers;

import aa5_woodshops.centros.*;
import aa5_woodshops.clientes.*;
import aa5_woodshops.items.*;
import aa5_woodshops.validador_fechas.ValidadorFechas;
import aa5_woodshops.ventas.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * La Clase Driver contiene los métodos Driver para el programa main.
 */
public class Driver {

    static Scanner teclado = new Scanner(System.in);

    /**
     * Método para crear la instancia de SedeCentral
     *
     * @param nombre String Nombre de la empresa.
     * @param nif    String Nombre de la empresa.
     * @return SedeCentral Instancia de tipo SedeCentral que representa a la empresa.
     * @see SedeCentral
     */
    public static SedeCentral crearSedeCentral(String nombre, String nif) {
        return new SedeCentral(nombre, nif);
    }

    /**
     * Método para crear instancias de tipo Tienda y asociarlas a la Empresa.
     *
     * @param sede      SedeCentral Instancia de tipo SedeCentral que representa la empresa.
     * @param nombre    String Nombre d ela tienda.
     * @param localidad String Ubicación de la tienda.
     * @return int Índice de posición en la lista de Tiendas
     * @see SedeCentral
     * @see Tienda
     */
    public static int crearTienda(SedeCentral sede, String nombre, String localidad) {
        sede.addTienda(nombre, localidad);

        return sede.buscarTiendaPorNombre(nombre);
    }

    /**
     * Método para crear una instancia de tipo Proveedor que representa a un proveedor de la Empresa.
     *
     * @param catalogo CatalogoProveedores Instancia de CatalogoProveedores que contiene todos los Proveedores asociados a la empresa.
     * @param nif      String NIF del proveedor.
     * @param nombre   String Nombre del proveedor.
     * @return ind Índice de posición del proovedor en la lista de proveedores.
     * @see CatalogoProveedores
     * @see Proveedor
     */
    public static int crearProveedor(CatalogoProveedores catalogo, String nif, String nombre) {
        Proveedor actualProveedor = new Proveedor(nif, nombre);
        catalogo.addProveedor(actualProveedor);

        return catalogo.getListaProveedores().indexOf(actualProveedor);
    }

    /**
     * Método para añadir una instacia de tipo Producto a una instancia de tipo Tienda asociada a una SedeCentral.
     * El producto se añade a la instancia de Almacen asociada con la tienda.
     *
     * @param sede         SedeCentral Instancia de SedeCentral que representa la empresa.
     * @param nombreTienda String Nombre de la tienda
     * @param producto     Producto Instancia de tipo Producto para añadir a la tienda.
     * @param precioventa  double Precio de venta del producto en la tienda.
     * @param cantidad     int Cantidad de stock de producto a añadir a la tienda.
     * @see SedeCentral
     * @see Tienda
     * @see Almacen
     * @see Producto
     * @see Stock
     * @see Proveedor
     */
    public static void addProductoATienda(SedeCentral sede, String nombreTienda, Producto producto,
                                          double precioventa, int cantidad) {
        sede.addProductoTienda(nombreTienda, producto, precioventa, cantidad);
    }

    /**
     * Método para implementar la creación de productos en el menú.
     *
     * @param sede          SedeCentral Empresa
     * @param tiposProducto String[] Tipos de producto de los que dispone la empresa.
     * @param proveedores   CatalogoProveedores Proveedores asociados a la empresa.
     */
    public static void addProductosATienda(SedeCentral sede, String[] tiposProducto, CatalogoProveedores proveedores) {
        Producto actualProducto;
        Proveedor actualProveedor;
        int opcion = -1, ind;
        String actualTienda, actualTipoProducto, actualTipo, actualDescripcion;
        double altura = -1.0, anchura = -1.0, actualPrecioVenta = -1.0;
        int mililitros = -1, actualCantidad = -1;

        System.out.println("Por favor, escoja una tienda de la siguiente lista:");
        sede.listNombreTiendas();
        System.out.println("Seleccione una opcion entre 1 - " + sede.getTiendas().size());

        /* Validación de entrada */
        do {
            try {
                opcion = demanarOpcioSencer();

                if (opcion > sede.getTiendas().size() || opcion < 1) {
                    System.out.println("El valor introducido no es correcto, por favor, " +
                            "introduzca una opcion entre 1 y " + sede.getTiendas().size() + ':');
                }
            } catch (Exception e) {
                System.out.println("El valor introducido no es un entero, por favor, +" +
                        "introduzca una opcion ente 1 y " + sede.getTiendas().size() + ':');
                continue;
            }
        } while (opcion > sede.getTiendas().size() || opcion < 1);

       /* opcion = demanarOpcioSencer();
        while (opcion > sede.getTiendas().size() || opcion < 1) {
            System.out.println("El valor introducido no es correcto, por favor, " +
                    "introduzca una opcion entre 1 y " + sede.getTiendas().size() + ':');
            opcion = demanarOpcioSencer();
        }*/
        actualTienda = sede.getTiendas().get(opcion - 1).getNombre();

        System.out.println("Escoja un proveedor de la siguiente lista:");
        proveedores.listProveedoresName();
        System.out.println("Seleccione una opcion entre 1 - " + proveedores.getListaProveedores().size());

        /* Validación de entrada */
        do {
            try {
                opcion = demanarOpcioSencer();

                if (opcion > proveedores.getListaProveedores().size() || opcion < 1) {
                    System.out.println("El valor introducido no es correcto, por favor, " +
                            "introduzca una opcion entre 1 y " + proveedores.getListaProveedores().size() + ':');
                }
            } catch (Exception e) {
                System.out.println("El valor introducido no es un entero, por favor, " +
                        "introduzca un valor entre 1 y " + proveedores.getListaProveedores().size() + ':');
                continue;
            }
        } while (opcion > proveedores.getListaProveedores().size() || opcion < 1);
        /*opcion = demanarOpcioSencer();
        while (opcion > proveedores.getListaProveedores().size() || opcion < 1) {
            System.out.println("El valor introducido no es correcto, por favor, " +
                    "introduzca una opcion entre 1 y " + proveedores.getListaProveedores().size() + ':');
            opcion = demanarOpcioSencer();
        }*/
        actualProveedor = proveedores.getListaProveedores().get(opcion - 1);

        System.out.println("Escoja el tipo de producto:");
        ind = 0;
        for (String tipo : tiposProducto) {
            System.out.println(++ind + ". " + tipo);
        }
        System.out.println("Seleccione una opcion entre 1 - " + tiposProducto.length);

        /* Validación de datos */
        do {
            try {
                opcion = demanarOpcioSencer();

                if (opcion > tiposProducto.length || opcion < 1) {
                    System.out.println("El valor introducido no es correcto, por favor, " +
                            "introduzca una opcion 1 y " + tiposProducto.length + ':');
                }
            } catch (Exception e) {
                System.out.println("El valor introducido no es un entero, por favor, " +
                        "introduzca una opcion 1 y " + tiposProducto.length + ':');
                continue;
            }
        } while (opcion > tiposProducto.length || opcion < 1);
        /*opcion = demanarOpcioSencer();
        while (opcion > tiposProducto.length || opcion < 1) {
            System.out.println("El valor introducido no es correcto, por favor, " +
                    "introduzca una opcion 1 y " + tiposProducto.length + ':');
            opcion = demanarOpcioSencer();
        }*/
        actualTipoProducto = tiposProducto[opcion - 1];

        System.out.println("Ingrese los datos del producto: ");
        System.out.println("Descripcion: ");
        actualDescripcion = demanarDades();
        while (actualDescripcion == null || Objects.requireNonNull(actualDescripcion).length() < 1) {
            System.out.println("Por favor, introduzca una descripción válida:");
            actualDescripcion = demanarDades();
        }

        System.out.println("Cantidad: [Ingrese un entero]");

        /* Validación de datos */
        do {
            try {
                actualCantidad = demanarOpcioSencer();

                if (actualCantidad < 1) {
                    System.out.println("Por favor, introduzca una cantidad valida:");
                }
            } catch (Exception e) {
                System.out.println("El valor introducido no es un entero, por favor, " +
                        "introduzca un valor entero.");
                continue;
            }
        } while (actualCantidad < 1);
        /*actualCantidad = demanarOpcioSencer();
        while (actualCantidad < 1) {
            System.out.println("Por favor, introduzca una cantidad valida:");
            actualCantidad = demanarOpcioSencer();
        }*/

        System.out.println("Precio de Venta: [En Euros]");

        /* Validación de datos */
        do {
            try {
                actualPrecioVenta = Double.parseDouble(Objects.requireNonNull(demanarDades()));
            } catch (Exception e) {
                System.out.println("El valor introducido no es válido, por favor introduzca un valor real tipo ee.dd");
                continue;
            }
        } while (actualPrecioVenta < 0);
        /*actualPrecioVenta = Double.parseDouble(Objects.requireNonNull(demanarDades()));*/

        if (actualTipoProducto.equals(tiposProducto[0])) {
            System.out.println("Indique la altura en cm: ");
            /* Validación de datos */
            do {
                try {
                    altura = Double.parseDouble(Objects.requireNonNull(demanarDades()));
                } catch (Exception e) {
                    System.out.println("El valor introducido no es válido, por favor introduzca un valor real tipo ee.dd");
                    continue;
                }
            } while (altura < 0);
            /*altura = Double.parseDouble(Objects.requireNonNull(demanarDades()));*/
            System.out.println("Indique la anchura en cm: ");
            /* Validación de datos */
            do {
                try {
                    anchura = Double.parseDouble(Objects.requireNonNull(demanarDades()));
                } catch (Exception e) {
                    System.out.println("El valor introducido no es válido, por favor introduzca un valor real tipo ee.dd");
                    continue;
                }
            } while (anchura < 0);
            /*anchura = Double.parseDouble(Objects.requireNonNull(demanarDades()));*/
            System.out.println("Indique el tipo: ");
            ind = 0;
            for (TipoTablero tipo : TipoTablero.values()) {
                System.out.println(++ind + ". " +
                        tipo.toString());
            }
            System.out.println("Seleccione una opcion entre 1 - " + TipoTablero.values().length);
            /* Validación datos */
            do {
                try {
                    opcion = demanarOpcioSencer();

                    if (opcion > TipoTablero.values().length || opcion < 0) {
                        System.out.println("El valor introducido no es valido, por favor " +
                                "introduzca un valor entre 1 y " + TipoTablero.values().length + ':');
                    }
                } catch (Exception e) {
                    System.out.println("El valor introduido no es un entero, por favor " +
                            "introduzca un valor entre 1 y " + TipoTablero.values().length + ':');
                    continue;
                }
            } while (opcion > TipoTablero.values().length || opcion < 0);
            /*opcion = demanarOpcioSencer();*/
            actualTipo = String.valueOf(TipoTablero.values()[opcion - 1]);

            actualProducto = new Tablero(actualDescripcion, actualProveedor, altura, anchura, actualTipo);

        } else if (actualTipoProducto.equals(tiposProducto[1])) {
            System.out.println("Indique la cantidad en ml: ");
            /* Validación de datos */
            do {
                try {
                    mililitros = Integer.parseInt(Objects.requireNonNull(demanarDades()));
                } catch (Exception e) {
                    System.out.println("El valor introducido no es válido, por favor introduzca un valor real tipo ee.dd");
                    continue;
                }
            } while (mililitros < 0);
            /*mililitros = Integer.parseInt(Objects.requireNonNull(demanarDades()));*/
            System.out.println("Indique el color: ");
            ind = 0;
            for (TipoColor color : TipoColor.values()) {
                System.out.println(++ind + ". " +
                        color.toString());
            }
            System.out.println("Seleccione una opcion entre 1 - " + TipoColor.values().length);
            /* Validación de datos */
            do {
                try {
                    opcion = demanarOpcioSencer();

                    if (opcion < 1 || opcion > TipoColor.values().length) {
                        System.out.println("El valor escogido no es válido, por favor, " +
                                "escoja una opción entre 1 y " + TipoColor.values().length);
                    }
                } catch (Exception e) {
                    System.out.println("El valor introducido no es un entero, por favor, " +
                            "introduzca un valor ente 1 y " + TipoColor.values().length);
                    continue;
                }
            } while (opcion < 1 || opcion > TipoColor.values().length);
            /*opcion = demanarOpcioSencer();*/
            actualTipo = String.valueOf(TipoColor.values()[opcion - 1]);

            actualProducto = new Barniz(actualDescripcion, actualProveedor, mililitros, actualTipo);

        } else {
            System.out.println("Indique el tipo de Articulo:");
            ind = 0;
            for (TipoArticulo tipo : TipoArticulo.values()) {
                System.out.println(++ind + ". " +
                        tipo.toString());
            }
            System.out.println("Seleccione una opcion entre 1 - " + TipoArticulo.values().length);
            /* Validación de datos */
            do {
                try {
                    opcion = demanarOpcioSencer();

                    if (opcion < 1 || opcion > TipoArticulo.values().length) {
                        System.out.println("El valor no es válido, por favor, " +
                                "escoja un valor entre 1 y " + TipoArticulo.values().length);
                    }
                } catch (Exception e) {
                    System.out.println("El valor introducido no es un entero, por favor, " +
                            "seleccione un valor entre 1 y " + TipoArticulo.values().length);
                    continue;
                }
            } while (opcion < 1 || opcion > TipoArticulo.values().length);
            /*opcion = demanarOpcioSencer();*/
            actualTipo = String.valueOf(TipoArticulo.values()[opcion - 1]);

            actualProducto = new Articulo(actualDescripcion, actualProveedor, actualTipo);
        }

        addProductoATienda(sede, actualTienda, actualProducto, actualPrecioVenta, actualCantidad);

        System.out.println("Se ha creado el siguiente producto:");
        System.out.println(actualProducto);
        System.out.println("En la tienda:");
        System.out.println(actualTienda);

        System.out.println("-----------------------");
    }

    /**
     * Método para implementar el menú que permite listar todos los productos de una tienda de la empresa.
     *
     * @param sede          SedeCentral Empresa
     * @param tiposProducto String[] Tipos de producto de los que dispone la empresa.
     */
    public static void listarProductosTiendas(SedeCentral sede, String[] tiposProducto) {
        int opcion = -1, ind;
        String actualTienda, actualTipoProducto;

        System.out.println("-----------------------");
        System.out.println("Por favor, escoja una tienda de la siguiente lista:");
        sede.listNombreTiendas();
        System.out.println("Seleccione una opcion entre 1 - " + sede.getTiendas().size());
        /* Validación de datos */
        do {
            try {
                opcion = demanarOpcioSencer();

                if (opcion < 1 || opcion > sede.getTiendas().size()) {
                    System.out.println("El valor introducido no es válido, por favor, " +
                            "introduzca un valor entre 1 y " + sede.getTiendas().size());
                }
            } catch (Exception e) {
                System.out.println("El valor introducido no es un entero, por favor, " +
                        "introduzca un valor entre 1 y " + sede.getTiendas().size());
                continue;
            }
        } while (opcion < 1 || opcion > sede.getTiendas().size());
       /*opcion = demanarOpcioSencer();*/
        actualTienda = sede.getTiendas().get(opcion - 1).getNombre();

        System.out.println("Escoja el tipo de producto:");
        ind = 0;
        for (String tipo : tiposProducto) {
            System.out.println(++ind + ". " + tipo);
        }
        System.out.println("Seleccione una opcion entre 1 - " + tiposProducto.length);
        /* Validación de datos */
        do {
            try {
                opcion = demanarOpcioSencer();

                if (opcion < 1 || opcion > tiposProducto.length) {
                    System.out.println("El valor introducido no es válido, por favor, " +
                            "introduzca un valor entre 1 y " + tiposProducto.length);
                }
            } catch (Exception e) {
                System.out.println("El valor introducido no es un entero, por favor, " +
                        "introduzca un valor entre 1 y " + tiposProducto.length);
                continue;
            }
        } while (opcion < 1 || opcion > tiposProducto.length);
        /*opcion = demanarOpcioSencer();
        while (opcion > tiposProducto.length || opcion < 1) {
            System.out.println("El valor introducido no es correcto, por favor, " +
                    "introduzca una opcion entre 1 y " + tiposProducto.length + ':');
            opcion = demanarOpcioSencer();
        }*/
        actualTipoProducto = tiposProducto[opcion - 1];

        System.out.println("La tienda: " + actualTienda + " dispone de los siguientes productos de tipo "
                + actualTipoProducto);

        sede.listarProductosTiendaPorTipo(actualTienda, actualTipoProducto);
        System.out.println("-----------------------");
    }

    /**
     * Método para implementar el menú que muestra todos los códigos de producto y permite buscar lso stocks de un
     * producto dado su código y los muestra relacionados con cada tienda d ela empresa.
     *
     * @param sede SedeCentral empresa
     */
    public static void listarStocksProductosEnTiendasPorCodigo(SedeCentral sede) {
        int opcion = -1;
        boolean isSalir = false;
        String actualCodigo;

        do {
            System.out.println("-----------------------");
            System.out.println("Por favor escoja una opción: ");
            System.out.println("""
                    1. Ver todos los codigos de producto
                    2. Listar el stcok de productos por codigo
                    0. Salir""");
            /* Validación de Datos */
            do {
                try {
                    opcion = demanarOpcioSencer();

                    if (opcion > 2 || opcion < 0) {
                        System.out.println("El valor introducido no es correcto, por favor, introduzca una opcion entre 0 y 2:");
                    }
                } catch (Exception e) {
                    System.out.println("El valor introducido no es un entero, por favor, " +
                            "introduzca un valor entre 0 y 2:");
                    continue;
                }
            } while (opcion > 2 || opcion < 0);
            /*while (opcion > 2 || opcion < 0) {
                System.out.println("El valor introducido no es correcto, por favor, introduzca una opcion entre 0 y 2:");
                opcion = demanarOpcioSencer();
            }*/

            switch (opcion) {
                case 1 -> {
                    System.out.println("-----------------------");
                    sede.listarCodigosProducto();
                }
                case 2 -> {
                    System.out.println("-----------------------");
                    System.out.println("Indique el codigo del producto:");
                    actualCodigo = demanarDades();

                    sede.listarStockProductoEnTienda(actualCodigo);
                }
                case 0 -> isSalir = true;
            }
        } while (!isSalir);

        System.out.println("-----------------------");
    }

    /**
     * Método para imprimir por pantalla una lista de los proveedores de la empresa y los productos que tienen asociados.
     *
     * @param sede SedeCentral Empresa.
     */
    public static void listarProveedores(SedeCentral sede) {
        int ind = 0;

        System.out.println("-----------------------");
        for (Proveedor proveedor : sede.getProveedores().getListaProveedores()) {
            System.out.println(++ind + ". " +
                    proveedor);
        }
        System.out.println("-----------------------");
    }

    /**
     * El método demanarOpcioSencer() lee una entrada por teclado y arroja el entero obtenido.
     *
     * @return int: Entero seleccionado por el usuario
     */
    static int demanarOpcioSencer() {
        String resp;
        resp = teclado.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }

        return Integer.parseInt(resp);
    }

    /**
     * El método demanarDades() lee una entrada por teclado y arroja el String obtenido.
     *
     * @return String: String creado por el usuario
     */
    static String demanarDades() {
        String res;
        res = teclado.nextLine();
        if (res.isEmpty()) {
            res = null;
        }

        return res;
    }

    /* AA4 */

    /**
     * El método gestionarClientes() es el driver para control el flujo de opciones de gestión de clientes.
     * Implementa un menú contextual y realiza la llamada a las funciones o drivers necesarios. Para la impresión de la
     * lista de clientes, delega en SedeCentral llamando a la función printClientes().
     *
     * @param sede SedeCentral Instancia de la Clase SedeCentral que representa la empresa y centraliza la mayoría de
     *             funciones.
     * @see SedeCentral
     * @see Cliente
     */
    public static void gestionarClientes(SedeCentral sede) {

        int opcion = -1;
        boolean isSalir = false;

        System.out.println("====================================================");
        System.out.println("Administración de Clientes:");
        System.out.println("====================================================");

        do {
            System.out.println("Por favor, escoja una opcion:");
            System.out.println("1. Ver todos los clientes actuales.");
            System.out.println("2. Buscar datos de un cliente.");
            System.out.println("3. Añadir un nuevo cliente.");
            System.out.println("0. Volver.");
            System.out.println("" +
                    "Elija entre 0 y 3");
            /* Validación de Datos */
            do {
                try {
                    opcion = demanarOpcioSencer();

                    if (opcion < 0 || opcion > 3) {
                        System.out.println("El valor introducido no es correcto, por favor, " +
                                "introduzca una opcion entre 0 y 3:");
                    }
                } catch (Exception e) {
                    System.out.println("El valor introducido no es un entero, por favor " +
                            "introduzca una opción entre 0 y 3:");
                    continue;
                }
            } while (opcion < 0 || opcion > 3);
            /*opcion = demanarOpcioSencer();
            while (opcion > 3 || opcion < 0) {
                System.out.println("El valor introducido no es correcto, por favor, introduzca una opcion entre 0 y 3:");
                opcion = demanarOpcioSencer();
            }*/

            switch (opcion) {
                case 1 -> sede.printClientes();
                case 2 -> mostrarCliente(sede);
                case 3 -> nuevoCliente(sede);
                case 0 -> isSalir = true;
            }
        } while (!isSalir);

        System.out.println("====================================================");
        System.out.println();
    }

    /**
     * El método makeVenta() es el driver principal para dirigir el flujo del programa para realizar runa venta.
     * Realiza las llamadas a los drivers necesarios, crea las instancias de la Clase Venta y de la Clase Ticker y gestiona
     * la creación de la venta, el uso de la Clase Asociativa DetalleVenta y añad ela Venta a la instancia de la Clase Tienda.
     *
     * @param sede SedeCentral Instancia de la Clase SedeCentral que representa la empresa y centraliza la mayoría de
     *             funciones.
     * @see SedeCentral
     * @see Venta
     * @see Ticket
     * @see Cliente
     * @see Producto
     * @see DetalleVenta
     */
    public static void makeVenta(SedeCentral sede) {

        Venta venta;
        Ticket ticket;
        Tienda actualTienda;
        Cliente actualCliente;
        String opcionStr;
        boolean isSalir = false;
        int opcion = -1;

        System.out.println("====================================================");
        System.out.println("Nueva Venta:");
        System.out.println("====================================================");

        /* Escoger Tienda */
        actualTienda = chooseTienda(sede);

        if (actualTienda != null) {

            /* Seleccionar cliente */
            try {
                actualCliente = chooseCliente(sede);
            } catch (NullPointerException e) {
                System.out.println("Fallo en la selección del cliente.");
                return;
            }

        } else {
            System.out.println("Error: Ha habido un problema en la seleccion de la tienda.");
            return;
        }

        if (actualCliente != null) {

            /* Abrir ticket venta */
            venta = new Venta(actualTienda, actualCliente);

        } else {
            System.out.println("Ha habido un problema en la seleccion del cliente.");
            return;
        }

        /* Escoger productos */
        /* Creamos la venta y el ticket */
        //venta = new Venta(actualTienda, actualCliente);
        ticket = new Ticket();

        do {
            System.out.println("-------------------------------------------------");
            System.out.println("Por favor, escoja una opcion: ");
            System.out.println("1. Generar una nueva línea de compra.");
            System.out.println("0. Volver");
            do {
                try {
                    opcion = demanarOpcioSencer();

                    if (opcion < 0 || opcion > 1) {
                        System.out.println("El valor introducido no es correcto, por favor, introduzca una opcion 1 o 0:");
                    }
                } catch (Exception e) {
                    System.out.println("El valor introducido no es un entero, por faovr, introduzca 1 o 0:");
                    continue;
                }
            } while (opcion < 0 || opcion > 1);
            /*opcion = demanarOpcioSencer();
            while (opcion > 1 || opcion < 0) {
                System.out.println("El valor introducido no es correcto, por favor, introduzca una opcion 0 o 1:");
                opcion = demanarOpcioSencer();
            }*/

            switch (opcion) {
                case 1 -> escogerProductos(actualTienda, venta, ticket);
                case 0 -> isSalir = true;
            }
        } while (!isSalir);

        /* Mostramos el ticket por pantalla */
        if (ticket != null) { venta.printVenta(ticket); }

        /* Finalizamos el ticket */
        if (venta != null) { actualTienda.addVenta(venta); }

        System.out.println("====================================================");
        System.out.println();

        /* Espera de lectura de ticket */
        System.out.println("Pulse ENTER para continuar");
        try {
            opcionStr = demanarDades();
        } catch (Exception e) {
            return;
        }
    }

    /**
     * El método mostrarTodosLosTickets() es el driver principal para dirigir el flujo del programa para realizar la tarea
     * de mostrar un resumen de todas las ventas dentro de una franja temporal.
     * Realiza las llamadas a los driver secundarios, crea un ArrayList de tipo Venta para almacenar una lista temporal de
     * instancias de la Clase venta que coincidan con el filtro de búsqueda, obtiene el rango de fechas y la tienda y filtra
     * las ventas de esa tienda. Delega las funciones de filtrado e impresión de datos en Tienda y Venta respectivamente.
     *
     * @param sede SedeCentral Instancia de la Clase SedeCentral que representa la empresa y centraliza la mayoría de
     *             funciones.
     * @see SedeCentral
     * @see Tienda
     * @see Venta
     * @see Ticket
     * @see DetalleVenta
     */
    public static void mostrarTodosLosTickets(SedeCentral sede) {

        String opcionStr;
        LocalDate dumbDate, fechaIn, fechaFin;
        Tienda actualTienda;
        Ticket ticket;
        ArrayList<Venta> ventasFiltradas = new ArrayList<>();

        dumbDate = LocalDate.parse("1900-01-01");
        fechaIn = null;
        fechaFin = null;

        System.out.println("====================================================");
        System.out.println("Resumen de Ventas:");
        System.out.println("====================================================");

        /* Preguntamos la tienda */
        actualTienda = chooseTienda(sede);

        /* Preguntamos las fechas de inicio y fin */
        System.out.println("-------------------------------------------------");

        /* Preguntamos la fecha de inicio */
        System.out.println("Por favor, introduzca la fecha de inicio con el siguiente formato dd-mm-aaaa:");
        fechaIn = escogerFechas();

        /* Preguntamos la fecha final */
        System.out.println("Por favor, introduzca la fecha final con el siguiente formato dd-mm-aaaa:");
        fechaFin = escogerFechas();

        System.out.println("-------------------------------------------------");
        System.out.println();

        if (actualTienda != null) { ventasFiltradas = actualTienda.filterVentas(fechaIn, fechaFin); }

        if (ventasFiltradas.size() > 0) {
            System.out.println("-------------------------------------------------");
            System.out.println("Resumen de ventas:");

            /* Iteramos por todos los elementos de la lista y mostramos la información */
            for (Venta venta : ventasFiltradas) {
                System.out.println("-------------------------------------------------");
                ticket = venta.getDetalleLineas().get(0).getTicket();
                venta.printResumenVenta(ticket);

                /* Espera de lectura de ticket */
                System.out.println("Pulse ENTER para continuar");
                try {
                    opcionStr = demanarDades();
                } catch (Exception e) {
                    continue;
                }
            }

        } else {
            System.out.println("No hay ventas coincidentes con el filtro.");
            return;
        }
    }

    /**
     * El método mostrarCliente() nusca una instancia de la Clase Cliente a través del nif que recibe como parámetro y, si
     * existe, imprime sus datos por pantalla.
     * Delega en la función buscarCliente().
     *
     * @param sede SedeCentral Instancia de la Clase SedeCentral que representa la empresa y centraliza la mayoría de
     *             funciones.
     * @see SedeCentral
     * @see Cliente
     */
    private static void mostrarCliente(SedeCentral sede) {

        Cliente cliente = null;

        /* Buscamos el cliente */
        try {
            cliente = buscarCliente(sede);
        } catch (NullPointerException e) {
            System.out.println("Error: No se ha podido acceder a ningun cliente.");
            return;
        }

        System.out.println("-------------------------------------------------");
        System.out.println("Datos del Cliente:");
        System.out.println((cliente != null) ? cliente : "No existe ningún cliente con ese NIF.");
        System.out.println("-------------------------------------------------");
        System.out.println();
    }

    /**
     * El método buscarCliente() busca un cliente en una lista de clientes de una instancia de SedeCentral y, si existe,
     * lo devuelve como retorno. Para la búsqueda usa el nif del cliente que recibe como parámetro y delega en el método
     * searchCliente() de SedeCentral.
     *
     * @param sede SedeCentral Instancia de la Clase SedeCentral que representa la empresa y centraliza la mayoría de
     *             funciones.
     * @return Cliente Instancia de Cliente buscada a través del nif.
     * @see SedeCentral
     * @see Cliente
     */
    private static Cliente buscarCliente(SedeCentral sede) {

        String auxDatos = null;
        int indPos = -1;

        System.out.println("-------------------------------------------------");
        System.out.println("Por favor, introduzca el NIF del cliente:");
        do {
            try {
                auxDatos = demanarDades();

                if (auxDatos.length() != 9) {
                    System.out.println("El formato de DNI introducido no es valido.");
                }
            } catch (NullPointerException e) {
                System.out.println("Se ha producido un error en la captura de datos.");
                continue;
            }
        } while (auxDatos.length() != 9);
        /*auxDatos = demanarDades();*/
        System.out.println();

        /* Buscamos el Cliente a través de su NIF */
        if (auxDatos != null) {
            try {
                indPos = sede.searchCliente(auxDatos);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("El DNI no se encuentra.");
                return null;
            }
        }
        /*indPos = sede.searchCliente(auxDatos);*/

        if (indPos >= 0) {
            return sede.getClientes().get(indPos);
        } else {
            return null;
        }
    }

    /**
     * El método escogerProductos() recibe por parámetro una instancia de la Clase Tienda, de la Clase Venta y de la Clase
     * Ticket y genera la líneas de venta gestionando la Clase Asociativa DetalleVenta.
     * Para ello, obtiene el producto a través del Stock en la Instancia de Almacen de la Tienda recibida por parámetro,
     * y los muestra para que el usuario escoja los productos a añadir en la línea de venta. Crea y gestiona una instancia
     * de DetalleVenta para añadir los prouctos y la añade a las instancias asociadas de las Clases Venta y Ticket.
     * Obtiene los datos de forma interactiva mediante un menú contextual.
     * Delega en los métodos de la Clase Tienda, Venta y Ticket.
     *
     * @param tienda Tienda Instancia de la Clase Tienda que representa una tienda de WoodShops desde donde se realiza la
     *               venta.
     * @param venta  Venta Instancia de la Clase Venta que representa una venta realizada por una tienda y esta formada por
     *               diferente líneas de detalle gestionadas a través de la clase aasociativa DetalleVenta
     * @param ticket Ticket Instancia de la Clase Ticker que gestiona la fecha y el número de Ticket y se asocia con Venta
     *               a través de la Clase Asociativa DetalleVenta.
     * @see Tienda
     * @see Venta
     * @see Ticket
     * @see Almacen
     * @see Stock
     * @see Producto
     * @see DetalleVenta
     */
    private static void escogerProductos(Tienda tienda, Venta venta, Ticket ticket) {

        String opcionChar = null;
        int cantidad = -1, actualStock;
        boolean isAvailable = false;
        Producto actualProducto;
        DetalleVenta actualDetalle;

        System.out.println("-------------------------------------------------");
        System.out.println("Generando una nueva línea de venta:");

        System.out.println("A continuación se muestra una lista con los productos disponibles: ");
        tienda.listarStock();

        /* Capturamos el código de producto */
        System.out.println("Introduzca el codigo del producto deseado: ");
        do {
            try {
                opcionChar = demanarDades();

                if (opcionChar.length() < 1) {
                    System.out.println("No se ha introducido un valor valido.");
                }
            } catch (Exception e) {
                System.out.println("Por favor, introduzca un valor valido.");
                continue;
            }
        } while (opcionChar.length() < 1);
       /* opcionChar = demanarDades();*/

        /* Buscamos y asignamos el producto */
        actualProducto = tienda.getAlmacen().obtenerProductoPorCodigo(opcionChar);
        while (actualProducto == null) {
            try {
                actualProducto = tienda.getAlmacen().obtenerProductoPorCodigo(opcionChar);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("El codigo de producto introducido no es correcto." +
                        " Por favor, indique un codigo valido:");
                opcionChar = demanarDades();
            }
        }

        try {
            actualStock = tienda.getAlmacen().getInventario().get(tienda.getAlmacen().checkProducto(actualProducto)).getCantidad();
            System.out.println("Cantidad disponible: " + actualStock);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error en la entrada de producto.");
            return;
        }

        /* Preguntamos la cantidad de unidades a vender y nos aseguramos de que haya stock */
        do {
            System.out.println("Indique la cantidad de unidades, introduzca un entero:");
            try {
                cantidad = demanarOpcioSencer();
            } catch (Exception e) {
                System.out.println("El valor initroducido no es un entero.");
                continue;
            }
            /*cantidad = demanarOpcioSencer();*/

            if (cantidad <= actualStock) {
                isAvailable = true;
            } else {
                System.out.println("La cantidad introducida supera el stock del producto.");
            }
        } while (!isAvailable);

        /* Reducimos el stock */
        if (cantidad > 0) {
            tienda.getAlmacen().getInventario().get(tienda.getAlmacen().checkProducto(actualProducto)).setCantidad(actualStock - cantidad);
        } else {
            System.out.println("Error: No se ha introducido una cantidad valida.");
            return;
        }

        /* Creamos la línea de venta */
        try {
            actualDetalle = new DetalleVenta(actualProducto, cantidad, venta, ticket);
        } catch (Exception e) {
            System.out.println("No se ha podido generar la línea de venta.");
            return;
        }
        venta.addDetalleVenta(actualDetalle);
        ticket.addDetalleVenta(actualDetalle);
    }

    /**
     * El método chooseTienda() realiza la selección de una tienda desde la cual se realizará la venta. Realizamos este
     * primer paso para ejecutar la prueba de las funciones de ventas. En un entorno real, la el software capturaría la
     * tienda desde donde se está trabajando.
     *
     * @param sede SedeCentral Instancia de la Clase SedeCentral que representa la empresa a la que pertenece la tienda.
     * @return Tienda Instanci de Clase Tienda. La tienda de la empresa desde donde realizaremos la venta.
     * @see SedeCentral
     * @see Tienda
     */
    private static Tienda chooseTienda(SedeCentral sede) {
        int opcion = -1;

        System.out.println("====================================================");
        System.out.println("Tienda actual:");
        System.out.println("====================================================");
        System.out.println("A continuacion se muestra la lista de tiendas. Para la prueba, escoja la tienda" +
                " desde donde se realizara la venta:");
        System.out.println("Escoja una opcion de 1 a " + sede.getTiendas().size() + ':');
        sede.listNombreTiendas();

        do {
            try {
                opcion = demanarOpcioSencer();

                if (opcion > sede.getTiendas().size() || opcion < 1) {
                    System.out.println("El valor introducido no es correcto, por favor, " +
                            "introduzca una opcion entre 1 y " + sede.getTiendas().size() + ':');
                }
            } catch (Exception e) {
                System.out.println("El valor introducido no es un entero, por favor, " +
                        "introduzca un valor entre 1 y " + sede.getTiendas().size() + ':');
            }
        } while (opcion > sede.getTiendas().size() || opcion < 1);
        /*opcion = demanarOpcioSencer();
        while (opcion > sede.getTiendas().size() || opcion < 1) {
            System.out.println("El valor introducido no es correcto, por favor, " +
                    "introduzca una opcion entre 1 y " + sede.getTiendas().size() + ':');
            opcion = demanarOpcioSencer();
        }*/

        return sede.getTiendas().get(opcion - 1);
    }

    /**
     * El método chooseCliente() implementa un menú contextual que sirve como función secundaria para makeVenta(). Se encarga
     * permitir al usuario decidir entre buscar una Instancia de CLiente en la lista de Clientes de una instancia de SedeCentral
     * que representa la empresa o crear un cliente nuevo y aladirlo a dicha lista. Retorna el cliente escogido o el nuevo.
     * Delega en SedeCentral, en el método obtainCliente() que devuelve la posición de una Instancia Cliente en la lista
     * para obtener un cliente ya dado de alta; o en el método nuevoCliente() para crear uno.
     *
     * @param sede SedeCentral Instancia de la Clase SedeCentral que representa la empresa y centraliza la mayoría de
     *             funciones.
     * @return Cliente Instancia de la Clase Cliente, representa un cliente de la empresa.
     * @see SedeCentral
     * @see Cliente
     */
    private static Cliente chooseCliente(SedeCentral sede) {

        Cliente actualCliente = null;
        int opcion = -1, posInd;

        System.out.println("-------------------------------------------------");

        System.out.println("Por favor, escoja una opcion: ");
        System.out.println("1. Escoger un cliente.");
        System.out.println("2. Dar de alta un nuevo cliente.");
        System.out.println("0. Volver atrás.");

        do {
            try {
                opcion = demanarOpcioSencer();

                if (opcion > 2 || opcion < 0) {
                    System.out.println("El valor introducido no es valido, por favor, introduzca 1, 2 o 0:");
                }
            } catch (Exception e) {
                System.out.println("El valor introducido no es un entero, por favor, " +
                        "introduzca 1, 2 o 0:");
            }
        } while (opcion > 2 || opcion < 0);
        /*opcion = demanarOpcioSencer();
        while (opcion > 2 || opcion < 0) {
            System.out.println("El valor introducido no es correcto, por favor, introduzca una opcion entre 0 y 2:");
            opcion = demanarOpcioSencer();
        }*/

        /* Escogemos buscar un cliente o crear uno nuevo */
        switch (opcion) {
            case 1 -> {
                try {
                    actualCliente = sede.getClientes().get(obtainCliente(sede));
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Error, el NIF introducido no se corresponde con ningún cliente.");
                    return null;
                }
            }
            case 2 -> actualCliente = nuevoCliente(sede);
            case 0 -> {
                return null;
            }
        }

        //System.out.println("-------------------------------------------------");
        System.out.println();

        return actualCliente;
    }

    /**
     * El método obtainCliente() implementa la búsqueda de una instancia de la Clase Cliente en una lista de instancias de
     * Cliente asociada a una instancia de la Clase SedeCentral que representa la empresa WoodShops.
     * Obtiene el nif del cliente mediante un menú contextual y delega en el método searchCliente() de la Clase SedeCentral
     * para encontrar el cliente, si existe.
     *
     * @param sede SedeCentral Instancia de la Clase SedeCentral que representa la empresa y centraliza la mayoría de
     *             funciones.
     * @return int Índice de posición de la instancia de Cliente en la lista de clientes de SedeCentral.
     * @see SedeCentral
     * @see Cliente
     */
    public static int obtainCliente(SedeCentral sede) {

        String nif = null;

        System.out.println("-------------------------------------------------");
        System.out.println("Obtener datos de un cliente:");
        System.out.println("-------------------------------------------------");

        /* Obtenemos el nif del cliente */
        System.out.println("Por favor, introduzca el NIF del cliente:");

        do {
            try {
                nif = demanarDades();

                if (nif.length() != 9) {
                    System.out.println("El DNI introducido no es valido. Por favor, seleccione un DNI valido");
                }
            } catch (Exception e) {
                System.out.println("Por favor, introduzca un valor con el formato ########X");
                continue;
            }
        } while (nif == null || Objects.requireNonNull(nif).length() != 9);
        /*nif = demanarDades();
        while (Objects.requireNonNull(nif).length() != 9) {
            System.out.println("El nif introducido no es correcto, por favor, introduzca nuevamente el nif:");
            nif = demanarDades();
        }*/

        /* Buscamos si existe el cliente */
        try {
            return sede.searchCliente(nif);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error, el NIF introducido no se corresponde con ningún cliente.");
            return -1;
        }
    }

    /**
     * El método nuevoCliente() gestiona la creación de una nueva instancia de la Clase Cliente mediante un menú contextual
     * y la añade a la lista de instancias de Cliente de una instancia de SedeCentral que representa la empresa.
     * Gestiona contextualmente la creación del tipo de subclase de Cliente a través de opciones que va escogiendo el usuario.
     *
     * @param sede SedeCentral Instancia de la Clase SedeCentral que representa la empresa y centraliza la mayoría de
     *             funciones.
     * @return Cliente Nueva instancia de Cliente generada.
     * @see SedeCentral
     * @see Cliente
     * @see Registrado
     * @see NoRegistrado
     * @see Profesional
     * @see WoodFriend
     */
    private static Cliente nuevoCliente(SedeCentral sede) {

        String nif = null, nombre = null, opcionChar = null;
        int opcion = -1, indPosCliente = -1;
        double descuento;
        Cliente actualCliente = null;

        System.out.println("-------------------------------------------------");
        System.out.println("Alta de nuevo cliente:");
        System.out.println("-------------------------------------------------");

        /* Obtenemos los distintos datos */
        do {
            System.out.println("Por favor, indique el nombre completo del cliente:");
            try {
                nombre = demanarDades();
                if (nombre.length() < 1) {
                    System.out.println("El valor introducido no es valido.");
                }
            } catch (Exception e) {
                System.out.println("Por favor, introduzca un nombre valido.");
                continue;
            }
        } while (nombre == null || Objects.requireNonNull(nombre).length() < 1);
        /*nombre = demanarDades();*/

        do {
            System.out.println("Indique el NIF del cliente, incluyendo la letra: ");
            try {
                nif = demanarDades();
                if (nif.length() != 9) {
                    System.out.println("El DNI introducido no es valido. Por favor, seleccione un DNI valido");
                }
            } catch (Exception e) {
                System.out.println("Por favor, introduzca un valor con el formato ########X");
                continue;
            }
            /*nif = demanarDades();*/
        } while (nif == null || Objects.requireNonNull(nif).length() != 9);

        /* Confirmamos que el cliente no exista */
        try {
            indPosCliente = sede.searchCliente(nif);
        } catch (IndexOutOfBoundsException e) {}
        if (indPosCliente > -1) {
            System.out.println("El NIF ya existe.");
            return sede.getClientes().get(indPosCliente);
        }

        /* Discriminamos el tipo de cliente */
        do {
            System.out.println("Quiere registrar el cliente como Profesional o como WoodFriend?");
            System.out.println("Por favor, introduzca [S] o [N].");
            try {
                opcionChar = demanarDades();
            } catch (Exception e) {
                System.out.println("El valor introducido no es valido.");
                continue;
            }
            /*opcionChar = demanarDades();*/
        } while (opcionChar == null || !Objects.requireNonNull(opcionChar).equals("S") &&
                !Objects.requireNonNull(opcionChar).equals("N"));

        if (opcionChar.equals("S")) {
            System.out.println("Escoja el tipo de cliente:");
            System.out.println("1. Profesional.");
            System.out.println("2. WoodFriend.");

            do {
                try {
                    opcion = demanarOpcioSencer();
                    if (opcion > 2 || opcion < 1) {
                        System.out.println("Por favor, escoja 1 o 2:");
                    }
                } catch (Exception e) {
                    System.out.println("El valor introducido no es valido, por favor, introduzca 1 o 2:");
                }
            } while (opcion > 2 || opcion < 1);
            /*opcion = demanarOpcioSencer();
            while (opcion > 2 || opcion < 1) {
                System.out.println("Por favor, escoja 1 o 2:");
                opcion = demanarOpcioSencer();
            }*/

            switch (opcion) {
                case 1 -> {
                    System.out.println("Indique el descuento a aplicar al cliente como un numero decimal." +
                            "Por ejemplo, 30.00:");
                    descuento = Double.parseDouble(Objects.requireNonNull(demanarDades()));
                    actualCliente = new Profesional(nif, nombre, descuento);
                    sede.addCliente(actualCliente);
                }
                case 2 -> {
                    actualCliente = new WoodFriend(nif, nombre);
                    sede.addCliente(actualCliente);
                    System.out.println("Nuevo codigo de cliente: ");
                }
            }
        } else {
            try {
                actualCliente = new NoRegistrado(nif, nombre);
            } catch (NullPointerException e) {
                System.out.println("Error: No se ha podido generar el cliente.");
                return null;
            }
        }

        if (actualCliente != null) {
            System.out.println("-------------------------------------------------");
            System.out.println("Se ha añadido un cliente nuevo.");
            System.out.println(actualCliente);
            System.out.println("-------------------------------------------------");
        }

        System.out.println();

        return actualCliente;
    }

    /**
     * El método escogerFechas() implementa la opción para que el usuario introduzca una fecha a través dle menú contextual.
     * Se encarga de crear un formato para la lectura de la fecha y convertirla en LocalDate a través del formato introducido.
     *
     * @return LocalDate Fecha introducida por el usuario.
     */
    private static LocalDate escogerFechas() {

        String datePattern = "dd-MM-yyyy";
        DateTimeFormatter format = DateTimeFormatter.ofPattern(datePattern);

        String auxFecha;
        LocalDate fecha;

        /* Obtenemos la fecha */
        auxFecha = demanarDades();

        /* Validamos a fecha */
        ValidadorFechas validador = new ValidadorFechas();
        while (!validador.isValid(auxFecha)) {
            System.out.println("La fecha introducida no es correta." +
                    " Por favor, introduzca una fecha valida:");
            auxFecha = demanarDades();
        }

        /* Formateamos la fecha */
        assert auxFecha != null;
        fecha = LocalDate.parse(auxFecha, format);
        return fecha;
    }

    /* AA5 */

    /**
     * La función menuResumenes() implementa el submenú para escoger el tipo de resumen de ventas que queremos obtener.
     * Delega en las funciones mostrarTodosLosTickets() para mostrar un resumen de los tickets de una Tienda en un periodo
     * de tiempo, o en mostrarTotalVentas() para mostrar un resumen de las ventas totales de una tienda en un periodo de tiempo.
     *
     * @param sede SedeCentral Instancia de la Clase SedeCentral que representa la empresa y centraliza la mayoría de
     *      funciones.
     */
    public static void menuResumenes(SedeCentral sede) {

        int opcion = -1;
        boolean isSalir = false;

        do {
            System.out.println("-------------------------------------------------");
            System.out.println("Por favor, escoja una opcion: ");
            System.out.println("1. Mostrar resumen de todos los tickets de venta de una tienda.");
            System.out.println("2. Mostrar resumen de ventas totales de una tienda.");
            System.out.println("0. Volver");
            System.out.println("Introduzca 1, 2 o 0:");

            do {
                try {
                    opcion = demanarOpcioSencer();

                    if (opcion > 2 || opcion < 0) {
                        System.out.println("El valor introducido no es correcto, por favor, introduzca una opcion " +
                                "entre 0 y 2:");
                    }
                } catch (Exception e) {
                    System.out.println("Error: El valor introducido no es un entero, por favor, introduzca una opcion " +
                            "entre 0 y 2:");
                    continue;
                }
            } while (opcion > 2 || opcion < 0);

            switch (opcion) {
                case 1 -> mostrarTodosLosTickets(sede);
                case 2 -> mostrarTotalVentas(sede);
                case 0 -> isSalir = true;
            }
        } while (!isSalir);
    }

    /**
     * La función mostrarTotalVentas() imprime por pantalla la suma total del valor de los tickets de venta de una instancia
     * de Tienda seleccionada por el usuario en un espacio de tiempo concreto también indicado por el usuario.
     * Delega en el módulo Tienda, en la función filterVentas() para obtener una lista filtrada por las fechas de venta con
     * todas las ventas y en la función resumentTotalVentas() del mismo módulo para obtener el número de ventas totales y
     * la suma de los valores totales vendidos.
     *
     * @param sede SedeCentral Instancia de la Clase SedeCentral que representa la empresa WoodShops.
     * @see Tienda
     * @see SedeCentral
     */
    public static void mostrarTotalVentas(SedeCentral sede) {
        String opcionStr = null;
        LocalDate dumbDate, fechaIn, fechaFin;
        Tienda actualTienda;
        Ticket ticket;
        ArrayList<Venta> ventasFiltradas = new ArrayList<>();

        dumbDate = LocalDate.parse("1900-01-01");
        fechaIn = null;
        fechaFin = null;

        System.out.println("====================================================");
        System.out.println("Resumen de Ventas Totales:");
        System.out.println("====================================================");

        System.out.println("====================================================");
        System.out.println();

        /* Preguntamos la tienda */
        try {
            actualTienda = chooseTienda(sede);
        } catch (NullPointerException e) {
            System.out.println("Error: No se ha podido seleccionar una tienda válida.");
            return;
        }

        /* Preguntamos las fechas de inicio y fin */
        /* Preguntamos la fecha de inicio */
        System.out.println("Por favor, introduzca la fecha de inicio con el siguiente formato dd-mm-aaaa:");
        fechaIn = escogerFechas();

        /* Preguntamos la fecha final */
        System.out.println("Por favor, introduzca la fecha final con el siguiente formato dd-mm-aaaa:");
        fechaFin = escogerFechas();

        System.out.println("-------------------------------------------------");
        System.out.println();

        /* Mostramos la información de la tienda */
        try {
            System.out.println(Objects.requireNonNull(actualTienda));
        } catch (NullPointerException e) {
            System.out.println("Error, no se ha podido seleccionar la informacion de ninguna tienda valida.");
            return;
        }

        ventasFiltradas = actualTienda.filterVentas(fechaIn, fechaFin);

        if (ventasFiltradas.size() > 0) {
            System.out.println("-------------------------------------------------");
            System.out.println("Resumen de ventas:");

            /* Iteramos por todos los elementos de la lista y mostramos la información */
            actualTienda.resumenTotalVentas(ventasFiltradas);
            System.out.println("-------------------------------------------------\n");
        } else {
            System.out.println("No hay ventas coincidentes con el filtro.");
            return;
        }
    }

    /**
     * El método createOferta() crea una nueva Oferta, la relaciona con la Clase Asociativa DetalleOferta y la añade a través de
     * esta a la lista de Ofertas de la instancia de la Clase SedeCentral que representa las Ofertas de una empresa.
     *
     * @param descripcion String Descripción de la oferta.
     * @param fechaInicio String Fecha de inicio de la oferta.
     * @param fechaFin String Fecha de finalización de la oferta.
     * @param sede SedeCentral Instancia de SedeCentral que representa la empresa.
     * @param clientes ArrayList Lista de instancias de la Clase Cliente que representa a los clientes a los que se les aplica
     *                 la oferta.
     * @see Oferta
     * @see DetalleOferta
     * @see SedeCentral
     */
    public static void createOferta(String descripcion, String fechaInicio, String fechaFin, SedeCentral sede, ArrayList<Cliente> clientes) {

        boolean isAdded = false;
        Oferta actualOferta = new Oferta(descripcion);

        /* Creamos el detalle de la oferta */
        DetalleOferta actualDetalle = new DetalleOferta(fechaInicio, fechaFin, sede, actualOferta);

        /* Añadimos el detalle a la oferta */
        actualOferta.setDetalleOferta(actualDetalle);

        /* Añadimos los clientes a los que se les aplica la oferta */
        actualOferta.setClientes(Objects.requireNonNull(clientes));

        /* Añadimos el detalle a la sede */
        isAdded = sede.addOferta(actualDetalle);

        /* Mostramos la oferta por pantalla */
        System.out.println((isAdded) ? actualOferta : "No se ha podido crear la nueva oferta.");
    }

    /**
     * El método mostrarOfertas() accede a la lista de Ofertas de la empresa y la muestra por pantall.
     *
     * @param sede SedeCentral Instancia de la Clase SedeCentral que representa a la empresa.
     * @see SedeCentral
     * @see Oferta
     */
    public static void mostrarOfertas(SedeCentral sede) {

        ArrayList<DetalleOferta> ofertas = sede.getDetalleOfertas();
        String opcionStr = null;

        if (!ofertas.isEmpty()) {
            sede.listOfertas();
        } else {
            System.out.println("No existen ofertas que mostrar.");
        }

        /* Espera de lectura de las ofertas */
        System.out.println("Pulse ENTER para continuar");
        try {
            opcionStr = demanarDades();
        } catch (Exception e) {
            return;
        }
    }
}