/********************************
 * Author: Ethan Rimer
 * Class Name: PaymentSelectPayment
 * Class Description: Allows the user to select payment type (cash or credit)
 * and enter order price
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

    //  Creates an uninitialized Order object
    private Order order;

    //  Creates an uninitialized RadioGroup and RadioButtons for payment type
    //  This means that only one payment type can be selected at a time
    private RadioGroup paymentTypeRadGroup;
    private RadioButton creditCardRadBtn, cashRadBtn;

    //  Creates an uninitialized EditText
    private EditText priceEditText;

    //  Creates an uninitialized Button object
    private Button nextBtn;

    //  Creates an Intent object and initializes it to 'null'
    private Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_select_payment);

        //  Receives info from the previous activity from the Parcel
        //  and stores it in 'order'
        order = getIntent().getParcelableExtra("order_parcel_data");

        //  Sets the RadioGroup and RadioButtons equal
        //  to the corresponding XML object
        paymentTypeRadGroup = (RadioGroup) findViewById(R.id.paymentTypeRadGroup);
        creditCardRadBtn = (RadioButton) findViewById(R.id.creditCardRadBtn);
        cashRadBtn = (RadioButton) findViewById(R.id.cashRadBtn);

        //  Sets the EditText equal to the corresponding XML object
        priceEditText = (EditText) findViewById(R.id.priceEditText);

        //  Sets the Button object equal to the corresponding XML object
        nextBtn = (Button) findViewById(R.id.nextBtn);

        //  On checked change listener for payment type
        //  Allows the user to choose payment type, i.e cash or credit card
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

        //  On click listener for nextBtn
        //  Checks that payment type is selected and price is entered before
        //  opening the next screen.
        //  If credit card is chosen, the credit card info screen is opened.
        //  If cash is chosen, the home screen is opened.
        nextBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //  "IF price is not entered. . ."
                if(!priceEntered()) {

                    //  "AND payment type is not selected. . ."
                    if(intent == null) {

                        //  (User prompt) "Please select payment type
                        //                  and enter order price"
                        Toast.makeText(getApplicationContext(),
                                "Please select payment type and enter order price",
                                Toast.LENGTH_LONG).show();
                    }

                    //  "OTHERWISE. . ."
                    else {

                        //  (User prompt) "Please enter order price"
                        Toast.makeText(getApplicationContext(),
                                "Please enter order price",
                                Toast.LENGTH_LONG).show();
                    }
                }

                //  "OTHERWISE, IF payment type is not selected. . ."
                else if(intent == null) {

                    //  (User prompt) "Please select payment type"
                    Toast.makeText(getApplicationContext(),
                            "Please select payment type",
                            Toast.LENGTH_LONG).show();
                }

                //  "OTHERWISE. . ."
                else {

                    //  Puts the order data in a Parcel
                    intent.putExtra("order_parcel_data", order);

                    //  Prints success dialog if payment type is cash
                    if(order.getPaymentType().equals("Cash")) {

                        Toast.makeText(getApplicationContext(),
                                "Order successfully logged",
                                Toast.LENGTH_LONG).show();
                    }

                    //  Opens the next activity
                    //  depending on what payment type was chosen
                    startActivity(intent);
                }
            }
        }));
    }

    //  creditCardSelected() method
    //  Sets the Intent to point to the credit card info screen
    //  if payment type is credit card
    //  and sets order payment type as credit card
    public void creditCardSelected() {

        intent = new Intent(this, PaymentCreditCardInfo.class);

        order.setPaymentType("Credit Card");
    }

    //  cashSelected() method
    //  Sets the Intent to point to the home screen
    //  if payment type is cash
    //  and sets order payment type as cash
    public void cashSelected() {

        intent = new Intent(this, HomeScreen.class);

        order.setCreditCard(null);
        order.setPaymentType("Cash");
    }

    //  priceEntered() method
    //  Checks that the price field isn't empty
    //  (Side note: Again, I don't know if it's necessarily efficient to have
    //  a method like this for just one boolean, but consistency or whatever.)
    public boolean priceEntered() {

        boolean priceEntered = false;

        if(!priceEditText.getText().toString().equals("")) {

            priceEntered = true;

            order.setPrice(Double.valueOf(priceEditText.getText().toString()));
        }

        return priceEntered;
    }
}