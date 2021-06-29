package com.example.whiskeylist;

import android.media.Image;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Whiskey class for holding all the information about the
 * different whiskeys, along with a constructor
 * get methods for name and description, and a method to set the name
 * to a string.
 */

public class Whiskey {
    private String name;
    private String description;
    private int img;

    //List of the whiskeys
    public static final Whiskey[] whiskeyList = {
            new Whiskey("Lagavulin 16 years",
                    "A much sought-after single malt Scotch whisky with the massive " +
                            "peat-smoke that's typical of southern Islay - but also offering richness" +
                            " and a dryness that turns it into a truly interesting tipple. " +
                            "The 16 year old has truly become a benchmark Islay dram from the Lagavulin distillery.\n" +
                    "\n" +
                    "If you're looking for a food pairing for this beauty, try intensely flavoured " +
                            "salty blue cheeses, which complement the intense, peat rich, sweet and " +
                            "salty character of this Lagavulin wonderfully.", R.drawable.lagavulin_16),

            new Whiskey("Oban 14 years", "A bustling seaside resort has grown up around the distillery " +
                    "in the two centuries since it was first built in the fishing town of Oban. The West Highland malt is " +
                    "still produced in the same unhurried, traditional fashion and this 14 year old is a classic whisky from the distillery.", R.drawable.oban_14),

            new Whiskey("Highland Park 18 years", "Highland Park's 18 Year Old enjoyed a redesign in 2017, receiving livery " +
                    "inspired by the wood carvings from Urnes Stave Church and a new sub-name, \"Viking Pride\". The Orkney single malt remains " +
                    "the same as before - rich, complex and supremely delicious.", R.drawable.highland_park_18)
    };

    //Constructor
    private Whiskey(String name, String description, int img){
        this.name = name;
        this.description = description;
        this.img = img;
    }

    public String getDescription(){
        return description;
    }

    public String getName(){
        return name;
    }

    public int getImg() {return img;}

    public String toString(){
        return this.name;
    }
}
