package gmoseley98.gmail.com.fatimaspizzashop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    private Button dailyReport;
    private Button placeOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        
        dailyReport = (Button) findViewById(R.id.dailyReportBtn);
        placeOrder = (Button) findViewById(R.id.orderBtn);

        dailyReport.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openDailyReport();

            }
        }
        );

        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlaceOrder();
            }
        });
    }

    public void openDailyReport() {
        Intent intent = new Intent(this, DailyReport.class);
        startActivity(intent);
    }

    public void openPlaceOrder() {
        Intent intentOrder = new Intent(this, PlaceOrder.class);
        startActivity(intentOrder);
    }
}
