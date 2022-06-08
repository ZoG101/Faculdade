const prompt = require('prompt-sync')({sigint:true});

//Declara e solicita os valores de "altura", "peso" e "sexo" da pessoa.
var altura = parseFloat(prompt('\nInsira a sua altura:\n'));
var peso = parseFloat(prompt('\nInsira o seu peso:\n'));
var sexo = prompt('\nInsira seu sexo (H/M):\n');

//Faz o cálculo de IMC da pessoa com base nos dados inseridos.
var aux = peso/(altura*altura);

//Verifica o sexo inserido pela pessoa e exibe no console a mensagem conforme o IMC da pessoa. 
if(sexo == "H" || sexo == "Homem"){
    if(aux < 20){
        console.log(`\n-----O seu IMC é de ${aux}, e isso é abaixo do peso.-----\n`);
    }else if(aux > 20 && aux < 24.9){
        console.log(`\n-----O seu IMC é de ${aux}, e isso é o normal.-----\n`);
    }else if(aux > 25 && aux < 29.9){
        console.log(`\n-----O seu IMC é de ${aux}, e isso é sobrepeso.-----\n`);
    }else if(aux > 30 && aux < 39.9){
        console.log(`\n-----O seu IMC é de ${aux}, e isso é obesidade.-----\n`);
    }else{
        console.log(`\n-----O seu IMC é de ${aux}, e isso é obesidade grave.-----\n`);
    }
}else if(sexo == "M" || sexo == "Mulher"){
    if(aux < 19){
        console.log(`\n-----O seu IMC é de ${aux}, e isso é abaixo do peso.-----\n`);
    }else if(aux > 19 && aux < 23.9){
        console.log(`\n-----O seu IMC é de ${aux}, e isso é o normal.-----\n`);
    }else if(aux > 24 && aux < 28.9){
        console.log(`\n-----O seu IMC é de ${aux}, e isso é sobrepeso.-----\n`);
    }else if(aux > 29 && aux < 38.9){
        console.log(`\n-----O seu IMC é de ${aux}, e isso é obesidade.-----\n`);
    }else{
        console.log(`\n-----O seu IMC é de ${aux}, e isso é obesidade grave.-----\n`);
    }
}else{
    console.log(`O valor "${sexo}" é inválido!`);
}