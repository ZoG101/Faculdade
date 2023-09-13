<?php
    class Calculo {

        public function calculaImc (float $valor): string {

        $imc = [
            'Magreza' => [
                'base' => 0,
                'limite' => 18.5
            ],
            'Saudável' => [
                'base' => 18.51,
                'limite' => 24.9
            ],
            'Sobrepeso' => [
                'base' => 25.0,
                'limite' => 29.9
            ],
            'Obesidade Grau I' => [
                'base' => 30.0,
                'limite' => 34.9
            ],
            'Obesidade Grau II' => [
                'base' => 35.0,
                'limite' => 39.9
            ],
            'Obesidade Grau III' => [
                'base' => 39.9,
                'limite' => 999999
            ]
        ];

        foreach ($imc as $key => $value) {
            
            if ($valor >= $value['base'] && $valor <= $value['limite']) {
                return $key;
            }

        }

        }   

    }
?>

<h1>Cálculo de IMC</h1>
<form action="" method="post">
    <div><label for="Peso">Peso: </label><input type="number" id="peso" name="peso"></div>
    <button type="submit">Enviar</button>
</form>

<?php

    if ((isset($_POST['peso'])) && (is_numeric($_POST['peso'])) && ($_POST['peso'] >= 0)) {

        $calculo = new Calculo();
        $resultado = $calculo->calculaImc($_POST['peso']);
        echo "<p>Atenção, seu IMC é ".$_POST['peso'].", e você está classificado como ".$resultado."</p>";

    }
    
?>
