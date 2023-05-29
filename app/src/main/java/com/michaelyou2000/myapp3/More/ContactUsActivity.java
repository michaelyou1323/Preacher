package com.michaelyou2000.myapp3.More;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.michaelyou2000.myapp3.R;

public class ContactUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        CardView card1 = findViewById(R.id.cardView1);
        CardView card2 = findViewById(R.id.cardView2);
        CardView card3 = findViewById(R.id.cardView3);
//        CardView card4 = findViewById(R.id.cardView4);


        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("https://www.facebook.com/profile.php?id=100082959537977&mibextid=ZbWKwL");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });


        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("https://www.facebook.com/profile.php?id=100069166308498&mibextid=ZbWKwL");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });


    }



}