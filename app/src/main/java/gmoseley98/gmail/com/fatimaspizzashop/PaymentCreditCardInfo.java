/********************************
 * Author: Ethan Rimer
 * Class Name: PaymentCreditCardInfo
 ********************************/
package gmoseley98.gmail.com.fatimaspizzashop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PaymentCreditCardInfo extends AppCompatActivity {

    private Order order;

    private CreditCard creditCard;

    private String cardNum, name, securityNum, expDate;

    private EditText cardNumEditText, nameEditText, securityNumEditText,
            expDateEditText;

    private Button finishBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_credit_card_info);

        order = (Delivery) getIntent().getParcelableExtra("order_parcel_data");

        cardNumEditText = (EditText) findViewById(R.id.cardNumEditText);
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        securityNumEditText = (EditText) findViewById(R.id.securityNumEditText);
        expDateEditText = (EditText) findViewById(R.id.expDateEditText);

        finishBtn = (Button) findViewById(R.id.finishBtn);

        finishBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finishOrder();
            }
        }));
    }

    public void finishOrder() {
        if(allFieldsFilled()) {

            order.setCreditCard(creditCard
                    = new CreditCard(cardNum, name, securityNum, expDate));

            Intent intent = new Intent(this, HomeScreen.class);
            startActivity(intent);
        }
        else {

            Toast.makeText(getApplicationContext(),
                    "Please complete all fields", Toast.LENGTH_LONG).show();
        }
    }

    public boolean allFieldsFilled() {

        boolean cardNumFilled = false;
        boolean nameFilled = false;
        boolean securityNumFilled = false;
        boolean expDateFilled = false;

        if(!cardNumEditText.getText().toString().equals("")) {

            cardNumFilled = true;

            cardNum = cardNumEditText.getText().toString();
        }
        if(!nameEditText.getText().toString().equals("")) {

            nameFilled = true;

            name = nameEditText.getText().toString();
        }
        if(!securityNumEditText.getText().toString().equals("")) {

            securityNumFilled = true;

            securityNum = securityNumEditText.getText().toString();
        }
        if(!expDateEditText.getText().toString().equals("")) {

            expDateFilled = true;

            expDate = expDateEditText.getText().toString();
        }

        return (cardNumFilled
                && nameFilled
                && securityNumFilled
                && expDateFilled);
    }
}