package com.david.bgwfanspaid.xmas.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.david.bgwfanspaid.R;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;

/**
 * Created by david.hodge on 12/9/13.
 */
public class XmasSiteFragment extends SherlockFragment {

    private WebView webview;
    private ProgressBar Pbar;
    private Tracker mGaTracker;
    private GoogleAnalytics mGaInstance;

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.bgwfans, container, false);

        mGaInstance = GoogleAnalytics.getInstance(getSherlockActivity());
        mGaTracker = mGaInstance.getTracker("UA-39204043-1");

        webview = (WebView) view.findViewById(R.id.webView1);
        webview.getSettings().setJavaScriptEnabled(true);
        //webview.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
        //webview.getSettings().setLoadWithOverviewMode(true);
        webview.getSettings().setBuiltInZoomControls(true);
        webview.getSettings().setDisplayZoomControls(false);
        //webview.getSettings().setUseWideViewPort(true);
        webview.getSettings().setSupportZoom(true);
        //webview.getSettings().setDefaultZoom(ZoomDensity.FAR);
        webview.loadUrl("http://seaworldparks.com/christmastown-williamsburg/");
        webview.setWebViewClient(new WebViewClient());
        webview.setBackgroundColor(0x00000000);
        Pbar = (ProgressBar) view.findViewById(R.id.pb1);
        setHasOptionsMenu(true);


        webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress < 100 && Pbar.getVisibility() == ProgressBar.GONE) {
                    Pbar.setVisibility(ProgressBar.VISIBLE);
                }
                Pbar.setProgress(progress);
                if (progress == 100) {
                    Pbar.setVisibility(ProgressBar.GONE);
                }

            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.webmenu, menu);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.web_back) {
            webview.goBack();
        } else if (itemId == R.id.web_forward) {
            webview.goForward();
        } else if (itemId == R.id.web_refresh) {
            webview.reload();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();
        EasyTracker.getInstance().activityStart(getActivity()); // Add this method.
    }

    @Override
    public void onStop() {
        super.onStop();
        EasyTracker.getInstance().activityStop(getActivity()); // Add this method.
    }

}
