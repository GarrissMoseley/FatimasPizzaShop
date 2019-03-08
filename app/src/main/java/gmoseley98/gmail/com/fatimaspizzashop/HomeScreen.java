package gmoseley98.gmail.com.fatimaspizzashop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    private Button dailyReport;
    private Button logOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        
        dailyReport = (Button) findViewById(R.id.dailyReportBtn);
        logOrder = (Button) findViewById(R.id.orderBtn);

        dailyReport.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openDailyReport();

            }
        }
        );

        logOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogOrder();
            }
        });
    }

    public void openDailyReport() {
        Intent intent = new Intent(this, DailyReport.class);
        startActivity(intent);
    }

    //  Changed intentOrder to point to LogOrderMain
    public void openLogOrder() {
        Intent intentOrder = new Intent(this, LogOrderMain.class);
        startActivity(intentOrder);
    }
}
