package edu.northsouth.application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Control all kind of activities of the user business
 * extends AppCompactActivity for compacting
 * Business type user UI goes through this class
 * @author Tushar
 */
public class UserBusiness extends AppCompatActivity {

    Button profileUsBuBtn,bookingUsBuBtn, locationUsBuBtn;

    /**
     * onCreate method for realtime activity handling in this class
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_business);
        this.setTitle("New Feed");

        profileUsBuBtn = (Button) findViewById(R.id.profileUsBuBtn);
        bookingUsBuBtn = (Button) findViewById(R.id.bookingUsBuBtn);
        locationUsBuBtn = (Button) findViewById(R.id.locationUsBuBtn);

        profileUsBuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),BusinessProfile.class));
            }
        });

        bookingUsBuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),StoreList.class));
            }
        });

        locationUsBuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MapsActivity.class));
            }
        });


    }
}
