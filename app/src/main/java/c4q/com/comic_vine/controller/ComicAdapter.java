package c4q.com.comic_vine.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import c4q.com.comic_vine.Comic_Model;
import c4q.com.comic_vine.R;

/**
 * Created by Shant on 1/30/2018.
 */

public class ComicAdapter extends RecyclerView.Adapter<ComicAdapter.ComicViewHolder> {

    List<Comic_Model.Results> comicList = new ArrayList<>();

    public ComicAdapter(List<Comic_Model.Results> list){
        comicList = list;
    }


    @Override
    public ComicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comic_item,parent,false);
        return new ComicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ComicViewHolder holder, int position) {
        Comic_Model.Results result = comicList.get(position);
        holder.onBind(result);


    }

    @Override
    public int getItemCount() {
        return comicList.size();
    }

    public class ComicViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private ImageView image;

        public ComicViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);
        }

        public void onBind(Comic_Model.Results results){
            name.setText(results.getName());
            Picasso.with(itemView.getContext()).load(results.getImage().getIcon_url()).into(image);

        }
    }
}