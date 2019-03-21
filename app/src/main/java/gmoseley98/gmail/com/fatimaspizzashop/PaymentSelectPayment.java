/********************************
 * Author: Ethan Rimer
 * Class Name: PaymentSelectPayment
 ********************************/
package gmoseley98.gmail.com.fatimaspizzashop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PaymentSelectPayment extends AppCompatActivity {

    private RadioGroup paymentTypeRadGroup;
    private RadioButton creditCardRadBtn, cashRadBtn;

    private EditText priceEditText;

    private Button nextBtn;

    private Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_select_payment);

        paymentTypeRadGroup = (RadioGroup) findViewById(R.id.paymentTypeRadGroup);
        creditCardRadBtn = (RadioButton) findViewById(R.id.creditCardRadBtn);
        cashRadBtn = (RadioButton) findViewById(R.id.cashRadBtn);

        priceEditText = (EditText) findViewById(R.id.priceEditText);

        nextBtn = (Button) findViewById(R.id.nextBtn);

        paymentTypeRadGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.creditCardRadBtn) {

                    creditCardSelected();
                }
                else if(checkedId == R.id.cashRadBtn) {

                    cashSelected();
                }
            }
        });

        nextBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(priceEntered() && intent != null) {

                    startActivity(intent);
                }
                else if(!priceEntered() && intent == null){

                    Toast.makeText(getApplicationContext(),
                            "Please select payment type and enter order price",
                            Toast.LENGTH_LONG).show();
                }
                else if(!priceEntered() && intent != null) {

                    Toast.makeText(getApplicationContext(),
                            "Please enter order price",
                            Toast.LENGTH_LONG).show();
                }
                else if(priceEntered() && intent == null) {

                    Toast.makeText(getApplicationContext(),
                            "Please select payment type",
                            Toast.LENGTH_LONG).show();
                }
            }
        }));
    }

    public void creditCardSelected() {

        intent = new Intent(this, PaymentCreditCardInfo.class);
    }

    public void cashSelected() {

        intent = new Intent(this, HomeScreen.class);
    }

    public boolean priceEntered() {

        boolean priceEntered = false;

        if(!priceEditText.getText().toString().equals("")) {

            priceEntered = true;
        }

        if(priceEntered) {

            return true;
        }
        else {

            return false;
        }
    }
}