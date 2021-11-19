package com.example.a6master;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        String message;

        Intent intentMain = getIntent();
        message = intentMain.getStringExtra(EnterNameActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.textView5);
        textView.setText(message);
    }
}