/********************************
 * Author: Ethan Rimer
 * Class Name: LogOrderTakeoutInfo
 ********************************/
package gmoseley98.gmail.com.fatimaspizzashop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogOrderTakeoutInfo extends AppCompatActivity {

    private TakeOut order = new TakeOut();

    private EditText nameEditText, phoneNumberEditText;
    private Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_order_takeout_info);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
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
            intent.putExtra("takeout_parcel_data", order);
            startActivity(intent);
        }
        else {

            Toast.makeText(getApplicationContext(),
                    "Please complete all fields", Toast.LENGTH_LONG).show();
        }
    }

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