package br.com.loja.loca;

import java.time.LocalDate;

import br.com.loja.carro.Carro;
import br.com.loja.cliente.Cliente;

public class Locacao {
    
    private Cliente cliente;
    private Carro carro;
    private LocalDate dataRetirada;
    private LocalDate dataRetorno;
    private Double valor;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }
    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public LocalDate getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(LocalDate dataRetorno) {
        this.dataRetorno = dataRetorno;
    }
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
}
