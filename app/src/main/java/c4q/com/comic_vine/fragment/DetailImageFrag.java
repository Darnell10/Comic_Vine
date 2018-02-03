package c4q.com.comic_vine.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import c4q.com.comic_vine.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailImageFrag extends Fragment {

    View rootView;
    ImageView image;

    public DetailImageFrag() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_detail_image, container, false);
        image = rootView.findViewById(R.id.detail_image_frag);
        Bundle bundle = getArguments();
        String img = bundle.getString("img");
        Picasso.with(getContext()).load(img).into(image);

        return rootView;
    }

}
