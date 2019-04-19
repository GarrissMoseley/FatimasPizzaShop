/********************************
 * Author: Ethan Rimer
 * Class Name: LogOrderPizzaSelection
 * Class Description: Allows the user to
 * select pizza type and size
 ********************************/
package gmoseley98.gmail.com.fatimaspizzashop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class LogOrderPizzaSelection extends AppCompatActivity {

    //  Creates an uninitialized Order object
    private Order order;

    //  Creates an uninitialized RadioGroup object for pizza type and size
    //  This means that only one type and size can be selected at a time
    private RadioGroup pizzaTypeRadGroup, pizzaSizeRadGroup;

    //  Creates uninitialized RadioButton objects for all pizza types and sizes
    private RadioButton supremeRadBtn, meatLoversRadBtn, cheeseRadBtn,
            pepperoniRadBtn, veggieRadBtn, sizeMediumRadBtn, sizeLargeRadBtn;

    //  Creates an uninitialized Button object
    private Button nextBtn;

    //  Creates two boolean values initialized to 'false'
    //  These correspond to the pizza type and size being selected
    private boolean pizzaTypeSelected = false;
    private boolean pizzaSizeSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_order_pizza_selection);

        //  Receives the Parcel from the intent that pointed to this activity
        //  and stores the data in 'order.'
        //  (Side note: I love this functionality. I had the option of using
        //  either the Parcelable or Serializable interface,
        //  as both do essentially the same thing. If you can't tell,
        //  I used Parcelable because I believe I read that although there was
        //  more coding involved, it would be faster than Serializable)
        order = getIntent().getParcelableExtra("order_parcel_data");

        order.addPizza();

        //  Sets the pizza type RadioGroup and RadioButtons
        //  to their XML counterparts
        pizzaTypeRadGroup = (RadioGroup) findViewById(R.id.pizzaTypeRadGroup);
        supremeRadBtn = (RadioButton) findViewById(R.id.supremeRadBtn);
        meatLoversRadBtn = (RadioButton) findViewById(R.id.meatLoversRadBtn);
        cheeseRadBtn = (RadioButton) findViewById(R.id.cheeseRadBtn);
        pepperoniRadBtn = (RadioButton) findViewById(R.id.pepperoniRadBtn);
        veggieRadBtn = (RadioButton) findViewById(R.id.veggieRadBtn);

        //  On checked change listener for pizza type radio group
        //  Sets order pizza type depending on what the user selects
        //  and sets pizzaTypeSelected to 'true'
        pizzaTypeRadGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
                    case R.id.supremeRadBtn:

                        order.getCurrentPizza().setType("Supreme");

                        break;

                    case R.id.meatLoversRadBtn:

                        order.getCurrentPizza().setType("Meat Lovers");

                        break;

                    case R.id.cheeseRadBtn:

                        order.getCurrentPizza().setType("Cheese");

                        break;

                    case R.id.pepperoniRadBtn:

                        order.getCurrentPizza().setType("Pepperoni");

                        break;

                    case R.id.veggieRadBtn:

                        order.getCurrentPizza().setType("Veggie");

                        break;
                }

                pizzaTypeSelected = true;
            }
        });

        //  Sets pizza size radio group and radio buttons
        //  to the corresponding XML object
        pizzaSizeRadGroup = (RadioGroup) findViewById(R.id.pizzaSizeRadGroup);
        sizeMediumRadBtn = (RadioButton) findViewById(R.id.sizeMediumRadBtn);
        sizeLargeRadBtn = (RadioButton) findViewById(R.id.sizeLargeRadBtn);

        //  On checked change listener for pizza size radio group
        //  Sets order pizza size depending on what the user selects
        //  and sets pizzaSizeSelected to 'true'
        pizzaSizeRadGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.sizeMediumRadBtn) {

                    order.getCurrentPizza().setSize("Medium");
                    order.getCurrentPizza().setCost(8);
                }
                else if(checkedId == R.id.sizeLargeRadBtn){

                    order.getCurrentPizza().setSize("Large");
                    order.getCurrentPizza().setCost(10);
                }

                pizzaSizeSelected = true;
            }
        });

        //  Initializes nextBtn
        nextBtn = (Button) findViewById(R.id.nextBtn);

        //  On click listener for nextBtn
        //  First checks that pizza type and size are selected then opens the
        //  next activity, otherwise the user is prompted to select one or both
        //  (Side note: I'm also pretty happy with this method's if-else
        //  statement. It may not be that impressive,
        //  but I think it's pretty cool. :)
        //  There's another one in payment selection.)
        nextBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //   "IF pizza type is not selected. . ."
                if(!pizzaTypeSelected) {

                    //  "AND pizza size is not selected. . ."
                    if(!pizzaSizeSelected) {

                        //  (User prompt) "Please select pizza type and size"
                        Toast.makeText(getApplicationContext(),
                                "Please select pizza type and size",
                                Toast.LENGTH_LONG).show();
                    }

                    //  "OTHERWISE. . . "
                    else {

                        //  (User prompt) "Please select pizza type"
                        Toast.makeText(getApplicationContext(),
                                "Please select pizza type",
                                Toast.LENGTH_LONG).show();
                    }
                }

                //  "OTHERWISE IF pizza size is not selected. . ."
                else if(!pizzaSizeSelected) {

                    //  (User prompt) "Please select pizza size"
                    Toast.makeText(getApplicationContext(),
                            "Please select pizza size",
                            Toast.LENGTH_LONG).show();
                }

                //  "OTHERWISE. . ."
                else {

                    //  Open next activity
                    openExtraToppings();
                }
            }
        }));
    }

    //  openExtraToppings()
    //  Launches the extra toppings activity,
    //  if you couldn't tell from the name
    public void openExtraToppings() {

        Intent intent = new Intent(this, LogOrderExtraToppings.class);

        //  Puts order info in a Parcel to be opened in the next activity
        intent.putExtra("order_parcel_data", order);

        startActivity(intent);
    }
}