/********************************
 * Author: Ethan Rimer
 * Class Name: LogOrderDeliveryInfo
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

    private Delivery order = new Delivery();

    private EditText nameEditText, addressEditText, phoneNumberEditText;

    private Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_order_delivery_info);

        nameEditText  = (EditText) findViewById(R.id.nameEditText);
        addressEditText = (EditText) findViewById(R.id.addressEditText);
        phoneNumberEditText = (EditText) findViewById(R.id.phoneNumberEditText);

        nextBtn = (Button) findViewById(R.id.nextBtn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openPizzaSelection();
            }
        });
    }

    public void openPizzaSelection() {
        if(allFieldsFilled()) {


            Intent intent = new Intent(this, LogOrderPizzaSelection.class);
            intent.putExtra("order_parcel_data", order);

            startActivity(intent);
        }
        else {

            Toast.makeText(getApplicationContext(),
                    "Please complete all fields", Toast.LENGTH_LONG).show();
        }
    }

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