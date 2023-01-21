package com.example.unit8;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class MainActivity03 extends AppCompatActivity {

    private TextInputLayout controlNombre;
    private EditText campoNombre;
    private Button botonAceptar;

    private TextInputLayout controlCorreo;
    private EditText campoCorreo;

    private TextInputLayout controlTlf;
    private EditText campoTlf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main03);
    //PARTE 5 - Nombre
        controlNombre=(TextInputLayout) findViewById(R.id.textInputLayout_nombre);
        campoNombre=(EditText) findViewById(R.id.campo_nombre);
        campoNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                controlNombre.setError(null);
                esNombreValido(String.valueOf(charSequence));
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        botonAceptar=(Button) findViewById(R.id.button_aceptar);
        botonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarDatos();
            }
        });
        //PARTE 5 -Correo
        controlCorreo=(TextInputLayout) findViewById(R.id.textInputLayout_correo);
        campoCorreo=(EditText) findViewById(R.id.campo_correo);
        campoCorreo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                controlCorreo.setError(null);
                esCorreoValido(String.valueOf(charSequence));
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        //PARTE 5 -Tlf
        controlTlf=(TextInputLayout) findViewById(R.id.textInputLayout_correo);
        campoTlf=(EditText) findViewById(R.id.campo_tlf);
        campoTlf.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                controlTlf.setError(null);
                esTlfValido(String.valueOf(charSequence));
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

    }

    private boolean esNombreValido(String nombre){
        Pattern patron=Pattern.compile("^[a-zA-Z ]+$");
        if(!patron.matcher(nombre).matches() || nombre.length()>30){
            controlNombre.setError("ERROR EN NOMBRE");
            return false;
        }else
            controlNombre.setError(null);
        return true;
    }
    private void validarDatos(){
        String nombre=controlNombre.getEditText().getText().toString();
        boolean a=esNombreValido(nombre);
        String correo=controlCorreo.getEditText().getText().toString();
        boolean b=esCorreoValido(correo);
        String tlf=controlCorreo.getEditText().getText().toString();
        boolean c=esCorreoValido(tlf);

        if(a && b && c)
            Toast.makeText(this, "REGISTRO CORRECTO",Toast.LENGTH_LONG).show();

    }

    private boolean esCorreoValido(String correo){
        if(!Patterns.EMAIL_ADDRESS.matcher(correo).matches()){
            controlCorreo.setError("ERROR EN CORREO");
            return false;
        }else
            controlCorreo.setError(null);
        return true;
    }

    private boolean esTlfValido(String tlf){
        if(!Patterns.PHONE.matcher(tlf).matches()){
            controlCorreo.setError("ERROR EN TELEFONO");
            return false;
        }else
            controlCorreo.setError(null);
        return true;
    }
}