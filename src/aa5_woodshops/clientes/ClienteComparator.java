package aa5_woodshops.clientes;

import java.util.Comparator;

/**
 * Clase que implementa el interface Comparator para comparar dos instancias de la Clase Cliente.
 *
 * @see Cliente
 */
public class ClienteComparator implements Comparator<Cliente> {

    /**
     * Override del método compare() del interfaz de comparación Comparator que compara dos instancias de la Clase CLiente
     * entre ellas. Devuelve 0 si los elementos son iguales, mayor a 0 si el primer elemento es superior o menor a 0 si el segundo
     * elemento es superior.
     *
     * @param src1 Cliente Primera instancia de la Clase Cliente a comparar.
     * @param src2 Cliente Segunda instancia de la Clase Cliente a comparar.
     * @return int Devuelve 0 si los elementos son iguales o un entero diferente a 0 si no es así.
     * @see Cliente
     */
    public int compare(Cliente src1, Cliente src2) {

        int nifCompare = src1.getNif().compareTo(src2.getNif());

        int nameCompare = src1.getNombre().compareTo(src2.getNombre());

        return (nifCompare == 0) ? nameCompare : nifCompare;
    }
}
