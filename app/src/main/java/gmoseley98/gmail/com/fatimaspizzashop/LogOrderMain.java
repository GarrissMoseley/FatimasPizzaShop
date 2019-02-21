/********************************
 * Author: Ethan Rimer
 * Class Name: LogOrderMain
 ********************************/
package gmoseley98.gmail.com.fatimaspizzashop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class LogOrderMain extends AppCompatActivity {

    private Button delivery;
    private Button inHouse;
    private Button takeOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_order_main);

        delivery = (Button) findViewById(R.id.deliveryBtn);
        inHouse = (Button) findViewById(R.id.inHouseBtn);
        takeOut = (Button) findViewById(R.id.takeOutBtn);
    }
}
