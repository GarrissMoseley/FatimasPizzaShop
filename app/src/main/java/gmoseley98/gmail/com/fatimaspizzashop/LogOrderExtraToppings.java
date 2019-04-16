/********************************
 * Author: Ethan Rimer
 * Class Name: LogOrderExtraToppings
 * Class Description: Allows the user to select extra toppings
 ********************************/
package gmoseley98.gmail.com.fatimaspizzashop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class LogOrderExtraToppings extends AppCompatActivity {

    //  Creates an uninitialized Order object
    private Order order;

    //  Creates uninitialized CheckBox objects for all ten toppings
    //  CheckBoxes can have more than one selection at a time,
    //  unlike RadioButtons in a RadioGroup
    private CheckBox mushroomsChkBox, onionsChkBox, grnPeppersChkBox,
            jalapenosChkBox, beefChkBox, chickenChkBox, sausageChkBox,
            pineappleChkBox, hamChkBox, spinachChkBox;

    //  Creates an uninitialized Button object
    private Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_order_extra_toppings);

        //  Receives info from the previous activity from the Parcel
        //  and stores it in 'order'
        order = getIntent().getParcelableExtra("order_parcel_data");

        //  Sets the CheckBoxes equal to the corresponding XML object
        mushroomsChkBox = (CheckBox) findViewById(R.id.mushroomsChkBox);
        onionsChkBox = (CheckBox) findViewById(R.id.onionsChkBox);
        grnPeppersChkBox = (CheckBox) findViewById(R.id.grnPeppersChkBox);
        jalapenosChkBox = (CheckBox) findViewById(R.id.jalapenosChkBox);
        beefChkBox = (CheckBox) findViewById(R.id.beefChkBox);
        chickenChkBox = (CheckBox) findViewById(R.id.chickenChkBox);
        sausageChkBox = (CheckBox) findViewById(R.id.sausageChkBox);
        pineappleChkBox = (CheckBox) findViewById(R.id.pineappleChkBox);
        hamChkBox = (CheckBox) findViewById(R.id.hamChkBox);
        spinachChkBox = (CheckBox) findViewById(R.id.spinachChkBox);

        //  Sets the Button object equal to the corresponding XML object
        nextBtn = (Button) findViewById(R.id.nextBtn);

        //  On click listener for nextBtn
        //  Launches the payment selection activity
        //  There is no need to make sure something is selected because extra
        //  toppings are optional (hence 'extra').
        nextBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openPaymentSelection();
            }
        }));
    }

    //  onCheckboxClicked(View) method
    //  Checks if any CheckBoxes are checked
    //  and adds or removes extra toppings accordingly
    public void onCheckboxClicked(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.mushroomsChkBox:
                if(checked) {

                    order.addToppings("Mushrooms");
                }
                else {

                    order.removeToppings("Mushrooms");
                }

                break;

            case R.id.onionsChkBox:
                if(checked) {

                    order.addToppings("Onions");
                }
                else {

                    order.removeToppings("Onions");
                }

                break;

            case R.id.grnPeppersChkBox:
                if(checked) {

                    order.addToppings("Green Peppers");
                }
                else {

                    order.removeToppings("Green Peppers");
                }

                break;

            case R.id.jalapenosChkBox:
                if(checked) {

                    order.addToppings("Jalapeños");
                }
                else {

                    order.removeToppings("Jalapeños");
                }

                break;

            case R.id.beefChkBox:
                if(checked) {

                    order.addToppings("Beef");
                }
                else {

                    order.removeToppings("Beef");
                }

                break;

            case R.id.chickenChkBox:
                if(checked) {

                    order.addToppings("Chicken");
                }
                else {

                    order.removeToppings("Chicken");
                }

                break;

            case R.id.sausageChkBox:
                if(checked) {

                    order.addToppings("Sausage");
                }
                else {

                    order.removeToppings("Sausage");
                }

                break;

            case R.id.pineappleChkBox:
                if(checked) {

                    order.addToppings("Pineapple");
                }
                else {

                    order.removeToppings("Pineapple");
                }

                break;

            case R.id.hamChkBox:
                if(checked) {

                    order.addToppings("Ham");
                }
                else {

                    order.removeToppings("Ham");
                }

                break;

            case R.id.spinachChkBox:
                if(checked) {

                    order.addToppings("Spinach");
                }
                else {

                    order.removeToppings("Spinach");
                }

                break;
        }
    }

    //  openPaymentSelection() method
    //  Launches the payment selection screen
    public void openPaymentSelection() {

        Intent intent = new Intent(this, PaymentSelectPayment.class);

        //  Puts all order data in a Parcel to be sent to the next screen
        intent.putExtra("order_parcel_data", order);

        startActivity(intent);
    }
}