const prompt = require('prompt-sync')({sigint:true});

//Declaração de variável "ano" e solicitação de valor através do prompt para armazenar o ano que deseja ser verificado.
var ano = parseInt(prompt(`Insira o ano:\n`));
/*
Para descobrir se um ano é bissexto ou não, basta dividir o ano por 4, 100 e 400. 
Se o resultado for inteiro em todas as divisõs, isso significa que ele é uma ano bissexto. 
E, para isso, tem-se a função "Number.isInteger()" que verifica se o resultada de uma operação ou se o número inserido é inteiro ou não e, 
a partir disso, retorna um resultado booleano (verdadeiro ou falso).
*/ 
var res1 = Number.isInteger(ano/4);
var res2 = Number.isInteger(ano/100);
var res3 = Number.isInteger(ano/400);

//var aux = Number.isInteger(res);

//Verifica se todos os resultados são verdadeiros.
if(res1 && res2 && res3){
    console.log(`O ano ${ano} é bissexto.`);
}else{
    console.log(`O ano de ${ano} não é bissexto.`);
}