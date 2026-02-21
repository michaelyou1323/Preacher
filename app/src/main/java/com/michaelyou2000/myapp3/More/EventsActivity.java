package com.michaelyou2000.myapp3.More;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.michaelyou2000.myapp3.R;
import com.michaelyou2000.myapp3.Recyclerview.EventsAdapter;
import com.michaelyou2000.myapp3.Recyclerview.EventsDataModel;

import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    EventsAdapter eventsAdapter;
    ArrayList<EventsDataModel> eventsDataModels;
    private ArrayList<EventsDataModel> newsArrayList;
    private RecyclerView recyclerview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        recyclerView = findViewById(R.id.eventsRecycler);
        recyclerView.setHasFixedSize(true);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);


        eventsDataModels = new ArrayList<>();
        eventsAdapter = new EventsAdapter(EventsActivity.this,eventsDataModels);
        eventsAdapter.setUsersList(eventsDataModels);

        // Cloudinary fetching logic will go here.
        // You'll need to configure Cloudinary and then fetch the data.

        eventsAdapter = new EventsAdapter(EventsActivity.this, eventsDataModels);
        recyclerView.setAdapter(eventsAdapter);


    }
}