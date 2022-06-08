const prompt = require('prompt-sync')({sigint: true});

//Vetor contendo todos os valores de notas existentes.
const cedulas = [200, 100, 50, 20, 10, 5, 2, 1];

//Solicita o valor do produto e o valor a ser pago.
var valor = parseInt(prompt('\nQual o valor do produto?\n'));
var valorDado = parseInt(prompt('\nQual o valor pago?\n'));

//Descobre o valor do troco.
var troco = valorDado - valor;

//Verifica se há necessidade de troco.
if(valorDado > valor){

    //Varre todo o vetor.
    for(var i = 0; i < cedulas.length; i++){
        /*
        Método menos eficiente:

        if(cedulas[i] + cedulas[i] === troco){
            console.log(`\nO troco de R$${valorDado} neste caso é de: R$${troco}.\n Dê duas notas de R$${cedulas[i]}`);
            break;
        }
        for(var o = 1; o < 8; o++){
            if(cedulas[i] + cedulas[o] === troco){
                var aux = cedulas[i] + cedulas[o];
                break;
            }else if(cedulas[o] + cedulas[o] === troco){
                console.log(`\nO troco de R$${valorDado} neste caso é de: R$${troco}.\n Dê duas notas de R$${cedulas[o]}`);
                break;
            }
        }
        if(aux === troco){
            console.log(`\nO troco de R$${valorDado} neste caso é de: R$${troco}.\n Dê uma nota de R$${cedulas[i]} e uma de R$${cedulas[o]}`);
            break;
        }else if(troco >= cedulas[i]){
            console.log(`Cedulas de ${cedulas[i]}: ${parseInt(troco/cedulas[i])}`);
            troco = troco % cedulas[i];
        }
        */

        //Método mais eficiênte:
        if(troco >= cedulas[i]){
            //Informa o valor de cedula que está sendo verificado e informa a quantidade do mesmo que será necessário para o troco.
            console.log(`Cedula(s) de ${cedulas[i]}: ${parseInt(troco/cedulas[i])}`);

            //Devolve o resto da divisão para o valor da variável "troco" para a próxima verificação.
            troco = troco % cedulas[i];
        }
    }
}else{
    //Informa caso não haja a necessidade de troco.
    console.log('Não precisa de troco.');
}