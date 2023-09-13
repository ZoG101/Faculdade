<?php require 'inicio.php'?>

<?php
if(isset($_POST['nome_usuario'])){
    echo '<h2>Olá, ' . $_POST['nome_usuario'] . '<h2>';
}
?>

<?php require 'fim.php'?>