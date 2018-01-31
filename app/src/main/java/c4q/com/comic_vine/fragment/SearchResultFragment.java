package c4q.com.comic_vine.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import c4q.com.comic_vine.Comic_Retrofit;
import c4q.com.comic_vine.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchResultFragment extends Fragment {

    private View rootView;


    public SearchResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_search_result, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.search_rec_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(rootView.getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        Bundle bundle = getArguments();
        String query = bundle.getString("query");
        Comic_Retrofit comic_retrofit = new Comic_Retrofit(recyclerView,query);
        comic_retrofit.start();
        // Inflate the layout for this fragment
        return rootView;
    }

}
