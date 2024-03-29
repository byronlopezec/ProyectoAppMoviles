<?php
if($_SERVER['REQUEST_METHOD']=='POST'){
$id = $_POST['id'];
}
//Recuperar el id enviado por el mensaje POST
if(strcasecmp($_SERVER['REQUEST_METHOD'], 'POST') != 0){
 throw new Exception('Request method must be POST!');
}
//Asegurarse de que es un mensaje POST.
require_once 'login.php';

//llama al archivo con los datos para la conexión a MySQL y a la base de datos
header ('Content-type: text/html; charset=utf-8');

//definir el juego de caracteres a utilizarse
$db_conn = mysqli_connect($db_hostname, $db_username, $db_password,$db_database);

//Conexión con la base de datos de MySQL en base a los datos declarados en login.php
if (!$db_conn) die("Unable to connect to MySQL: " . mysql_error());

//Verificación de conexión con la base de datos de MySQL
$query = "SELECT * FROM contactos WHERE id = '$id'";

//Establece la consulta a realizar para la base de datos con el id recuperado del mensaje
$result = mysqli_query($db_conn, $query);

//Realiza la consula a la base de datos
$rawdata = array();

//Definición de un arreglo para almacenar los resultados de la consulta
while($row = mysqli_fetch_assoc($result))
 {
		$rawdata['contactos'][] = $row;
 }
//Almacenar los elementos recuperados en el arreglo
echo json_encode($rawdata, 128);
//Publicación de los resultados en formato JSON
?>