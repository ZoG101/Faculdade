package colaboradores;

import java.util.Objects;

import auentica.Autenticavel;

public abstract class Colaborador implements Autenticavel{

    private String nome;
    private String departamento;
    private String senha;

    public Colaborador (String nome, String departamento) {

        this.nome = nome;
        this.departamento = departamento;

    }

    public String getNome () {

        return nome;

    }

    public String getDepartamento () {

        return departamento;

    }

    public abstract double getSalario ();

    public String getSenha () {

        return senha;

    }

    public void setSenha (String senha) {

        this.senha = senha;

    }

    @Override
    public boolean autenticar (String senhaDigitada) {

        return this.getSenha().equals(senhaDigitada);

    }

    @Override
    public String toString () {

        return String.format("Colaborador: %s\nDepartamento: %s", this.nome, this.departamento);

    }

    @Override
    public boolean equals (Object outro) {

        if (this == outro) return true;
        if (outro == null) return false;
        if (this.getClass() != outro.getClass()) return false;

        Colaborador colaborador = (Colaborador) outro;

        return nome.equals(colaborador.nome) && departamento.equals(colaborador.departamento);

    }

    @Override
    public int hashCode () {

        return Objects.hash(this.nome, this.departamento, this.senha);

    }

    //Basta combinar valores inteiros com os hashs de cada atributo em 
    //sua classe, no caso, Colaborador.
    /*
     * 
     * @Override
     * public int hashCode () {
     * 
     *      return 7 * this.nome.hashCode() + 11 * this.departamento.hashCode(); 
     * 
     * }
     * 
     */
    
}
