package com.example.llmexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InterestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);

        Button booksButton = findViewById(R.id.booksButton);
        Button moviesButton = findViewById(R.id.moviesButton);
        Button scienceButton = findViewById(R.id.scienceButton);
        Button historyButton = findViewById(R.id.historyButton);
        Button technologyButton = findViewById(R.id.technologyButton);
        Button musicButton = findViewById(R.id.musicButton);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String topic = ((Button) v).getText().toString();

                SharedPreferences prefs = getSharedPreferences("AppPrefs", MODE_PRIVATE);
                prefs.edit().putString("preferred_topic", topic).apply();

                Intent intent = new Intent(InterestActivity.this, QuizFetch.class);
                startActivity(intent);
                finish();
            }
        };

        booksButton.setOnClickListener(listener);
        moviesButton.setOnClickListener(listener);
        scienceButton.setOnClickListener(listener);
        historyButton.setOnClickListener(listener);
        technologyButton.setOnClickListener(listener);
        musicButton.setOnClickListener(listener);


    }
}