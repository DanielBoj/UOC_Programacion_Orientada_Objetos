package aa5_woodshops.centros;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * La clase CatálogoProveedores es una clase de apoyo para almacenar todos los proveedores que vayamos creando.
 * Para ellos usa un ArrayList para amacenar Objetos del tipo Proveedor. Le añadimos también un contador para tener
 * acceso rápido a la información.
 *
 * @see Proveedor
 */
public class CatalogoProveedores {

    private ArrayList<Proveedor> listaProveedores;
    private int numProveedores;

    /**
     * Constructor genérico para la clase.
     * Sin parámetros de entrada, inicializa el ArrayList de proveedores y el contador.
     *
     * @see Proveedor
     */
    public CatalogoProveedores() {
        listaProveedores = new ArrayList<>();
        numProveedores = 0;
    }

    /**
     * Sobrecarga del Constructor que permite añadir el primer Objeto de Tipo Proveedor a la lista.
     *
     * @param proveedor Proveeedor Objeto tipo Proveedor para añadiral al ArrayList
     * @see Proveedor
     */
    public CatalogoProveedores(Proveedor proveedor) {
        listaProveedores = new ArrayList<>();
        numProveedores = 1;
        listaProveedores.add(proveedor);
    }

    /* Getters & Setters */

    /**
     * Método getter que devuelve un ArrayList de tipo Proveedor que contiene una lista con todas
     * las instancias de Proveedor asociadas a una instancia de SedeCentral.
     *
     * @return ArrayList Lista de elementos de tipo Proveedor.
     * @see Proveedor
     * @see SedeCentral
     */
    public ArrayList<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

    /**
     * Método getter que devuelve la cantidad de proveedores creados.
     *
     * @return int Cantidad de instancias de tipo Proveedor en la lista de proveedores.
     */
    public int getNumProveedores() {
        return numProveedores;
    }

    /**
     * Método setter para cargar y asignar una ArrayList de tipo Proveedor con una lista de todos
     * los proveedores que vamos a asignar a una instancia de SedeCentral.
     * El valor de numProveedores se asigna de forma automática obteniendo el tamaño de la lista.
     *
     * @param listaProveedores ArrayList Lista de instancias de tipo Proveedor.
     * @see Proveedor
     */
    public void setListaProveedores(ArrayList<Proveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;
        numProveedores = listaProveedores.size();
    }

    /**
     * Override del método toString() que muestra toda la información de una instancia de CatalogoProveedores.
     * Usará el método toString() de la Clase Proveedor para mostrar la información de cada elemento
     * de la lista.
     *
     * @return String Información de la instancia de CatalogoProveedores
     */
    @Override
    public String toString() {
        return "CatalogoProveedores{" +
                "listaProveedores=" + listaProveedores +
                ", numProveedores=" + numProveedores +
                '}';
    }

    /* Métodos de Clase */

    /**
     * EL método addProveedor() permite añadir un Objeto de tipo Proveedor a la siguiente posición del ArrayList.
     *
     * @param proveedor Proveedor Objeto tipo Proveedor para añadir al ArrayList, representa a un proveedor de la empresa.
     */
    public void addProveedor(Proveedor proveedor) {
        listaProveedores.add(proveedor);
        numProveedores++;
    }

    /**
     * El método listarProveedores() permite obtener una lista por pantalla de todos elementos de tipo Proveedor que se
     * almacenan en el ArrayList.
     *
     * @see Proveedor
     */
    public void listProveedores() {
        if (listaProveedores.isEmpty()) {
            System.out.println("Error: Lista vacía!");
            return;
        }

        for (Proveedor p : listaProveedores) {
            System.out.println(p);
        }
    }

    /**
     * El método listarProveedoresName() permite obtener una lista por pantalla de todos elementos de tipo Proveedor que se
     * almacenan en el ArrayList e imprime su nombre.
     *
     * @see Proveedor
     */
    public void listProveedoresName() {
        int ind = 0;

        if (listaProveedores.isEmpty()) {
            System.out.println("Error: Lista vacía!");
            return;
        }

        for (Proveedor p : listaProveedores) {
            System.out.println(++ind + ". " +
                    p.getNombre());
        }
    }

    /**
     * El método isEmpty() devuelve true si el ArrayList de Proveedor se encuentra vacío y false si hay >=1 elmento.
     *
     * @return boolean True si la lista está vacía o false si hay => 1 elemento.
     */
    public boolean isEmpty() {
        return listaProveedores.size() == 0;
    }

    /**
     * EL método buscarProveedorPorNombre() devuelve el índice de posición de un Proveedor que
     * busca a través del nombre que recibe por parámetro. Si la el proveedor no existe, devuelve
     * -1. Para la búsqueda usa un iterador para recorrer el ArrayList listaProveedores.
     *
     * @param nombre String Nombre del proveedor a buscar.
     * @return int Índice de posición de la instacia de Proveedor en la lista de proveedores.
     * @see Proveedor
     */
    public int buscarProveedorPorNombre(String nombre) {

        int position = -1;
        boolean isFound = false;

        ListIterator<Proveedor> iteradorProveedores = listaProveedores.listIterator();

        try {
            while (iteradorProveedores.hasNext() && !isFound) {
                if (iteradorProveedores.next().getNombre().equals(nombre)) {
                    position = iteradorProveedores.previousIndex();
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
     * EL método buscarProveedorPorNif() devuelve el índice de posición de un Proveedor que
     * busca a través del nif que recibe por parámetro. Si la el proveedor no existe, devuelve
     * -1. Para la búsqueda usa un iterador para recorrer el ArrayList listaProveedores.
     *
     * @param nombre String Nombre del Proveedor.
     * @return int Índice de posición en el ArrayList listaProveedores.
     * @see Proveedor
     */
    public int buscarProveedorPorNif(String nombre) {

        int position = -1;
        boolean isFound = false;

        ListIterator<Proveedor> iteradorProveedores = listaProveedores.listIterator();

        try {
            while (iteradorProveedores.hasNext() && !isFound) {
                if (iteradorProveedores.next().getNif().equals(nombre)) {
                    position = iteradorProveedores.previousIndex();
                    isFound = true;
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println(e + "El proveedor no existe!");
            return -1;
        }


        return position;
    }

    /**
     * El método listAllProducts() muestra una lista con todos los productos de cada proveedor.
     * Imprime por pantalla el tipo, nombre y código del producto.
     * Delega en Proveedor.
     *
     * @see Proveedor
     */
    public void listAllProductos() {

        for (Proveedor proveedor : listaProveedores) {
            proveedor.listProductos();
        }
    }
}
