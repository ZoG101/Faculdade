const prompt = require('prompt-sync')({sigint:true});

//Declara uma variável.
var numero;

//Solicita um valor para ser atribuído a variável.
numero = prompt('Insira um número: ');

//Verifica se o número é positivo, negativo ou neutro.
if(numero > 0){
    console.log("Esse número é positivo");
}else if(numero < 0){
    console.log("Esse número é negativo");
}else{
    console.log("Esse número é neutro");
}