const prompt = require('prompt-sync')({sigint: true});

//Declaração de variável "ano" e solicitação de valor através do prompt para armazenar o ano do nascimento.
var ano = prompt('Qual o ano de seu nascimento?\n');

//Declaração de variável "idade" e conta de "ano atual - ano de nascimento" para saber a idade da pessoa.
var idade = 2022 - ano;

//Verificação para saber se a pessoa tem uma idade maior ou igual a 16 anos e, com isso, saber se essa pessoa pode votar o não.
if(idade >= 16){
    console.log(`Você tem ${idade} anos. Então, pode votar.`);
}else{
    console.log(`Você tem ${idade} anos. Então, você não pode votar.`);
}