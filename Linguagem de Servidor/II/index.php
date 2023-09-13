<?php require 'inicio.php'?>

<h1>
    Mercado
</h1>

<?php $frutas = ['banana' => 12, 'laranja' => 6, 'abacaxi' => 2];?>

<ul>
    <?php foreach ($frutas as $fruta => $quantidade) {
        echo "<li>$quantidade unidade(s) de $fruta</li>";
    }?>
</ul>

<?php require 'fim.php'?>
