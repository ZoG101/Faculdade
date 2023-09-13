<?php require 'inicio.php'?>

<?php
session_start();
$db = new PDO('mysql:host=localhost:8010;dbname=meu_banco;charset=utf8', 'root', 'root');

if(array_key_exists('email', $_POST) && array_key_exists('senha', $_POST)){
    $res = $db->query("SELECT * FROM `usuarios` WHERE `email` = '{$_POST['email']}'" );
    $linha = $res->fetch();

    if($linha && $linha['senha'] === $_POST['senha']){
        $_SESSION['usuario_id'] = $linha['id'];
        $usuario = $linha;
    }
}

if(array_key_exists('usuario_id', $_SESSION) && $_SESSION['usuario_id'] && !isset($usuario)){
    $res = $db->query("SELECT * FROM `usuarios` WHERE `id` = '{$_SESSION['usuario_id']}'" );
    $usuario = $res->fetch();
}

if(isset($usuario)){?>
    <h1>Seja bem-vindo "<?php echo $usuario['nome'] ?>"!</h1>
    <p>O seu e-mail é <?php echo $usuario['email'] ?></p>
<?php 
} else {
?>
    <h1>Faça seu login!</h1>
    <form action="" method="post">
        <div><label for="email">E-mail: </label><input type="text" id="email" name="email"></div>
        <div><label for="senha">Senha: </label><input type="password" id="senha" name="senha"></div>
        <button type="submit">Login</button>
    </form>
<?php
} // fim do if
?>

<?php require 'fim.php'?>
