package edu.northsouth.application;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * THis is the class for sign Up a member using FireBase API
 * The type Sign up.
 *
 * @author Tushar
 * @version 1.00
 */
public class SignUp extends AppCompatActivity implements View.OnClickListener {


    private EditText fullNameSUEditText, emailSUEditText, passSUEditText, locationSUEditText, phnNoSuEditText; //Create EditText objects
    private Button signUpSUBtn; // Create Button Object
    private TextView signInSUTextView ; //Create TextView Object
    private ProgressBar progressBarSUProgressBar; // Create ProgressBar object

    private RadioButton genderSuRadioButton;
    private RadioGroup genderSURadioGroup;


    //add firebase database stuff
    private FirebaseAuth mAuth; // Create FireBase object for Authentication
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;


    /**
     *  method for realtime activity handling in this class
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.setTitle("Sign Up"); // Setting title of this screen

        //declare firebase database objetcs
        mAuth = FirebaseAuth.getInstance();// mAuth comment
        mFirebaseDatabase = FirebaseDatabase.getInstance();


        // Initialize EditText Objects
        fullNameSUEditText = (EditText) findViewById(R.id.fullNameSUEditText);
        emailSUEditText = (EditText) findViewById(R.id.emailSUEditText);
        passSUEditText = (EditText) findViewById(R.id.passwordSUEditText);
        phnNoSuEditText = (EditText) findViewById(R.id.phnNoSUEditText);
        locationSUEditText = (EditText) findViewById(R.id.locationSUEditText);

        // Initialize RadioButton objects
        genderSURadioGroup = (RadioGroup) findViewById(R.id.genderSURadioGroup);


        // initialize Button Objetc
        signUpSUBtn = (Button) findViewById(R.id.signUpSUBtn);
        // Initialize ProgressBar Object
        progressBarSUProgressBar = (ProgressBar) findViewById(R.id.signUpProgressBar);
        // Initialize TextView objetcs
        signInSUTextView = (TextView) findViewById(R.id.signInSUEextView);

        // Declare on click listener to some specific objects
        signUpSUBtn.setOnClickListener(this);
        signInSUTextView.setOnClickListener(this);



    }

    /**
     * On click listerner method controls all the actions in StoreOwner class
     * @param no parametr
     */
    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.signUpSUBtn:
                userRegister();
                break;

            case R.id.signInSUEextView:
                Intent signIn = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(signIn);
                break;
        }
    }
    /**
    * userRegister method create a user in FIREBASE database Existing API
    *
    * This is a method of SignUp class that is build to only create a sign up authentication in FireBase cloud server
    * @param takes no parameter as input. Uses emailEditText and passwordEditText as default inputs
    * @return void type return
    */
    private void userRegister()
    {
        String email, password; // String types Email and Password variables

        email = emailSUEditText.getText().toString().trim();
        password = passSUEditText.getText().toString().trim();

        //checking the validity of the email
        if(email.isEmpty())
        {
            emailSUEditText.setError("Enter an email address");
            emailSUEditText.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            emailSUEditText.setError("Enter a valid email address");
            emailSUEditText.requestFocus();
            return;
        }

        //checking the validity of the password
        if(password.isEmpty())
        {
            passSUEditText.setError("Enter a password");
            passSUEditText.requestFocus();
            return;
        }

        if(password.length()<6)
        {
            passSUEditText.setError("Password should be at least 6 character long");
            passSUEditText.requestFocus();
            return;
        }

        progressBarSUProgressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                progressBarSUProgressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    addDataToDB();// adding other user information to realtime database
                    Toast.makeText(getApplicationContext(), "Register is Successfull", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //Give Toast message with the email that already exist
                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(getApplicationContext(), "User with this email already have an account", Toast.LENGTH_SHORT).show();
                    }
                    //Give Toast message task is randomly is not successfull
                    else {
                        Toast.makeText(getApplicationContext(), "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }


        });

    }

    /**
     * Call this method when need to add data to firebase realtime databse
     * Add data in realtime dataabse
     * @param null takes no parameter
     */
    private void addDataToDB()
    {
        myRef = mFirebaseDatabase.getReference("customerid");
        //Check which radio gender button checked
        genderSuRadioButton = (RadioButton) findViewById(genderSURadioGroup.getCheckedRadioButtonId());
        //Create and declare object of CustomerId
        CustomerId customer = new CustomerId();
        customer.setName(fullNameSUEditText.getText().toString());
        customer.setEmail(emailSUEditText.getText().toString());
        customer.setGender(genderSuRadioButton.getText().toString());
        customer.setLocation(locationSUEditText.getText().toString());
        customer.setPhn_no(phnNoSuEditText.getText().toString());

        FirebaseUser userId = mAuth.getCurrentUser();
        String user = userId.getUid();
        myRef.child(user).setValue(customer);
        Toast.makeText(getApplicationContext(),"User Info Added",Toast.LENGTH_LONG).show();


    }

}
