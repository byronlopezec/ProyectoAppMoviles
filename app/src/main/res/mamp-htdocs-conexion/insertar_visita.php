<?php
/**
 * Insertar un nuevo alumno en la base de datos
 */

require 'Visita.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    // Decodificando formato Json
    $body = json_decode(file_get_contents("php://input"), true);

    // Insertar Visita
    $retorno = Visita::insert(
        $body['nombre'],
		$body['fecha_visita'],
		$body['hora_visita'],
		$body['numero_visitantes'],
        $body['telefono']);

    if ($retorno) {
        $json_string = json_encode(array("estado" => 1,"mensaje" => "Creacion correcta"));
		echo $json_string;
    } else {
        $json_string = json_encode(array("estado" => 2,"mensaje" => "No se creo el registro"));
		echo $json_string;
    }
}

?>