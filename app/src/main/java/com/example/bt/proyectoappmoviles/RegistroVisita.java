package com.example.bt.proyectoappmoviles;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import java.util.Calendar;

public class RegistroVisita extends AppCompatActivity implements View.OnClickListener {
    private static final String CERO = "0";
    private static final String DOS_PUNTOS = ":";
    private static final String BARRA = "/";
    private Spinner spinner1;
    //Calendario para obtener fecha & hora
    public final Calendar c = Calendar.getInstance();

    //Fecha
    final int mes = c.get(Calendar.MONTH);
    final int dia = c.get(Calendar.DAY_OF_MONTH);
    final int anio = c.get(Calendar.YEAR);

    //Hora
    final int hora = c.get(Calendar.HOUR_OF_DAY);
    final int minuto = c.get(Calendar.MINUTE);

    //Widgets
    EditText etFecha, etHora;
    ImageButton ibObtenerFecha, ibObtenerHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_visita);

        etFecha = (EditText) findViewById(R.id.id_text_fecha_visita);
        etHora = (EditText) findViewById(R.id.id_text_hora_visita);

        ibObtenerFecha = (ImageButton) findViewById(R.id.ib_obtener_fecha);
        ibObtenerHora = (ImageButton) findViewById(R.id.ib_obtener_hora);

        ibObtenerFecha.setOnClickListener(this);
        ibObtenerHora.setOnClickListener(this);

        addItemsOnSpinner1();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_obtener_fecha:
                obtenerFecha();
                break;
            case R.id.ib_obtener_hora:
                obtenerHora();
                break;
        }
    }

    private void obtenerFecha(){
        DatePickerDialog recogerFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                final int mesActual = month + 1;

                String diaFormateado = (dayOfMonth < 10)? CERO + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                String mesFormateado = (mesActual < 10)? CERO + String.valueOf(mesActual):String.valueOf(mesActual);

                etFecha.setText(diaFormateado + BARRA + mesFormateado + BARRA + year);


            }
        },anio, mes, dia);

        recogerFecha.show();

    }

    private void obtenerHora(){
        TimePickerDialog recogerHora = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                String horaFormateada =  (hourOfDay < 9)? String.valueOf(CERO + hourOfDay) : String.valueOf(hourOfDay);
                String minutoFormateado = (minute < 9)? String.valueOf(CERO + minute):String.valueOf(minute);

                String AM_PM;
                if(hourOfDay < 12) {
                    AM_PM = "a.m.";
                } else {
                    AM_PM = "p.m.";
                }

                etHora.setText(horaFormateada + DOS_PUNTOS + minutoFormateado + " " + AM_PM);
            }

        }, hora, minuto, false);

        recogerHora.show();
    }


    public void addItemsOnSpinner1() {
        spinner1 = (Spinner) findViewById(R.id.id_spinner_numero_visitas);
        List<String> list = new ArrayList<String>();

        list.add("Numeros Visitantes");
        for(int i =1; i<10;i++)
            list.add(i+"");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
    }

    public void guardarVisita(View view) {

        Intent intent = new Intent(this,RegistroResultado.class);

        EditText et_nombre = (EditText) findViewById(R.id.id_text_nombre); //para extraer informacion de esa parte
        EditText et_fecha_visita = (EditText) findViewById(R.id.id_text_fecha_visita); //para extraer informacion de esa parte
        Spinner sp_numero_visitas = (Spinner) findViewById(R.id.id_spinner_numero_visitas); //para extraer informacion de esa parte
        EditText et_hora_visita = (EditText) findViewById(R.id.id_text_hora_visita); //para extraer informacion de esa parte
        EditText et_telefono = (EditText) findViewById(R.id.id_textTelefono); //para extraer informacion de esa parte


        String nombre = et_nombre.getText().toString();//convertir en un string lo que esta en editTExt
        String fecha_visita = et_fecha_visita.getText().toString();//convertir en un string lo que esta en editTExt
        String hora_visita = et_hora_visita.getText().toString();//convertir en un string lo que esta en editTExt
        String numero_visitas = sp_numero_visitas.getSelectedItem().toString();//convertir en un string lo que esta en editTExt
        String telefono = et_telefono.getText().toString();//convertir en un string lo que esta en editTExt

        String message = "Registro Guardado con éxito";
        intent.putExtra(EXTRA_MESSAGE, message); //enviar lo que esta en ese texto a la otra actividad



        String INSERT = "localhost/insertar_visita.php";
        WebServiceDatabase conexionWebService = new WebServiceDatabase();
        conexionWebService.execute(INSERT,"3",
                nombre,
                fecha_visita,
                numero_visitas,
                hora_visita,
                telefono);   // Parámetros que recibe doInBackground
        startActivity(intent);
    }
    /*
     *
     * */



}