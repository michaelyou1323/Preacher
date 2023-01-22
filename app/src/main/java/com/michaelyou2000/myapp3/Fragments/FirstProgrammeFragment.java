package com.michaelyou2000.myapp3.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.michaelyou2000.myapp3.Recyclerview.FProgrammeAdapter;
import com.michaelyou2000.myapp3.Recyclerview.FirstProgrammeDataModel;
import com.michaelyou2000.myapp3.R;


public class FirstProgrammeFragment extends Fragment {
RecyclerView recyclerView;
FProgrammeAdapter fProgrammeAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_first_programme, container,false);

        recyclerView = (RecyclerView)view.findViewById(R.id.rvFProgramme);




        FirebaseRecyclerOptions<FirstProgrammeDataModel> options =
                new FirebaseRecyclerOptions.Builder<FirstProgrammeDataModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("New page"), FirstProgrammeDataModel.class)
                        .build();


        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(),2));

        fProgrammeAdapter = new FProgrammeAdapter(options);
        recyclerView.setAdapter(fProgrammeAdapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onStart() {
        super.onStart();
        fProgrammeAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        fProgrammeAdapter.stopListening();
    }
}