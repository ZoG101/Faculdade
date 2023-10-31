package br.com.loja.loca;

import java.time.LocalDate;

import br.com.loja.carro.Carro;
import br.com.loja.carro.exception.CarroNaoDisponivelException;
import br.com.loja.cliente.Cliente;
import br.com.loja.loca.exception.LocacaoException;

public class LocacaoService {

    public Locacao alugaCarro(Cliente cliente, Carro carro) throws LocacaoException, CarroNaoDisponivelException {
        if(cliente == null) throw new LocacaoException("Cliente não informado");

        if(carro == null) throw new LocacaoException("Carro não informado");

        if(carro.getDisponiveis() == 0) throw new CarroNaoDisponivelException();

        Locacao locacao = new Locacao();
        locacao.setCliente(cliente);
        locacao.setCarro(carro);
        locacao.setDataRetirada(LocalDate.now());
        locacao.setDataRetorno(adicionaDias(LocalDate.now(), 3));
        locacao.setValor(carro.getValor());

        //Salvar a locacao, no banco de dados
        return locacao;
    }

    public LocalDate adicionaDias (LocalDate data, int dias) {
        return data.plusDays(dias);
    }

}
