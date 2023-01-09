package aa5_woodshops.items;

import aa5_woodshops.centros.Almacen;
import aa5_woodshops.centros.Proveedor;

/**
 * La clase Articulo permite instanciar objteos que representan artículos variados en el almacén real de la tienda.
 * Es una subclase de Producto y está representado por su tipo que obtenemos de un enumerador.
 *
 * @see Producto
 * @see Almacen
 * @see TipoArticulo
 */
public class Articulo extends Producto {

    private TipoArticulo tipo;

    /**
     * El constructor genérico para la clase, hereda los elementos de la superclase Producto y recibe por parámetro la
     * el tipo de artículo en formato String. Dentro del constructor asigna el tipo mediante el método de la clase
     * ENUM .valueOf(String).
     *
     * @param descripcion String Descripción del producto.
     * @param proveedor   Proveedor instancia de Proveedor, proveedor asociado al producto.
     * @param tipo        TipoArticulo Indica el tipo de artículo
     * @see Producto
     * @see TipoArticulo
     */
    public Articulo(String descripcion, Proveedor proveedor, String tipo) {
        super(descripcion, proveedor, tipo);
        this.tipo = TipoArticulo.valueOf(tipo);
    }

    /* Getters & Setters */

    /**
     * Getter que devuelve el tipo de artículo.
     *
     * @return TipoArticulo Devuelve un elemento de tipo enumerador.
     */
    public TipoArticulo getTipo() {
        return tipo;
    }

    /**
     * Setter para asignar un tipo enumerador que identifica el tipo de un articulo.
     *
     * @param tipo TipoArticolo Tipo enumerador.
     */
    public void setTipo(TipoArticulo tipo) {
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
                "Tipo: Articulo Variado" +
                "\nDescripcion: " + super.getDescripcion();
    }

    /* Métodos de Subclase */

    /**
     * Añade las comparaciones entre los atributos particulares de Artículo al supermétodo equals()
     * de la superclase Producto.
     *
     * @param articulo Articulo Producto del tipo Artículo que vamos a comparar.
     * @return boolean True si los Objetos coinciden y false si son diferentes.
     * @see Producto
     */
    public boolean equals(Articulo articulo) {
        return super.equals(articulo)
                && (this.tipo.equals(articulo.getTipo()));
    }
}
