/********************************
 * Author: Ethan Rimer
 * Class Name: LogOrderPizzaSelection
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

    private Order order;

    private RadioGroup pizzaTypeRadGroup;
    private RadioButton supremeRadBtn, meatLoversRadBtn, cheeseRadBtn,
            pepperoniRadBtn, veggieRadBtn;
    private RadioGroup pizzaSizeRadGroup;
    private RadioButton sizeMediumRadBtn, sizeLargeRadBtn;

    private Button nextBtn;

    private boolean pizzaTypeSelected = false;
    private boolean pizzaSizeSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_order_pizza_selection);

        setOrderType();

        pizzaTypeRadGroup = (RadioGroup) findViewById(R.id.pizzaTypeRadGroup);
        supremeRadBtn = (RadioButton) findViewById(R.id.supremeRadBtn);
        meatLoversRadBtn = (RadioButton) findViewById(R.id.meatLoversRadBtn);
        cheeseRadBtn = (RadioButton) findViewById(R.id.cheeseRadBtn);
        pepperoniRadBtn = (RadioButton) findViewById(R.id.pepperoniRadBtn);
        veggieRadBtn = (RadioButton) findViewById(R.id.veggieRadBtn);

        pizzaTypeRadGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
                    case R.id.supremeRadBtn:

                        order.setPizzaType("Supreme");

                        break;

                    case R.id.meatLoversRadBtn:

                        order.setPizzaType("Meat Lovers");

                        break;

                    case R.id.cheeseRadBtn:

                        order.setPizzaType("Cheese");

                        break;

                    case R.id.pepperoniRadBtn:

                        order.setPizzaType("Pepperoni");

                        break;

                    case R.id.veggieRadBtn:

                        order.setPizzaType("Veggie");

                        break;
                }

                pizzaTypeSelected = true;
            }
        });

        pizzaSizeRadGroup = (RadioGroup) findViewById(R.id.pizzaSizeRadGroup);
        sizeMediumRadBtn = (RadioButton) findViewById(R.id.sizeMediumRadBtn);
        sizeLargeRadBtn = (RadioButton) findViewById(R.id.sizeLargeRadBtn);

        pizzaSizeRadGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.sizeMediumRadBtn) {

                    order.setPizzaSize("Medium");
                }
                else if(checkedId == R.id.sizeLargeRadBtn){

                    order.setPizzaSize("Large");
                }

                pizzaSizeSelected = true;
            }
        });

        nextBtn = (Button) findViewById(R.id.nextBtn);

        nextBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!pizzaTypeSelected && !pizzaSizeSelected){

                    Toast.makeText(getApplicationContext(),
                            "Please select pizza type and size",
                            Toast.LENGTH_LONG).show();
                }
                else if(!pizzaTypeSelected && pizzaSizeSelected) {

                    Toast.makeText(getApplicationContext(),
                            "Please select pizza type",
                            Toast.LENGTH_LONG).show();
                }
                else if(pizzaTypeSelected && !pizzaSizeSelected) {

                    Toast.makeText(getApplicationContext(),
                            "Please select pizza size",
                            Toast.LENGTH_LONG).show();
                }
                else {

                    openExtraToppings();
                }
            }
        }));
    }

    public void setOrderType() {
        if(isDeliveryOrder()) {

            order = (Delivery) getIntent().getParcelableExtra(
                    "delivery_parcel_data");
        }
        else if(isInHouseOrder()) {

            order = (InHouse) getIntent().getParcelableExtra(
                    "inhouse_parcel_data");
        }
        else {

            order = (InHouse) getIntent().getParcelableExtra(
                    "inhouse_parcel_data");
        }
    }

    public void openExtraToppings() {

        Intent intent = new Intent(this, LogOrderExtraToppings.class);
        intent.putExtra("order_parcel_data", order);
        startActivity(intent);
    }

    public boolean isDeliveryOrder() {
        if(getIntent().getParcelableExtra("delivery_parcel_data") == null) {

            return false;
        }
        else {

            return true;
        }
    }

    public boolean isInHouseOrder() {
        if(getIntent().getParcelableExtra("inhouse_parcel_data") == null) {

            return false;
        }
        else {

            return true;
        }
    }

    public boolean isTakeoutOrder() {
        if(getIntent().getParcelableExtra("takeout_parcel_data") == null) {

            return false;
        }
        else {

            return true;
        }
    }
}