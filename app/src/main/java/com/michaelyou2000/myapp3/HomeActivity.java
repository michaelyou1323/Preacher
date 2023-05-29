package com.michaelyou2000.myapp3;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.michaelyou2000.myapp3.Recyclerview.HomeFragment;
import com.michaelyou2000.myapp3.Fragments.VideosFragment;

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
