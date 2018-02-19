package com.example.bt.proyectoappmoviles;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by bt on 18/02/2018.
 */

public class WebServiceDatabase extends AsyncTask<String,Void,String> {

    public String resultado="" ;


    @Override
    protected String doInBackground(String... params) {

        String cadena = params[0];
        URL url = null; // Url de donde queremos obtener información
        String devuelve ="";

        if(params[1]=="1"){    // Consulta de todos los alumnos

            try {

                url = new URL(cadena);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //Abrir la conexión
                connection.setRequestProperty("User-Agent", "Mozilla/58 (Linux; Android 3.0.1; es-ES) Ejemplo HTTP");

                int respuesta = connection.getResponseCode();
                StringBuilder result = new StringBuilder();


                if (respuesta == HttpURLConnection.HTTP_OK){


                    InputStream in = new BufferedInputStream(connection.getInputStream());  // preparo la cadena de entrada


                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));  // la introduzco en un BufferedReader

                    // El siguiente proceso lo hago porque el JSONOBject necesita un String y tengo
                    // que tranformar el BufferedReader a String. Esto lo hago a traves de un
                    // StringBuilder.

                    String line;
                    while ((line = reader.readLine()) != null) {
                        result.append(line);        // Paso toda la entrada al StringBuilder
                    }
                    //Creamos un objeto JSONObject para poder acceder a los atributos (campos) del objeto.
                    JSONObject respuestaJSON = new JSONObject(result.toString());   //Creo un JSONObject a partir del StringBuilder pasado a cadena
                    //Accedemos al vector de resultados
                    String resultJSON = respuestaJSON.getString("estado");   // estado es el nombre del campo en el JSON

                    if (resultJSON.equals("1")){      // hay visitas a mostrar

                        JSONArray visitaJSON = respuestaJSON.getJSONArray("visita");   // estado es el nombre del campo en el JSON

                        for(int i=0;i<visitaJSON.length();i++){

                            devuelve = devuelve +
                                    visitaJSON.getJSONObject(i).getString("idVisita") + " " +
                                    visitaJSON.getJSONObject(i).getString("nombre") + " " +
                                    visitaJSON.getJSONObject(i).getString("fecha_visita") + " " +
                                    visitaJSON.getJSONObject(i).getString("hora_visita") + " " +
                                    visitaJSON.getJSONObject(i).getString("numero_visitantes") + " " +
                                    visitaJSON.getJSONObject(i).getString("telefono") + "\n";

                        }

                    }
                    else if (resultJSON=="2"){
                        devuelve = "No hay visitas";
                        Log.d(" devuelve: ",devuelve+"");
                    }
                    Log.d(" devuelve: ",devuelve+"");
                }


            } catch (MalformedURLException e) {
                Log.d("MalformedURLException: ",e.getMessage());
                e.printStackTrace();
            } catch (IOException e) {
                Log.d("IOException: ",e.getMessage());
                e.printStackTrace();
            } catch (JSONException e) {
                Log.d("JSONException: ",e.getMessage());
                e.printStackTrace();
            }

            return devuelve;


        }
        else if(params[1]=="3"){    // insert

            try {
                HttpURLConnection urlConn;

                DataOutputStream printout;
                DataInputStream input;
                url = new URL(cadena);
                urlConn = (HttpURLConnection) url.openConnection();
                urlConn.setDoInput(true);
                urlConn.setDoOutput(true);
                urlConn.setUseCaches(false);
                urlConn.setRequestProperty("Content-Type", "application/json");
                urlConn.setRequestProperty("Accept", "application/json");
                urlConn.connect();

                //Creo el Objeto JSON
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("nombre", params[2]);
                jsonParam.put("fecha_visita", params[3]);
                jsonParam.put("hora_visita", params[4]);
                jsonParam.put("numero_visitantes", params[5]);
                jsonParam.put("telefono", params[6]);

                // Envio los parámetros post.
                OutputStream os = urlConn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(jsonParam.toString());
                writer.flush();
                writer.close();

                int respuesta = urlConn.getResponseCode();


                StringBuilder result = new StringBuilder();

                if (respuesta == HttpURLConnection.HTTP_OK) {

                    String line;
                    BufferedReader br=new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
                    while ((line=br.readLine()) != null) {
                        result.append(line);
                        //response+=line;
                    }

                    //Creamos un objeto JSONObject para poder acceder a los atributos (campos) del objeto.
                    JSONObject respuestaJSON = new JSONObject(result.toString());   //Creo un JSONObject a partir del StringBuilder pasado a cadena
                    //Accedemos al vector de resultados

                    String resultJSON = respuestaJSON.getString("estado");   // estado es el nombre del campo en el JSON

                    if (resultJSON == "1") {      // hay una visita que mostrar
                        devuelve = "Visita ingresada correctamente";

                    } else if (resultJSON == "2") {
                        devuelve = "La visita no se pudo registrar!!!";
                    }

                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return devuelve;
        }

        return null;
    }

    @Override
    protected void onCancelled(String s) {
        super.onCancelled(s);
    }

    @Override
    protected void onPostExecute(String s) {
        Log.d("on Post Execute : ",s);
        resultado= s;
        //super.onPostExecute(s);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}

