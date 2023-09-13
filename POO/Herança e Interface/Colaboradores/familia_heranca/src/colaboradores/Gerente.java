package colaboradores;

import java.util.List;
import java.util.stream.Collectors;

public class Gerente extends Colaborador{

    private double salarioBase;
    private List<Colaborador> colaboradores;

    public Gerente (String nome, String departamento, double salarioBase, List<Colaborador> colaboradores) {

        super(nome, departamento);
        this.salarioBase = salarioBase;
        this.colaboradores = colaboradores;

    }

    public double getSalarioBase () {

        return salarioBase;

    }

    public List<Colaborador> getColaboradores () {

        return colaboradores;

    }

    private double getBonus () {

        List<Colaborador> colaboradores = this.colaboradores
        .stream()
        .filter(colaborador -> colaborador instanceof Comissionado)
        .collect(Collectors.toList());

        double total = colaboradores
        .stream()
        .mapToDouble(Colaborador::getSalario)
        .sum();

        return total * 0.1;

    }

    @Override
    public double getSalario () {

        return this.getSalarioBase() + this.getBonus();

    }

    @Override
    public String toString () {

        return String.format("%s\nSalário: R$%.2f", super.toString(), this.getSalarioBase());

    }

}
