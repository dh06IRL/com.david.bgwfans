package com.david.bgwfanspaid.hos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.MenuItem;
import com.david.bgwfanspaid.viewcomponents.AttractionItem;
import com.david.bgwfanspaid.webviews.HiddenWiki;
import com.david.bgwfanspaid.R;
import com.github.rtyley.android.sherlock.roboguice.activity.RoboSherlockFragmentActivity;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.manuelpeinado.fadingactionbar.FadingActionBarHelper;
import roboguice.inject.InjectView;

/**
 * Created with IntelliJ IDEA.
 * User: david.hodge
 * Date: 8/17/13
 * Time: 8:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class hosFiends extends RoboSherlockFragmentActivity {

    GoogleMap mMap;
    private static final LatLng LOC_FIENDS = new LatLng(37.236105,-76.647993);
    private Marker fiends;
    static final CameraPosition HOME =
            new CameraPosition.Builder().target(LOC_FIENDS)
                    .zoom(17)
                    .bearing(0)
                    .tilt(25)
                    .build();

    @InjectView (R.id.fiends_forum)
    AttractionItem fiendsForum;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setTheme(R.style.HOSTheme);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setIcon(android.R.color.transparent);

        FadingActionBarHelper helper = new FadingActionBarHelper()
                .actionBarBackground(R.drawable.ab_solid_bgwfans2)
                .headerLayout(R.layout.hos_fiends_header)
                .parallax(true)
                .contentLayout(R.layout.hos_fiends_2013);

        setContentView(helper.createView(this));
        helper.initActionBar(this);
        setUpMapIfNeeded();

        fiendsForum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), HiddenWiki.class);
                i.putExtra("wikiLink", "http://forum.parkfans.net/thread-1450.html");
                startActivity(i);
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {
        fiends = mMap.addMarker(new MarkerOptions()
                .position(LOC_FIENDS)
                .title("Fiends")
                .snippet("The wacky doctor and his manic nurses are creating the ultimate Fiends, " +
                        "and there's not a bad seat in the lab"));
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mMap.setMyLocationEnabled(false);
        mMap.getUiSettings().setZoomControlsEnabled(false);
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(HOME));
    }

    @Override
    public void onStart() {
        super.onStart();
        EasyTracker.getInstance().activityStart(this); // Add this method.
    }

    @Override
    public void onStop() {
        super.onStop();
        EasyTracker.getInstance().activityStop(this); // Add this method.
    }
}
