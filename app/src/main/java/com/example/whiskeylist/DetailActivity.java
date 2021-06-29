package com.example.whiskeylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * DetailActivity shows the
 */

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_WHISKEY_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Get the detail fragment and give it the reference
        WhiskeyDetailFragment whiskeyDetailFragment = (WhiskeyDetailFragment)
                getSupportFragmentManager().findFragmentById(R.id.detail_frag);
        //Get the intent that user clicked
        int whiskeyId = (int) getIntent().getExtras().get(EXTRA_WHISKEY_ID);
        whiskeyDetailFragment.setWhiskey(whiskeyId); //Pass the whiskeyId to the fragment
    }
}