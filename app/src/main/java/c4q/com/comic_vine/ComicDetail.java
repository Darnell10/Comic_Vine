package c4q.com.comic_vine;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import c4q.com.comic_vine.fragment.DetailDescFrag;
import c4q.com.comic_vine.fragment.DetailImageFrag;

/**
 * Created by Shant on 1/30/2018.
 */

public class ComicDetail extends AppCompatActivity {

    private static final int NUM_PAGES = 2;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comic_detail);
        setReferences();
        bundle = getIntent().getExtras();
        getSupportActionBar().setTitle(bundle.getString("name"));
    }

    public void setReferences(){

        viewPager = findViewById(R.id.detail_view_pager);
        pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        FloatingActionButton addToFave = findViewById(R.id.add_to_fave_button);
        addToFave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ComicSQL db = ComicSQL.getInstance(getApplicationContext());
                db.addComix(bundle);
                Toast.makeText(getBaseContext(),"Added to My Comics!",Toast.LENGTH_SHORT)
                        .show();

            }
        });


    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }


    public  class MyPagerAdapter extends FragmentPagerAdapter {
        final static int NUM_ITEMS = 2;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    DetailImageFrag imgFrag = new DetailImageFrag();
                    imgFrag.setArguments(bundle);
                    return imgFrag;

                case 1: // Fragment # 0 - This will show FirstFragment different title
                    DetailDescFrag descFrag = new DetailDescFrag();
                descFrag.setArguments(bundle);
                    return descFrag;
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            String title = "";
            switch(position){
                case 0:
                    title = "Cover";
                    break;
                case 1:
                    title = "Description";
                    break;
            }
            return title;
        }

    }


}
