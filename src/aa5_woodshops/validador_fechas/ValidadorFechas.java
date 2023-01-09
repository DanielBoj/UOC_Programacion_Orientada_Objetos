package aa5_woodshops.validador_fechas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidadorFechas {

    private DateTimeFormatter formatter;
    private String pattern = "dd-MM-yyyy";

    public ValidadorFechas() {
        this.formatter = DateTimeFormatter.ofPattern(pattern);
    }

    public boolean isValid(String date) {
        try {
            LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            return false;
        }

        return true;
    }
}
