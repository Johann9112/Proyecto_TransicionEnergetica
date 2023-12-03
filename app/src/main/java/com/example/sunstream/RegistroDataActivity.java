package com.example.sunstream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class estadisticas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);
    }
}

        import androidx.appcompat.app.AppCompatActivity;
                import android.content.Intent;
                import android.os.Bundle;
                import android.view.View;
                import android.widget.Button;
                import android.widget.TextView;
                import android.widget.Toast;

public class EstadisticasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        // Recuperar datos del Intent
        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String ubicacion = intent.getStringExtra("ubicacion");
        double capacidad = intent.getDoubleExtra("capacidad", 0);
        String tipoModulo = intent.getStringExtra("tipoModulo");
        int numeroPaneles = intent.getIntExtra("numeroPaneles", 0);
        String inversor = intent.getStringExtra("inversor");
        String fechaInstalacion = intent.getStringExtra("fechaInstalacion");

        // Mostrar datos en TextViews
        mostrarDatosEnTabla(nombre, ubicacion, capacidad, tipoModulo, numeroPaneles, inversor, fechaInstalacion);

        Button btnPromedios = findViewById(R.id.btn_promedios);
        Button btnMaximo = findViewById(R.id.btn_maximo);

        btnPromedios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Calcular y mostrar el promedio
                double promedio = calcularPromedio(capacidad, numeroPaneles);
                mostrarResultado("Promedio: " + promedio);
            }
        });

        btnMaximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Calcular y mostrar el máximo
                double maximo = calcularMaximo(capacidad, numeroPaneles);
                mostrarResultado("Máximo: " + maximo);
            }
        });
    }

    private void mostrarDatosEnTabla(String nombre, String ubicacion, double capacidad, String tipoModulo,
                                     int numeroPaneles, String inversor, String fechaInstalacion) {
        TextView tvNombre = findViewById(R.id.tv_nombre);
        TextView tvUbicacion = findViewById(R.id.tv_ubicacion);
        TextView tvCapacidad = findViewById(R.id.tv_capacidad);
        TextView tvTipoModulo = findViewById(R.id.tv_tipo_modulo);
        TextView tvNumeroPaneles = findViewById(R.id.tv_numero_paneles);
        TextView tvInversor = findViewById(R.id.tv_inversor);
        TextView tvFechaInstalacion = findViewById(R.id.tv_fecha_instalacion);

        tvNombre.setText("Nombre: " + nombre);
        tvUbicacion.setText("Ubicación: " + ubicacion);
        tvCapacidad.setText("Capacidad: " + capacidad);
        tvTipoModulo.setText("Tipo de Módulo: " + tipoModulo);
        tvNumeroPaneles.setText("Número de Paneles: " + numeroPaneles);
        tvInversor.setText("Inversor: " + inversor);
        tvFechaInstalacion.setText("Fecha de Instalación: " + fechaInstalacion);
    }

    private double calcularPromedio(double capacidad, int numeroPaneles) {
        return capacidad * numeroPaneles;
    }

    private double calcularMaximo(double capacidad, int numeroPaneles) {
        return capacidad * numeroPaneles;
    }

    private void mostrarResultado(String resultado) {
        Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
    }
}
