<?php

/**
 * Representa el la estructura de las Alumnoss
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
     *
     * @param $idAlumno Identificador del registro
     * @return array Datos del registro
     */
    public static function getAllReservado()
    {
        $consulta = "SELECT * FROM historial where estado="reservado"";
        try {
            // Preparar sentencia
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            // Ejecutar sentencia preparada
            $comando->execute();

            return $comando->fetchAll(PDO::FETCH_ASSOC);

        } catch (PDOException $e) {
            return false;
        }
    }
	 
}

?>