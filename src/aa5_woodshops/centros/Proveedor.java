package aa5_woodshops.centros;

import aa5_woodshops.items.Producto;

import java.util.ArrayList;

/**
 * La clase Proveedor instancia un Objeto que representa a un proveedor de uno o varios de los productos de los que
 * dispone un almacén.
 * Cada instancia contiene los atributos del tipo String nif y nombre y se relaciona con los productos que puede contener
 * una instancia del tipo Almacen.
 *
 * @see Producto
 * @see Almacen
 * @see CatalogoProveedores
 */
public class Proveedor {

    private String nif;
    private String nombre;
    private ArrayList<Producto> catalogo;

    /**
     * Constructor genérico que recibe por parámetros tipo String el nif y el nombre del proveedor.
     * El constructor inicializa un ArrayList que contendrá los Objteos del tipo Producto que representan
     * todos los productos que puede tener asociados un Proveedor en un Almacén.
     *
     * @param nif    String NIF de empresa proveedor
     * @param nombre String nombre dle proveedor
     */
    public Proveedor(String nif, String nombre) {
        this.nif = nif;
        this.nombre = nombre;
        catalogo = new ArrayList<>();
    }

    /**
     * Sobrecarga del constructor que permite instanciar un Objeto del tipo proveedor añadiendo ya un producto.
     *
     * @param nif      String NIF de la empresa proveedora
     * @param nombre   String nombre del proveedor
     * @param catalogo ArrayList permite a
     */
    public Proveedor(String nif, String nombre, ArrayList<Producto> catalogo) {
        this.nif = nif;
        this.nombre = nombre;
        catalogo = new ArrayList<>();
        this.catalogo = catalogo;
    }

    /* Getters & Setters */

    /**
     * Getter que devuelve el NIF del proveedor.
     *
     * @return String NIF del proveedor.
     */
    public String getNif() {
        return nif;
    }

    /**
     * Getter que devuelve el nombre del proveedor.
     *
     * @return String Nombre del proveedor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter que devuelve un ArrayList de tipo Producto con todos los productos asociados al proveedor.
     *
     * @return ArrayList Lista de instancias de tipo Producto.
     * @see Producto
     */
    public ArrayList<Producto> getCatalogo() {
        return catalogo;
    }

    /**
     * Setter que permite asignar un NIF al proveedor.
     *
     * @param nif String NIF del proveedor.
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * Setter que permite asignar un nombre al proveedor.
     *
     * @param nombre String Nombre dle proveedor.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Override del método toString() para mostrar toda la información de un proveedor.
     *
     * @return String Información de una instancia de tipo Proveedor.
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\tNif: " + nif +
                "\n" + catalogo;
    }

    /* Métodos de Clase */

    /**
     * EL método addProducto() añade al ArrayList de tipo Producto catalogo una instancia de tipo
     * Producto que recibe por parámetro. Así, mantenemos un catálogo con todos los productos que
     * trabaja un Proveedor.
     *
     * @param producto Producto Instancia de Producto que representa un producto que vende el
     *                 proveedor.
     * @see Producto
     */
    public void addProducto(Producto producto) {
        catalogo.add(producto);
    }

    /**
     * El método listarProductos imprime por pantalla todos los productos del ArrayList catalogo.
     * Muestra por pantalla todos los Productos asociados a una instancia de Proveedor.
     *
     * @see Producto
     */
    public void listProductos() {
        int ind = 0;

        for (Producto producto : catalogo) {
            System.out.println(++ind + ". " +
                    producto.getClass().getSimpleName());
            System.out.println(producto.getCodigoProducto());
            System.out.println(producto.getDescripcion());
        }
    }

}
