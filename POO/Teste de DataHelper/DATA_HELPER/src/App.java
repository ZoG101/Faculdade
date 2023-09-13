import java.time.LocalDate;

import helper.DataHelper;

public class App {

    public static void main(String[] args) {

        LocalDate hoje = LocalDate.now();

        System.out.println(hoje);
        System.out.println(DataHelper.formataData(hoje));

    }

}
