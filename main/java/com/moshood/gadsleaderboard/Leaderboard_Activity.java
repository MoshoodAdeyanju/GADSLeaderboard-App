package com.moshood.gadsleaderboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.moshood.gadsleaderboard.adapters.ViewPagerAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

public class Leaderboard_Activity extends AppCompatActivity {
    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_leaderboard_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tabs);
        setSupportActionBar(toolbar);

       ViewPagerAdapter = new ViewPagerAdapter(Leaderboard_Activity this, getApplicationContext());
        ViewPager2 viewPager2 = findViewById(R.id.skillIQTab);
        viewPager2.setAdapter(ViewPagerAdapter);
        TabLayout tabLayout = findViewById(R.id.learningTab);
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> tab.setText(TAB_TITLES[position])).attach();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.layout.fragment_leaderboard_, R);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.submitButton) {
            Intent intent = new Intent(Leaderboard_Activity.this, Submit_Activity.class);
            startActivity(intent);
        }
        return true;
    }

    public void startSubmitActivity(View view) {
        Intent intent = new Intent(Leaderboard_Activity.this, Submit_Activity.class);
        startActivity(intent);
    }
}