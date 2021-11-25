package com.example.a6master;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterName2Activity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE1 = "YourPackageName.MESSAGE1";
    public static final String EXTRA_MESSAGE2 = "YourPackageName.MESSAGE2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_name2);

        final EditText editText = findViewById(R.id.enterNameText);
        final EditText editText2 = findViewById(R.id.enterNameText2);

        Button okButton = (Button)findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent sendName = new Intent(getApplication(), ManagerActivity.class);
                if(editText.getText() != null) {
                    String str = editText.getText().toString();
                    sendName.putExtra(EXTRA_MESSAGE1, str);
                }
                if(editText2.getText() != null) {
                    String str2 = editText2.getText().toString();
                    sendName.putExtra(EXTRA_MESSAGE2, str2);
                }
                int hito=2;
                sendName.putExtra("hito", hito);
                startActivity(sendName);
            }
        });
    }
}
