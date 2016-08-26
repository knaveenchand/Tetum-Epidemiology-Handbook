package matenek.epidemiologyhandbookintetum;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


/**
 * Created by admin on 25/08/16.
 */
public class DbObject {

    private static DictionaryDatabase dbHelper;
    private SQLiteDatabase db;

    public DbObject(Context context) {
        dbHelper = new DictionaryDatabase(context);
        this.db = dbHelper.getReadableDatabase();
    }

    public SQLiteDatabase getDbConnection(){
        return this.db;
    }

    public void closeDbConnection(){
        if(this.db != null){
            this.db.close();
        }
    }

}
