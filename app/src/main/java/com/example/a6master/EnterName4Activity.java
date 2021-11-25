package com.example.a6master;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterName4Activity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE1 = "YourPackageName.MESSAGE1";
    public static final String EXTRA_MESSAGE2 = "YourPackageName.MESSAGE2";
    public static final String EXTRA_MESSAGE3 = "YourPackageName.MESSAGE3";
    public static final String EXTRA_MESSAGE4 = "YourPackageName.MESSAGE4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_name4);

        final EditText editText = findViewById(R.id.enterNameText);
        final EditText editText2 = findViewById(R.id.enterNameText2);
        final EditText editText3 = findViewById(R.id.enterNameText3);
        final EditText editText4 = findViewById(R.id.enterNameText4);

        Button okButton = findViewById(R.id.okButton);
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
                if(editText3.getText() != null) {
                    String str3 = editText3.getText().toString();
                    sendName.putExtra(EXTRA_MESSAGE3, str3);
                }
                if(editText4.getText() != null) {
                    String str4 = editText4.getText().toString();
                    sendName.putExtra(EXTRA_MESSAGE4, str4);
                }
                int hito=4;
                sendName.putExtra("hito", hito);
                startActivity(sendName);
            }
        });
    }
}
