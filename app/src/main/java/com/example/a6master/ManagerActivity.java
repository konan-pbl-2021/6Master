package com.example.a6master;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class ManagerActivity extends AppCompatActivity {

    private String Name[] = new String[4];
    private ImageView Masses[] = new ImageView[10];
    private ImageView Players[] = new ImageView[4];
    private int PlayerPosition[][] = new int[4][2];
    private int PlayerNum = 0;
    private int Num = 0;
    private TextView Player = null;
    private int NowPosition[] = new int[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        PlayerNum = getIntent().getIntExtra("hito", 0);

        //名前用の変数を初期化するための関数呼び出し
        nameInit();
        // マス用の変数を初期化するための関数呼び出し
        massInit();
        // プレイヤー用の変数を初期化するための関数呼び出し
        playersInit();
        //プレイする人数以外の駒を非表示にする関数を呼び出し
        playerHide();

        Player.setText(Name[Num]);

        Button saikoro = findViewById(R.id.saikoro);
        saikoro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int randomValue = random.nextInt(6)+1;

                NowPosition[Num] = NowPosition[Num] + randomValue;
                int massPosition[] = new int[2];
                Masses[NowPosition[Num]].getLocationInWindow(massPosition);
                Players[Num].getLocationInWindow(PlayerPosition[Num]);
                TranslateAnimation translate = new TranslateAnimation(0, massPosition[0]-PlayerPosition[Num][0], 0, massPosition[1]-PlayerPosition[Num][1]);
                translate.setDuration(500);
                translate.setFillAfter(true);
                Players[Num].startAnimation(translate);

                Num++;
                if(Num > PlayerNum-1) {
                    Num = 0;
                }
                Player.setText(Name[Num]);
            }
        });
    }

    private void nameInit(){
        Intent intentMain = getIntent();
        if (PlayerNum == 1) {
            Name[0] = intentMain.getStringExtra(EnterNameActivity.EXTRA_MESSAGE1);
        }
        if (PlayerNum == 2) {
            Name[0] = intentMain.getStringExtra(EnterName2Activity.EXTRA_MESSAGE1);
            Name[1] = intentMain.getStringExtra(EnterName2Activity.EXTRA_MESSAGE2);

        }
        if (PlayerNum == 3) {
            Name[0] = intentMain.getStringExtra(EnterName3Activity.EXTRA_MESSAGE1);
            Name[1] = intentMain.getStringExtra(EnterName3Activity.EXTRA_MESSAGE2);
            Name[2] = intentMain.getStringExtra(EnterName3Activity.EXTRA_MESSAGE3);
        }
        if (PlayerNum == 4) {
            Name[0] = intentMain.getStringExtra(EnterName4Activity.EXTRA_MESSAGE1);
            Name[1] = intentMain.getStringExtra(EnterName4Activity.EXTRA_MESSAGE2);
            Name[2] = intentMain.getStringExtra(EnterName4Activity.EXTRA_MESSAGE3);
            Name[3] = intentMain.getStringExtra(EnterName4Activity.EXTRA_MESSAGE4);
        }
    }
    private void massInit()
    {
        Masses[0] = findViewById(R.id.mass1);
        Masses[1] = findViewById(R.id.mass2);
        Masses[2] = findViewById(R.id.mass3);
        Masses[3] = findViewById(R.id.mass4);
        Masses[4] = findViewById(R.id.mass5);
        Masses[5] = findViewById(R.id.mass6);
        Masses[6] = findViewById(R.id.mass7);
        Masses[7] = findViewById(R.id.mass8);
        Masses[8] = findViewById(R.id.mass9);
        Masses[9] = findViewById(R.id.mass10);
    }

    private void playersInit() {
        Players[0] = findViewById(R.id.playerImage1);
        Players[1] = findViewById(R.id.playerImage2);
        Players[2] = findViewById(R.id.playerImage3);
        Players[3] = findViewById(R.id.playerImage4);

        Player = findViewById(R.id.player);
    }

    private void playerHide() {
        for(int i = PlayerNum; i < 4; i++) {
            Players[i].setVisibility(View.GONE);
        }
    }
}