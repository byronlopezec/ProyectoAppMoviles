<?php

/**
 * Representa el la estructura de las Alumnoss
 * almacenadas en la base de datos
 */
require 'Database.php';

class Visita
{
    function __construct()
    {
    }

    /*
     * Retorna en la fila especificada de la tabla 'Alumnos'
     * @param $idAlumno Identificador del registro
     * @return array Datos del registro
     */
    public static function getAll()
    {
        $consulta = "SELECT * FROM visita";
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

    /**
     * Obtiene los campos de un Alumno con un identificador
     * determinado
     *
     * @param $idAlumno Identificador del alumno
     * @return mixed
     */
	 
    public static function getById($idVisita)
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
	
	
	/**
     * Insertar una nueva Visita
     * @return PDOStatement
     */
    public static function insert($nombre,$fecha_visita,$hora_visita,$numero_visitantes,$telefono)
    {
        // Sentencia INSERT
        $comando = "INSERT INTO Visita ( " .
            "nombre," .
			"fecha_visita," .
			"hora_visita," .
			"numero_visitantes," .
            " telefono)" .
            " VALUES( ?,?,?,?,?)";

        // Preparar la sentencia
        $sentencia = Database::getInstance()->getDb()->prepare($comando);

        return $sentencia->execute(
            array(
                $nombre,
				$fecha_visita,
				$hora_visita,
				$numero_visitantes,
				$telefono
            )
        );

    }
	 
}

?>