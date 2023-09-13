<?php require 'inicio.php'?>

<?php
    if($_SESSION['reqs'] == 10){
        echo '<h1>Você ganhou um prêmio!</h1>';
    } else {
        echo '<h1>Nada por aqui...</h1>';
    }
?>

<?php require 'fim.php'?>