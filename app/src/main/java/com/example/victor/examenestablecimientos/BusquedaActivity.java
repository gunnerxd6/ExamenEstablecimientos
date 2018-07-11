package com.example.victor.examenestablecimientos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class BusquedaActivity extends AppCompatActivity {
    ArrayList<String> ciudades = new ArrayList<>();
    ArrayList<String> niveles = new ArrayList<>();
    ArrayList<String> tipos = new ArrayList<>();
    Spinner sp_ciudad, sp_tipo, sp_nivel;
    Button bt_filtrar;
    String seleccionCiudad,seleccionTipo,seleccionNivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);

        //Completar arrays
        ciudades.add("Temuco");
        ciudades.add("Santiago");

        niveles.add("Enseñanza basica");
        niveles.add("Enseñanza media");
        niveles.add("Ambos");

        tipos.add("Municipal");
        tipos.add("Privada");

        //Inicializar componentes
        sp_ciudad = findViewById(R.id.sp_ciudad);
        sp_nivel = findViewById(R.id.sp_nivel);
        sp_tipo = findViewById(R.id.sp_tipo);
        bt_filtrar = findViewById(R.id.bt_filtrar);
        //Cargar spinners
        ArrayAdapter<String> adaptadorCiduad = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, ciudades);
        sp_ciudad.setAdapter(adaptadorCiduad);


        ArrayAdapter<String> adaptadorNivel = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, niveles);
        sp_nivel.setAdapter(adaptadorNivel);

        ArrayAdapter<String> adaptadorTipos = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, tipos);
        sp_tipo.setAdapter(adaptadorTipos);

        //Iniciar actividad listado con filtro
        bt_filtrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtener opciones seleccionadas en los spinners
                seleccionCiudad = sp_ciudad.getSelectedItem().toString();
                seleccionNivel = sp_nivel.getSelectedItem().toString();
                seleccionTipo = sp_tipo.getSelectedItem().toString();
                Intent i = new Intent(BusquedaActivity.this, ListadoActivity.class);
                i.putExtra("seleccionCiudad",seleccionCiudad);
                i.putExtra("seleccionNivel",seleccionNivel);
                i.putExtra("seleccionTipo",seleccionTipo);
                startActivity(i);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.acerca:
                Toast.makeText(this, "Buscador de etablecimientos\n Creado por: Victor Ortiz", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    public void cargarBuscar(Context ctx) {
        Intent i = new Intent(ctx, BusquedaActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        this.finishAffinity();
        super.onBackPressed();
    }
}
