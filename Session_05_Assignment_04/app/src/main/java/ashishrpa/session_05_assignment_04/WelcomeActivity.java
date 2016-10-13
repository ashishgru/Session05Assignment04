package ashishrpa.session_05_assignment_04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Intent intent = getIntent();
        String userID = intent.getStringExtra("emailId");

        textView = (TextView)findViewById(R.id.tv_userName);
        textView.setText("WELCOME "+ userID);
    }
}
