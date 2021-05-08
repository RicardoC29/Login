package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class registro extends AppCompatActivity {

    Button btnRegistro;
    EditText txtNombre, txtCorreo, txtContra;
    SQLite_OpenHelper helper=new SQLite_OpenHelper(this, "BD1", null,1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnRegistro=(Button) findViewById(R.id.btnRegister);
        txtNombre=(EditText) findViewById(R.id.editTextName);
        txtCorreo=(EditText) findViewById(R.id.editTextEmail);
        txtContra=(EditText) findViewById(R.id.ediTextPassword);


        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.abrirBD();
                helper.insertar(String.valueOf(txtNombre.getText()),
                        String.valueOf(txtCorreo.getText()),
                        String.valueOf(txtContra.getText()));


                helper.cerrar();

                Toast.makeText(getApplicationContext(),"Registro exitoso", Toast.LENGTH_LONG).show();

                Intent i = new Intent(getApplicationContext(),MainActivity.class);

                startActivity(i);
            }
        });



    }
}