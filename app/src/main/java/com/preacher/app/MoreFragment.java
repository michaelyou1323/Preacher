package com.preacher.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.card.MaterialCardView;
import com.preacher.app.More.ContactUsActivity;
import com.preacher.app.More.EventsActivity;
import com.preacher.app.More.KerazaActivity;
import com.preacher.app.More.Service;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MoreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MoreFragment extends Fragment  {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MoreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MoreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MoreFragment newInstance(String param1, String param2) {
        MoreFragment fragment = new MoreFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View rootView = inflater.inflate(R.layout.fragment_more, container, false);

        MaterialCardView materialCardView1 = (MaterialCardView) rootView.findViewById(R.id.MCard1);
        MaterialCardView materialCardView2 = (MaterialCardView) rootView.findViewById(R.id.MCard2);
        MaterialCardView materialCardView3 = (MaterialCardView) rootView.findViewById(R.id.MCard3);
        MaterialCardView materialCardView4 = (MaterialCardView) rootView.findViewById(R.id.MCard4);





       materialCardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigatToService();
            }
        });

        materialCardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NavigatToEvents();
            }
        });

        materialCardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigatToKeraza();
            }
        });

        materialCardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigatToContactUs();
            }
        });


        return rootView;
    }

    public void NavigatToService() {

        Intent intent = new Intent(getActivity(), Service.class);
        startActivity(intent);
    }

    public void NavigatToEvents() {

        Intent intent = new Intent(getActivity(), EventsActivity.class);
        startActivity(intent);
    }

    public void NavigatToKeraza() {

        Intent intent = new Intent(getActivity(), KerazaActivity.class);
        startActivity(intent);
    }

    public void NavigatToContactUs() {

        Intent intent = new Intent(getActivity(), ContactUsActivity.class);
        startActivity(intent);
    }


}