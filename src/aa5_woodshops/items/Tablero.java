package aa5_woodshops.items;

import aa5_woodshops.centros.Almacen;
import aa5_woodshops.centros.Proveedor;

/**
 * La clase Tablero permite instanciar objteos que representan un elemento del tipo tablero en el almacén real de la tienda.
 * Es una subclase de Producto y está representado por su altura y anchura en cm, como pueden haber fracciones en el corte,
 * se representa con el tipo double, y por su tipo que obtenemos de un enumerador.
 *
 * @see Producto
 * @see Almacen
 * @see TipoTablero
 */
public class Tablero extends Producto {

    private double altura;
    private double anchura;
    private TipoTablero tipo;

    /**
     * El constructor genérico para la clase, hereda los elementos de la superclase Producto y recibe por parámetro la
     * anchura, la altura y el tipo de tablero en formato String. Dentro del constructor asigna el tipo mediante el
     * método de la clase ENUM .valueOf(String).
     *
     * @param proveedor Proveedor Instancia de la Clase Proveedor.
     * @param descripcion String Descripción del producto.
     * @param altura  double Indica la altura del tablero
     * @param anchura double Indica la anchura del tablero
     * @param tipo    TipoTablero Indica el material de construcción del tablero
     * @see Producto
     * @see TipoTablero
     */
    public Tablero(String descripcion, Proveedor proveedor, double altura,
                   double anchura, String tipo) {
        super(descripcion, proveedor, tipo);
        this.altura = altura;
        this.anchura = anchura;
        this.tipo = TipoTablero.valueOf(tipo);
    }

    /* Getters & Setters */

    /**
     * Getter que devuelve la altura del tablero.
     *
     * @return double Altura del tablero en cm.
     * @see Producto
     */
    public double getAltura() {
        return altura;
    }

    /**
     * Getter que devuelve la anchura del tablero.
     *
     * @return double Anchuira del tablero en cm.
     * @see Producto
     */
    public double getAnchura() {
        return anchura;
    }

    /**
     * Getter que devuele el tipo de tablero.
     *
     * @return TipoTablero Valor Enum que representa el tipo de tablero.
     */
    public TipoTablero getTipo() {
        return tipo;
    }

    /**
     * Setter para asignar la altura de un tablero.
     *
     * @param altura double Altura del tablero en cm.
     * @see Producto
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * Setter para asignar la anchura de un tablero.
     *
     * @param anchura double Anchura del tablero en cm.
     * @see Producto
     */
    public void setAnchura(double anchura) {
        this.anchura = anchura;
    }

    /**
     * Seeter para asignar el tipo de un tablero.
     *
     * @param tipo TipoTablero Tipo enumerador.
     */
    public void setTipo(TipoTablero tipo) {
        this.tipo = tipo;
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
                "Tablero" +
                "\tAltura:" + altura + "cm" +
                "\tAnchura:" + anchura + "cm";
    }

    /* Métodos de Subclase */

    /**
     * Añade las comparaciones entre los atributos particulares de Tablero al supermétodo equals()
     * de la superclase Producto.
     *
     * @param tablero Tablero Instancia de Producto de la subclase Tablero para la comparación.
     * @return boolean True si los Objetos coinciden y false si son diferentes.
     * @see Producto
     */
    public boolean equals(Tablero tablero) {
        return super.equals(tablero)
                && this.anchura == tablero.getAnchura()
                && this.altura == tablero.getAltura()
                && this.tipo.equals(tablero.getTipo());
    }
}
