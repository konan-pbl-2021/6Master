package com.example.a6master;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectNumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_number);

        //1人buttonを押すとEnterNameActivityに移動
        Button onePlayButton = (Button)findViewById(R.id.onePlayButton);
        onePlayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SelectNumberActivity.this, EnterNameActivity.class);
                startActivity(intent);
            }
        });
    }
}