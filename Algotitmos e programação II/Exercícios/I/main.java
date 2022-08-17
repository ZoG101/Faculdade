public class main {

    public static void main (String[] args) {

        //Variáveis de números inteiros.
        int a = 10;             //2 bytes de memória.
        short b = 10;           //4 bytes de memória.
        long c = 200000000L;    //8 bytes de memória (maior de 2BI tem que adicionar o "L").

        //Variáveis de números com decimais.
        double d = 10.0;
        float e = 10.0f;

        //Variáveis de texto (string).
        char f = 'A'; //Tem que ser aspas simples ('') para 'char'.
        String g = "AAAAA";

        //Variáveis booleanas.
        boolean h = true;
        boolean i = false;

        //Operadores aritméticos.
        //+ - * % / ++ -- += -= *= /=
        int aa = 10 + 20;
        int bb = 10 / 2;
        int cc = aa - bb;

        //Operadores relacionais.
        //< > == != <= >=
        int hh = 6;
        int ii = 2;
        boolean jj = hh > ii;
        boolean ll = hh >= ii;
        //...
        String qq = "Davi";
        boolean rr = qq.equals("Davi");
        boolean rl = qq.equals("DAVI");
        boolean gg = qq.equalsIgnoreCase("DAVI");

        //Operadores Lógicos
        //&& || !
        int xx = 10;
        String yy = "java";
        boolean x1 = xx == 10 && yy.equals("java");
        boolean x2 = xx == 10 || yy.equals("java");
        //...

    }
    
}
