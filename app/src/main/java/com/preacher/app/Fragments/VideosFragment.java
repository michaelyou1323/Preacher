package com.preacher.app.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.preacher.app.R;




public class VideosFragment extends Fragment implements AdapterView.OnItemSelectedListener {






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
                Toast.makeText(getActivity(), "Second Programme selected",
                        Toast.LENGTH_LONG).show();
                break;
            case 2:
                getChildFragmentManager()
                        .beginTransaction()
                        .replace(R.id.VFramelayout, new ThirdProgrammeFragment())
                        .commit();
                Toast.makeText(getActivity(), "Third Programme selected",
                        Toast.LENGTH_LONG).show();
                break;

                // To be edited
            case 3:
                getChildFragmentManager()
                        .beginTransaction()
                        .replace(R.id.VFramelayout, new FourthProgrammeFragment())
                        .commit();
                Toast.makeText(getActivity(), "Fourth Programme selected",
                        Toast.LENGTH_LONG).show();

                break;
            case 4:
                getChildFragmentManager()
                        .beginTransaction()
                        .replace(R.id.VFramelayout, new FifthProgrammeFragment())
                        .commit();
                Toast.makeText(getActivity(), "Fifth Programme selected",
                        Toast.LENGTH_LONG).show();
                break;

            case 5:
                getChildFragmentManager()
                        .beginTransaction()
                        .replace(R.id.VFramelayout, new SixthProgrammeFragment())
                        .commit();
                Toast.makeText(getActivity(), "Fifth Programme selected",
                        Toast.LENGTH_LONG).show();
                break;

        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


        Toast.makeText(getActivity(),"Please chose one ",
                Toast.LENGTH_LONG).show();
    }
}

