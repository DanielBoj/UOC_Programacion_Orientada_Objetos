package aa5_woodshops.ventas;

import aa5_woodshops.centros.SedeCentral;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * La clase DetalleOferta es una Clase Asociativa que relaciona una instancia de Oferta con una instancia de SedeCentral,
 * es decir, una Oferta con la Empresa, y almacena la fecha de inicio y de fin de la oferta.
 */
public class DetalleOferta {

    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private SedeCentral sedeCentral;
    private Oferta oferta;

    /**
     * Constructor genérico para una instancia de la Clase DetalleOferta. Recibe por parámetro las fechas de inicio y de fin,
     * una instancia de SedeCentral, la empresa, y una instacnia de Oferta.
     *
     * @param fechaInicio LocalDate Fecha de inicio de la oferta.
     * @param fechaFin    LocalDate Fecha de fin de la oferta.
     * @param sedeCentral SedeCentral Instancia de SedeCentral que representa la empresa.
     * @param oferta Oferta Instancia de Oferta.
     * @see Oferta        Oferta Instancia de la Clase Oferta.
     * @see SedeCentral   SedeCentral Instancia de la Clase SedeCentral.
     */
    public DetalleOferta(LocalDate fechaInicio, LocalDate fechaFin, SedeCentral sedeCentral, Oferta oferta) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.sedeCentral = sedeCentral;
        this.oferta = oferta;
    }

    /**
     * Override del constructor que recibe las fechas como String.
     *
     * @param fechaInicio String Fecha de inicio de la oferta.
     * @param fechaFin String Fecha de finalización de la oferta.
     * @param sedeCentral SedeCentral Instancia de SedeCentral que representa la empresa.
     * @param oferta Oferta Instancia de Oferta.
     * @see SedeCentral
     * @see Oferta
     */
    public DetalleOferta(String fechaInicio, String fechaFin, SedeCentral sedeCentral, Oferta oferta) {

        LocalDate formatedDate = null;

        /* generamos la fecha */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            formatedDate = LocalDate.parse(fechaInicio, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("No se ha podido generar la fecha de inicio.");
            return;
        }
        this.fechaInicio = formatedDate;

        try {
            formatedDate = LocalDate.parse(fechaFin, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("No se ha podido generar la fecha de finalización.");
        }
        this.fechaFin = formatedDate;

        this.sedeCentral = sedeCentral;
        this.oferta = oferta;
    }

    /* Getters & Setters */

    /**
     * Método Getter que devuelve la fecha de inicio de la oferta.
     *
     * @return LocalDate Fecha de inicio.
     */
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Método Getter que devuelve la fecha de finalización de la oferta.
     *
     * @return LocalDate Fecha de finalización.
     */
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    /**
     * Método Getter que devuelve la SedeCentral asociada a la Oferta.
     *
     * @return SedeCentral Instancia de la Clase SedeCentral.
     */
    public SedeCentral getSedeCentral() {
        return sedeCentral;
    }

    /**
     * Método Getter que devuelve la Oferta relacionada con la SedeCentral.
     *
     * @return Oferta Instancia de la Clase Oferta.
     */
    public Oferta getOferta() {
        return oferta;
    }

    /**
     * Método Setter para asignar una fecha de inicio de la oferta.
     *
     * @param fechaInicio LocalDate Fecha de inicio de la oferta.
     */
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Método Setter para asignar la fecha de finalización de la oferta.
     *
     * @param fechaFin LocalDate Fecha de finalización.
     */
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Método Setter para asignar una SedaCentra para relacionar con la oferta.
     *
     * @param sedeCentral SedeCentral Instancia de la Clase SedeCentral que representa la empresa.
     */
    public void setSedeCentral(SedeCentral sedeCentral) {
        this.sedeCentral = sedeCentral;
    }

    /**
     * Método Setter para asignar una oferta relacionada con la empresa, SedeCentral.
     *
     * @param oferta Oferta Instancia de la Clase Oferta.
     */
    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    /**
     * Override del método String que formatea los datos de una instancia de la Clase DetalleOferta en un String para
     * mostrarlas por pantalla
     *
     * @return String Datos de la instancia de DetalleOferta.
     */
    @Override
    public String toString() {
        return "Detalles:" +
                "\nInicio: " + fechaInicio +
                "\tFin: " + fechaFin;
    }
}
