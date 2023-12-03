package com.example.sunstream;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sunstream.modelos.Usuario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class login extends AppCompatActivity {

    Button btnLogin, btnRegister;
    EditText etUsuario, etContraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_ingresar_login);
        etUsuario = findViewById(R.id.et_usuario);
        etContraseña = findViewById(R.id.et_contraseña);

        File fileReader = new File(getFilesDir(), "Usuario.txt");

        ArrayList<Usuario> usuariosList = listUsuarios(fileReader);

        Intent home = new Intent(getApplicationContext(), com.example.sunstream.home.class);
        Intent registrarUsuario = new Intent(getApplicationContext(), registro_usuario.class);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean state = false;
                if (etUsuario.getText().toString().isEmpty() || etContraseña.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Ambos campos deben estar diligenciados", Toast.LENGTH_LONG).show();
                } else {
                    for (Usuario i : usuariosList) {
                        if (i.getNombre().equals(etUsuario.getText().toString()) || i.getCorreo().equals(etUsuario.getText().toString()) ||
                                i.getTelefono().equals(etUsuario.getText().toString())) {
                            state = true;
                            if (i.getContraseña().equals(etContraseña.getText().toString())) {
                                home.putExtra("idUsuario", i.getIdUsuario());

                                Toast.makeText(getApplicationContext(), "Los datos son correctos", Toast.LENGTH_LONG).show();
                                try {
                                    sleep(500);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                startActivity(home);
                                break;
                            } else {
                                Toast.makeText(getApplicationContext(), "La contraseña es incorrecta", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                    if (!state) {
                        Toast.makeText(getApplicationContext(), "Este usuario no está registrado", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        btnRegister = findViewById(R.id.btn_registrarse);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(registrarUsuario);
            }
        });

        Button btnRecordarContraseña = findViewById(R.id.btn_recordar_contraseña);
        btnRecordarContraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, recordar_pass.class);
                startActivity(intent);
            }
        });
    }

    public ArrayList<Usuario> listUsuarios(File fileUsuario) {
        ArrayList<Usuario> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileUsuario);
            BufferedReader reader = new BufferedReader(fileReader);
            String usuario;

            while ((usuario = reader.readLine()) != null) {
                String[] usuarioArray = usuario.split(",");
                String id = usuarioArray[0];
                String nombre = usuarioArray[1];
                String correo = usuarioArray[2];
                String telefono = usuarioArray[3];
                String contraseña = usuarioArray[4];

                Usuario usuarioObj = new Usuario(id, nombre, telefono, correo, contraseña);
                list.add(usuarioObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
