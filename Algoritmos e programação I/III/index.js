const prompt = require('prompt-sync')({sigint:true});

//Declaração de variáveis.
var senha, repete, s;

//Laço de repetição para a definição de uma senha de 6 dígitos, o laço só será quebrado ao digitar uma senha de 6 dígitos ou encerrando o programa.
do {
  senha = prompt("Insira sua senha numérica de 6 dígitos: ");
}while(senha.length != 6);

//Solicita que o usuário repita a seha para confirmação.
repete = prompt("Redigite sua senha para validação. Ela deve ser a mesma: ");

//Verifica se a senha repetida foi a mesma da primeira informada, caso contrário, terá que repetir até digitar a mesma senha. 
while(repete != senha) {
  repete = prompt("A senha não é a mesma. Insira novamente a senha para validação: ");
}

//Solicita a senha para acessar a conta.
s = prompt("Para acessar sua conta entre com sua senha: ");

//Verifica se a senha informada está correta e, caso esteja incorreta, pedirá para que tente novamente com até 3 tentativas.
for (var cont = 0; senha != s && cont < 3; cont++){
  console.log("A senha informada não confere. Insira novamente. Você tem mais " + (3 - cont) + " tentativa(s)");
  s = prompt("Para acessar sua conta entre com sua senha: ");
}

//Verifica se conseguiu acertar a senha em até 3 tentativas, caso não tenha conseguido, a senha será resetada e exibirá um mensagem para que o usuário procure seu gerente.
if (cont <= 3){
  console.log("Sua senha está correta! Você pode acessar sua conta.");
} else {
  senha = 99;
  console.log("Sua senha foi bloqueada. Procure seu gerente.");
}
