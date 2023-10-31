package br.com.loja.carro.exception;

public class CarroNaoDisponivelException extends RuntimeException {

    public CarroNaoDisponivelException () {}

    public CarroNaoDisponivelException (String mensagem) {
        super(mensagem);
    }
    
}
