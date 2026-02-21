package com.preacher.app.New;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.preacher.app.HomeActivity;
import com.preacher.app.Users;
import com.preacher.app.databinding.ActivityUserListBinding;

public class UserList extends AppCompatActivity {

    ActivityUserListBinding binding;
    String FirstName ,LastName ,PhoneNumber ,Country ,City ,Region ,Email,church ;
    FirebaseDatabase database;
    DatabaseReference reference;

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



                     if (!FirstName.isEmpty()){
                         if ( !LastName.isEmpty()) {
                             if (!PhoneNumber.isEmpty()) {
                                 if (!Country.isEmpty()) {
                                     if (!City.isEmpty()) {
                                         if (!Region.isEmpty()) {
                                             if (!church.isEmpty()) {

                                                 Users users = new Users(FirstName, LastName, PhoneNumber, Country, City, Region,church ,Email);
                                                 database = FirebaseDatabase.getInstance();
                                                 reference = database.getReference("Users");
                                                 reference.child(PhoneNumber + " " + FirstName).setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                     @Override
                                                     public void onComplete(@NonNull Task<Void> task) {

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

                                                 });
                                             }
                                             else {  Toast.makeText(UserList.this, "Please Enter Your Church Name ", Toast.LENGTH_SHORT).show();}
                                         }
                                         else {  Toast.makeText(UserList.this, "Please Enter Your Region", Toast.LENGTH_SHORT).show();}
                                     }
                                     else {  Toast.makeText(UserList.this, "Please Enter Your City", Toast.LENGTH_SHORT).show();}
                                 }
                                 else {  Toast.makeText(UserList.this, "Please Enter Your Country", Toast.LENGTH_SHORT).show();}
                             }
                             else {  Toast.makeText(UserList.this, "Please Enter Your Phone Number", Toast.LENGTH_SHORT).show();}
                         }
                         else {  Toast.makeText(UserList.this, "Please Enter Your Last Name", Toast.LENGTH_SHORT).show();}
                     }
                     else {  Toast.makeText(UserList.this, "Please Enter Your First Name", Toast.LENGTH_SHORT).show();}




            }
        });

    }

    public void updateDetail() {

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }







}
