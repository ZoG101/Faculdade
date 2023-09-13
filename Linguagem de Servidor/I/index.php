<?php require 'inicio.php'?>

<h1>
    Meu Formulário
</h1>

<form method="post" action="resultado.php">
    <label for="campo_de_nome">Digite seu nome</label>
    <input name="nome_usuario" id="campo_de_nome" type="text"/>
    <button type="submit">Enviar</button>
</form>

<?php require 'fim.php'?>
