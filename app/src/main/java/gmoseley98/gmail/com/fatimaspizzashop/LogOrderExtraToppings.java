/********************************
 * Author: Ethan Rimer
 * Class Name: LogOrderExtraToppings
 ********************************/
package gmoseley98.gmail.com.fatimaspizzashop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class LogOrderExtraToppings extends AppCompatActivity {

    private CheckBox mushroomsChkBox, onionsChkBox, grnPeppersChkBox,
            jalapenosChkBox, beefChkBox, chickenChkBox, sausageChkBox,
            pineappleChkBox, hamChkBox, spinachChkBox;

    private Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_order_extra_toppings);

        mushroomsChkBox = (CheckBox) findViewById(R.id.mushroomsChkBox);
        onionsChkBox = (CheckBox) findViewById(R.id.onionsChkBox);
        grnPeppersChkBox = (CheckBox) findViewById(R.id.grnPeppersChkBox);
        jalapenosChkBox = (CheckBox) findViewById(R.id.jalapenosChkBox);
        beefChkBox = (CheckBox) findViewById(R.id.beefChkBox);
        chickenChkBox = (CheckBox) findViewById(R.id.chickenChkBox);
        sausageChkBox = (CheckBox) findViewById(R.id.sausageChkBox);
        pineappleChkBox = (CheckBox) findViewById(R.id.mushroomsChkBox);
        hamChkBox = (CheckBox) findViewById(R.id.mushroomsChkBox);
        spinachChkBox = (CheckBox) findViewById(R.id.mushroomsChkBox);

        nextBtn = (Button) findViewById(R.id.nextBtn);

        nextBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openPaymentSelection();
            }
        }));
    }

    public void onCheckClicked(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.mushroomsChkBox:
                if(checked) {

                }
        }
    }

    public void openPaymentSelection() {

        Intent intent = new Intent(this, PaymentSelectPayment.class);
        startActivity(intent);
    }
}