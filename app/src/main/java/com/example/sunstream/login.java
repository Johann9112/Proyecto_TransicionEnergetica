package com.example.sunstream;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;


public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

// Botón para ingresar
        Button btnIngresarLogin = findViewById(R.id.btn_ingresar_login);
        btnIngresarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, home.class);
                startActivity(intent);
            }
        });

        // Botón para registrarse
        Button btnRegistrarse = findViewById(R.id.btn_registrarse);
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, registro_usuario.class);
                startActivity(intent);
            }
        });

        // Botón para recordar contraseña
        Button btnRecordarContraseña = findViewById(R.id.btn_recordar_contraseña);
        btnRecordarContraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, recordar_pass.class);
                startActivity(intent);
            }
        });

    }
}