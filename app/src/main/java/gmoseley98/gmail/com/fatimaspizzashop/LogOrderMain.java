/********************************
 * Author: Ethan Rimer
 * Class Name: LogOrderMain
 * Class Description: This is the main activity for logging an order.
 * Here, the user chooses whether to log a delivery, in-house,
 * or takeout order.
 ********************************/
package gmoseley98.gmail.com.fatimaspizzashop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogOrderMain extends AppCompatActivity {

    //  Creates three uninitialized Button objects
    private Button deliveryBtn, inHouseBtn, takeOutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_order_main);

        //  Sets the three Button objects equal
        //  to the corresponding XML objects
        deliveryBtn = (Button) findViewById(R.id.deliveryBtn);
        inHouseBtn = (Button) findViewById(R.id.inHouseBtn);
        takeOutBtn = (Button) findViewById(R.id.takeOutBtn);

        //  On click listener for deliveryBtn
        //  When clicked, the delivery button will open the
        //  delivery info activity
        deliveryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDeliveryInfo();
            }
        });

        //  On click listener for inHouseBtn
        //  When clicked, the in-house button will open the
        //  in-house info activity
        inHouseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openInHouseInfo();
            }
        });

        //  On click listener for takeOutBtn
        //  When clicked, the takeout button will open the
        //  takeout info activity
        takeOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openTakeoutInfo();
            }
        });
    }

    //  openDeliveryInfo() method
    //  Opens delivery info page
    public void openDeliveryInfo() {

        Intent intent = new Intent(this, LogOrderDeliveryInfo.class);
        startActivity(intent);
    }

    //  openInHouseInfo() method
    //  Opens in-house info page
    public void openInHouseInfo() {

        Intent intent = new Intent(this, LogOrderInHouseInfo.class);
        startActivity(intent);
    }

    //  openTakeoutInfo() method
    //  Opens takeout info page
    public void openTakeoutInfo() {

        Intent intent = new Intent(this, LogOrderTakeoutInfo.class);
        startActivity(intent);
    }
}