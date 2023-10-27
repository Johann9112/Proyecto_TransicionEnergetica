package com.example.sunstream;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

public class categorias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        // Imagen de canchas
        ImageView ivCanchas = findViewById(R.id.iv_canchas);
        ivCanchas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(categorias.this, registro_data.class);
                startActivity(intent);
            }
        });

        // Imagen de parques
        ImageView ivParques = findViewById(R.id.iv_parques);
        ivParques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(categorias.this, registro_data.class);
                startActivity(intent);
            }
        });

        // Imagen de colegios
        ImageView ivColegios = findViewById(R.id.iv_colegios);
        ivColegios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(categorias.this, registro_data.class);
                startActivity(intent);
            }
        });
    }
}
