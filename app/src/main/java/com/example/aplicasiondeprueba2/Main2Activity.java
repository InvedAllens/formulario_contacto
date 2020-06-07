package com.example.aplicasiondeprueba2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;
    private TextView tvFechaDeNacimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String Nombre= getIntent().getStringExtra("nombre");
        String Telefono= getIntent().getStringExtra("telefono");
        String Descripcion= getIntent().getStringExtra("descripcion");
        String Email= getIntent().getStringExtra("correo");
        String Fecha=getIntent().getStringExtra("fecha");
        tvNombre =findViewById(R.id.tvNombre);
        tvNombre.setText(Nombre);
        tvTelefono =findViewById(R.id.tvTelefono);
        tvTelefono.setText(Telefono);
        tvEmail =findViewById(R.id.tvMostrarEmail);
        tvEmail.setText(Email);
        tvDescripcion =findViewById(R.id.tvMostrarDescripcion);
        tvDescripcion.setText(Descripcion);
        tvFechaDeNacimiento=findViewById(R.id.tvMostrarFechaNacimiento);
        tvFechaDeNacimiento.setText(Fecha);

    }
    public void editarFor(View view){
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra( "nombre" , tvNombre.getText().toString());
        i.putExtra( "telefono" , tvTelefono.getText().toString());
        i.putExtra( "descripcion" , tvDescripcion.getText().toString());
        i.putExtra( "correo" , tvEmail.getText().toString());
        i.putExtra( "fecha" , tvFechaDeNacimiento.getText().toString());
        startActivity(i);
        finish();

    }
}
