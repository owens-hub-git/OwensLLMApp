package com.example.llmexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.llmexample.data.DatabaseHelper;
import com.example.llmexample.model.user;

public class SignUpActivity extends AppCompatActivity {
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        EditText signUpUsernameEditText = findViewById(R.id.signUpUsernameEditText);
        EditText signUpPasswordEditText = findViewById(R.id.signUpPasswordEditText);
        EditText confirmEditText = findViewById(R.id.confirmEditText);
        Button signUpSaveButton = findViewById(R.id.signUpSaveButton);
        Button backLoginButton = findViewById(R.id.backLoginButton);
        db = new DatabaseHelper(this);

        signUpSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = signUpUsernameEditText.getText().toString();
                String password = signUpPasswordEditText.getText().toString();
                String confirmPassword = confirmEditText.getText().toString();

                if (password.equals(confirmPassword))
                {
                    long result = db.insertUser(new user(username, password));
                    if (result > 0)
                    {
                        Toast.makeText(SignUpActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUpActivity.this, InterestActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(SignUpActivity.this, "Registration Error", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(SignUpActivity.this, "Two Passwords don't match", Toast.LENGTH_SHORT).show();
                }
            }
        });
        backLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}