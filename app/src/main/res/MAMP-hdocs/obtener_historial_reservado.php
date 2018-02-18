<?php
/**
 * Obtiene todas las historias de la base de datos
 */

require 'Historial.php';

if ($_SERVER['REQUEST_METHOD'] == 'GET') {

    // Manejar petición GET
    $historial = Historial::getAllReservado();

    if ($historial) {

        $datos["estado"] = 1;
        $datos["historial"] = $historial;

        print json_encode($datos);
    } else {
        print json_encode(array(
            "estado" => 2,
            "mensaje" => "Ha ocurrido un error"
        ));
    }
}

