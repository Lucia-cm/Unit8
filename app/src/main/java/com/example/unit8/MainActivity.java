package com.example.unit8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar toolbar=(MaterialToolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }
    private void mensaje(int index){
        Toast.makeText(this, getText(index), Toast.LENGTH_SHORT).show();
    }

    public boolean onOptionsItemSelected(MenuItem item){
        boolean result;
        switch (item.getItemId()){
            case R.id.barra_nuevo: mensaje(R.string.cadena_barra_nuevo);
                return true;
            case R.id.barra_editar: mensaje(R.string.cadena_barra_editar);
                return true;
            case R.id.barra_configurar: mensaje(R.string.cadena_barra_configurar);
                return true;
            case R.id.barra_ayuda: mensaje(R.string.cadena_barra_ayuda);
                return true;
            case R.id.barra_acerca: mensaje(R.string.cadena_barra_acerca);
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }
}