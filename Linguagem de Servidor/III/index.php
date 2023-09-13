<?php require 'inicio.php'?>

<h1>
    Pizzas
</h1>

<form method="GET" action="resultado.php">
    <input type="checkbox" name="sabores[]" id="mussarela" value="Mussarela">
    <label for="mussarela"> Mussarela </label>

    <input type="checkbox" name="sabores[]" id="calabresa" value=" Calabresa">
    <label for="calabresa"> Calabresa </label>

    <input type="checkbox" name="sabores[]" id="portuguesa" value="Portuguesa">
    <label for="portuguesa"> Portuguesa </label>

    <button type="submit">
        Enviar
    </button>
</form>

<?php $sabores = ['Mussarela', 'Calabresa', 'Portuguesa'];?>

<form method="GET" action="resultado.php">
    <?php foreach($sabores as $sabor){ ?>
        <input type="checkbox" name="sabores[]" id="<?php echo $sabor?>" value="<?php echo $sabor?>">
        <label for="<?php echo $sabor?>"><?php echo $sabor?></label>
    <?php } ?>
    <button type="submit">
        Enviar
    </button>
</form>

<?php require 'fim.php'?>
