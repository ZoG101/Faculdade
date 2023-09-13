<?php require 'inicio.php'?>

<?php
if(isset($_GET['sabores'])){
    if(array_key_exists('sabores', $_GET)){
        foreach($_GET['sabores'] as $sabor_escolhido){
            echo 'Você escolheu o sabor ' . $sabor_escolhido . '<br>';
        }
    }
}
?>

<?php require 'fim.php'?>