package com.example.mydemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //First Commit
    private ImageButton mediaButton, weatherButton,hvacButton, navigationButton,phoneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaButton = (ImageButton)findViewById(R.id.mediaBtn);
        weatherButton = (ImageButton)findViewById(R.id.weatherBtn);
        hvacButton = (ImageButton)findViewById(R.id.hvacBtn);
        navigationButton = (ImageButton)findViewById(R.id.navigationBtn);
        phoneButton = (ImageButton)findViewById(R.id.phoneBtn);

        //Media Button
        mediaButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");

                Intent activity2Intent = new Intent(getApplicationContext(), Media2Activity.class);
                startActivity(activity2Intent);
            }
        });

        //Weather button
        weatherButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activity2Intent = new Intent(getApplicationContext(), WeatherActivity.class);
                startActivity(activity2Intent);
            }
        });
        //Hvac button
        hvacButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activity2Intent = new Intent(getApplicationContext(), HvacActivity.class);
                startActivity(activity2Intent);
            }
        });

        //Navigation button
        navigationButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activity2Intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(activity2Intent);
            }
        });

        //Phone button
        phoneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activity2Intent = new Intent(getApplicationContext(), PhoneActivity.class);
                startActivity(activity2Intent);
            }
        });
    }
}
