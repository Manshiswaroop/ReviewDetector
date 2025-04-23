package com.example.reviewdetector;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText reviewInput;
    Button detectButton;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reviewInput = findViewById(R.id.reviewInput);
        detectButton = findViewById(R.id.detectButton);
        resultText = findViewById(R.id.resultText);

        detectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String review = reviewInput.getText().toString();
                String result = detectFakeReview(review);
                resultText.setText("Result: " + result);
            }
        });
    }

    private String detectFakeReview(String review) {
        // Simulated AI logic: simple keyword-based detection
        String[] fakeKeywords = {"amazing", "awesome", "best ever", "superb", "incredible"};
        int score = 0;

        for (String keyword : fakeKeywords) {
            if (review.toLowerCase().contains(keyword)) {
                score++;
            }
        }

        if (score >= 2) {
            return "Fake Review";
        } else {
            return "Genuine Review";
        }
    }
}