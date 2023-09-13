<?php require 'inicio.php'?>

<h1>Qual seu nome?</h1>
<form method="post">
    <input type="text" name="nome">
    <button type="submit">Enviar</button>
</form>
<?php
if(array_key_exists('nome', $_POST)){
    $fh = fopen('nome.txt', 'a');
    fwrite($fh, $_POST['nome']."\n");
    fclose($fh);
}
?>

<?php require 'fim.php'?>
