package com.example.proyectopmdm.DBHelpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class LibroDBHelper {
    private Context mCtx = null;
    private DataBaseHelperInternal mDbHelper = null;
    private SQLiteDatabase mDb = null;
    private static final String DATABASE_NAME = "LIBROS";
    private static final int DATABASE_VERSION = 3;
    // tabla y campos
    private static final String DATABASE_TABLE_LIBROS = "libros";
    public static final String SL_ID = "_id";
    public static final String SL_TITULO = "titulo";
    public static final String SL_AUTOR = "autor";
    public static final String SL_SINOPSIS = "sinopsis";
    public static final String SL_USERID = "user_id";

    // SQL de creación de la tabla
    private static final String DATABASE_CREATE_LIBROS =
            "create table "+ DATABASE_TABLE_LIBROS + " (" +
                    SL_ID + " integer primary key, " +
                    SL_TITULO + " text not null, " +
                    SL_AUTOR + " text not null, " +
                    SL_SINOPSIS + " text, " +
                    SL_USERID + " text not null)";
    //constructor
    public LibroDBHelper(Context ctx) {
        this.mCtx = ctx;
    }
    //clase privada para control de la SQLite
    private static class DataBaseHelperInternal extends SQLiteOpenHelper {
        public DataBaseHelperInternal(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            createTables(db);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            deleteTables(db);
            createTables(db);
        }
        private void createTables(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE_LIBROS);
        }

        private void deleteTables(SQLiteDatabase db) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_LIBROS);
        }
    }

    public LibroDBHelper open()  {
        mDbHelper = new DataBaseHelperInternal(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        mDbHelper.close();
    }

    //obtener todos los elementos
    public Cursor getItems() {
        //Parametros:nombreTabla,campos,campoWhere,condicionWhere,Group By, Havong, Order by
        return mDb.query(DATABASE_TABLE_LIBROS, new String[] {SL_ID, SL_TITULO, SL_AUTOR, SL_SINOPSIS, SL_USERID}, null, null, null, null, SL_ID);
    }

    public Cursor getItemsFrom(int userid) {
        //Parametros:nombreTabla,campos,campoWhere,condicionWhere,Group By, Havong, Order by
        return mDb.query(DATABASE_TABLE_LIBROS, new String[] {SL_ID, SL_TITULO, SL_AUTOR, SL_SINOPSIS, SL_USERID}, "user_id = " + userid, null, null, null, SL_ID);
    }

    //crear elemento
    public long insertItem(String titulo, String autor, String sinopsis, String userid){
        ContentValues initialValues = new ContentValues();
        initialValues.put(SL_TITULO, titulo);
        initialValues.put(SL_AUTOR, autor);
        initialValues.put(SL_SINOPSIS, sinopsis);
        initialValues.put(SL_USERID, userid);
        return mDb.insert(DATABASE_TABLE_LIBROS, null, initialValues);
    }
}
