const prompt = require('prompt-sync')({sigint: true});

//Função para criação do aluno e formatação da matriz.
function criarAluno(){
    
    //Pedido de formato anual da instutução.
    var formato = prompt("Selecione o formato anual de sua instituição: \n\n 1.Trimestral; \n 2.Semestral. \n");

    //Média de aprovação da instituição.
    var mediaDeAprovacao = prompt("Insira a média de aprovação de sua instituição: ");

    //Conversão das variáveis "formato" e "mediaDeAprovação" para inteiros para uma melhor compreesão e tomada de decisão mais acertiva por parte do JavaScript.
    parseInt(formato);
    parseInt(mediaDeAprovacao);

    //Matriz que irá armazenar os dados e notas do aluno.
    var aluno = [[],[],[],[],[],[],[],[],[],[]];

    //Estrutura de repetição para a possibilidade de criação de mais de um aluno.
    do{
        //Variável para armazenar o nome do aluno.
        var alunoNome = prompt("Insira o nome do aluno: ");

        //Formatação inicial da matriz com o nome do aluno e as matérias básicas que serão utilizadas.
        aluno [0][0] = alunoNome;
        aluno [1][0] = "Português";
        aluno [2][0] = "Matemática";
        aluno [3][0] = "Biologia";
        aluno [4][0] = "Química";
        aluno [5][0] = "Física";
        aluno [6][0] = "História";
        aluno [7][0] = "Geografia";
        aluno [8][0] = "Sociologia";
        aluno [9][0] = "Filosofia";

        //Primeira tomada de decisão baseada na escolha do usuário sobre o formato anual de sua instituição.
        if(formato == 1){
            aluno [0][1] = "1º trimestre";
            aluno [0][2] = "2º trimestre";
            aluno [0][3] = "3º trimestre";
            aluno [0][4] = "4º trimestre";
        }else if(formato == 2){
            aluno [0][1] = "1º Semestre";
            aluno [0][2] = "2º Semestre";
        }
        
        //Laço de repetição aninhados para varrer as linhas e colunas da matriz e preecher as notas do aluno.
        for(var linha = 1; linha < aluno.length; linha ++){

            //Segunda tomada de decisão também baseada no formato anual da instituição.
            if(formato == 1){
                for(var coluna = 1; coluna < 5; coluna++){
                    var i = coluna + "ª";
                    parseInt(i);
                    aluno [linha][coluna] = prompt(`Insira a ${i} nota do ${aluno[0][coluna]} da matéria ${aluno[linha][0]}: `);
                    parseFloat(aluno [linha][coluna]);
                    i++
                }
            }else if(formato == 2){
                for(var coluna = 1; coluna < 3; coluna++){
                    var i = coluna + "ª";
                    parseInt(i);
                    aluno [linha][coluna] = prompt(`Insira a ${i} nota do ${aluno[0][coluna]} da matéria ${aluno[linha][0]}: `);
                    parseFloat(aluno [linha][coluna]);
                }
            }
        }

        //Variável para armazenar o resultado do cálculo da média das notas do aluno para posteriormente adicioná-las na matriz.
        var media;

        //Segunda tomada de decisão também baseado no formato anual e utilizando a "mediaDeAprovação", também efetua o cálculo da média final e exibe na matriz se o aluno foi aprovado ou não em cada matéria individualmente.
        if(formato == 1){
            for(var linha = 1; linha < aluno.length; linha++){
                media = aluno[linha][1] + aluno[linha][2] + aluno[linha][3] + aluno[linha][4] / 4;

                if(media < mediaDeAprovacao){
                    aluno[linha][5] = "REPROVADO";
                }else{
                    aluno[linha][5] = "APROVADO";
                }
            }
        }else if(formato == 2){
            for(var linha = 1; linha < aluno.length; linha++){
                media = aluno[linha][1] + aluno[linha][2] / 2;

                if(media < mediaDeAprovacao){
                    aluno[linha][3] = "REPROVADO";
                }else{
                    aluno[linha][3] = "APROVADO";
                }
            }
        }

        //Exibe a tabela completa contendo o nome do aluno, suas notas e se foi aprovado ou não em cada matéria individualmente.
        console.log(aluno);

        //Pergunta ao usuário se ele deseja criar mais um aluno e, caso a resposta seja verdadeira, o laço de repetição irá verificar como verdadeiro.
        var volta = prompt(`Deseja criar mais um aluno? "s" ou "n" \n`);
    }while(volta == "s");
}

//Variável de resposta para verificar a resposta do menu.
var res;

//Um laço de repetição que gera um menu simples e, enquanto a resposta for diferente do núro relacionado a "sair", ele se repetirá.
do{
    res = prompt(
        `Escolha uma das opções a seguir: \n 
        1.Criar aluno; \n 
        2.Encerrar; \n`);

        if(res == 1){
            criarAluno();
        }
    
}while(res != 2);