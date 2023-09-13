package ui;

public class Conta {

    //variavel de instância.
    private String cliente;
    //variavel de classe.
    private static Long totalContas;
    private Long numero;
    private Double saldo;

    public Conta (String cliente, Long numero, Double saldo) {

        this.cliente = cliente;
        this.numero = numero;
        this.saldo = saldo;
        Conta.totalContas++;
        
    }

    public String getCliente () {

        return cliente;

    }

    public void setCliente (String cliente) {

        this.cliente = cliente;

    }

    public Long getNumero () {

        return numero;

    }

    public void setSaldo (Double saldo) {

        this.saldo = saldo;

    }

    public final Double consultaSaldo () {

        return saldo;

    }

}