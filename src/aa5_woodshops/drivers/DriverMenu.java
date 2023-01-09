package aa5_woodshops.drivers;

import aa5_woodshops.centros.CatalogoProveedores;
import aa5_woodshops.centros.SedeCentral;

import java.util.Scanner;

public class DriverMenu {

    static Scanner teclado = new Scanner(System.in);
    private static final int OPCIONES = 8;

    /**
     * Método para iniciar el menú interactivo.
     *
     * @param sede          SedeCentral Empresa.
     * @param tiposProducto Array Contiene los nombres de los tipos de producto que trabaja la empresa.
     * @param proveedores   CatalogoProveedores proveedores de la empresa.
     */
    public static void iniciarMenu(SedeCentral sede, String[] tiposProducto, CatalogoProveedores proveedores) {

        boolean salir = false;
        char opcion = 'x';

        System.out.println("====================================================");
        System.out.println("Bienvenido a WoodShops!");
        System.out.println("====================================================");

        do {
            System.out.println("\nPrograma de Gestion de Tiendas:");
            System.out.println("\n1. Añadir producto a una tienda");
            System.out.println("2. Listar los productos de una tienda por tipo");
            System.out.println("3. Mostrar stocks por código de producto");
            System.out.println("4. Mostrar una lista de los proveedores de la empresa");
            /* AA4 */
            System.out.println("5. Administrar clientes de la empresa.");
            System.out.println("6. Nueva venta.");
            /* AA5 */
            System.out.println("7. Obtener resumen ventas.");
            System.out.println("8. Mostrar ofertas.");
            System.out.println("0. Salir");
            System.out.println("Introduzca 1, 2, 3, 4 , 5 ,6, 7, 8 o 0:");

            do {
                try {
                    opcion = demanarOpcioMenu();
                } catch (Exception e) {
                    System.out.println("El valor introducido no es válido. Por favor, introduzca un entero " +
                            "entre 0 y 8:");
                    continue;
                }
            } while(opcion == 'x');


            switch (opcion) {
                case '1' -> Driver.addProductosATienda(sede, tiposProducto, proveedores);
                case '2' -> Driver.listarProductosTiendas(sede, tiposProducto);
                case '3' -> Driver.listarStocksProductosEnTiendasPorCodigo(sede);
                case '4' -> Driver.listarProveedores(sede);
                case '5' -> Driver.gestionarClientes(sede);
                case '6' -> Driver.makeVenta(sede);
                case '7' -> Driver.menuResumenes(sede);
                case '8' -> Driver.mostrarOfertas(sede);
                case '0' -> salir = true;
            }
        }
        while (!salir);

    }

    /**
     * El método demanarOpcioMenu() lee una entrada por teclado y arroja el carácter obtenido.
     *
     * @return char Caracter seleccionado por el usuario.
     */
    public static char demanarOpcioMenu() {
        String resp = null;

        resp = teclado.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }

        while (Integer.parseInt(resp) > OPCIONES || Integer.parseInt(resp) < 0) {
            System.out.println("La opción escogida no existe.");
            System.out.println("Por favor, escoja una opción ente 0 y 7: ");
            resp = teclado.nextLine();
            if (resp.isEmpty()) {
                resp = " ";
            }
        }

        return resp.charAt(0);
    }
}
