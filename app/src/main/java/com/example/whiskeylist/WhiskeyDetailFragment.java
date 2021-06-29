package com.example.whiskeylist;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

/**
 * WhiskeyDetailFragment is a Fragment that holds the information on the whiskeys
 */

public class WhiskeyDetailFragment extends Fragment implements View.OnClickListener {
    //Coordinates variable for the distillery
    private LatLng coordinates = new LatLng(0, 0);
    private long whiskeyId; //Id of the Whiskey
    View view;
    Button mapButton;

    //onCreateView is called when the android needs the fragment's layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null){
            whiskeyId = savedInstanceState.getLong("whiskeyId"); //Set the value of the whiskeyId
        }
        //The view layout of the fragment
        view = inflater.inflate(R.layout.fragment_whiskey_detail, container, false);
        //Button functionality
        mapButton = (Button) view.findViewById(R.id.map_button);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putParcelable("coords", coordinates);

                Intent intent = new Intent(view.getContext(), MapsActivity.class);
                intent.putExtra("bundle", args);
                view.getContext().startActivity(intent);
            }
        });

        //return the view and inflate the layout
        return view;
    }

    @Override
    public void onStart(){
        super.onStart();
        //Get the view to reference later
        View view = getView();

        if (view != null){
            TextView title = (TextView) view.findViewById(R.id.textTitle);
            Whiskey whiskey = Whiskey.whiskeyList[(int) whiskeyId];
            title.setText(whiskey.getName());
            TextView description = (TextView) view.findViewById(R.id.textDescription);
            description.setText(whiskey.getDescription());
            view.setBackgroundResource(whiskey.getImg());
        }
    }

    //Save the value of whiskeyId in the bundle before the fragment gets destroyed
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putLong("whiskeyId", whiskeyId);
    }

    //Setter for the whiskeyId
    public void setWhiskey(long id){
        this.whiskeyId = id;
    }

    @Override
    public void onClick(View v) {
    }
}