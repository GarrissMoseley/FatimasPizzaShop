package gmoseley98.gmail.com.fatimaspizzashop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class PaymentSelectPayment extends AppCompatActivity {

    private RadioGroup paymentTypeRadGroup;
    private RadioButton creditCardRadBtn, cashRadBtn;

    private Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_select_payment);

        paymentTypeRadGroup = (RadioGroup) findViewById(R.id.paymentTypeRadGroup);
        creditCardRadBtn = (RadioButton) findViewById(R.id.creditCardRadBtn);
        cashRadBtn = (RadioButton) findViewById(R.id.cashRadBtn);

        nextBtn = (Button) findViewById(R.id.nextBtn);
    }
}
