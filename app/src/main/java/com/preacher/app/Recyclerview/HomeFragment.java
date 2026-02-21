package com.preacher.app.Recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.preacher.app.More.EventsActivity;
import com.preacher.app.New.UserList;
import com.preacher.app.R;


public class HomeFragment extends Fragment {



    DatabaseReference database;




    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_baseline_event_24)
                .error(R.drawable.facebook_logo__2019_);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);







        ImageView rImage = (ImageView) rootView.findViewById(R.id.homeImage);

        rImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EventsActivity.class);
                startActivity(intent);
            }
        });

        FirebaseDatabase firebaseDatabase
                = FirebaseDatabase.getInstance();

        database = FirebaseDatabase.getInstance().getReference("Events");

        database.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(
                            @NonNull DataSnapshot dataSnapshot)
                    {
                        for (DataSnapshot ds : dataSnapshot.getChildren()){
                            String imageUrl = ds.child("imageUrl").getValue(String.class);
                                    String link = ds.child("link").getValue(String.class);

                           // Picasso.get().load(imageUrl).into(rImage);


                            Glide.with(rootView)
                                    .load(imageUrl).into(rImage);
                        }



                    }

                    @Override
                    public void onCancelled(@androidx.annotation.NonNull DatabaseError error) {

                    }


                });





        Button button1 = rootView.findViewById(R.id.MoreButton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EventsActivity.class);
                startActivity(intent);
            }
        });



        Button button = rootView.findViewById(R.id.hButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail();
            }
        });
        return rootView;
    }

    public void updateDetail() {
        Intent intent = new Intent(getActivity(), UserList.class);
        startActivity(intent);
    }



}





