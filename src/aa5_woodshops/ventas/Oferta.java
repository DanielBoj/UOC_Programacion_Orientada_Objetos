package aa5_woodshops.ventas;

import aa5_woodshops.clientes.Cliente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * La clase Oferta representa una oferta que ofrece la empresa, SedeCentral, a los clientes fidelizados, WoodFriend.
 */
public class Oferta {

    private String codigo;
    private String descripcion;
    private DetalleOferta detalleOferta;
    private ArrayList<Cliente> clientes;

    private static int actualCodigo = 0;

    /**
     * Constructor genérico para crear una instancia de la Clase Oferta. Recibe por parámetro la descripción de la
     * oferta y una instancia de DetalleOferta e inicializa un ArrayList del tipo Cliente que contiene la lista de
     * clientes a los que se les ofrece la oferta y le asigna la lista recibida por parámetro. Finaliza asignando el
     * código de oferta.
     *
     * @param descripcion   String Descripción de la oferta.
     * @param detalleOferta DetalleOferta Instancia de la Clase DetalleOferta.
     * @param clientes      ArrayList ArrayList del tipo Clientes.
     */
    public Oferta(String descripcion, DetalleOferta detalleOferta, ArrayList<Cliente> clientes) {
        this.descripcion = descripcion;
        this.detalleOferta = detalleOferta;
        clientes = new ArrayList<>();
        this.clientes = clientes;

        codigo = "SALE" + Integer.toString(++actualCodigo);
    }

    /**
     * Override del constructor que inicializa el ArrayList pero no lo recibe por parámetro.
     *
     * @param descripcion String Descripcion de la oferta.
     */
    public Oferta(String descripcion) {
        this.descripcion = descripcion;
        clientes = new ArrayList<>();

        codigo = "SALE" + Integer.toString(++actualCodigo);
    }

    /* Getters & Setters */

    /**
     * Método Getter que devuelve el código de la oferta.
     *
     * @return codigoProducto String Codigo de la oferta.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Método Getter que devuelve la descripción de la oferta.
     *
     * @return String Descripción de la oferta.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método Getter que devuelve una instancia de DetalleOferta con las fechas de inicio y fin y asocia una instancia
     * de Oferta con una instancia de SedeCentral.
     *
     * @return DetalleOferta Instancia de la Clase DetalleOferta.
     */
    public DetalleOferta getDetalleOferta() {
        return detalleOferta;
    }

    /**
     * Método Getter que devuelve un ArrayList de tipo Cliente con la lista de clientes a los que se les aplica la oferta.
     *
     * @return ArrayList ArrayList del tipo Cliente.
     */
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    /**
     * Método Getter que devuelve el número actual de código para asignar a una oferta.
     *
     * @return int Número actual de código.
     */
    public static int getActualCodigo() {
        return actualCodigo;
    }

    /**
     * Método Setter que permite asignar una descripción.
     *
     * @param descripcion String Descripción de la oferta.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método Setter que asigna una instancia de DetalleOferta a la oferta.
     *
     * @param detalleOferta DetalleOferta Instancia de la Clase DetalleOferta.
     */
    public void setDetalleOferta(DetalleOferta detalleOferta) {
        this.detalleOferta = detalleOferta;
    }

    /**
     * Método Setter que permite asignar un ArrayList del tipo Cliente con la lista de Clientes a los que asignar la oferta.
     *
     * @param clientes ArrayList ArrayList del tipo Cliente.
     */
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     * Método Setter que permite modificar el nñumero actual de código.
     *
     * @param actualCodigo int Número actual de código de oferta.
     */
    public static void setActualCodigo(int actualCodigo) {
        Oferta.actualCodigo = actualCodigo;
    }

    /**
     * Override del método toString para mostrar todos los datos formateados de una instancia de la Clase Oferta.
     *
     * @return String Datos de la instancia de Oferta.
     */
    @Override
    public String toString() {
        return  "Oferta: " + codigo +
                "\nDescripcion: " + descripcion +
                '\n' + detalleOferta;
    }

    /**
     * El método compareOferta() compara 2 instancias de Oferta.
     * Si todos los campos de las instancias son iguales, devuelve cierto, si no, falso.
     *
     * @param src Oferta Instancia de la CLase Oferta.
     * @return boolean Devuelve verdadero si las ofertas comparadas son iguales.
     */
    public boolean compareOferta(Oferta src) {
        return (Objects.requireNonNull(src).getCodigo().equals(this.codigo) &&
                Objects.requireNonNull(src).getDescripcion().equals(this.descripcion));
    }

    /**
     * Override del método compareOferta() que realiza la comparación únicamente por el código de Oferta que recibe por String.
     *
     * @param codigo String Código de la oferta.
     * @return boolean Devuelve verdadero si las ofertas comparadas son iguales.
     */
    public boolean compareOferta(String codigo) {
        return (this.getCodigo().equals(Objects.requireNonNull(codigo)));
    }

    /**
     * El método modificarOferta() permite cambiar la descripción de una oferta y su fecha de finalización.
     *
     * @param descripcion
     */
    public void modificarOferta(String descripcion, String fechaFin) {

        LocalDate formatedDate = null;
        /* generamos la fecha */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            formatedDate = LocalDate.parse(fechaFin, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("No se ha podido modificar la fecha de finalizacion.");
            return;
        }

        setDescripcion(Objects.requireNonNull(descripcion));
        getDetalleOferta().setFechaFin(formatedDate);
    }

    /**
     * Override del método modificarOferta() que realiza las modificaciones a través de una instancia de la Clase Oferta que
     * recibe como parámetro.
     *
     * @param oferta Oferta Instancia de la Clase Oferta con los elementos modificados.
     * @see DetalleOferta
     */
    public void modificarOferta(Oferta oferta) {
        this.setDescripcion(Objects.requireNonNull(oferta.getDescripcion()));
        this.getDetalleOferta().setFechaFin(Objects.requireNonNull(oferta.getDetalleOferta().getFechaFin()));
    }
    }
