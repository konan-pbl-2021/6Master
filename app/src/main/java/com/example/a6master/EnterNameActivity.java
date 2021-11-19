package com.example.a6master;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EnterNameActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE1 = "YourPackageName.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_name);

        final EditText editText = findViewById(R.id.enterNameText);

        Button okButton = (Button)findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent sendName = new Intent(getApplication(), ManagerActivity.class);
                if(editText.getText() != null){
                    String str = editText.getText().toString();
                    sendName.putExtra(EXTRA_MESSAGE1, str);
                }
                startActivity(sendName);
            }
        });
    }
}