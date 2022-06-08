const prompt = require('prompt-sync')({sigint:true});

//Declaração das variáveis.
var num, tentativa;

//Função para gerar um número aleatório e retorná-lo.
function numeroAleatório(){
    num = Math.floor(Math.random()*11);
    //console.log(num);
    return num;
}

//Chamando a função para que seja executada.
numeroAleatório();

//Laço de repetição para limitar até três tentativas.
for(var i = 0; i < 3; i++){

    //Solicita o número para tentar acertar.
    tentativa = prompt("insira um número de 0 a 10! ");

    //Verifica se o usuário acertou o número, caso tenha acertado, o laço será quebrado.
    if(tentativa == num){
        console.log("Parabéns, você acertou!");
        break;

    //Verifica se o número de tentativas é menor do que dois e se o número informado como tentativa é um número válido e, caso seja, informa que a pessoa errou e pede para tentar novamente.
    }else if(i < 2 && tentativa > 0 && tentativa < 10){
        console.log("Você errou! Tente novamente.");
    }

    //Verifica se o usuário digitou um número válido. Caso tenha digitado um número inválido, informará o usuário sobre o erro e devolverá uma chance ao usuário.
    if(tentativa < 0 || tentativa > 10){
        console.log("Você digitou um número inválido! O número deve estar entre 0 e 10!");
        i=-1;
    }
}

//verifica se as tentativas se esgotaram e, caso tenham, ele informará que as tentativas se esgotaram e qual era o número correto.
if(i == 3){
    console.log(`Suas tentativas se esgotaram... O número correto era ${num}`);
}