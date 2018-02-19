package com.example.bt.proyectoappmoviles;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class Informacion extends AppCompatActivity {

    Button btn,btn2,btn3,btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        btn = (Button) findViewById(R.id.btnDescripcion);
        btn2 = (Button) findViewById(R.id.btnExpo);
        btn3 = (Button) findViewById(R.id.btnMultimedia);
        btn4 = (Button) findViewById(R.id.btnInfo);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn = new Intent (Informacion.this, Descripcion.class);
                startActivity(btn);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn2 = new Intent (Informacion.this, Exposiciones.class);
                startActivity(btn2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn3 = new Intent (Informacion.this, Multimedia.class);
                startActivity(btn3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn4 = new Intent (Informacion.this, MasInfo.class);
                startActivity(btn4);
            }
        });

    }
}
