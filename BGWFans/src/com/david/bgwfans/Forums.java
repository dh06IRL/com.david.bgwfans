package com.david.bgwfans;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;

public class Forums extends SideMenuActivity implements View.OnClickListener{
	
	private WebView webview2;
	private ProgressBar Pbar;
	private Tracker mGaTracker;
	private GoogleAnalytics mGaInstance;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forums);
		
		mGaInstance = GoogleAnalytics.getInstance(this);
		mGaTracker = mGaInstance.getTracker("UA-39204043-1");
		 
		ActionBar actionbar = getActionBar();
        actionbar.setDisplayShowTitleEnabled(false);
		actionbar.setListNavigationCallbacks(null, null);
        actionbar.setDisplayHomeAsUpEnabled(true);
        createNavigation();
 
		webview2 = (WebView) findViewById(R.id.webView2);
		webview2.getSettings().setJavaScriptEnabled(true);
		webview2.getSettings().setPluginsEnabled(true);
		webview2.loadUrl("http://www.bgwfans.com/forums");
		webview2.setWebViewClient(new WebViewClient());
		webview2.getSettings().setBuiltInZoomControls(true);
		webview2.setBackgroundColor(0x00000000);
		Pbar = (ProgressBar) findViewById(R.id.pb1);

		webview2.setWebChromeClient(new WebChromeClient() {
		 public void onProgressChanged(WebView view, int progress)   
		 {
			 if(progress < 100 && Pbar.getVisibility() == ProgressBar.GONE){
	             Pbar.setVisibility(ProgressBar.VISIBLE);
			 }
			 Pbar.setProgress(progress);
	         if(progress == 100) {
	             Pbar.setVisibility(ProgressBar.GONE);
	         }
		 
		   }
		 });}
	
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.webmenu, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(android.view.MenuItem item) {
		int itemId = item.getItemId();
		if (itemId == android.R.id.home) {
			toggle();
			return true;
		} else if (itemId == R.id.web_back) {
			webview2.goBack();
		} else if (itemId == R.id.web_forward) {
			webview2.goForward();
		} else if (itemId == R.id.web_refresh) {
			webview2.reload();
		}
		return super.onOptionsItemSelected(item);
	}
		
	private void createNavigation() {
		// TODO Auto-generated method stub
		
	}
	
}
