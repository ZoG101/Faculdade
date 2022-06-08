const prompt = require('prompt-sync')({sigint:true});

//Declara as variáveis de "idade", que será o vetor que armazenará os números; "aux", variável que auxiliará a organizar os números do vetor; "quantidade", que definirá a quantidade de idades que serão armazenadas no vetor.
var idade = [], aux, quantidade = parseInt(prompt("Digite o número de idades que devem ser solicitadas: "));

//Varre o vetor para preenchê-lo com as idades com base na quantidade de idades definidas anteriormente.
for(var i = 0; i < quantidade; i++){
    idade[i] = parseInt(prompt(`Digite a ${i + 1 + "ª"} idade: `));
}

//Varre o vetor através de dois laços de repetição aninhados para verificar um número e depois o número posterior, compará-los e troca-los de lugar caso seja necessário.
for(var fixa = 0; fixa < idade.length - 1; fixa++){
    for(var resto = fixa + 1; resto < idade.length; resto++){
        if(idade[fixa] > idade[resto]){
            aux = idade[fixa];

            idade[fixa] = idade[resto];
            idade[resto] = aux;
        }
    }
}

//Exibe o resultado final do vetor ordenado no console.
console.log(idade);