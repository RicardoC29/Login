package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class MainActivity extends AppCompatActivity {

    TextView txRegistrar;
    Button btnInicio;
    SQLite_OpenHelper helper = new SQLite_OpenHelper(this,"BD1", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txRegistrar=(TextView)findViewById(R.id.btnCrearCuenta);

        txRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),registro.class);

                startActivity(i);

            }
        });

        btnInicio= findViewById(R.id.btnLogin);
        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtusu=(EditText)findViewById(R.id.editTextEmail);
                EditText txtcontra=(EditText)findViewById(R.id.ediTextPassword);

                Cursor cursor=helper.ConsultarUsuario(txtusu.getText().toString(),
                        txtcontra.getText().toString());

                if(cursor.getCount()>0){
                    Intent i = new Intent(getApplicationContext(),Principal.class);

                    startActivity(i);

                }else{
                    Toast.makeText(getApplicationContext(),"Usuario y/o pas incorrecto", Toast.LENGTH_LONG).show();

                }

                txtusu.setText("");
                txtcontra.setText("");




            }
        });
    }
}