package gmoseley98.gmail.com.fatimaspizzashop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class DailyReport extends AppCompatActivity {
    public static DatabaseHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_report);
        PieChart pieChart = findViewById(R.id.piechart);
        pieChart.setUsePercentValues(true);

        Description desc = new Description();
        desc.setText("");
        desc.setTextSize(20f);

        pieChart.setDescription(desc);

        pieChart.setHoleRadius(45f);
        pieChart.setTransparentCircleRadius(25f);

        List<PieEntry>value = new ArrayList<>();

        myDB = new DatabaseHelper(this);
        double deliveryRevenue = myDB.deliveryRevenue();
        double takeOutRevenue = myDB.takeOutRevenue();
        double inHouseRevenue = myDB.inHouseRevenue();

        // Test values according to the video tutorial
        value.add(new PieEntry((float)deliveryRevenue, "Delivery"));
        value.add(new PieEntry((float)takeOutRevenue, "Takeout"));
        value.add(new PieEntry((float)inHouseRevenue, "In-House"));

        PieDataSet pieDataSet = new PieDataSet(value, "Order Type");
        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);

        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        pieChart.animateXY(1400,1400);



    }
}
