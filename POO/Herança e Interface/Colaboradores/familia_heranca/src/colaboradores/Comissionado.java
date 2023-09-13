package colaboradores;

import auentica.AssinaturaDigital;

public class Comissionado extends Colaborador implements AssinaturaDigital {

    private double totalVendas;
    private int comissao;
    private int hashSenha;

    public Comissionado (String nome, String departamento, int comissao) {

        super(nome, departamento);
        this.comissao = comissao;
        
    }

    public void setTotalVendas (double totalVendas) {

        this.totalVendas = totalVendas;

    }

    public double getTotalVendas () {

        return totalVendas;

    }

    public int getComissao () {

        return comissao;

    }

    @Override
    public double getSalario () {

        return this.totalVendas * (this.comissao/100.);

    }

    public int getHashSenha () {

        return hashSenha;

    }

    public void setHashSenha (int hashSenha) {

        this.hashSenha = hashSenha;

    }

    @Override
    public String toString () {

        return String.format("%s\nTotal de Vendas: R$ %.2f\n" +
        "Comissão: %d%%\nSalário Mensal: R$ %.2f",
        super.toString(), this.getTotalVendas(),
        this.getComissao(), this.getSalario());

    }

    @Override
    public long hash () {
        
        long hash = (this.getHashSenha() % 3) * super.hashCode();
        return hash;

    }
    
}
