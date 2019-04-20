package gmoseley98.gmail.com.fatimaspizzashop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LogOrderReviewOrder extends AppCompatActivity {

    private Order order;

    private Button addPizzaBtn, selectPaymentBtn;
    private TextView totalCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_order_review_order);

        order = getIntent().getParcelableExtra("order_parcel_data");

        addPizzaBtn = (Button) findViewById(R.id.addPizzaBtn);
        selectPaymentBtn = (Button) findViewById(R.id.selectPaymentBtn);

        totalCost = (TextView) findViewById(R.id.totalCostTextView);

        order.calculateTotalPrice();
        totalCost.setText("Total cost: $" + order.getTotalPrice());

        addPizzaBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openPizzaSelection();
            }
        }));

        selectPaymentBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openPaymentSelection();
            }
        }));
    }

    public void openPizzaSelection() {

        Intent intent = new Intent(this, LogOrderPizzaSelection.class);

        intent.putExtra("order_parcel_data", order);

        startActivity(intent);
    }

    public void openPaymentSelection() {

        Intent intent = new Intent(this, PaymentSelectPayment.class);

        intent.putExtra("order_parcel_data", order);

        startActivity(intent);
    }
}