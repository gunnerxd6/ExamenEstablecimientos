package com.example.victor.examenestablecimientos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BaseHelper extends SQLiteOpenHelper {
    ArrayList<String> nombres = new ArrayList<>();
    ArrayList<String> tipos = new ArrayList<>();
    ArrayList<String> altidud = new ArrayList<>();
    ArrayList<String> latitud = new ArrayList<>();
    ArrayList<String> direccion = new ArrayList<>();
    ArrayList<String> telefono = new ArrayList<>();
    ArrayList<String> web = new ArrayList<>();
    ArrayList<String> nivel = new ArrayList<>();
    ArrayList<String> director = new ArrayList<>();
    ArrayList<String> correo = new ArrayList<>();
    ArrayList<String> ensenanza = new ArrayList<>();


    public BaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Utilidades.TABLA_ESTABLECIMIENTOS);
        ContentValues c = new ContentValues();
        //Definir nombres
        nombres.add("Liceo particular comercial Temuco");
        nombres.add("Liceo Bicentenario Temuco");

        //Definir direccion
        direccion.add(" Manuel Rodriguez 1344, Antonio Varas, Temuco, Región de la Araucanía");
        direccion.add("San Martín 81, Temuco, Región de la Araucanía");

        //Definir telefono
        telefono.add("45 221 3239");
        telefono.add("(45) 227 3143");

        //Definir web
        web.add("www.www.cl");
        web.add("http://www.liceobicentenariotemuco.cl");

        //Definit Tipo
        tipos.add("Privada");
        tipos.add("Municipal");

        //Definir nivel
        nivel.add("Medio");
        nivel.add("Medio");

        //Definir director
        director.add("asdasd");
        director.add("Pedro Figueroa Mellado");

        //Definir correo
        correo.add("asd@asd.cl");
        correo.add("liceobicentenario@temuco.cl");

        //Definir enseñanza
        ensenanza.add("Cientifico humanista");
        ensenanza.add("Cientifico humanista");


        //Definit altitud
        altidud.add("-38.7392535");
        altidud.add("-38.7405434");

        //Definir latitud
        latitud.add("-72.5837616");
        latitud.add("-72.6038889");


        for (int i = 0; i < nombres.size(); i++) {
            c.put("NOMBRE_ESTABLECIMIENTO", nombres.get(i));
            c.put("TIPO", tipos.get(i));
            c.put("DIRECCION_ESTABLECIMIENTO", direccion.get(i));
            c.put("TELEFONO", telefono.get(i));
            c.put("CORREO", correo.get(i));
            c.put("WEB", web.get(i));
            c.put("NIVEL", nivel.get(i));
            c.put("DIRECTOR", director.get(i));
            c.put("ALTITUD", altidud.get(i));
            c.put("LATITUD", latitud.get(i));
            c.put("ENSENANZA", ensenanza.get(i));
            db.insert("ESTABLECIMIENTOS", null, c);
            c.clear();
        }
        // c.put("NOMBRE_ESTABLECIMIENTO", "Nombre1");
        //c.put("TIPO", "Municipal");
        // Log.e("ESTADO BD", "CREADA!");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE ESTABLECIMIENTOS");
        onCreate(db);
    }

    private void llenarTabla() {


    }

}
