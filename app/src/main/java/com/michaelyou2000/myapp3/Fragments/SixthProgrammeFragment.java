package com.michaelyou2000.myapp3.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cloudinary.android.MediaManager;
import com.google.gson.Gson;
import com.michaelyou2000.myapp3.New.MyAdapter;
import com.michaelyou2000.myapp3.New.User;
import com.michaelyou2000.myapp3.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;


public class SixthProgrammeFragment extends Fragment {
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    ArrayList<User> users;


    public SixthProgrammeFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sixth_programme, container, false);


        recyclerView = view.findViewById(R.id.userList6);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));

        users = new ArrayList<>();
        myAdapter = new MyAdapter(requireContext(), users);
        recyclerView.setAdapter(myAdapter);

        // TODO: Replace with your logic to get the list of file names from your Cloudinary folder
        List<String> fileNames = new ArrayList<>();
        fileNames.add("user1.json");
        fileNames.add("user2.json");

        for (String fileName : fileNames) {
            fetchUserData(fileName);
        }

        return view;


    }

    private void fetchUserData(String fileName) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String url = MediaManager.get().url().generate("SecretsDetector/" + fileName);
                    URL url_ = new URL(url);
                    HttpsURLConnection connection = (HttpsURLConnection) url_.openConnection();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                    reader.close();
                    String jsonString = stringBuilder.toString();

                    Gson gson = new Gson();
                    User user = gson.fromJson(jsonString, User.class);

                    if (user != null) {
                        users.add(user);
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                myAdapter.notifyItemInserted(users.size() - 1);
                            }
                        });
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }


}