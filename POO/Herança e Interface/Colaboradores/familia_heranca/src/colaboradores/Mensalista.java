package colaboradores;

import java.util.List;

public class Mensalista extends Colaborador {

    private double salarioMensal;

    public Mensalista (String nome, String departamento, double salarioMensal) {

        super(nome, departamento);
        this.salarioMensal = salarioMensal;
        
    }

    public static long contadorMensalistas (List<Colaborador> colaboradores) {

        return colaboradores
        .stream()
        .filter(colaborador -> 
        colaborador instanceof  Mensalista)
        .count();

    }

    @Override
    public double getSalario () {

        return this.salarioMensal;

    }

    @Override
    public String toString () {

        return String.format("%s\nSalário Mensal: R$ %.2f",
        super.toString(), this.getSalario());

    }
    
}
