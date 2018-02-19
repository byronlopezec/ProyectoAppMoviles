<?php

/**
 * Representa el la estructura de los dias disponibles
 * almacenadas en la base de datos
 */
require 'Database.php';

class Historial
{
    function __construct()
    {
    }

    /**
     * Retorna en la fila especificada de la tabla 'Reservados'
     
	 
     * @return array Datos del registro
     */
     public static function getFechaVisitaReservada($fecha_visita)
    {
        // Consulta de la tabla Alumnos
        $consulta = "SELECT idVisita,
                            nombre,
                            fecha_visita,
							hora_visita,
							numero_visitantes,
							telefono
                             FROM visita
                             WHERE idVisita = ?";

        try {
            // Preparar sentencia
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            // Ejecutar sentencia preparada
            $comando->execute(array($idVisita));
            // Capturar primera fila del resultado
            $row = $comando->fetch(PDO::FETCH_ASSOC);
            return $row;

        } catch (PDOException $e) {
            // Aquí puedes clasificar el error dependiendo de la excepción
            // para presentarlo en la respuesta Json
            return -1;
        }
    }
	 
}

?>