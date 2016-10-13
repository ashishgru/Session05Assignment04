package ashishrpa.session_05_assignment_04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    Bundle bundle;
    TextView textView;
    EditText emailText, passwordText;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.warningText);
        emailText = (EditText)findViewById(R.id.emailText);
        passwordText = (EditText)findViewById(R.id.passwordText);
        loginButton = (Button)findViewById(R.id.buttonLogin);

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub

                //Validation for Blank Field
                if(emailText.getText().toString().length()==0)
                {
                    Toast.makeText(getApplicationContext(), "Email cannot be Blank", Toast.LENGTH_LONG).show();
                    emailText.setError("Email cannot be Blank");
                    textView.setText("Email cannot be Blank");
                    textView.setVisibility(View.VISIBLE);
                    return;
                }
                else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(emailText.getText().toString()).matches())
                {
                    //Validation for Invalid Email Address
                    Toast.makeText(getApplicationContext(), "Invalid Email", Toast.LENGTH_LONG).show();
                    emailText.setError("Invalid Email");
                    textView.setText("Invalid Email");
                    textView.setVisibility(View.VISIBLE);
                    return;
                }
                else if(passwordText.getText().toString().length()==0)
                {
                    //Validation for Invalid Email Address
                    Toast.makeText(getApplicationContext(), "Password cannot be Blank", Toast.LENGTH_LONG).show();
                    passwordText.setError("Password cannot be Blank");
                    textView.setText("Password cannot be Blank");
                    textView.setVisibility(View.VISIBLE);
                    return;
                }
                else
                {
                    //All is well
                    Toast.makeText(getApplicationContext(), "Validated Succesfully", Toast.LENGTH_LONG).show();
                    textView.setText("*** WELCOME ***");
                    textView.setVisibility(View.VISIBLE);

                    bundle = new Bundle();
                    bundle.putString("emailId",emailText.getText().toString());
                    intent = new Intent(MainActivity.this,WelcomeActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }

            }
        });
    }
}
