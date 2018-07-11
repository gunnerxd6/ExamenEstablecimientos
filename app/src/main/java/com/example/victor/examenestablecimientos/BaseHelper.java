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
    ArrayList<String> ciudad = new ArrayList<>();


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
        nombres.add("Colegio Emprender Temuco");
        nombres.add("Colegio Santa Cruz");
        nombres.add("Escuela Basica Santa Isabel");
        nombres.add("Escuela Villa Carolina");
        nombres.add("Escuela Arturo Prat");
        nombres.add("Escuela Libertadores De Chile");
        nombres.add("Escuela Reyes Católicos");

        //Definir direccion
        direccion.add(" Manuel Rodriguez 1344, Antonio Varas, Temuco, Región de la Araucanía");
        direccion.add("San Martín 81, Temuco, Región de la Araucanía");
        direccion.add("Milano 2025, Temuco, Región de la Araucanía");
        direccion.add("Diego Portales 750, Temuco, Región de la Araucanía");
        direccion.add("Escuela Basica Santa Isabel");
        direccion.add("Boyeco 0561 PEDRO DE VALDIVIA, Temuco");
        direccion.add("Gral Mackenna 685, Temuco, Región de la Araucanía");
        direccion.add("Escuela Libertadores De Chile");
        direccion.add("Sta Elena 1829, Santiago, Región Metropolitana");

        //Definir telefono
        telefono.add("45 221 3239");
        telefono.add("(45) 227 3143");
        telefono.add("9 4442 5749");
        telefono.add("(45) 221 1192");
        telefono.add("(2) 2544 3050");
        telefono.add("(45) 234 5837");
        telefono.add("(45) 227 0974");
        telefono.add("562-26733010");
        telefono.add("(2) 2544 3373");

        //Definir web
        web.add("www.www.cl");
        web.add("http://www.liceobicentenariotemuco.cl");
        web.add("http://emprender.cl/nuestros-colegios/emprender-temuco/");
        web.add("http://colegiosantacruztemuco.cl/");
        web.add("colegiosantaisabel.cl");
        web.add("villacarolina-temuco.cl");
        web.add("arturoprat-temuco.cl");
        web.add("webescuela.cl");
        web.add("webescuela.cl");

        //Definit Tipo
        tipos.add("Privada");
        tipos.add("Municipal");
        tipos.add("Privada");
        tipos.add("Privada");
        tipos.add("Privada");
        tipos.add("Municipal");
        tipos.add("Municipal");
        tipos.add("Municipal");
        tipos.add("Municipal");

        //Definir nivel
        nivel.add("Enseñanza media");
        nivel.add("Enseñanza media");
        nivel.add("Enseñanza basica");
        nivel.add("Enseñanza basica");
        nivel.add("Enseñanza basica");
        nivel.add("Enseñanza basica");
        nivel.add("Enseñanza basica");
        nivel.add("Enseñanza basica");
        nivel.add("Enseñanza basica");


        //Definir director
        director.add("asdasd");
        director.add("Pedro Figueroa Mellado");
        director.add("");
        director.add("Brunilda Troncoso Ascencio");
        director.add("");
        director.add("Paula Riquelme S.");
        director.add("Jaime Ponce");
        director.add("Cristian Andrés Moreno Tapia");
        director.add("María Elena Domínguez Rogers");

        //Definir correo
        correo.add("asd@asd.cl");
        correo.add("liceobicentenario@temuco.cl");
        correo.add("");
        correo.add("");
        correo.add("colegiosantaisabel2000@gmail.com ");
        correo.add("villacarolina@temuco.cl");
        correo.add("arturoprat@temuco.cl");
        correo.add("e.libertadoresdechile@munistgo.cl");
        correo.add("e.reyescatolicos@munistgo.cl");

        //Definir enseñanza
        ensenanza.add("Cientifico humanista");
        ensenanza.add("Cientifico humanista");
        ensenanza.add("Cientifico humanista");
        ensenanza.add("Cientifico humanista");
        ensenanza.add("Cientifico humanista");
        ensenanza.add("Cientifico humanista");
        ensenanza.add("Cientifico humanista");
        ensenanza.add("Cientifico humanista");
        ensenanza.add("Cientifico humanista");

        //Definit altitud
        altidud.add("-38.7392535");
        altidud.add("-38.7405434");
        altidud.add("-38.7369997");
        altidud.add("-38.7369893");
        altidud.add("-33.4453833");
        altidud.add("-38.7167521");
        altidud.add("-38.7407119");
        altidud.add("-33.4349887");
        altidud.add("-33.4678316");

        //Definir latitud
        latitud.add("-72.5837616");
        latitud.add("-72.6038889");
        latitud.add("-72.6508077");
        latitud.add(",72.6508077");
        latitud.add("-70.6283737");
        latitud.add("-72.6233975");
        latitud.add("-72.5890722");
        latitud.add("-70.6623018");
        latitud.add("-70.6299658");

        //Definir ciudad
        ciudad.add("Temuco");
        ciudad.add("Temuco");
        ciudad.add("Temuco");
        ciudad.add("Temuco");
        ciudad.add("Santiago");
        ciudad.add("Temuco");
        ciudad.add("Temuco");
        ciudad.add("Santiago");
        ciudad.add("Santiago");

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
            c.put("CIUDAD", ciudad.get(i));
            db.insert("ESTABLECIMIENTOS", null, c);
            c.clear();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE ESTABLECIMIENTOS");
        onCreate(db);
    }


}
