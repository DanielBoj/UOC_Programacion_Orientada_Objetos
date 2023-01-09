package aa5_woodshops.generadores_codigos_unicos;

import java.util.Arrays;

/**
 * La clase CodeList permite generar códigos únicos para los Objetos de tipo Almacén y del tipo Producto.
 * El código se genera mediante un algoritmo de tipo Hash que recibe un key única basada en los campos
 * identificativos de los objetos originales. Esta Clase no tiene Setters porque la idea es que todos
 * los códigos sean únicos y generados de forma automática, así que no se pueden modificar los códigos
 * asignados al Array.
 *
 * @see aa5_woodshops.centros.Almacen
 * @see aa5_woodshops.items.Producto
 */
public class CodeList {

    /* Máximo del rango de códigos que podemos adjudicar */
    final int CODE_SIZE = 10000;
    private int[] listaCodigos;
    private int numElem;

    /**
     * Constructo genérico para la Clase CodeList.
     * Inicializa un Array que contiene los códigos que se irán generando con un tope determinado
     * por la constante CODE_SIZE y asigna todos sus elementos avalor -1. También inicializa el
     * contador de códigos a 0.
     * La asignación a -1 es para poder manejar las colisiones en el Array.
     */
    public CodeList() {
        listaCodigos = new int[CODE_SIZE];
        Arrays.fill(listaCodigos, -1);
        numElem = 0;
    }

    /* GETTER */

    /**
     * Método getter que devuelve un Array que contiene una lista de códigos.
     *
     * @return Array String Lista de códigos.
     */
    public int[] getListaCodigos() {
        return listaCodigos;
    }

    /**
     * Método getter que devuelve el número de cñodigos generados.
     *
     * @return int Número de elementos en el Array.
     */
    public int getNumElem() {
        return numElem;
    }

    /**
     * Override del mñetodo toString() que devuelve toda la lista de códigos del Array.
     *
     * @return String Códigos dentro del Array de códigos.
     */
    @Override
    public String toString() {
        return "CodeList{" +
                "CODE_SIZE=" + CODE_SIZE +
                ", listaCodigos=" + Arrays.toString(listaCodigos) +
                ", numElem=" + numElem +
                '}';
    }

    /* Métodos de Clase */

    /**
     * El método hashCode() devuelve la parte numérica que se usará par asignar un código de
     * Almacen o de Producto.
     * Método privado: Solo se usa dentro de la Clase.
     *
     * @param key String Llave para generar el código único.
     * @return int Código único numérico.
     * @see aa5_woodshops.centros.Almacen
     * @see aa5_woodshops.items.Producto
     */
    private int hashCode(String key) {
        if (isFull()) {
            System.out.println("Error: No se admiten mas codigos!");
        }
        int primeConstant = 31;
        int hashValue = 0;

        for (int i = 0; i < key.length(); i++) {
            hashValue = hashValue * primeConstant + key.charAt(i) + i;
        }

        hashValue = compressor(hashValue);

        if (listaCodigos[hashValue] == -1) {
            listaCodigos[hashValue] = hashValue;
            numElem++;
        }

        hashValue = checkCode(hashValue + 1, hashValue);

        listaCodigos[hashValue] = hashValue;
        numElem++;

        return hashValue;
    }

    /**
     * El método compressor() recibe el primer valor de Hash generado, lo pasa a positivo
     * y se aseguro de que esté dentro del rango de elementos del Array.
     * Método privado: Solo se usa dentro de la Clase.
     *
     * @param value int Primer valor de Hash.
     * @return int Valor de Hash comprimido.
     * @see java.util.AbstractList
     * @see aa5_woodshops.items.Producto
     */
    private int compressor(int value) {
        value = value & 0x70000000;

        return value % CODE_SIZE;
    }

    /**
     * EL método checkCode() maneja la colisión en la generación de códigos. Si el código ya existiera,
     * realiza una gestión por búsqueda lineal, asignará el siguiente valor libre.
     * Método privado: Solo se usa dentro de la Clase.
     * Es un tipo de función recursiva: Se generan las condiciones bases y el retorno para está y, si no
     * se cumplen, se vuelve a llamar a la función pasándole por parámetro la nueva condición a checkear.
     *
     * @param insertPosition int Recibe la nueva posición de inserción a probar cuando se genera una
     *                       colisión.
     * @param start          int Recibe la posición de inserción donde se ha generado la colisión.
     * @return int Posición de inserción libre de colisión, se usara como código único numérico.
     * @see aa5_woodshops.centros.Almacen
     * @see aa5_woodshops.items.Producto
     */
    private int checkCode(int insertPosition, int start) {

        if (listaCodigos[insertPosition] == -1) {
            return insertPosition;
        }

        if (insertPosition == CODE_SIZE - 1) {
            return checkCode(0, start);
        }

        if (insertPosition == start) {
            throw new RuntimeException("Lista de códigos llena!");
        }

        return checkCode(insertPosition + 1, start);
    }

    /**
     * El método addCodigoAlmacen() genera el código para una instancia de tipo Almacén.
     * Añade la cadena "AL" a un código numñerico generado de forma automática por Hash.
     *
     * @param key String Llave para generar el código único numérico.
     * @return String Código único de almacén.
     * @see aa5_woodshops.centros.Almacen
     */
    public String addCodigoAlmacen(String key) {
        numElem++;
        return "AL" + String.valueOf(hashCode(key));
    }

    /**
     * El método addCodigoProducto() genera el código para una instancia de tipo Producto.
     * Añade la cadena "SKU" a un código numérico generado de forma automática por Hash.
     *
     * @param key String Llave para generar el código único numérico.
     * @return String Código único de producto.
     * @see aa5_woodshops.items.Producto
     */
    public String addCodigoProducto(String key) {
        numElem++;
        return "SKU" + String.valueOf(hashCode(key));
    }

    /* AA4 */

    /**
     * El método addCodigoWoodFriend() genera ek código para una instancia de tipo WoodFriend, que ens una subclase de
     * la clase Registrado, a su vez, subclase de la clase CLiente.
     * Añade la cadena "CST" a un código númerico generado de forma automática por Hash.
     *
     * @param key String Clave para generar el código.
     * @return String Código único generado.
     */
    public String addCodigoWoodFriend(String key) {
        numElem++;
        return "CST" + String.valueOf(hashCode(key));
    }

    /**
     * El método isFull() es un método interno que comprueba si el Array de códigos ya está lleno.
     * Si esta lleno devuelve true, si no, false.
     *
     * @return boolean Si esta lleno devuelve true, si no, false.
     */
    private boolean isFull() {
        return numElem == CODE_SIZE;
    }

    public void printLista() {
        for (int code : listaCodigos) {
            if (code > -1) {
                System.out.println(code);
            }

        }
    }
}
