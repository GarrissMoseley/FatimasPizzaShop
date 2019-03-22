/********************************
 * Author: Ethan Rimer
 * Class Name: LogOrderMain
 ********************************/
package gmoseley98.gmail.com.fatimaspizzashop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogOrderMain extends AppCompatActivity {

    private Button deliveryBtn, inHouseBtn, takeOutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_order_main);

        deliveryBtn = (Button) findViewById(R.id.deliveryBtn);
        inHouseBtn = (Button) findViewById(R.id.inHouseBtn);
        takeOutBtn = (Button) findViewById(R.id.takeOutBtn);

        deliveryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDeliveryInfo();
            }
        });

        inHouseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openInHouseInfo();
            }
        });

        takeOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openTakeoutInfo();
            }
        });
    }

    public void openDeliveryInfo() {

        Intent intent = new Intent(this, LogOrderDeliveryInfo.class);
        startActivity(intent);
    }

    public void openInHouseInfo() {

        Intent intent = new Intent(this, LogOrderInHouseInfo.class);
        startActivity(intent);
    }

    public void openTakeoutInfo() {

        Intent intent = new Intent(this, LogOrderTakeoutInfo.class);
        startActivity(intent);
    }
}