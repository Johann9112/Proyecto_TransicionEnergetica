package com.example.sunstream;

import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Thread.sleep;

import android.graphics.Color;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.sunstream.modelos.Usuario;
import com.google.android.material.textfield.TextInputLayout;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class registro_usuario extends AppCompatActivity {

    Button btnregistro;
    EditText etnombre, etcorreo, ettelefono, etcontraseña1, etcontraseña2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        btnregistro = findViewById(R.id.btn_registrar);
        etnombre = findViewById(R.id.et_nombre_completo);
        etcorreo = findViewById(R.id.et_email);
        ettelefono = findViewById(R.id.et_telefono);
        etcontraseña1 = findViewById(R.id.et_contraseña_registro);
        etcontraseña2 = findViewById(R.id.et_confirmar_contraseña);

        Intent home = new Intent(getApplicationContext(), home.class);
        btnregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarUsuario()) {
                    Usuario usuario = crearUsuario();
                    almacenarUsuario(usuario);
                    Toast.makeText(getApplicationContext(), "Registro Exitoso", Toast.LENGTH_LONG).show();
                    try {
                        sleep(500);
                        startActivity(home);
                        finish();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Asegurarse de que la información esté correcta", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public String idGenerator(String nombre) {
        String id = "";
        for (int i = 0; i < 2; i++) {
            int random1 = (int) (Math.random() * nombre.length());
            int random2 = (int) (Math.random() * 10000);
            id += nombre.charAt(random1);
            id += random2;
        }
        return id;
    }

    public Usuario crearUsuario() {
        String nombre_usuario = etnombre.getText().toString();
        String id = idGenerator(nombre_usuario);
        String correo_usuario = etcorreo.getText().toString();
        String telefono_usuario = ettelefono.getText().toString();
        String contraseña = etcontraseña1.getText().toString();

        Usuario usuario = new Usuario(id, nombre_usuario, correo_usuario, telefono_usuario, contraseña);

        return usuario;
    }

    public boolean validarUsuario() {
        boolean state = true;

        if (etnombre.getText().toString().isEmpty()) {
            etnombre.setHintTextColor(Color.RED);
            state = false;
        }
        if (etcorreo.getText().toString().isEmpty()) {
            etcorreo.setHintTextColor(Color.RED);
            state = false;
        }
        if (ettelefono.getText().toString().isEmpty()) {
            ettelefono.setHintTextColor(Color.RED);
            state = false;
        }
        if (etcontraseña1.getText().toString().isEmpty()) {
            etcontraseña1.setHintTextColor(Color.RED);
            state = false;
        }
        if (etcontraseña2.getText().toString().isEmpty()) {
            etcontraseña2.setHintTextColor(Color.RED);
            state = false;
        }
        if (!etcontraseña1.getText().toString().equals(etcontraseña2.getText().toString())) {
            etcontraseña1.setHintTextColor(Color.RED);
            etcontraseña2.setHintTextColor(Color.RED);
            state = false;
        }

        return state;
    }

    public void almacenarUsuario(Usuario usuario) {
        File fileUsuario = new File(getFilesDir(), "Usuario.txt");

        try {
            FileWriter writer = new FileWriter(fileUsuario, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(usuario.getIdUsuario() + "," +
                    usuario.getNombre() + "," +
                    usuario.getCorreo() + "," +
                    usuario.getTelefono() + "," +
                    usuario.getContraseña()
            );
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}
