package com.preacher.app.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.preacher.app.New.MyAdapter;
import com.preacher.app.New.User;
import com.preacher.app.R;

import java.util.ArrayList;


public class FifthProgrammeFragment extends Fragment {
    RecyclerView recyclerView;
    DatabaseReference database;
    MyAdapter myAdapter;
    ArrayList<User> users;
    private ArrayList<User> newsArrayList;
    private RecyclerView recyclerview;



    public FifthProgrammeFragment(){

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fifth_programme, container, false);




        recyclerView = view.findViewById(R.id.userList5);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(),2));

        database = FirebaseDatabase.getInstance().getReference("SecretsDetector");

        users = new ArrayList<>();
        myAdapter = new MyAdapter(requireContext(),users);
        myAdapter.setUsersList(users);
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    User user = dataSnapshot.getValue(User.class);
                    users.add(user);
                }
                myAdapter.setUsersList(users);
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });


        myAdapter = new MyAdapter(getActivity(), users);
        recyclerView.setAdapter(myAdapter);
        return view;



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




    }



}