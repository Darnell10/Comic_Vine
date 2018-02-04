package c4q.com.comic_vine.controller;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import c4q.com.comic_vine.ComicDetail;
import c4q.com.comic_vine.Comic_Model;
import c4q.com.comic_vine.Favorites;
import c4q.com.comic_vine.R;

/**
 * Created by D on 2/3/18.
 */

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.FavoriteViewHolder> {

    List<Favorites> favList = new ArrayList<>();

    public FavoritesAdapter(List<Favorites> list) {
        favList = list;
    }


    @Override
    public FavoriteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_item, parent, false);
        return new FavoritesAdapter.FavoriteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FavoriteViewHolder holder, int position) {
        Favorites myfave = favList.get(position);
        holder.onBind(myfave);
    }


    @Override
    public int getItemCount() {
        return favList.size();
    }

    public class FavoriteViewHolder extends RecyclerView.ViewHolder {

        private ImageView fav_comic_image;
        private TextView fav_comic_name;
        private TextView fav_comic_res;
        private TextView fav_comic_pub;



        public FavoriteViewHolder(View itemView) {
            super(itemView);

            fav_comic_image = itemView.findViewById(R.id.fav_image);
            fav_comic_name = itemView.findViewById(R.id.fav_name);
            fav_comic_res = itemView.findViewById(R.id.fav_res);
            fav_comic_pub = itemView.findViewById(R.id.fav_pub);

        }

        public void onBind(Favorites favs) {

            fav_comic_name.setText(favs.getName());
            fav_comic_res.setText(favs.getRes());
            fav_comic_pub.setText(favs.getPub());
            Picasso.with(itemView.getContext()).load(favs.getImg());


        }
    }
}


