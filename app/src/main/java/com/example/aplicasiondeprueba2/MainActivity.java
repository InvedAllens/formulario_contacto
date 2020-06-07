package com.example.aplicasiondeprueba2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText etNombre;
    private EditText etTelefono;
    private EditText etDescripcion;
    private EditText etEmail;
    private DatePicker dpFechaNacimiento;

    private EditText etFechaDeNacimiento;
    private Button btnAceptar;
    private Button btnCancelar;

    private LinearLayout componenteFecha;
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String Nombre= getIntent().getStringExtra("nombre");
        String Telefono= getIntent().getStringExtra("telefono");
        String Descripcion= getIntent().getStringExtra("descripcion");
        String Email= getIntent().getStringExtra("correo");
        String Fecha= getIntent().getStringExtra("fecha");
        etNombre = findViewById(R.id.etNombre);
        etNombre.setText(Nombre);
        etFechaDeNacimiento=findViewById(R.id.etFechaNacimiento);
        etFechaDeNacimiento.setText(Fecha);
        etTelefono = findViewById(R.id.etTelefono);
        etTelefono.setText(Telefono);
        etEmail=findViewById(R.id.etEmail);
        etEmail.setText(Email);
        etDescripcion=findViewById(R.id.etDescripcionContacto);
        etDescripcion.setText(Descripcion);
        dpFechaNacimiento=findViewById(R.id.dpFechaNacimiento);
        btnAceptar=findViewById(R.id.btnAceptar);
        btnCancelar=findViewById(R.id.btnCancelar);
        componenteFecha=findViewById(R.id.parteFecha);

        if(etFechaDeNacimiento.getText().length()!= 0){
            componenteFecha.setVisibility(View.GONE);
            etFechaDeNacimiento.setVisibility(View.VISIBLE);


        }
        etFechaDeNacimiento.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                componenteFecha.setVisibility(View.VISIBLE);
                etFechaDeNacimiento.setVisibility(View.GONE);

            }
        });
        //comienza codigo de la fecha

        mDisplayDate=(TextView)findViewById(R.id.etFechaNacimiento);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal=Calendar.getInstance();
                int year =cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog= new DatePickerDialog(
                  MainActivity.this,
                  android.R.style.Theme_Black,
                  mDateSetListener,
                  year,month,day);
              //  dialog.getWindow().setBackgroundDrawble(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date =month +"/"+dayOfMonth+"/"+year;
                mDisplayDate.setText(date);
            }
        };
    //parte de la no fecha

    }
    public void enviarFor(View view){
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra( "nombre" , etNombre.getText().toString());
        i.putExtra( "telefono" , etTelefono.getText().toString());
        i.putExtra( "descripcion" , etDescripcion.getText().toString());
        i.putExtra( "correo" , etEmail.getText().toString());
        i.putExtra("fecha",etFechaDeNacimiento.getText().toString());
        startActivity(i);

    }
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
    public void establecerFecha(View v){
        int mes=dpFechaNacimiento.getMonth()+1;
        String fecha=dpFechaNacimiento.getDayOfMonth() +"/"+mes+"/"+dpFechaNacimiento.getYear();
        etFechaDeNacimiento.setText(fecha);
        etFechaDeNacimiento.setVisibility(View.VISIBLE);
        componenteFecha.setVisibility(View.GONE);
    }
    public  void launchFecha(View v){
        componenteFecha.setVisibility(View.VISIBLE);
        etFechaDeNacimiento.setVisibility(View.GONE);

    }
    public void cancelarFecha(View view) {
        etFechaDeNacimiento.setVisibility(View.VISIBLE);
        componenteFecha.setVisibility(View.GONE);
    }
}
