package com.example.bt.proyectoappmoviles;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RegistroVisita extends AppCompatActivity {

    //Declara las siguientes variables
    private Calendar calendar;
    private TextView dateView;
    private TextView dateView_fin;
    private int year, month, day;
    // Variabla auxiliar para determinar si se trata de editar dateView Fin o Inicio
    private int num_textViewDate;


    //Spinner para el Estado del caso
    private Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registro_visita);

        dateView = (TextView) findViewById(R.id.id_text_fecha_visita);
        //dateView_fin = (TextView) findViewById(R.id.id_text_hora_visita);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        num_textViewDate =0;
        showDate(year, month+1, day);

        addItemsOnSpinner1();

    }

      /* crear un método setDate que será llamada al momento de dar clic en el botón
de nuestra actividad.*/

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        num_textViewDate = 0;
        showDialog(999);
        Toast.makeText(getApplicationContext(),"Fecha de Inicio",
                Toast.LENGTH_SHORT).show();


    }

    @SuppressWarnings("deprecation")
    public void setDate1(View view) {
        num_textViewDate = 1;
        showDialog(999);
        Toast.makeText(getApplicationContext(),"Fecha Fin",
                Toast.LENGTH_SHORT).show();

    }



    /*La ejecución del método anterior implica que el método onCreateDialog() será llamado automáticamente.
Es necesario entonces sobrecargar este método para que presente un dialogo tipo DatePicker cuando
reciba el código 999.*/
    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }


    /* crear un método que nos permita reaccionar ante la fecha seleccionada por el utilizador. */

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3)
                {
                    showDate(arg1, arg2+1, arg3);
                }
            };


    /* el método anterior va a llamar al método showDate() que actualizará la fecha del día
seleccionado en el cuadro de texto correspondiente. E*/

    private void showDate(int year, int month, int day) {

        if (num_textViewDate==0) {
            dateView.setText(new StringBuilder().append(day).append("/")
                    .append(month).append("/").append(year));
        }

        if (num_textViewDate==1) {
            dateView_fin.setText(new StringBuilder().append(day).append("/")
                    .append(month).append("/").append(year));
        }

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


    public void guardarCaso(View view) {

        DatabaseHandler db = new DatabaseHandler(this);

        //Intent intent = new Intent(this,ConsultaCasos.class);

        EditText editTextNombre = (EditText) findViewById(R.id.id_text_nombre); //para extraer informacion de esa parte
        String stringTextNombre = editTextNombre.getText().toString();//convertir en un string lo que esta en editTExt

        EditText editTextfecha_visita = (EditText) findViewById(R.id.id_text_fecha_visita); //para extraer informacion de esa parte
        String stringeditTextfecha_visita = editTextfecha_visita.getText().toString();//convertir en un string lo que esta en editTExt

        Spinner spinnerNumeroVisitas = (Spinner) findViewById(R.id.id_spinner_numero_visitas); //para extraer informacion de esa parte
        String stringTextNumeroVisitas = spinner1.getSelectedItem().toString();//convertir en un string lo que esta en editTExt


        EditText editTextHora_visita = (EditText) findViewById(R.id.id_text_hora_visita); //para extraer informacion de esa parte
        String stringeditHora_visita = editTextHora_visita.getText().toString();//convertir en un string lo que esta en editTExt

        EditText editTextTelefono = (EditText) findViewById(R.id.id_textTelefono); //para extraer informacion de esa parte
        String stringeditTelefono = editTextTelefono.getText().toString();//convertir en un string lo que esta en editTExt



        //intent.putExtra(EXTRA_MESSAGE, message); //enviar lo que esta en ese texto a la otra actividad
        db.addCaso(new Visita(stringTextNombre,stringeditTextfecha_visita,stringTextNumeroVisitas,stringeditHora_visita,stringeditTelefono));

       // startActivity(intent);
    }

}
