<?php require 'inicio.php'?>

<?php
function is_jpg($name){
    return substr( $name, -4 ) === '.jpg';
}

if(array_key_exists('arquivo', $_FILES)){
    $f = $_FILES['arquivo'];
    if(!is_jpg($f['name'])){
        echo "<p>Erro! Envie apenas JPGs</p>";
    } else {
        $img = imagecreatefromjpeg($f['tmp_name']);
        $nome_final = './img/' . date('U') . $f['name'];
        $quadrada = imagescale($img, 300, 300);
        if($_POST['filtro'] > -1){
            imagefilter($quadrada, $_POST['filtro']);
        }
        imagejpeg($quadrada, $nome_final);
    }
}
?>

<h1>Adicione uma foto: </h1>
<form enctype="multipart/form-data" method="POST">
    
    <input name="arquivo" type="file" />
    <br>
    <label for="filtro">Escolha o filtro desejado</label>
    <select name="filtro" id="filtro">
        <option value="-1">Nenhum</option>
        <option value="<?php echo IMG_FILTER_GRAYSCALE ?>">Preto e branco</option>
        <option value="<?php echo IMG_FILTER_MEAN_REMOVAL ?>">Rabisco</option>
        <option value="<?php echo IMG_FILTER_NEGATE ?>">Negativo</option>
    </select>
    <button type="submit">Enviar</button>
</form>

<h2>Fotos enviadas</h2>

<?php
$fotos = scandir('img');
foreach($fotos as $f){
    if(is_jpg($f)){
        echo '<img src="/img/'.$f.'" width="300"/>';
    }
}
?>

<?php require 'fim.php'?>
