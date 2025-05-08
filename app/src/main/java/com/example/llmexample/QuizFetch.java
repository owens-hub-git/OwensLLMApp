package com.example.llmexample;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuizFetch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_fetch);

        Button buttonToQuiz = findViewById(R.id.button);
        buttonToQuiz.setOnClickListener(v -> {
            Intent intent = new Intent(QuizFetch.this, MainActivity.class);
            startActivity(intent);
            finish();
        });



    }
}