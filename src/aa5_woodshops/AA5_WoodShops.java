/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa5_woodshops;

import aa5_woodshops.centros.CatalogoProveedores;
import aa5_woodshops.centros.SedeCentral;
import aa5_woodshops.centros.Tienda;
import aa5_woodshops.clientes.Cliente;
import aa5_woodshops.clientes.NoRegistrado;
import aa5_woodshops.clientes.Profesional;
import aa5_woodshops.clientes.WoodFriend;
import aa5_woodshops.drivers.Driver;
import aa5_woodshops.drivers.DriverMenu;
import aa5_woodshops.items.Articulo;
import aa5_woodshops.items.Barniz;
import aa5_woodshops.items.Tablero;
import aa5_woodshops.ventas.DetalleVenta;
import aa5_woodshops.ventas.Ticket;
import aa5_woodshops.ventas.Venta;

import java.util.ArrayList;

/**
 * AA5_WoodShops es la clase MAIN para ejecutar el programa de gestión de tiendas que hemos creado.
 * WoodShops es un programa de gestión para una empresa de venta de productos de madera compuesta por varias tiendas
 * que funcionan como delegaciones. Tras generar la Sede Central para la empresa, el programa permite gestionar las
 * diversas delegaciones que lo compones: Podemos generar las Tiendas, cada tienda tiene un único almacén relacionado, cada
 * almacén dispone de un inventario de productos disponibles que se gestionan mediante el uso de un stock de producto. Los
 * almacenes no comparten productos entre ellos, el almacén de cada tienda es único.
 * Podemos crear los diferentes productos, superclase, de los que dispondrá cada tienda, hay 3 tipos de producto, generados como
 * subclases: Tableros, barnices y artículos manufacturados de madera.
 * Podemos asignar los distintos productos al almacén de la tienda que queramos, lo gestionamos todo desde la clase SedeCentral
 * usando de
 * Los productos tendrán un Proveedor asociado, como no usamos base de datos, se ha añadido por comodidad, una clase para
 * almacenar todos los proveedores y poder consultarlos o asignarlos a un producto de forma más ágil.
 * Se usa la clase CodeList como dependencia para generar los distintos códigos únicos de productos y almacenes.
 *
 * @author Cobos Boj, Daniel
 * @version 1.2
 * @see SedeCentral
 * @since 01-2023
 */
public class AA5_WoodShops {

    /**
     * El método MAIN contiene el o los drivers principales para iniciar el programa.
     *
     * @param args Permite pasar una serie de argumentos a través de CMD que se entregan como un String.
     */
    public static void main(String[] args) {
        AA5_WoodShops prg = new AA5_WoodShops();
        prg.inicio();

    }

    /**
     * Driver para iniciar el flujo del programa.
     */
    void inicio() {
        String[] tiposProducto = {"Tablero", "Barniz", "Articulo"};

        /* Cargamos los datos iniciales para las pruebas */
        SedeCentral sede = cargaDatosIncial();

        /* Llamamos al menu principal */
        DriverMenu.iniciarMenu(sede, tiposProducto, sede.getProveedores());
    }

    /**
     * El método cargaDatosInicial() inicializa todos los datos del programa necesarios para realizar las pruebas. En un
     * entorno real deberíamos guardar los datos en una BD externa y cargarlos desde ahí, o en un archivo externo.
     *
     * @return SedeCentral Representa la empresa WoodShops, centraliza el manejo del programa.
     * @see SedeCentral
     */
    public SedeCentral cargaDatosIncial() {

        SedeCentral woodShops = Driver.crearSedeCentral("WoodShops", "93775426X");

        int tienda1 = Driver.crearTienda(woodShops, "Carpintería Lozano", "Zaragoza");
        int tienda2 = Driver.crearTienda(woodShops, "Maderas Rodrigo", "Huesca");
        int tienda3 = Driver.crearTienda(woodShops, "WoodShops Jaca", "Jaca");

        CatalogoProveedores proveedoresWoodShops = new CatalogoProveedores();
        woodShops.setProveedores(proveedoresWoodShops);
        int proveedor1 = Driver.crearProveedor(proveedoresWoodShops, "56307227F", "Coisa");
        int proveedor2 = Driver.crearProveedor(proveedoresWoodShops, "20078555S", "Lepanto");
        int proveedor3 = Driver.crearProveedor(proveedoresWoodShops, "40886156E", "Pino del Norte");

        Tablero tablero1 = new Tablero("tablero grande cuadraro aglomerado",
                proveedoresWoodShops.getListaProveedores().get(proveedor1), 100, 100, "AGLOMERADO");
        Tablero tablero2 = new Tablero("tablero grande rectangular MDF sin tratar",
                proveedoresWoodShops.getListaProveedores().get(proveedor1), 60, 160, "MDF");
        Tablero tablero3 = new Tablero("tablero encimera rectangular roble cepillado",
                proveedoresWoodShops.getListaProveedores().get(proveedor1), 90, 200, "ROBLE");

        Barniz barniz1 = new Barniz("Barniz exteriores brillante",
                proveedoresWoodShops.getListaProveedores().get(proveedor2), 1000, "CAOBA");
        Barniz barniz2 = new Barniz("Barniz exteriores mate",
                proveedoresWoodShops.getListaProveedores().get(proveedor2), 5000, "MATE");
        Barniz barniz3 = new Barniz("Barniz interiores oscuro",
                proveedoresWoodShops.getListaProveedores().get(proveedor2), 500, "EBANO");

        Articulo articulo1 = new Articulo("Estantería doble puerta y 5 estantes acristalada",
                proveedoresWoodShops.getListaProveedores().get(proveedor3), "ESTANTERIA");
        Articulo articulo2 = new Articulo("Armario ropero 150a x 200h x 60p",
                proveedoresWoodShops.getListaProveedores().get(proveedor3), "ARMARIO");
        Articulo articulo3 = new Articulo("Silla beige madera",
                proveedoresWoodShops.getListaProveedores().get(proveedor3), "SILLA");

        Driver.addProductoATienda(woodShops, "WoodShops Jaca", tablero1, 20.35, 50);
        Driver.addProductoATienda(woodShops, "WoodShops Jaca", barniz1, 16.50, 30);
        Driver.addProductoATienda(woodShops, "WoodShops Jaca", articulo1, 565.90, 2);
        Driver.addProductoATienda(woodShops, "WoodShops Jaca", tablero2, 18.99, 50);
        Driver.addProductoATienda(woodShops, "WoodShops Jaca", barniz2, 30.50, 30);
        Driver.addProductoATienda(woodShops, "WoodShops Jaca", articulo2, 800.00, 2);

        Driver.addProductoATienda(woodShops, "Maderas Rodrigo", tablero2, 21.00, 25);
        Driver.addProductoATienda(woodShops, "Maderas Rodrigo", barniz2, 28.99, 100);
        Driver.addProductoATienda(woodShops, "Maderas Rodrigo", articulo2, 750, 1);

        Driver.addProductoATienda(woodShops, "Carpintería Lozano", tablero3, 300.00, 25);
        Driver.addProductoATienda(woodShops, "Carpintería Lozano", barniz3, 20.00, 100);
        Driver.addProductoATienda(woodShops, "Carpintería Lozano", articulo3, 40.50, 1);

        /* AA4 */
        Cliente cliente1 = new WoodFriend("26209123W", "Miguel Sánchez");
        Cliente cliente2 = new WoodFriend("42727864M", "Pedro Manrique");
        Cliente cliente3 = new Profesional("63553015J", "Luisa DelRio", 10.00);
        Cliente cliente4 = new Profesional("70995895R", "Alonso Ramirez", 25.00);
        Cliente cliente5 = new NoRegistrado("58582583L", "Paz Alma");

        woodShops.addCliente(cliente1);
        woodShops.addCliente(cliente2);
        woodShops.addCliente(cliente3);
        woodShops.addCliente(cliente4);
        woodShops.addCliente(cliente5);

        /* AA5 */
        /* Cargamos algunas ventas */
        Venta auxVenta;
        Ticket auxTicket;
        Tienda auxTienda = woodShops.getTiendas().get(0);
        DetalleVenta auxDetalle;

        //Venta 1
        auxVenta = new Venta(auxTienda, cliente3);
        auxTicket = new Ticket("20-12-2022");
        //Línea 1
        auxDetalle = new DetalleVenta(tablero3, 2, auxVenta, auxTicket);
        auxVenta.addDetalleVenta(auxDetalle);
        auxTicket.addDetalleVenta(auxDetalle);
        //Línea 2
        auxDetalle = new DetalleVenta(barniz3, 3, auxVenta, auxTicket);
        auxVenta.addDetalleVenta(auxDetalle);
        auxTicket.addDetalleVenta(auxDetalle);
        auxTienda.addVenta(auxVenta);

        //Venta 2
        auxVenta = new Venta(auxTienda, cliente4);
        auxTicket = new Ticket("21-12-2022");
        //Línea 1
        auxDetalle = new DetalleVenta(tablero3, 1, auxVenta, auxTicket);
        auxVenta.addDetalleVenta(auxDetalle);
        auxTicket.addDetalleVenta(auxDetalle);
        //Línea 2
        auxDetalle = new DetalleVenta(barniz3, 5, auxVenta, auxTicket);
        auxVenta.addDetalleVenta(auxDetalle);
        auxTicket.addDetalleVenta(auxDetalle);
        auxTienda.addVenta(auxVenta);

        //Venta 3
        auxVenta = new Venta(auxTienda, cliente2);
        auxTicket = new Ticket("21-12-2022");
        //Línea 1
        auxDetalle = new DetalleVenta(barniz3, 10, auxVenta, auxTicket);
        auxVenta.addDetalleVenta(auxDetalle);
        auxTicket.addDetalleVenta(auxDetalle);
        auxTienda.addVenta(auxVenta);

        /* Extra: Creamos una oferta */
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);

        System.out.println("Extra: Generamos una oferta nueva para la demostración:");
        Driver.createOferta("Regalo fidelización", "01-12-2022", "31-01-2023", woodShops,
                clientes);

        return woodShops;
    }
}
