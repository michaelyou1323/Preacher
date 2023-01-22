package com.michaelyou2000.myapp3.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.michaelyou2000.myapp3.R;




public class VideosFragment extends Fragment implements AdapterView.OnItemSelectedListener {



    String[] country = {"India", "USA", "China", "Japan", "Other"};

    public VideosFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        }




    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.spinner,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_videos, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Spinner spin = (Spinner) view.findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);




            }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                getChildFragmentManager()
                        .beginTransaction()
                        .replace(R.id.VFramelayout, new FirstProgrammeFragment())
                        .commit();
                break;
            case 1:
                getChildFragmentManager()
                        .beginTransaction()
                        .replace(R.id.VFramelayout, new SecondProgrammeFragment())
                        .commit();
                break;
            case 2:
                getChildFragmentManager()
                        .beginTransaction()
                        .replace(R.id.VFramelayout, new ThirdProgrammeFragment())
                        .commit();
                break;

        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

