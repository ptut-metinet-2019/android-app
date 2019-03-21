package games.aeres.smsvote.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import games.aeres.smsvote.R;
import games.aeres.smsvote.SmsVoteApplication;
import games.aeres.smsvote.exception.LoginException;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SmsVoteApplication application    = (SmsVoteApplication) getApplication();
        final EditText emailInput               = findViewById(R.id.loginEmail);
        final EditText passwordInput            = findViewById(R.id.loginPassword);
        final Button loginButton                = findViewById(R.id.loginButton);
        final Button registerButton             = findViewById(R.id.gotoRegister);

        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                try
                {
                    application.user = application.connectionManager.login(emailInput.getText().toString(), passwordInput.getText().toString());
                    Toast.makeText(MainActivity.this, "Login OK", Toast.LENGTH_LONG).show();
                }
                catch(LoginException exception)
                {
                    Toast.makeText(MainActivity.this, exception.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
