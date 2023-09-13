<?php
$mysql = mysqli_connect("localhost", "root", "root", "meu_banco");
if (!$mysql) {
    echo mysqli_connect_error();
}

mysqli_set_charset ( $mysql , 'utf8' );
$resultado = mysqli_query($mysql, "SELECT * from usuarios");
$linha = mysqli_fetch_assoc($resultado);
echo $linha['nome'];
?>