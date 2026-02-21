package com.michaelyou2000.myapp3.New;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.cloudinary.android.MediaManager;
import com.cloudinary.android.callback.ErrorInfo;
import com.cloudinary.android.callback.UploadCallback;
import com.michaelyou2000.myapp3.HomeActivity;
import com.michaelyou2000.myapp3.Users;
import com.michaelyou2000.myapp3.databinding.ActivityUserListBinding;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

public class UserList extends AppCompatActivity {

    ActivityUserListBinding binding;
    String FirstName, LastName, PhoneNumber, Country, City, Region, Email, church;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Button button = binding.UButton;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirstName = binding.etFirstName.getText().toString();
                LastName = binding.etLastName.getText().toString();
                PhoneNumber = binding.etPhone.getText().toString();
                Country = binding.etCountry.getText().toString();
                City = binding.etCity.getText().toString();
                Region = binding.etRegion.getText().toString();
                Email = binding.etEmail.getText().toString();
                church = binding.etChurch.getText().toString();


                if (!FirstName.isEmpty()) {
                    if (!LastName.isEmpty()) {
                        if (!PhoneNumber.isEmpty()) {
                            if (!Country.isEmpty()) {
                                if (!City.isEmpty()) {
                                    if (!Region.isEmpty()) {
                                        if (!church.isEmpty()) {

                                            Users users = new Users(FirstName, LastName, PhoneNumber, Country, City, Region, church, Email);
                                            String userData = "FirstName: " + FirstName + "\n"
                                                    + "LastName: " + LastName + "\n"
                                                    + "PhoneNumber: " + PhoneNumber + "\n"
                                                    + "Country: " + Country + "\n"
                                                    + "City: " + City + "\n"
                                                    + "Region: " + Region + "\n"
                                                    + "Email: " + Email + "\n"
                                                    + "Church: " + church;

                                            InputStream inputStream = new ByteArrayInputStream(userData.getBytes());

                                            MediaManager.get().upload(inputStream)
                                                    .option("folder", "users")
                                                    .option("public_id", PhoneNumber + " " + FirstName)
                                                    .callback(new UploadCallback() {
                                                        @Override
                                                        public void onStart(String requestId) {
                                                        }

                                                        @Override
                                                        public void onProgress(String requestId, long bytes, long totalBytes) {
                                                        }

                                                        @Override
                                                        public void onSuccess(String requestId, Map resultData) {
                                                            binding.etFirstName.setText("");
                                                            binding.etLastName.setText("");
                                                            binding.etPhone.setText("");
                                                            binding.etCountry.setText("");
                                                            binding.etCity.setText("");
                                                            binding.etRegion.setText("");
                                                            binding.etEmail.setText("");
                                                            updateDetail();

                                                            Toast.makeText(UserList.this, "Successfully Sent", Toast.LENGTH_SHORT).show();
                                                        }

                                                        @Override
                                                        public void onError(String requestId, ErrorInfo error) {
                                                            Toast.makeText(UserList.this, "Upload failed: " + error.getDescription(), Toast.LENGTH_SHORT).show();
                                                        }

                                                        @Override
                                                        public void onReschedule(String requestId, ErrorInfo error) {
                                                        }
                                                    })
                                                    .dispatch();

                                        } else {
                                            Toast.makeText(UserList.this, "Please Enter Your Church Name ", Toast.LENGTH_SHORT).show();
                                        }
                                    } else {
                                        Toast.makeText(UserList.this, "Please Enter Your Region", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(UserList.this, "Please Enter Your City", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(UserList.this, "Please Enter Your Country", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(UserList.this, "Please Enter Your Phone Number", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(UserList.this, "Please Enter Your Last Name", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(UserList.this, "Please Enter Your First Name", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    public void updateDetail() {

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }


}
