package c4q.com.comic_vine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Shant on 1/30/2018.
 */

public class ComicDetail extends AppCompatActivity {

    ImageView image;
    TextView name;
    TextView desc;
    TextView pub;
    TextView resType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comic_detail);

        setReferences();

    }

    public void setReferences(){
        image = findViewById(R.id.detail_image);
        name = findViewById(R.id.detail_name);
        desc = findViewById(R.id.detail_desc);
        resType = findViewById(R.id.resource_type);
        pub = findViewById(R.id.detail_publisher);
        setViews();

    }

    public void setViews(){
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String pub = bundle.getString("pub");
        String desc = bundle.getString("desc");
        String img = bundle.getString("img");
        String res = bundle.getString("res");

        Picasso.with(getApplicationContext()).load(img).into(image);
        this.name.setText(name);
        this.resType.setText(res);
        this.pub.setText(pub);
        this.desc.setText(desc);

    }


}
