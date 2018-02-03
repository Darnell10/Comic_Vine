package c4q.com.comic_vine;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import nl.qbusict.cupboard.QueryResultIterable;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by D on 2/2/18.
 */

public class ComicDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "comic.db";
    private static final int DATABASE_VERSION = 1;

    private static ComicDatabaseHelper comic_instance;

    private ComicDatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public static synchronized ComicDatabaseHelper getComic_instance(Context context){
        if (comic_instance ==null){
            comic_instance = new ComicDatabaseHelper(context.getApplicationContext());
        }
        return comic_instance;
    }

   static{
        cupboard().register(ComicDetail.class);
   }



    @Override
    public void onCreate(SQLiteDatabase db) {

        cupboard().withDatabase(db).createTables();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        cupboard().withDatabase(db).upgradeTables();

    }

    /** to be added to comic activity*/

    // place this in the global field..
    private SQliteDatabase db;

    // get instance of database place in activity
    ComicDatabaseHelper comicHelper = ComicDatabaseHelper.getComic_instance(this);
    db = comicHelper.getWritableDatabase();

    private void addComic(ComicDetail comicDetail){
        cupboard().withDatabase(db).put(comicDetail);
    }

    /** should this be the Model class or detail class, i say model*/
    private List<Comic_Model> AllComics(){
        List<Comic_Model> comic_models = new ArrayList<>();

        try{
            //Iterates through comics
            QueryResultIterable<Comic_Model> itr =cupboard().withDatabase(db).query(Comic_Model.class).query();
            for (Comic_Model comic_model: itr) {
                comic_models.add(comic_model);
            }
            itr.close();
        } catch (Exception e){
            Log.e("create tage in global feild",e);
        }
        return comic_models;
    }

}
