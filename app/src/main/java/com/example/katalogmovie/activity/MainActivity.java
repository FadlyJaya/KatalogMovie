package com.example.katalogmovie.activity;

import android.content.Intent;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.katalogmovie.fragment.NowPlayingFragment;
import com.example.katalogmovie.R;
import com.example.katalogmovie.fragment.TvShowFragment;
import com.example.katalogmovie.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private static final String Log_Tag = MainActivity.class.getSimpleName();
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(Log_Tag, "Click");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new NowPlayingFragment(), getString(R.string.now_playing));
        adapter.addFragment(new TvShowFragment(), getString(R.string.up_coming));

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.language_change){
            Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
