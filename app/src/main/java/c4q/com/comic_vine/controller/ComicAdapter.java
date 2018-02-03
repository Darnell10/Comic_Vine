package c4q.com.comic_vine.controller;

import android.content.Intent;
import android.os.Bundle;
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
        private TextView res;

        public ComicViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);
            res = itemView.findViewById(R.id.res);
        }

        public void onBind(Comic_Model.Results results){
            name.setText(results.getName());
            res.setText(results.getResource_type());
            Picasso.with(itemView.getContext()).load(results.getImage().getSmall_url()).into(image);
            final Comic_Model.Results res = results;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent goToDetail = new Intent(itemView.getContext(), ComicDetail.class);
                    goToDetail.putExtra("name",res.getName());
                    goToDetail.putExtra("res",res.getResource_type());
                    goToDetail.putExtra("desc",res.getDescription());
                    goToDetail.putExtra("pub",res.getPublisher().getName());
                    goToDetail.putExtra("img",res.getImage().getScreen_large_url() );
                    itemView.getContext().startActivity(goToDetail);
                }
            });


        }
    }
}
