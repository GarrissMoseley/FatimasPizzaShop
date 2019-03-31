/********************************
 * Author: Ethan Rimer
 * Class Name: LogOrderDeliveryInfo
 * Class Description: Allows the user to enter customer
 * information for delivery orders, i.e name, address, and phone number.
 ********************************/
package gmoseley98.gmail.com.fatimaspizzashop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogOrderDeliveryInfo extends AppCompatActivity {

    //  Creates a new Delivery object
    //  and initializes it to an empty Delivery object
    private Delivery order = new Delivery();

    //  Creates three uninitialized EditText objects
    //  for name, address, and phone number
    private EditText nameEditText, addressEditText, phoneNumberEditText;

    //  Creates an uninitialized Button object
    private Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_order_delivery_info);

        //  Sets the three EditText objects equal
        //  to the corresponding XML objects
        nameEditText  = (EditText) findViewById(R.id.nameEditText);
        addressEditText = (EditText) findViewById(R.id.addressEditText);
        phoneNumberEditText = (EditText) findViewById(R.id.phoneNumberEditText);

        //  Sets nextBtn equal to the corresponding XML object
        nextBtn = (Button) findViewById(R.id.nextBtn);

        //  On click listener for nextBtn
        //  When clicked, nextBtn will open the pizza selection activity
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openPizzaSelection();
            }
        });
    }

    //  openPizzaSelection() method
    //  First checks that all fields are filled and then opens pizza selection
    public void openPizzaSelection() {
        if(allFieldsFilled()) {


            Intent intent = new Intent(this, LogOrderPizzaSelection.class);

            //  Adds Delivery object info to the intent via a Parcel
            intent.putExtra("order_parcel_data", order);

            startActivity(intent);
        }
        else {

            Toast.makeText(getApplicationContext(),
                    "Please complete all fields", Toast.LENGTH_LONG).show();
        }
    }

    //  allFieldsFilled() method
    //  Checks that all text fields are not empty
    //  Returns false if all fields do not have something in them
    //  (Side note: I'm pretty happy with this method and others like it
    //  because the first method I tried crashed the app
    //  and this is the first one that worked. :)
    //  One of these in in-house info, takeout info,
    //  payment selection, and credit card info)
    public boolean allFieldsFilled() {

        boolean nameEntered = false;
        boolean addressEntered = false;
        boolean phoneNumberEntered = false;

        if(!nameEditText.getText().toString().equals("")) {

            nameEntered = true;

            order.setName(nameEditText.getText().toString());
        }
        if(!addressEditText.getText().toString().equals("")) {

            addressEntered = true;

            order.setAddress(addressEditText.getText().toString());
        }
        if(!phoneNumberEditText.getText().toString().equals("")) {

            phoneNumberEntered = true;

            order.setPhoneNumber(phoneNumberEditText.getText().toString());
        }

        return (nameEntered && addressEntered && phoneNumberEntered);
    }
}