package c4q.com.comic_vine;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by D on 2/3/18.
 */

public class ComicSQL extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "comix.db";
    private static final String TABLE_NAME = "comix";
    private static final int SCHEMA_VERSION= 1;

    public ComicSQL(Context context){
        super(context,DATABASE_NAME,null,SCHEMA_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE" + TABLE_NAME+
                        "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        //Add detail later
                        "comic_name TEXT, publisher_name TEXT, etc_Stuff TEXT);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // leave blank unless I want to add to new version of Schema
        // something like the code below\
        /**if (newVersion > oldVersion) {
         db.execSQL("ALTER TABLE student ADD COLUMN student_rollno INTEGER DEFAULT 0");
         }
         */
    }

    public  void addComix(Comic_Model comic_model){
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM" + "comic_model.getmethod()");

    }


}
