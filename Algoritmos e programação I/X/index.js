const prompt = require('prompt-sync')({sigint: true});

//Função para converter de fahrenheit para celcius utilizando sua respectiva fórmula.
function converterEmC(){
    var F = parseInt(prompt('Digite a temperatura em fahrenheit: \n'));

    var res = (F - 32) * (5/9);

    console.log(`\n---A temperatura em celsius é ${res}°C---\n`);
}

//Função para converter de celcius para fahrenheit utilizando sua respectiva fórmula.
function converterEmF(){
    var C = parseInt(prompt('Dingite a temperatura em celsius:\n'));

    res = (C * 9/5) + 32;

    console.log(`\n---A temperatura em fahrenheit é: ${res}°F---\n`);
}

//Laço de repetição para criação de um menu simples o a pessoa pode escolher entre converter em celcius (opção 1), converter em fahrenheit (opção 2), sair (3).
do{
    var menu = parseInt(prompt('Você gostaria de:\n1.Converter de fahrenheit em celsius;\n2.Converter de celsius em fehrenheit;\n3.Sair.\n'));

    if(menu === 1){
        converterEmC();
    }

    if(menu === 2){
        converterEmF();
    }
}while(menu != 3);