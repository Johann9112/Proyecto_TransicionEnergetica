package com.example.sunstream;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Botón para ir a la categoría
        Button btnCategorias = findViewById(R.id.btn_categorias);
        btnCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, categorias.class);
                startActivity(intent);
            }
        });

        // Botón para ir a estadísticas
        Button btnEstadisticas = findViewById(R.id.btn_estadisticas);
        btnEstadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, estadisticas.class);
                startActivity(intent);
            }
        });

        // Botón para ir a beneficios
        Button btnBeneficios = findViewById(R.id.btn_beneficios);
        btnBeneficios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, beneficios.class);
                startActivity(intent);
            }
        });
    }
}
