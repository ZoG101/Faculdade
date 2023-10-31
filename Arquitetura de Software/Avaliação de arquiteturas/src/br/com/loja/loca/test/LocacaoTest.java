package br.com.loja.loca.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.*;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import br.com.loja.carro.Carro;
import br.com.loja.carro.exception.CarroNaoDisponivelException;
import br.com.loja.cliente.Cliente;
import br.com.loja.loca.Locacao;
import br.com.loja.loca.LocacaoService;
import br.com.loja.loca.exception.LocacaoException;

public class LocacaoTest {

    private LocacaoService service;

    @Rule
    public ErrorCollector erros = new ErrorCollector();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before // Como se fosse o construtor do teste.
    public void inicializa() {
        System.out.println("Executa antes de realizar os testes.");
        service = new LocacaoService();
    }

    /* 
    @Test
    public void testeAlugaCarro() throws Exception {
        Cliente cliente = new Cliente("Gustavo");
        Carro carro = new Carro("Renault Clio 2012", 5, 10.0);

        Locacao locacao = service.alugaCarro(cliente, carro);

        erros.checkThat(locacao.getValor(), is(equals(10.0)));
        erros.checkThat(ehMesmaData(LocalDate.now(), locacao.getDataRetirada()), is(true));
        erros.checkThat(ehMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(3)), is(true));
    }
    */

    private LocalDate obterDataComDiferencaDias(int i) {
        return LocalDate.now().plusDays(i);
    }

    private boolean ehMesmaData(LocalDate now, LocalDate dataRetirada) {
        return now.compareTo(dataRetirada) ==  0;
    }

    @Test(expected = CarroNaoDisponivelException.class)
    public void testeCarroNaoDisponivel() throws Exception{
        Cliente cliente = new Cliente("Martin");
        Carro carro = new Carro("Fiat Uno", 0, 10.0);

        service.alugaCarro(cliente, carro);
    }

    @Test
    public void testeVeiculoVazio() {
        Cliente cliente = new Cliente("Andrey");

        try {
            service.alugaCarro(cliente, null);
            fail(); // Da classe Assert
        } catch (CarroNaoDisponivelException | LocacaoException e) {
            assertEquals("Carro não informado", e.getMessage());
        }
    }

    @Test
    public void testeClienteVazio() throws  CarroNaoDisponivelException, LocacaoException {
        Carro carro = new Carro("Renault Clio 2012", 5, 10.0);

        exception.expect(LocacaoException.class);
        exception.expectMessage("Cliente não informado");

        service.alugaCarro(null, carro);
    }

    @After
    public void finaliza() {
        System.out.println("Executado após o teste.");
    }
}
