/********************************
 * Author: Ethan Rimer
 * Class Name: LogOrderTakeoutInfo
 * Class Description: Allows the user to enter customer
 * information for takeout orders, i.e name and phone number.
 ********************************/
package gmoseley98.gmail.com.fatimaspizzashop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LogOrderTakeoutInfo extends AppCompatActivity {

    //  Creates a new TakeOut object
    //  and initializes it to an empty TakeOut object
    private TakeOut order = new TakeOut();

    //  Creates two new uninitialized EditText objects
    //  for customer name and phone number
    private EditText nameEditText, phoneNumberEditText;

    private CheckBox wasLateCheckBox;

    //  Creates an uninitialized Button object
    private Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_order_takeout_info);

        //  Sets the two EditText objects equal
        //  to the corresponging XML objects
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        phoneNumberEditText = (EditText) findViewById(R.id.phoneNumberEditText);

        wasLateCheckBox = (CheckBox) findViewById(R.id.wasLateCheckBox);

        //  Sets the Button object equal to the corresponding XML object
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

    public void onCheckboxClicked(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        if(checked) {

            order.setWasLate(true);
        }
        else {

            order.setWasLate(false);
        }
    }

    //  openPizzaSelection() method
    //  First checks that all fields are filled
    //  and then opens the pizza selection activity
    public void openPizzaSelection() {
        if(allFieldsFilled()) {

            Intent intent = new Intent(this, LogOrderPizzaSelection.class);

            //  Adds Takeout object info to the intent via a Parcel
            intent.putExtra("order_parcel_data", order);

            startActivity(intent);
        }
        else {

            Toast.makeText(getApplicationContext(),
                    "Please complete all fields", Toast.LENGTH_LONG).show();
        }
    }

    //  allFieldsFilled()
    //  Checks that both text fields are not null
    //  Returns false if both fields are not filled
    public boolean allFieldsFilled() {

        boolean nameEntered = false;
        boolean phoneNumberEntered = false;

        if(!nameEditText.getText().toString().equals("")) {

            nameEntered = true;

            order.setName(nameEditText.getText().toString());
        }
        if(!phoneNumberEditText.getText().toString().equals("")) {

            phoneNumberEntered = true;

            order.setPhoneNumber(phoneNumberEditText.getText().toString());
        }

        return nameEntered && phoneNumberEntered;
    }
}