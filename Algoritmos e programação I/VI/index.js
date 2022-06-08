const prompt = require('prompt-sync')({sigint:true});

//Matriz onde será feito o jogo de batalha naval.
var naval = [[],[],[],[],[],[],[],[],[],[]];
var linha, coluna;

//Laço de repetição para varrer a matriz e preechê-la com a palavra água.
for(var i = 0; i < 10; i++){
    for(var j = 0; j < 10; j++){
        naval[i][j] = "água";
    }
}

//Segundo laço de repetição para varrer novamente a matriz e colocar navios em posições aleatórias da matriz.
for(var pos = 1; pos < 11; pos++){
    linha = Math.floor(Math.random()*10);
    coluna = Math.floor(Math.random()*10);

    naval[linha][coluna] = "navio";
}

//Laço de repetição para que o usuário possa tentar acertar os navios quantas vezes quiser.
do{
    linha = prompt("insira a linha de 0 a 9: ");
    coluna = prompt("Insira a coluna de 0 a 9: ");

    //Verifica se o usuário acertou a posição de um navio.
    if(naval[linha][coluna] == "navio"){
        console.log("Parabéns, Você acertou!");
    }else{
        console.log("Você caiu na água!");
    }

    var resp = prompt("Você deseja continuar? s ou n? ");

    console.clear();

//Verifica se o usuário deseja tentar novamente ou não.
}while(resp == "s");

console.log("Obrigado por jogar!");