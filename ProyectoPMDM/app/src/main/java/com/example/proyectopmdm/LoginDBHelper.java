package com.example.proyectopmdm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class LoginDBHelper {
    private Context mCtx = null;
    private DataBaseHelperInternal mDbHelper = null;
    private SQLiteDatabase mDb = null;
    private static final String DATABASE_NAME = "USUARIOS";
    private static final int DATABASE_VERSION = 3;

    private static final String DATABASE_TABLE_USUARIOS = "USUARIOS";
    public static final String SL_ID = "_id";
    public static final String SL_USUARIO = "USR";
    public static final String SL_CONTRASEÑA = "PWD";

    private static final String DATABASE_CREATE_USUARIOS =
            "create table "+ DATABASE_TABLE_USUARIOS + " (" +
                    SL_ID + " integer primary key, " +
                    SL_USUARIO + " text, " +
                    SL_CONTRASEÑA + " text)";

    private static final String DATABASE_INSERT_PRUEBA = "insert into " + DATABASE_TABLE_USUARIOS + " VALUES (0, 'usuario', 'usuario')";
    private static final String DATABASE_INSERT_PRUEBA2 = "insert into " + DATABASE_TABLE_USUARIOS + " VALUES (1, 'usuario2', 'usuario2')";


    //constructor
    public LoginDBHelper(Context ctx) {
        this.mCtx = ctx;
    }

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
            db.execSQL(DATABASE_CREATE_USUARIOS);
            db.execSQL(DATABASE_INSERT_PRUEBA);
            db.execSQL(DATABASE_INSERT_PRUEBA2);

        }

        private void deleteTables(SQLiteDatabase db) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_USUARIOS);
        }
    }

    public LoginDBHelper open()  {
        mDbHelper = new DataBaseHelperInternal(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        mDbHelper.close();
    }

    public Cursor getItems() {
        return mDb.query(DATABASE_TABLE_USUARIOS, new String[] {SL_ID, SL_USUARIO, SL_CONTRASEÑA}, null, null, null, null, SL_ID);
    }

    public int getUserId(String usr) {
        try {
            Cursor c = mDb.rawQuery("SELECT * FROM " + DATABASE_TABLE_USUARIOS +
                    " WHERE " + SL_USUARIO + " = '" + usr + "'", null);
            c.moveToFirst();
            return c.getInt(c.getColumnIndex(LoginDBHelper.SL_ID));
        } catch (Exception e) {
            return 0;
        }
    }

    //crear elemento
    public long insertItem(String item, String place, String description, int importance){
        ContentValues initialValues = new ContentValues();
        initialValues.put(SL_USUARIO, importance);
        initialValues.put(SL_CONTRASEÑA, item);
        return mDb.insert(DATABASE_TABLE_USUARIOS, null, initialValues);
    }

    public boolean login(String user, String pwd) {
        try {
            Cursor c = mDb.rawQuery("SELECT * FROM " + DATABASE_TABLE_USUARIOS +
                    " WHERE " + SL_USUARIO + " = '" + user + "' AND " + SL_CONTRASEÑA + " = '" + pwd + "'", null);
            if (c.getCount() > 0)
                return true;
            else
                return false;
        } catch (Exception e) {
            return false;
        }
    }
}
