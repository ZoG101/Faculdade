export class salaDeAula{
    constructor(numeroDaSala){
        this.numeroDaSala = numeroDaSala;
        this._quantidadeDeAlunos = quantidadeDeAlunos;
    }

    criarAluno(){
        
        var formato = prompt("Selecione o formato anual de sua instituição: \n\n 1.Trimestral; \n 2.Bimestral.");
        var mediaDeAprovacao = prompt("Insira a média de aprovação de sua instituição: ");

        parseInt(formato);
        parseInt(mediaDeAprovacao);

        do{
            var alunoNome = prompt("Insira o nome do aluno: ");
            var aluno = [[],[],[],[],[],[],[],[],[]];

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

            if(formato == 1){
                aluno [0][1] = "1º trimestre";
                aluno [0][2] = "2º trimestre";
                aluno [0][3] = "3º trimestre";
                aluno [0][4] = "4º trimestre";
            }else if(formato == 2){
                aluno [0][1] = "1º Bimestre";
                aluno [0][2] = "2º Bimestre";
            }
            
            for(var linha = 1; linha < aluno.length; linha ++){
                if(formato == 1){
                    for(var coluna = 1; coluna < 5; coluna++){
                        var i = 1 + "ª";
                        aluno [linha][coluna] = prompt(`Insira a ${i} nota: `);
                        parseFloat(aluno [linha][coluna]);
                        i++
                    }
                }else if(formato == 2){
                    for(var coluna = 1; coluna < 3; coluna++){
                        var i = 1 + "ª";
                        aluno [linha][coluna] = prompt(`Insira a ${i} nota: `);
                        parseFloat(aluno [linha][coluna]);
                        i++
                    }
                }
                
            }

            var media;

            if(formato == 1){
                for(var linha = 1; linha < aluno.length; linha++){
                    media = aluno[linha][1] + aluno[linha][2] + aluno[linha][3] + aluno[linha][4] / 4;

                    if(media < mediaDeAprovacao){
                        aluno[linha][5] = "REPROVADO";
                    }else{
                        aluno[linha][5] = "APROVADO";
                    }
                }
            }

            if(formato == 2){
                for(var linha = 1; linha < aluno.length; linha++){
                    media = aluno[linha][1] + aluno[linha][2] / 2;

                    if(media < mediaDeAprovacao){
                        aluno[linha][3] = "REPROVADO";
                    }else{
                        aluno[linha][3] = "APROVADO";
                    }
                }
            }

            var volta = prompt(`Deseja criar mais um aluno para esta sala? "s" ou "n" `);
        }while(volta == "s");
    }
}