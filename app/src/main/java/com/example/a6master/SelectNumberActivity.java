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

        //2人buttonを押すとEnterName2Activityに移動
        Button twoPlayButton = (Button)findViewById(R.id.twoPlayButton);
        twoPlayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SelectNumberActivity.this, EnterName2Activity.class);
                startActivity(intent);
            }
        });

        //3人buttonを押すとEnterName3Activityに移動
        Button threePlayButton = (Button)findViewById(R.id.threePlayButton);
        threePlayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SelectNumberActivity.this, EnterName3Activity.class);
                startActivity(intent);
            }
        });

        //4人buttonを押すとEnterName4Activityに移動
        Button fourPlayButton = (Button)findViewById(R.id.fourPlayButton);
        fourPlayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SelectNumberActivity.this, EnterName4Activity.class);
                startActivity(intent);
            }
        });
    }
}