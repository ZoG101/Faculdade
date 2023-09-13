import java.util.List;
import java.util.Scanner;

import RH.FolhaDePagamento;
import colaboradores.Colaborador;
import colaboradores.BaseComissionado;
import colaboradores.Comissionado;
import colaboradores.Gerente;
import colaboradores.Horista;
import colaboradores.Mensalista;

public class App {

    public static void main (String[] args) {

        System.out.println("\n|---- Horista ---------------------");
        Horista horista = new Horista("Avery Jordan", "Desenvolvimento", 75.5);
        horista.setHorasTrabalhadas(220);
        System.out.println(horista);
    	
        System.out.println("\n|---- Mensalista ------------------");
        Mensalista mensalista = new Mensalista("Taylor Griffin", "Agile", 8500);
        System.out.println(mensalista);
        
        System.out.println("\n|---- Comissionado ----------------");
        Comissionado comissionado = new Comissionado("Charlene Butler", "Comercial", 25);
        comissionado.setTotalVendas(350000);
        System.out.println(comissionado);

        System.out.println("\n|---- Base Comissionado -----------");
        BaseComissionado baseComissionado = new BaseComissionado("Terrance Wallace", "Venda", 5, 3000);
        baseComissionado.setTotalVendas(150000);
        System.out.println(baseComissionado);

        System.out.println(comissionado.equals(comissionado));

        System.out.println("\n|---- Contando Mensalistas -----------");
        List<Colaborador> colaboradores = List.of(

            horista,
            mensalista,
            comissionado,
            baseComissionado

        );
	
        System.out.printf("O total de colaboradores mensalistas é de %d colaboradores\n", 
        Mensalista.contadorMensalistas(colaboradores));

        Gerente gerente = new Gerente("Juliana", "Tecnologia", 20000, colaboradores);
        gerente.setSenha("12345");

        try (Scanner scaner = new Scanner(System.in)) {

            System.out.print("Informe sua senha:\n> ");
            String senha = scaner.next();

            if (gerente.autenticar(senha)) {

                FolhaDePagamento folha = new FolhaDePagamento(gerente);
                folha.geraRelatorio();

            } else {

                System.err.println("Falha ao autenticar colaborador.");

            }

        } catch (Exception e) {

            System.err.println(e.getMessage());
            e.printStackTrace();

        }

    }

}
