package com.example.victor.examenestablecimientos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class InformacionActivity extends AppCompatActivity {
    TextView tv_info_nombre, tv_info_direccion, tv_info_telefono, tv_info_correo, tv_info_web, tv_info_tipo, tv_info_ensenanzaa, tv_info_nivel,
            tv_info_director, tv_1, tv_2, tv_3, tv_4, tv_6;
    Switch sw_detalles;
    Button bt_ubicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
        sw_detalles = findViewById(R.id.sw_detalles);
        tv_info_nombre = findViewById(R.id.tv_info_nombre);
        tv_info_direccion = findViewById(R.id.tv_info_direccion);
        tv_info_telefono = findViewById(R.id.tv_info_telefono);
        tv_info_correo = findViewById(R.id.tv_info_correo);
        tv_info_web = findViewById(R.id.tv_info_web);
        tv_info_tipo = findViewById(R.id.tv_info_tipo);
        tv_info_ensenanzaa = findViewById(R.id.tv_info_ensenanza);
        tv_info_nivel = findViewById(R.id.tv_tipo_nivel);
        tv_info_director = findViewById(R.id.tv_info_director);
        tv_1 = findViewById(R.id.tv_1);
        tv_2 = findViewById(R.id.tv_2);
        tv_3 = findViewById(R.id.tv_3);
        tv_4 = findViewById(R.id.tv_4);
        tv_6 = findViewById(R.id.tv_6);
        bt_ubicacion = findViewById(R.id.bt_ubicacion);


        //Definir valores
        tv_info_nombre.setText(getIntent().getExtras().getString("nombre"));
        tv_info_direccion.setText(getIntent().getExtras().getString("direccion"));
        tv_info_telefono.setText(getIntent().getExtras().getString("telefono"));
        tv_info_correo.setText(getIntent().getExtras().getString("correo"));
        tv_info_web.setText(getIntent().getExtras().getString("web"));
        tv_info_tipo.setText(getIntent().getExtras().getString("tipo"));
        tv_info_ensenanzaa.setText(getIntent().getExtras().getString("ensenanza"));
        tv_info_nivel.setText(getIntent().getExtras().getString("nivel"));
        tv_info_director.setText(getIntent().getExtras().getString("director"));


        sw_detalles.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tv_info_tipo.setVisibility(View.VISIBLE);
                    tv_info_ensenanzaa.setVisibility(View.VISIBLE);
                    tv_info_nivel.setVisibility(View.VISIBLE);
                    tv_info_director.setVisibility(View.VISIBLE);
                    tv_1.setVisibility(View.VISIBLE);
                    tv_2.setVisibility(View.VISIBLE);
                    tv_3.setVisibility(View.VISIBLE);
                    tv_4.setVisibility(View.VISIBLE);
                    tv_6.setVisibility(View.VISIBLE);
                } else {
                    tv_info_tipo.setVisibility(View.INVISIBLE);
                    tv_info_ensenanzaa.setVisibility(View.INVISIBLE);
                    tv_info_nivel.setVisibility(View.INVISIBLE);
                    tv_info_director.setVisibility(View.INVISIBLE);

                    tv_1.setVisibility(View.INVISIBLE);
                    tv_2.setVisibility(View.INVISIBLE);
                    tv_3.setVisibility(View.INVISIBLE);
                    tv_4.setVisibility(View.INVISIBLE);
                    tv_6.setVisibility(View.INVISIBLE);
                }
            }
        });

        bt_ubicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                i.putExtra("latitud", getIntent().getExtras().getString("latitud"));
                i.putExtra("altitud", getIntent().getExtras().getString("altitud"));
                i.putExtra("nombre", getIntent().getExtras().getString("nombre"));
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
                Toast.makeText(this, "Buscador de establecimientos\n Creado por: Victor Ortiz", Toast.LENGTH_SHORT).show();

                break;
            case R.id.buscar:
                cargarBuscar(this);
                finish();
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
       // Intent i = new Intent(this, ListadoActivity.class);
       // startActivity(i);
        finish();
        super.onBackPressed();
    }
}
