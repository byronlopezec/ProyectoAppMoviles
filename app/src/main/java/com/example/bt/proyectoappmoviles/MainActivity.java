package com.example.bt.proyectoappmoviles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btnReserva);

        //listener click para llamar a la activdad Informacion
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn = new Intent(MainActivity.this, Informacion.class);
                startActivity(btn);
            }
        });

        //listener click para llamar a la activdad RegistroVisita
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn2 = new Intent(MainActivity.this, RegistroVisita.class);
                startActivity(btn2);
            }
        });

    }

}
