package c4q.com.comic_vine;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

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
                "CREATE TABLE " + TABLE_NAME+
                        "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        //Add detail later
                        "comic_image BLOB, comic_name TEXT,publisher_name TEXT,resource_type TEXT,detail TEXT);");
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
        Comic_Model.Results results = (Comic_Model.Results) comic_model.getResults();
        Cursor cursor = getReadableDatabase()
                .rawQuery("SELECT * FROM" + TABLE_NAME
                        + "WHERE comic_image = " + results.getImage().getScreen_large_url()
                        + "AND comic_name = "+ results.getName()
                        + "AND publisher_name" + results.getPublisher()
                        +"AND resource_type" + results.getResource_type()
                        +"AND detail" + results.getDescription()+";",null );
        if (cursor.getCount()==0){
            getWritableDatabase().execSQL( "INSERT INTO " + TABLE_NAME +
                    "(comic_image,comic_name,publisher_name,resource_type,detail) VALUES ("
                    + results.getImage().getScreen_large_url()
                    + " ',' " + results.getName()
                    +" ',' " + results.getPublisher()
                    +" ',' " + results.getResource_type()
                    +" ',' " + results.getDescription()+ "');" );
        }
        cursor.close();
    }

    public List<Comic_Model> getComicModel(){
        List<Comic_Model> comic_list = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery(
                " SELECT * FROM "+ TABLE_NAME +";", null);

        if (cursor != null){
            if (cursor.moveToFirst()) {
           do {
               Comic_Model comic_model1 = new Comic_Model(
                       cursor.getString(cursor.getColumnIndex("comic_image")),
                       cursor.getString(cursor.getColumnIndex("comic_name")),
                       cursor.getString(cursor.getColumnIndex("publisher_name")),
                       cursor.getString(cursor.getColumnIndex("resource_type")),
                       cursor.getString(cursor.getColumnIndex("detail")));
               comic_list.add(comic_model1);
           } while (cursor.moveToNext());
            }
        }
        return comic_list;
    }


}
