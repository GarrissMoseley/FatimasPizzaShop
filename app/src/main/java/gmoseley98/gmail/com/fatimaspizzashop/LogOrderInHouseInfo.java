/********************************
 * Author: Ethan Rimer
 * Class Name: LogOrderInHouseInfo
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

    private EditText nameEditText;
    private Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_order_in_house_info);

        nameEditText = (EditText) findViewById(R.id.nameEditText);

        nextBtn = (Button) findViewById(R.id.nextBtn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void openPizzaSelection() {
        if(nameEntered()) {

            Intent intent = new Intent(this, LogOrderPizzaSelection.class);
            startActivity(intent);
        }
        else {

            Toast.makeText(getApplicationContext(),
                    "Please complete all fields", Toast.LENGTH_LONG).show();
        }
    }

    public boolean nameEntered() {

        boolean nameEntered = false;

        if(!nameEditText.getText().toString().equals("")) {

            nameEntered = true;
        }

        return nameEntered;
    }
}