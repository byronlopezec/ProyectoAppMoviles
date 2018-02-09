package com.example.bt.proyectoappmoviles;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    //Versión de la base de datos
    private static final int DATABASE_VERSION =1;
    //Nombre de la base de datos
    private static final String DATABASE_NAME = "administradorContactos";
    //Nombre de la tabla de Visita
    private static final String TABLE_Visita = "Visita";

    //Nombres de las columnas de la tabla
    private static final String KEY_ID = "id";
    private static final String KEY_nombre = "nombre";
    private static final String KEY_fecha_visita= "fecha_visita";
    private static final String KEY_numero_visitantes = "numero_visitantes";
    private static final String KEY_hora_ingreso = "hora_ingreso";
    private static final String KEY_telefono = "telefono";

    //Constructor de la base de datos
    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_Visita_TABLE = "CREATE TABLE " + TABLE_Visita + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_nombre + " TEXT,"
                + KEY_fecha_visita + " TEXT,"
                + KEY_numero_visitantes + " TEXT,"
                + KEY_hora_ingreso + " TEXT"
                + KEY_telefono + " TEXT"+ ")";
        db.execSQL(CREATE_Visita_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Visita);
        onCreate(db);
    }

    public void addCaso(Visita Visita){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_nombre, Visita.get_nombre());
        values.put(KEY_fecha_visita, Visita.get_fecha_visita());
        values.put(KEY_numero_visitantes, Visita.get_numero_visitantes());
        values.put(KEY_hora_ingreso, Visita.get_hora_ingreso());
        values.put(KEY_telefono, Visita.get_telefono());
        db.insert(TABLE_Visita,null,values);
        db.close();
    }

    public Visita getVisita(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_Visita, new
                String[]{KEY_ID,KEY_nombre,KEY_fecha_visita,KEY_numero_visitantes,KEY_hora_ingreso,KEY_telefono}, KEY_ID+"=?", new
                String[]{String.valueOf(id)},null,null,null,null);
        if (cursor != null){
            cursor.moveToFirst();
        }

        Visita Visita = new Visita(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),cursor.getString(5));
        return Visita;
    }

    public List<Visita> getAllVisita(){
        //Instanciamos un Array para llenarlo con todos los objetos Notes que saquemos de la BD
        List<Visita> listaVisita = new ArrayList();

        // 1. Aramos un String con el query a ejecutar
        String query = "SELECT * FROM " + TABLE_Visita;

        // 2. Obtenemos una reference de la BD con permisos de escritura y ejecutamos el query
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. Iteramos entre cada uno de olos registros y agregarlos al array de Notas
        Visita caso = null;
        if (cursor.moveToFirst()) {
            do {
                caso = new Visita();
                caso.set_id(Integer.parseInt(cursor.getString(0)));
                caso.set_nombre(cursor.getString(1));
                caso.set_fecha_visita(cursor.getString(2));
                caso.set_numero_visitantes(cursor.getString(3));
                caso.set_hora_ingreso(cursor.getString(4));
                caso.set_telefono(cursor.getString(5));
                // Add caso to listaVisita
                listaVisita.add(caso);
            } while (cursor.moveToNext());
        }

        //Cerramos el cursor
        cursor.close();

        // Devolvemos las notas encontradas o un array vacio en caso de que no se encuentre nada
        return listaVisita;
    }

    /*
    * Para actualizar un registro vamos a definir un método llamado updateContact(). El parámetro de este
método será un objeto de la clase Contact. Al igual que para addContact(), usaremos un objeto
ContentValues para encapsular los datos de nuestro objeto Contact, y luego reemplazar el viejo contacto
con el nuevo.
*/
    public int updateVisita(Visita Visita){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, Visita.get_id());
        values.put(KEY_nombre, Visita.get_nombre());
        values.put(KEY_fecha_visita, Visita.get_fecha_visita());
        values.put(KEY_numero_visitantes, Visita.get_numero_visitantes());
        values.put(KEY_hora_ingreso, Visita.get_hora_ingreso());
        values.put(KEY_telefono, Visita.get_telefono());
        return db.update(TABLE_Visita, values, KEY_ID + "=?",
                new String[] {String.valueOf(Visita.get_id())});
    }

    /*Finalmente, vamos a implementar un método para borrar un registro. El método se llamará deleteContact
y recibirá un objeto Contact como parámetro. La implementación de este método es la siguiente.

*/
    public void deleteVisita(Visita Visita){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_Visita, KEY_ID + " =?",
                new String[] {String.valueOf(Visita.get_id())});
        db.close();
    }


}
