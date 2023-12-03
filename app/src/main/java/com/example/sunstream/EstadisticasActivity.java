package com.example.sunstream;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EstadisticasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        Intent intent = getIntent();
        if (intent != null) {
            String nombre = intent.getStringExtra("nombre");
            String ubicacion = intent.getStringExtra("ubicacion");
            double capacidad = intent.getDoubleExtra("capacidad", 0);
            String tipoModulo = intent.getStringExtra("tipoModulo");
            int numeroPaneles = intent.getIntExtra("numeroPaneles", 0);
            String inversor = intent.getStringExtra("inversor");
            String fechaInstalacion = intent.getStringExtra("fechaInstalacion");

            mostrarDatosEnTabla(nombre, ubicacion, capacidad, tipoModulo, numeroPaneles, inversor, fechaInstalacion);
        } else {
            Toast.makeText(this, "Error: No se pudieron recuperar los datos", Toast.LENGTH_SHORT).show();
        }

        Button btnPromedios = findViewById(R.id.btn_promedios);
        Button btnMaximo = findViewById(R.id.btn_maximo);

        btnPromedios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double promedio = calcularPromedio(capacidad, numeroPaneles);
