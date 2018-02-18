<?php
/**
 * Obtiene todas las Visita de la base de datos
 */

require 'Visita.php';

if ($_SERVER['REQUEST_METHOD'] == 'GET') {

    // Manejar petición GET
    $visita = Visita::getAll();

    if ($visita) {

        $datos["estado"] = 1;
        $datos["visita"] = $visita;

        print json_encode($datos);
    } else {
        print json_encode(array(
            "estado" => 2,
            "mensaje" => "Ha ocurrido un error"
        ));
    }
}

