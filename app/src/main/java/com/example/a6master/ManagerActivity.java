package com.example.a6master;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        String message1;
        String message2;
        String message3;
        String message4;
        TextView player1 = findViewById(R.id.player1);
        TextView player2 = findViewById(R.id.player2);
        TextView player3 = findViewById(R.id.player3);
        TextView player4 = findViewById(R.id.player4);

        int n = getIntent().getIntExtra("hito", 0);

        Intent intentMain = getIntent();
        if (n == 1) {
            message1 = intentMain.getStringExtra(EnterNameActivity.EXTRA_MESSAGE1);
            player1.setText(message1);
        }
        if (n == 2) {
            message1 = intentMain.getStringExtra(EnterName2Activity.EXTRA_MESSAGE1);
            message2 = intentMain.getStringExtra(EnterName2Activity.EXTRA_MESSAGE2);
            player1.setText(message1);
            player2.setText(message2);

        }
        if (n == 3) {
            message1 = intentMain.getStringExtra(EnterName3Activity.EXTRA_MESSAGE1);
            message2 = intentMain.getStringExtra(EnterName3Activity.EXTRA_MESSAGE2);
            message3 = intentMain.getStringExtra(EnterName3Activity.EXTRA_MESSAGE3);
            player1.setText(message1);
            player2.setText(message2);
            player3.setText(message3);
        }
        if (n == 4) {
            message1 = intentMain.getStringExtra(EnterName4Activity.EXTRA_MESSAGE1);
            message2 = intentMain.getStringExtra(EnterName4Activity.EXTRA_MESSAGE2);
            message3 = intentMain.getStringExtra(EnterName4Activity.EXTRA_MESSAGE3);
            message4 = intentMain.getStringExtra(EnterName4Activity.EXTRA_MESSAGE4);
            player1.setText(message1);
            player2.setText(message2);
            player3.setText(message3);
            player4.setText(message4);
        }

    }
}