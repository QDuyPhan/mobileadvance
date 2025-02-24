package com.example.mobileadvance.bt3;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mobileadvance.R;

import java.io.PrintWriter;
import java.net.Socket;

public class ClientActivity extends AppCompatActivity {
    private TextView chatbox;
    private EditText messageInput;
    private Button sendButton;
    private PrintWriter out;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chatbox = findViewById(R.id.chatbox);
        messageInput = findViewById(R.id.messageInput);
        sendButton = findViewById(R.id.sendButton);
        new Thread(new ClientThread()).start();
        sendButton.setOnClickListener(v -> sendMessage());
    }

    private void sendMessage() {
        String message = messageInput.getText().toString();
        if (out != null && !message.isEmpty()) {
            out.println(message);
            handler.post(() -> chatbox.append("\nBạn: " + message));
            messageInput.setText("");
        }
    }

    class ClientThread implements Runnable {

        @Override
        public void run() {
            try {
                Socket socket = new Socket("10.0.2.16", 12345);
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}