package colaboradores;

public class Horista extends Colaborador {

    private int horasTrabalhadas;
    private double valorPorHora;

    public Horista (String nome, String departamento, double valorPorHora) {

        super(nome, departamento);
        this.valorPorHora = valorPorHora;
        
    }

    public void setHorasTrabalhadas (int horasTrabalhadas) {

        this.horasTrabalhadas = horasTrabalhadas;

    }

    public int getHorasTrabalhadas () {

        return this.horasTrabalhadas;

    }

    public double getValorPorHora () {

        return valorPorHora;

    }

    @Override
    public double getSalario () {

        return this.horasTrabalhadas * this.valorPorHora;

    }

    @Override
    public String toString () {

        return String.format("%s\nHoras trabalhadas: %d\n" +
        "Valor por hora: R$ %.2f\nSalário: R$ %.2f",
        super.toString(), this.horasTrabalhadas,
        this.valorPorHora, this.getSalario());
    
    }
    
}
