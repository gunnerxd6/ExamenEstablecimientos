package com.example.victor.examenestablecimientos;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class ListadoActivity extends AppCompatActivity {
    RecyclerView rv_listado;
    ArrayList<Establecimiento> establecimientos = new ArrayList<>();
    String seleccionCiudad, seleccionNivel, seleccionTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        rv_listado = findViewById(R.id.rv_listado);
        seleccionCiudad = getIntent().getExtras().getString("seleccionCiudad");
        seleccionNivel = getIntent().getExtras().getString("seleccionNivel");
        seleccionTipo = getIntent().getExtras().getString("seleccionTipo");
        consultarEstablecimientos();


    }

    private void consultarEstablecimientos() {
        BaseHelper helper = new BaseHelper(this, "db_establecimientos", null, 17);
        SQLiteDatabase db = helper.getWritableDatabase();


        String sql = "SELECT * FROM ESTABLECIMIENTOS";
        Cursor CC = db.rawQuery(sql, null);
        while (CC.moveToNext()) {
            Establecimiento establecimiento = new Establecimiento();
            establecimiento.setNombre(CC.getString(CC.getColumnIndex("NOMBRE_ESTABLECIMIENTO")));
            establecimiento.setTipo(CC.getString(CC.getColumnIndex("TIPO")));
            establecimiento.setDireccion(CC.getString(CC.getColumnIndex("DIRECCION_ESTABLECIMIENTO")));
            establecimiento.setTelefono(CC.getString(CC.getColumnIndex("TELEFONO")));
            establecimiento.setCorreo(CC.getString(CC.getColumnIndex("CORREO")));
            establecimiento.setWeb(CC.getString(CC.getColumnIndex("WEB")));
            establecimiento.setNivel(CC.getString(CC.getColumnIndex("NIVEL")));
            establecimiento.setDirector(CC.getString(CC.getColumnIndex("DIRECTOR")));
            establecimiento.setAltitud(CC.getString(CC.getColumnIndex("ALTITUD")));
            establecimiento.setLatitud(CC.getString(CC.getColumnIndex("LATITUD")));
            establecimiento.setEnsenanza(CC.getString(CC.getColumnIndex("ENSENANZA")));
            establecimiento.setCiudad(CC.getString(CC.getColumnIndex("CIUDAD")));

            if(seleccionNivel.equals("Ambos")){
                if (establecimiento.getCiudad().toLowerCase().equals(seleccionCiudad.toLowerCase()) && establecimiento.getTipo().toLowerCase().equals(seleccionTipo.toLowerCase())) {
                    establecimientos.add(establecimiento);
                }
            }else{
                if (establecimiento.getCiudad().toLowerCase().equals(seleccionCiudad.toLowerCase()) && establecimiento.getTipo().toLowerCase().equals(seleccionTipo.toLowerCase()) && establecimiento.getNivel().toLowerCase().equals(seleccionNivel.toLowerCase())) {
                    establecimientos.add(establecimiento);
                }
            }



        }
        Adaptador adaptador = new Adaptador(establecimientos, this);
        rv_listado.setLayoutManager(new LinearLayoutManager(this));
        rv_listado.setAdapter(adaptador);
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

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, BusquedaActivity.class);
        startActivity(i);
        super.onBackPressed();
    }

    public void cargarBuscar(Context ctx) {
        Intent i = new Intent(ctx, BusquedaActivity.class);
        startActivity(i);
    }

}
