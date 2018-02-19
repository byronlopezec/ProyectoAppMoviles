package com.example.bt.proyectoappmoviles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class RegistroResultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_resultado);

        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);

        TextView id_resultado = (TextView) findViewById(R.id.id_resultado);


        id_resultado.setText(message);


    }

    public void clickInformacion(View view){

        Intent intent = new Intent(this,Informacion.class);

        startActivity(intent);

    }
}
