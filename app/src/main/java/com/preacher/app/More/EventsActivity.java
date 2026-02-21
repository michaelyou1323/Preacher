package com.preacher.app.More;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.preacher.app.R;
import com.preacher.app.Recyclerview.EventsAdapter;
import com.preacher.app.Recyclerview.EventsDataModel;

import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;

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




        database = FirebaseDatabase.getInstance().getReference("Events");



        eventsDataModels = new ArrayList<>();
        eventsAdapter = new EventsAdapter(EventsActivity.this,eventsDataModels);
        eventsAdapter.setUsersList(eventsDataModels);
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    EventsDataModel user = dataSnapshot.getValue(EventsDataModel.class);
                    eventsDataModels.add(user);




                                    }

                eventsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });


        eventsAdapter = new EventsAdapter(EventsActivity.this, eventsDataModels);
        recyclerView.setAdapter(eventsAdapter);


    }
}