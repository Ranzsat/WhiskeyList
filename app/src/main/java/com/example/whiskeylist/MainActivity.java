package com.example.whiskeylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * The WhiskeyList app implements and application that displays a list of
 * different whiskeys, when one of the items are pressed information about
 * said whiskey is shown, along with an image.
 *
 * On smaller screens the fragments will be shown in two different activities,
 * while on larger screens both fragments will be shown in the same activity.
 *
 * Implement WhiskeyListFragment.WhiskeyListListener defined in
 * WhiskeyListFragment.
 *
 * Extended functionality allows the user to press a button to get to a map
 * with the geodata of where the distillery is located
 *
 * @author Felix Höglund
 * @version 1.0
 * @since 2021-05-03
 */

public class MainActivity extends AppCompatActivity implements WhiskeyListFragment.WhiskeyListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //The interface listener method
    @Override
    public void itemClicked(long id, int pos){
        View fragmentContainer = findViewById(R.id.fragment_container);
        //Check for the fragmentContainer
        if (fragmentContainer != null){
            //Set the detail for large screens
            WhiskeyDetailFragment details = new WhiskeyDetailFragment();
            //Start of the transaction
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            details.setWhiskey(id);
            ft.replace(R.id.fragment_container, details); //Replace the fragment and add it to the back stack
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE); //Get the new fragment and transition the old and new fragments
            ft.commit(); //Commit the transaction
        } else {
            //Set details for small screen
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WHISKEY_ID, (int)id); //Pass the whiskeyId to the intent
            startActivity(intent); //Run details with the intent
        }

    }
}