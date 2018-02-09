package com.example.bt.proyectoappmoviles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mostrarVistaRegistroVisita(View view) {
// Código a ejecutarse en respuesta al botón Send
        Intent intent = new Intent(this,
                RegistroVisita.class);
        // EditText editText = (EditText) findViewById(R.id.editText); para extraer informacion de esa parte
        //String message = editText.getText().toString();//convertir en un string lo que esta en editTExt
        //intent.putExtra(EXTRA_MESSAGE, message); //enviar lo que esta en ese texto a la otra actividad
        startActivity(intent);
    }
}
