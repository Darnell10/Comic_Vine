package c4q.com.comic_vine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class FavoritesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        ComicSQL comicSQL = new ComicSQL(getApplicationContext());
        List<Favorites> comicFaves = comicSQL.favorites();

    }
}
