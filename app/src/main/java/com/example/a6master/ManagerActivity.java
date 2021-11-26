package com.example.a6master;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class ManagerActivity extends AppCompatActivity {

    public static final String EXTRA_NAME1 = "YourPackageName.NAME1";
    public static final String EXTRA_NAME2 = "YourPackageName.NAME2";
    public static final String EXTRA_NAME3 = "YourPackageName.NAME3";
    public static final String EXTRA_NAME4 = "YourPackageName.NAME4";

    private String Name[] = new String[4];
    private ImageView Masses[] = new ImageView[10];
    private ImageView Players[] = new ImageView[4];
    private int PlayerPosition[][] = new int[4][2];
    private int PlayerNum = 0;
    private int Num = 0;

    private TextView Player = null;
    private TextView Number = null;
    private TextView Name1 = null;
    private TextView Name2 = null;
    private TextView Name3 = null;
    private TextView Name4 = null;
    private TextView ScoresText[] = new TextView[4];

    private int NowPosition[] = new int[4];
    private int PointX[] = new int[4];
    private int PointY[] = new int[4];
    private int Scores[] = new int[4];

    private int Rank = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        PlayerNum = getIntent().getIntExtra("hito", 0);
        Number = findViewById(R.id.number);

        //名前用の変数を初期化するための関数呼び出し
        nameInit();
        // マス用の変数を初期化するための関数呼び出し
        massInit();
        // プレイヤー用の変数を初期化するための関数呼び出し
        playersInit();
        //スコア用の変数を初期化するための関数呼び出し
        setScores();
        //プレイする人数以外の駒を非表示にする関数を呼び出し
        playerHide();

        Player.setText(Name[Num]);

        Button daice = findViewById(R.id.daice);
        daice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int randomValue = random.nextInt(6) + 1;

                Number.setText(String.valueOf(randomValue));

                NowPosition[Num] = NowPosition[Num] + randomValue;
                if (NowPosition[Num] > 9) {
                    NowPosition[Num] = 9 - (NowPosition[Num] - 9);
                }

                int massPosition[] = new int[2];
                Masses[NowPosition[Num]].getLocationInWindow(massPosition);
                Players[Num].getLocationInWindow(PlayerPosition[Num]);
                TranslateAnimation translate = new TranslateAnimation(PointX[Num], massPosition[0] - PlayerPosition[Num][0], PointY[Num], massPosition[1] - PlayerPosition[Num][1]);
                PointX[Num] = massPosition[0] - PlayerPosition[Num][0];
                PointY[Num] = massPosition[1] - PlayerPosition[Num][1];
                translate.setDuration(500);
                translate.setFillAfter(true);

                translate.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        //各マスに止まった時のスコアの処理をする関数呼び出し
                        score();

                        ScoresText[Num].setText(String.valueOf(Scores[Num]));

                        Num++;
                        if (Num > PlayerNum - 1) {
                            Num = 0;
                        }

                        //ゴールした人を飛ばす関数呼び出し
                        skip();

                        //画面遷移させるための関数呼び出し
                        intent();

                        Player.setText(Name[Num]);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                Players[Num].startAnimation(translate);
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

        Name1 = findViewById(R.id.name1);
        Name2 = findViewById(R.id.name2);
        Name3 = findViewById(R.id.name3);
        Name4 = findViewById(R.id.name4);
        Name1.setText(Name[0]);
        Name2.setText(Name[1]);
        Name3.setText(Name[2]);
        Name4.setText(Name[3]);
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
            ScoresText[i].setVisibility(View.GONE);
        }
    }

    private void score() {
        if (NowPosition[Num] == 1) {
            Scores[Num] += 5;
        } else if (NowPosition[Num] == 2){
            Scores[Num] += 3;
        }else if (NowPosition[Num] == 3){
            Scores[Num] -= 2;
        }else if (NowPosition[Num] == 4){
            Scores[Num] += 4;
        }else if (NowPosition[Num] == 5){
            Scores[Num] -= 3;
        }else if (NowPosition[Num] == 6){
            Scores[Num] += 10;
        }else if (NowPosition[Num] == 7){
            Scores[Num] -= 5;
        }else if (NowPosition[Num] == 8){
            Scores[Num] -= 3;
        }else if (NowPosition[Num] == 9){
            goal();
        }
    }

    private void goal() {
        if(Rank == 1) {
            Scores[Num] += 30;
        }else if(Rank == 2){
            Scores[Num] += 20;
        }else if(Rank == 3){
            Scores[Num] += 15;
        }else{
            Scores[Num] += 10;
        }
        Rank++;
    }

    private void setScores(){
        ScoresText[0] = findViewById(R.id.score1);
        ScoresText[1] = findViewById(R.id.score2);
        ScoresText[2] = findViewById(R.id.score3);
        ScoresText[3] = findViewById(R.id.score4);
    }

    private void skip() {
        int count = 0;
        while(NowPosition[Num] == 9) {
            count++;

            Num++;
            if (Num > PlayerNum - 1) {
                Num = 0;
            }

            if(count >= PlayerNum) {
                break;
            }
        }
    }

    private void intent() {
        final Intent intent = new Intent(getApplication(), ResultActivity.class);

        intent.putExtra("score1", Scores[0]);
        intent.putExtra("score2", Scores[1]);
        intent.putExtra("score3", Scores[2]);
        intent.putExtra("score4", Scores[3]);
        intent.putExtra("PlayerNum", PlayerNum);
        intent.putExtra(EXTRA_NAME1, Name[0]);
        intent.putExtra(EXTRA_NAME2, Name[1]);
        intent.putExtra(EXTRA_NAME3, Name[2]);
        intent.putExtra(EXTRA_NAME4, Name[3]);

        if(PlayerNum == 1) {
            if(NowPosition[0] == 9) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(intent);
                    }
                }, 3000);
            }
        }else if(PlayerNum == 2) {
            if((NowPosition[0] == 9) && (NowPosition[1] == 9)) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(intent);
                    }
                }, 3000);
            }
        }else if(PlayerNum == 3) {
            if ((NowPosition[0] == 9) && (NowPosition[1] == 9) && (NowPosition[2] == 9)) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(intent);
                    }
                }, 3000);
            }
        }else if(PlayerNum == 4) {
            if ((NowPosition[0] == 9) && (NowPosition[1] == 9) && (NowPosition[2] == 9) && (NowPosition[3] == 9)) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(intent);
                    }
                }, 3000);
            }
        }
    }
}