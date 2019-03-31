/********************************
 * Author: Ethan Rimer
 * Class Name: PaymentCreditCardInfo
 * Class Description: Allows the user to enter a customer's credit card
 *  information if they paid with credit card.
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

    //  Creates an uninitialized Order object
    private Order order;

    //  Creates an uninitialized CreditCard object
    private CreditCard creditCard;

    //  Creates uninitialized String objects for card number, name on card,
    //  security number, and expiration
    private String cardNum, name, securityNum, expDate;

    //  Creates uninitialized EditText objects corresponding
    //  to the above String values
    private EditText cardNumEditText, nameEditText, securityNumEditText,
            expDateEditText;

    //  Creates an uninitialized Button object
    private Button finishBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_credit_card_info);

        //  Receives info from the previous activity from the Parcel
        //  and stores it in 'order'
        order = getIntent().getParcelableExtra("order_parcel_data");

        //  Sets the EditText object equal to the corresponding XML objects
        cardNumEditText = (EditText) findViewById(R.id.cardNumEditText);
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        securityNumEditText = (EditText) findViewById(R.id.securityNumEditText);
        expDateEditText = (EditText) findViewById(R.id.expDateEditText);

        //  Sets the Button object equal to the corresponding XML object
        finishBtn = (Button) findViewById(R.id.finishBtn);

        finishBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finishOrder();
            }
        }));
    }

    //  finishOrder() method
    //  First checks that all fields are filled,
    //  stores the card info in a CreditCard object,
    //  stores that in 'order,' and then returns to the home screen.
    public void finishOrder() {
        if(allFieldsFilled()) {

            order.setCreditCard(creditCard
                    = new CreditCard(cardNum, name, securityNum, expDate));

            Intent intent = new Intent(this, HomeScreen.class);

            Toast.makeText(getApplicationContext(),
                    "Order successfully logged",
                    Toast.LENGTH_LONG).show();

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