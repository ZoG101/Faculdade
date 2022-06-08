//Esta parte faz a solicitação do módulo "prompt-sync" caso esteja utilizando o node.js, caso não esteja, ele pode ser descartado.
const prompt = require('prompt-sync')({sigint: true});

//Executa o cálculo de comparação e retorna o resultado.
function comparacao(){ 
    var resultado = 0;

    resultado = alcool/gasolina;
    parseFloat(resultado);

    return resultado;
}

//Exibe o resultado da comparação com base no valor do resultado da função anterior.
function mostrarResultado(){ 
    if(resultado > 0.7){
        console.log(`\n${resultado}. A gasolina é mais vantajosa!`);
    }else if(resultado < 0.7){
        console.log(`\n${resultado}. O álcool é mais vantajoso!`);
    }else if(resultado == 0.7){
        console.log(`\n${resultado}. Não faz diferença!`);
    }
    return;
}

//Variável que irá armazenar a resposta do usuário no menu simples.
var res;

//Contador de vezes que o pragrama foi executado.
var i = 0; 

//Laço de repetição que cria um menu simples.
do{
    var gasolina;
    var alcool;

    //Verifica se o programa já foi executado e, caso não tenha sido, exibe um menu. Caso já tenha sido executado, ele não exibirá o menu novamente afim de evitar redundância.
    if(i == 0){ 
        res = prompt(`Selecione uma das opções:
        1.Efetuar comparação entre gasolina e álcool;
        2.Sair.\n`);
    }else{
        res = 1;
    }

    //Verifica a resposta do usuário no menu, solicita os valores ao usuário, faz a chamada das funções e aumenta o contador "i" em mais um.
    if(res == 1){ 
        gasolina = prompt("\nInforme o preço da gasolina:\n");
        parseFloat(gasolina);
        alcool = prompt("\nInforme o preço da álcool:\n");
        parseFloat(alcool);

        comparacao();

        var resultado = comparacao();
        mostrarResultado();

        i++
    }

    //Verifica se usuário executou o programa alguma vez.
    if(res != 2 && res < 2 && res > 0){ 

        //Verifica se o usuário deseja executar o programa mais uma vez.
        res = prompt(`\nDeseja efetuar mais um cálculo? "s" ou "n".\n`); 
    }

//Verifica qual foi a resposta do usuário no menu e na pergunta final.
}while(res != 2 && res != "n"); 