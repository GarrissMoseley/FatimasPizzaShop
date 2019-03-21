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

    private EditText name, address, phoneNumber;

    private Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_order_delivery_info);

        name  = (EditText) findViewById(R.id.nameEditText);
        address = (EditText) findViewById(R.id.addressEditText);
        phoneNumber = (EditText) findViewById(R.id.phoneNumberEditText);

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

        if(!name.getText().toString().equals("")) {

            nameEntered = true;
        }
        if(!address.getText().toString().equals("")) {

            addressEntered = true;
        }
        if(!phoneNumber.getText().toString().equals("")) {

            phoneNumberEntered = true;
        }

        if(nameEntered
                && addressEntered
                && phoneNumberEntered) {

            return true;
        }
        else {

            return false;
        }
    }
}
