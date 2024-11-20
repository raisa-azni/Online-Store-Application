package edu.northsouth.application;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Store Owner class declare all types of features and action and includes all functions related to this
 * @author tanmoy
 * @version 1
 */
public class StoreOwnerScreen extends AppCompatActivity implements View.OnClickListener {

    private Button profileStOwbtn, capacityStOwBtn, orderLogStOwBtn, productStatusStOwBtn, shippingGuyStOwBtn, paymentStatusStOwBtn, paymentMethodStOwBtn;

    /**
     * onCreate method for realtime activity handling in this class
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_owner_screen);
        this.setTitle("Store Owner");

        profileStOwbtn = (Button) findViewById(R.id.profileStOwbtn);
        capacityStOwBtn = (Button) findViewById(R.id.capacityStOwBtn);
        orderLogStOwBtn = (Button) findViewById(R.id.orderLogStOwBtn);
        productStatusStOwBtn = (Button) findViewById(R.id.productStatusStOwBtn);
        shippingGuyStOwBtn = (Button) findViewById(R.id.shippingGuyStOwBtn);
        paymentStatusStOwBtn = (Button) findViewById(R.id.paymentStatusStOwBtn);
        paymentMethodStOwBtn = (Button) findViewById(R.id.paymentMethodStOwBtn);

    }

    /**
     * On click listerner method controls all the actions in StoreOwner class
     * @param no parametr
     */
    @Override
    public void onClick(View view) {

    }
}
