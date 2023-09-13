package helper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataHelper {

    public static String formataData(LocalDate data) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);

    }
    
}
