package c4q.com.comic_vine.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import c4q.com.comic_vine.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailDescFrag extends Fragment {

    TextView desc;
    View rootView;


    public DetailDescFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_detail_desc, container, false);
        desc = rootView.findViewById(R.id.detail_desc_frag);
        Bundle bundle = getArguments();
        String description = bundle.getString("desc");
        desc.setText(Html.fromHtml(description));
        // Inflate the layout for this fragment
        return rootView;
    }

}
