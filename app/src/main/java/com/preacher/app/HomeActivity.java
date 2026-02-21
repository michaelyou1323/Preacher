package com.preacher.app;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.preacher.app.MoreFragment;
import com.preacher.app.Recyclerview.HomeFragment;
import com.preacher.app.Fragments.VideosFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.framLayout, new HomeFragment())
                .commit();
    }


    public void onHSelect(MenuItem item) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.framLayout, new HomeFragment())
                .commit();

    }

    public void onVideoSelect(MenuItem item) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.framLayout, new VideosFragment())
                .commit();
    }

    public void onMoreSelect(MenuItem item) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.framLayout, new MoreFragment())
                .commit();
    }

}
