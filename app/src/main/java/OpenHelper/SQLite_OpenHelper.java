package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLite_OpenHelper extends SQLiteOpenHelper {


    public SQLite_OpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table usuarios(_ID integer primary key autoincrement, " +
                "Nombre text, Correo text, Password text);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void abrirBD (){

        this.getWritableDatabase();
    }


    public void cerrar(){
        this.close();
    }


    public void  insertar(String nom, String cor, String pas){
        ContentValues valores = new ContentValues();
        valores.put("Nombre", nom);
        valores.put("Correo", cor);
        valores.put("Password", pas);

        this.getWritableDatabase().insert("usuarios",null,valores);
    }

    //Método validar

    public Cursor ConsultarUsuario(String usu, String pas) throws SQLException{
        Cursor ucursor=null;
        ucursor=this.getReadableDatabase().query("usuarios", new String[]{"_ID", "Nombre","Correo","Password"},
                "correo like '"+usu+"' and Password like '"+pas+"'", null, null, null, null);

        return ucursor;
    }


}
