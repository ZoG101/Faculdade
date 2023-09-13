package colaboradores;

public class BaseComissionado extends Comissionado {

    private double salarioBase;

    public BaseComissionado (String nome, String departamento, int comissao, double salarioBase) {

        super(nome, departamento, comissao);
        this.salarioBase = salarioBase;
        
    }

    public double getSalarioBase () {

        return this.salarioBase;

    }

    @Override
    public double getSalario () {

        return this.salarioBase + super.getSalario();

    }

    @Override
    public String toString () {

        return String.format("%s\nSalário Base: R$ %.2f",
        super.toString(), this.salarioBase);

    }
    
}
