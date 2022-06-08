const prompt = require ('prompt-sync') ({sigint:true});

//Declaração das variáveis que armazenarão os valores da quantidade de votos do condidato 1, 2, 3, votos nulos e brancos.
var v1, v2, v3, n, b;

//Solicita os valores dos votos dos cadidatos 1, 2, 3, votos nulos e brancos.
v1 = parseInt(prompt(`Insira quantas pessoas votaram no primeiro candidato: \n`));
v2 = parseInt(prompt(`Insira quantas pessoas votaram no segundo candidato: \n`));
v3 = parseInt(prompt(`Insira quantas pessoas votaram no terceiro candidato: \n`));
n = parseInt(prompt(`Insira quantas pessoas votaram em branco: \n`));
b = parseInt(prompt(`Insira quantas pessoas votaram nulo: \n`));

//Declaração e soma dos valores para obter a quantidade total de votos.
var nv = (v1 + v2 + v3 + n + b);

//Realizando uma regra de três básica para obter a porcentagem de votos de cada candidato, de votos nulos e brancos.
var res1 = 100*v1 / nv;
var res2 = 100*v2 / nv;
var res3 = 100*v3 / nv;
var res4 = 100*n / nv;
var res5 = 100*b / nv;

//Exibe os resultados com uma formatação simples.
console.log(`\n
--------------------------------------------------
O número total de pessoas que votaram é de ${nv}.
O total e porcentagem de votos por candidato é de:
-Candidato 1: ${v1} => ${res1}%;
-Candidato 2: ${v2} => ${res2}%;
-Candidato 3: ${v3} => ${res3}%;
-Votos nulos: ${n} => ${res4}%;
-Votos em branco: ${b} => ${res5}%.
--------------------------------------------------\n`);