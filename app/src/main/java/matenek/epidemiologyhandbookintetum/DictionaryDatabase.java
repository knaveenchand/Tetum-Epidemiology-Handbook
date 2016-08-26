package matenek.epidemiologyhandbookintetum;

import android.content.Context;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


/**
 * Created by admin on 26/08/16.
 */
public class DictionaryDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAMES = "quiz";
    private static final int DATABASE_VERSION = 5;

    public DictionaryDatabase(Context context) {
        super(context, DATABASE_NAMES, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }


}
