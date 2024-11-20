package edu.northsouth.application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Retrives data of a logged in user to his profile screen
 * Data from database
 * @author tushar
 * @version 1
 */
public class BusinessProfile extends AppCompatActivity {

    TextView showIdBPTextView, showNameBPTextView, showMailBPTextView, showGenderBPTextView, showLocationBPTextView, showPhnBPTextView;
    ProgressBar profileBRProgressBar;

    private FirebaseAuth mAuth; // Create FireBase object for Authentication
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;
    public String userId;
    CustomerId custom = new CustomerId();

    /**
     * onCreate method for realtime activity handling in this class
     * @param savedInstanceState for saving the type instance
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_profile);
        this.setTitle("Profile");

        mAuth = FirebaseAuth.getInstance();// mAuth comment
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference("customerid");

        showIdBPTextView = (TextView) findViewById(R.id.showIdBPTextView);
        showNameBPTextView = (TextView) findViewById(R.id.showNameBPTextView);
        showMailBPTextView = (TextView) findViewById(R.id.showMailBPTextView);
        showGenderBPTextView = (TextView) findViewById(R.id.showGenderBPTextView);
        showLocationBPTextView = (TextView) findViewById(R.id.showLocationBPTextView);
        showPhnBPTextView = (TextView) findViewById(R.id.showPhnBPTextView);

        profileBRProgressBar = (ProgressBar) findViewById(R.id.profileBPProgressBar);


        FirebaseUser user = mAuth.getCurrentUser();
        userId = user.getUid();
        profileBRProgressBar.setVisibility(View.VISIBLE);
        /*

        if(getIntent().hasExtra("USER_UI_KEY"))
        {
            userId = getIntent().getExtras().getString("USER_UI_KEY");
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Not Getting info",Toast.LENGTH_SHORT).show();
        } */

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(userId!=null)
                {
                    Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Not Signed in",Toast.LENGTH_SHORT).show();
                }
            }
        };

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                //whwnever method is called
                //when any data modified

                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(getApplicationContext(),"Error: "+databaseError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * Dispaly the data of the authorized user to his screen
     * Retrives data from fireBase
     * Search the data through the database
     * @param dataSnapshot holds a dataset for result
     */
    private void showData(DataSnapshot dataSnapshot)
    {
        for(DataSnapshot ds : dataSnapshot.getChildren())
        {
            if(ds.getKey().equals(userId))
            {
                showIdBPTextView.setText(userId);
                showNameBPTextView.setText(ds.getValue(CustomerId.class).getName());
                showMailBPTextView.setText(ds.getValue(CustomerId.class).getEmail());
                showGenderBPTextView.setText(ds.getValue(CustomerId.class).getGender());
                showLocationBPTextView.setText(ds.getValue(CustomerId.class).getLocation());
                showPhnBPTextView.setText(ds.getValue(CustomerId.class).getPhn_no());
                profileBRProgressBar.setVisibility(View.GONE);

            }
            /*
            showIdBPTextView.setText(userId);

            custom.setName(ds.child(userId).getValue(CustomerId.class).getName());
            custom.setEmail(ds.child(userId).getValue(CustomerId.class).getEmail());
            custom.setGender(ds.child(userId).getValue(CustomerId.class).getGender());
            custom.setLocation(ds.child(userId).getValue(CustomerId.class).getLocation());
            custom.setPhn_no(ds.child(userId).getValue(CustomerId.class).getPhn_no());



            showNameBPTextView.setText(custom.getName());
             */



        }
    }
}
