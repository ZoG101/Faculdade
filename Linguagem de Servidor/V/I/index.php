<?php require 'inicio.php'?>

<h1>A sua sessão foi iniciada em <?php echo $_SESSION['ultimo_login']?> e você já fez <?php echo $_SESSION['reqs']?> requisições</h1>

<form method="GET" action="resultado.php">
    <button type="submit">
        Ir
    </button>
</form>

<?php require 'fim.php'?>
