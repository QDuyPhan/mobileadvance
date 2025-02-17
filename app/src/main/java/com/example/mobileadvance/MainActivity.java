package com.example.mobileadvance;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button startButton;
    private Button stopButton;
    private ProgressBar progressBar;
    private int counter = 0;
    private boolean isRunning = false;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textView = findViewById(R.id.textView);
        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);
        progressBar = findViewById(R.id.progressBar);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isRunning) {
                    isRunning = true;
                    counter = 0;
                    textView.setText(String.valueOf(counter));
                    progressBar.setProgress(0);
                    startCounting();
                }
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRunning = false;
            }
        });
    }

    private void startCounting() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (isRunning && counter < 10) {
                    try {
                        Thread.sleep(1000); // Delay 1 second
                        counter++;

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText(String.valueOf(counter));
                                progressBar.setProgress(counter * 10); // Update progress bar
                                if (counter == 10) {
                                    textView.setText("Hoàn thành!");
                                    isRunning = false;
                                }
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}