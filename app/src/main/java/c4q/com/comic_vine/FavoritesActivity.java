package c4q.com.comic_vine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import c4q.com.comic_vine.controller.FavoritesAdapter;

public class FavoritesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        ComicSQL comicSQL = ComicSQL.getInstance(getApplicationContext());
        List<Favorites> comicFaves = comicSQL.favorites();

        RecyclerView favoriteRecyclerview = findViewById(R.id.favorite_rv);

        FavoritesAdapter favoritesAdapter = new FavoritesAdapter(comicFaves);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());

        favoriteRecyclerview.setAdapter(favoritesAdapter);
        favoriteRecyclerview.setLayoutManager(linearLayoutManager);

    }
}
