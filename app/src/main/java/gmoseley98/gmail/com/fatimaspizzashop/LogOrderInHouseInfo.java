/********************************
 * Author: Ethan Rimer
 * Class Name: LogOrderInHouseInfo
 * Class Description: Allows the user to enter customer
 * information for in-house orders, i.e name.
 ********************************/
package gmoseley98.gmail.com.fatimaspizzashop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogOrderInHouseInfo extends AppCompatActivity {

    //  Creates a new InHouse object
    //  and initializes it to an empty InHouse object
    private InHouse order = new InHouse();

    //  Creates a single uninitialized EditText object for customer name
    private EditText nameEditText;

    //  Creates an uninitialized Button object
    private Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_order_in_house_info);

        //  Sets nameEditText equal to the corresponding XML object
        nameEditText = (EditText) findViewById(R.id.nameEditText);

        //  Sets nextBtn equal to the corresponding XML object
        nextBtn = (Button) findViewById(R.id.nextBtn);

        //  On click listener for nextBtn
        //  When clicked, nextBtn will open the pizza selection activity
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openPizzaSelection();
            }
        });
    }

    //  openPizzaSelection() method
    //  First checks that the name field isn't empty
    //  and then opens the pizza selection activity
    public void openPizzaSelection() {
        if(nameEntered()) {

            Intent intent = new Intent(this, LogOrderPizzaSelection.class);

            //  Adds InHouse object info to the intent via a Parcel
            intent.putExtra("order_parcel_data", order);

            startActivity(intent);
        }
        else {

            Toast.makeText(getApplicationContext(),
                    "Please complete all fields", Toast.LENGTH_LONG).show();
        }
    }

    //  nameEntered() method
    //  Checks that the name field isn't empty
    //  returns true if and only if the name field isn't null
    //  (Side note: I probably didn't need to make a whole method for just one
    //  boolean, but I did anyway for the sake of consistency)
    public boolean nameEntered() {

        boolean nameEntered = false;

        if(!nameEditText.getText().toString().equals("")) {

            nameEntered = true;

            order.setName(nameEditText.getText().toString());
        }

        return nameEntered;
    }
}