package aa5_woodshops.items;

import aa5_woodshops.centros.Almacen;
import aa5_woodshops.centros.Proveedor;

/**
 * La clase Barniz permite instanciar objteos que representan un elemento del tipo barniz en el almacén real de la tienda.
 * Es una subclase de Producto y está representado por su cantidad en mililitros representada por un entero, y por su color
 * que obtenemos de un enumerador.
 *
 * @see Producto
 * @see Almacen
 * @see TipoColor
 */
public class Barniz extends Producto {

    private int mililitros;
    private TipoColor color;

    /**
     * El constructor genérico para la clase, hereda los elementos de la superclase Producto y recibe por parámetro la
     * cantidad de producto en mililitros y el color en formato String. Dentro del constructor asigna el color mediante
     * el método de la clase ENUM .valueOf(String).
     *
     * @param descripcion String Descripción del producto
     * @param proveedor Proveedor Proveedor del producto.
     * @param mililitros int Indica la cantidad de producto en mililitros
     * @param color      TipoColor Indica el color del barniz
     */
    public Barniz(String descripcion, Proveedor proveedor, int mililitros, String color) {
        super(descripcion, proveedor, color);
        this.mililitros = mililitros;
        this.color = TipoColor.valueOf(color);
    }

    /* Getters & Setters */

    /**
     * Método getter que devuelve la cantida del producto en mililitros.
     *
     * @return int Cantidad de producto en mililitros.
     * @see Producto
     */
    public int getMililitros() {
        return mililitros;
    }

    /**
     * Método getter que devuelve el color del barniz.
     *
     * @return TipoColor Valor Enum que representa el color del barniz.
     * @see Producto
     * @see TipoColor
     */
    public TipoColor getColor() {
        return color;
    }

    /**
     * Método setter que permite asignar la cantidad de producto en mililitros.
     *
     * @param mililitros int Cantidad de barniz en mililitros.
     */
    public void setMililitros(int mililitros) {
        this.mililitros = mililitros;
    }

    /**
     * Método setter que permite asignar un valor Enum para identificar el color del barniz.
     *
     * @param color TipoColor Valor tipo Enum.
     * @see TipoColor
     * @see Producto
     */
    public void setColor(TipoColor color) {
        this.color = color;
    }

    /**
     * Override del método toString() d ela superclase que muestra la información general de la superclase y añade
     * la información particular de la subclase.
     *
     * @return String Información del producto.
     * @see Producto
     */
    @Override
    public String toString() {
        return super.toString() +
                "Barniz" +
                "\tMililitros: " + mililitros +
                "\tColor:" + color;
    }

    /* Métodos de Subclase */

    /**
     * Añade las comparaciones entre los atributos particulares de Barniz al supermétodo equals()
     * de la superclase Producto.
     *
     * @param barniz Barniz Instancia de Producto de subclase Barniz para comparar.
     * @return boolean True si los Objetos coinciden y false si son diferentes.
     * @see Producto
     */
    public boolean equals(Barniz barniz) {
        return super.equals(barniz)
                && this.mililitros == barniz.getMililitros()
                && this.color.equals(barniz.getColor());
    }
}
