<?php
/**
 * Obtiene el detalle de una visita especificado por
 * su identificador "idVisita"
 */

require 'Visita.php';

if ($_SERVER['REQUEST_METHOD'] == 'GET') {

    if (isset($_GET['idVisita'])) {

        // Obtener parámetro idVisita
        $parametro = $_GET['idVisita'];

        // Tratar retorno
        $retorno = Visita::getById($parametro);


        if ($retorno) {

            $visita["estado"] = 1;		// cambio "1" a 1 porque no coge bien la cadena.
            $visita["visita"] = $retorno;
            // Enviar objeto json del visita
            print json_encode($visita);
        } else {
            // Enviar respuesta de error general
            print json_encode(
                array(
                    'estado' => '2',
                    'mensaje' => 'No se obtuvo el registro'
                )
            );
        }

    } else {
        // Enviar respuesta de error
        print json_encode(
            array(
                'estado' => '3',
                'mensaje' => 'Se necesita un identificador'
            )
        );
    }
}