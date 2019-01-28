package gmoseley98.gmail.com.fatimaspizzashop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private TextView info;
    private Button login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.usernameEditText);
        password = (EditText) findViewById(R.id.passwordEditText);
        info = (TextView) findViewById(R.id.infoTextView);
        login = (Button) findViewById(R.id.loginBtn);

        info.setText("Number of attempts remaining: 5");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(username.getText().toString(), password.getText().toString());
            }
        });

    }

    private void validate(String userName, String password) {
        if((userName.equals("admin")) && (password.equals("2019"))) {
            Toast.makeText(getApplicationContext(),
                    "Redirecting...",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, HomeScreen.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(),
                    "Wrong Credentials",Toast.LENGTH_SHORT).show();
            counter--;

            info.setText("Number of attempts remaining: " + String.valueOf(counter));

            if(counter == 0) {
                login.setEnabled(false);
            }

        }

    }
}
