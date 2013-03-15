package com.david.bgwfans;


import android.os.Bundle;
import android.view.View.OnClickListener;

import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;

public class About extends SideMenuActivity implements OnClickListener{

    private Tracker mGaTracker;
	private GoogleAnalytics mGaInstance;

	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.about_screen);
	
	mGaInstance = GoogleAnalytics.getInstance(this);
	mGaTracker = mGaInstance.getTracker("UA-39204043-1");
    
	}
}
