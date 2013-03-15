package com.david.bgwfans;


import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;


public class HOS_Shows extends SideMenuActivity implements View.OnClickListener {
    private Tracker mGaTracker;
    private GoogleAnalytics mGaInstance;

    public void Barrel(View view) {
        Intent barrelActivity = new Intent(this, Barrel.class);
        startActivity(barrelActivity);
    }

    public void Celtic(View view) {
        Intent celticActivity = new Intent(this, Celtic.class);
        startActivity(celticActivity);
    }

    public void Entwined(View view) {
        Intent entwinedActivity = new Intent(this, Entwined.class);
        startActivity(entwinedActivity);
    }

    public void Mix(View view) {
        Intent mixActivity = new Intent(this, Mix.class);
        startActivity(mixActivity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hos_shows);

        mGaInstance = GoogleAnalytics.getInstance(this);
        mGaTracker = mGaInstance.getTracker("UA-39204043-1");
    }

    public void Pets(View view) {
        Intent petsActivity = new Intent(this, Pets.class);
        startActivity(petsActivity);
    }

}
