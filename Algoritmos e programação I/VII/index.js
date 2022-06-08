const prompt = require('prompt-sync')({sigint: true});

//Vetor para armazenar os 10 números.
var num = [];

//Laço de repetição para preencher o vetor com os 10 números que o usuário informar, converter em inteiros.
for(var i = 0; i < 10; i++){
    num[i] = Math.floor(parseInt(prompt(`Insira o ${i + 1}º número:\n`)));
}

//Varre o vetor através de dois laços de repetição aninhados para verificar um número e depois o número posterior, compará-los e troca-los de lugar caso seja necessário.
for(var i = 0; i < 9; i++){
    for(var o = i + 1; o < 10; o++){
        if(num[i] > num[o]){
            var aux = num[i];

            num[i] = num[o];
            num[o] = aux;
        }
    }
}

//Exibe o maior e o menor número separados e todo o vetor organizado.
console.log(`O maior número é ${num[9]} e o menor número é ${num[0]}.\n Todos os números em ordem ficam: ${num}.`);