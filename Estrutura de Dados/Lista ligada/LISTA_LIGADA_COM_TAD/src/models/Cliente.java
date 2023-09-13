package models;

public class Cliente {

    private long codigo;
    private String razaoSocial; 
    private String endereco;
    private double previsaoVendas;

    public Cliente (long c, String r, String e, double p) {

        this.codigo = c;
        this.razaoSocial = r; 
        this.endereco = e; 
        this.previsaoVendas = p;


    }

    public long getCodigo () {

        return this.codigo;

    }

    public void setCodigo (long codigo) {

        this.codigo = codigo;

    }

    public String getRazaoSocial () {

        return this.razaoSocial;

    }

    public void setRazaoSocial (String razaoSocial) {

        this.razaoSocial = razaoSocial;

    }

    public String getEndereco () {

        return this.endereco;

    }

    public void setEndereco (String endereco) {

        this.endereco = endereco;

    }

    public double getPrevisaoVendas () {

        return this.previsaoVendas;

    }

    public void setPrevisaoVendas (double previsaoVendas) {

        this.previsaoVendas = previsaoVendas;

    }

    @Override
    public String toString () {

        return "Codigo: " + this.codigo + " Razão Social: " + this.razaoSocial;

    }

}
