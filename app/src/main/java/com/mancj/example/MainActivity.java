package com.mancj.example;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MaterialSearchBar.OnSearchActionListener, PopupMenu.OnMenuItemClickListener {
    private List<String> lastSearches;
    private MaterialSearchBar searchBar;
    private FrameLayout dim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dim = (FrameLayout) findViewById(R.id.dim);

        searchBar = (MaterialSearchBar) findViewById(R.id.searchBar);
        //enable searchbar callbacks
        searchBar.setOnSearchActionListener(this);
        searchBar.inflateMenu(R.menu.main);
        searchBar.getMenu().setOnMenuItemClickListener(this);
        //restore last queries from disk
//        lastSearches = loadSearchSuggestionFromDiks();
//        searchBar.setLastSuggestions(list);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //save last queries to disk
//        saveSearchSuggestionToDisk(searchBar.getLastSuggestions());
    }

    //called when searchbar enabled or disabled
    @Override
    public void onSearchStateChanged(boolean enabled) {
        String s = enabled ? "enabled" : "disabled";
        Toast.makeText(MainActivity.this, "Search " + s, Toast.LENGTH_SHORT).show();
        if (enabled){
            dim.setVisibility(View.VISIBLE);
        }else {
            dim.setVisibility(View.GONE);
        }
    }

    //called when user confirms request
    @Override
    public void onSearchConfirmed(CharSequence text) {
//        startSearch(text.toString(), true, null, true);
    }

    //called when microphone icon clicked
    @Override
    public void onSpeechIconSelected() {
//        openVoiceRecognizer();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Log.d("LOG_TAG", getClass().getSimpleName() + ": item clicked " + item.getTitle());
        return false;
    }
}
