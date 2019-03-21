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
import games.aeres.smsvote.exception.RegisterException;

public class RegisterActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final SmsVoteApplication application    = (SmsVoteApplication) getApplication();
        final EditText nameInput                = findViewById(R.id.registerName);
        final EditText emailInput               = findViewById(R.id.registerEmail);
        final EditText phoneInput               = findViewById(R.id.registerPhone);
        final EditText passwordInput            = findViewById(R.id.registerPassword);
        final EditText passwordRepeatInput      = findViewById(R.id.registerPasswordR);
        final Button registerButton             = findViewById(R.id.registerButton);
        final Button loginButton                = findViewById(R.id.gotoLogin);

        registerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(!passwordInput.getText().toString().equals(passwordRepeatInput.getText().toString()))
                {
                    Toast.makeText(RegisterActivity.this, "Le mot de passe et sa validation ne sont pas identiques", Toast.LENGTH_LONG).show();
                    return;
                }

                try
                {
                    application.user = application.connectionManager.register(
                            nameInput.getText().toString(),
                            emailInput.getText().toString(),
                            passwordInput.getText().toString(),
                            phoneInput.getText().toString());
                    Toast.makeText(RegisterActivity.this, "Register OK", Toast.LENGTH_LONG).show();
                }
                catch(RegisterException exception)
                {
                    Toast.makeText(RegisterActivity.this, exception.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
