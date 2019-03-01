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

public class LogOrderDeliveryInfo extends AppCompatActivity {

    private Button nextBtn;
    private EditText name;
    private EditText address;
    private EditText phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_order_delivery_info);

        nextBtn = (Button) findViewById(R.id.nextBtn);
        name = (EditText) findViewById(R.id.nameEditText);
        address = (EditText) findViewById(R.id.addressEditText);
        phoneNumber = (EditText) findViewById(R.id.phoneNumberEditText);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPizzaSelection();
            }
        });
    }

    public void openPizzaSelection() {

        Intent intent = new Intent(this, LogOrderPizzaSelection.class);
        startActivity(intent);
    }
}
