package com.example.whiskeylist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.Arrays;
import java.util.List;

/**
 * A Fragment that shows the list of whiskeys defined in whiskeyList.
 * The class extends ListFragment
 */

public class WhiskeyListFragment extends ListFragment {

    ArrayAdapter<String> adapter;

    //Interface for listener
    static interface WhiskeyListListener {
        void itemClicked(long id, int position);
    }


    private WhiskeyListListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] names = new String[Whiskey.whiskeyList.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = Whiskey.whiskeyList[i].getName(); //Create string of the whiskey names
        }


        //Options menu setup
        setHasOptionsMenu(true);

        //Create an ArrayAdapter and inflate
        adapter = new ArrayAdapter<String>(inflater.getContext(),
                android.R.layout.simple_list_item_1, names);
        setListAdapter(adapter); //Bind the ArrayAdapter to the list view

        //Return everything with the layout
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //Function that's called when a fragment gets attached to the activity
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        this.listener = (WhiskeyListListener)activity;
    }

    //Function that tells the listener when an item in the ListView is clicked
    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        if (listener != null){
            listener.itemClicked(id, position);
        }
    }

    /**
     * Toolbar for the list, with filtering search
     *
     * @param menu is showing the menu
     * @param inflater inflates the menu options
     */
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.whiskey_options, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        MenuItem infoItem = menu.findItem(R.id.info);
        MenuItem powerOffItem = menu.findItem(R.id.turn_off);

        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setQueryHint("Filter");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return true;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //Handle item selection
        switch(item.getItemId()){
            case R.id.info:
                showInfo();
                return true;
            case R.id.turn_off:
                System.exit(0);
            default:
                return  super.onOptionsItemSelected(item);
        }
    }

    /**
     * Called when the user tap the information button
     */
    private void showInfo() {
        Intent intent = new Intent(getActivity(), Information.class);
        startActivity(intent);
    }
}