package com.example.a6master;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private int PlayerNum = 0;
    private String PlayerName[] = new String[4];
    private int Scores[] = new int[4];
    private  TextView NameText[] = new TextView[4];
    private  TextView ScoreText[] = new TextView[4];
    private  TextView Rank[] = new TextView[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //人数用の変数を初期化するための関数呼び出し
        numInit();
        //名前用の変数を初期化するための関数呼び出し
        nameInit();
        //スコア用の変数を初期化するための関数呼び出し
        scoreInit();
        //スコアを表示するための関数呼び出し
        view();
        //プレイする人数以外のテキストを非表示にする関数を呼び出し
        hide();
    }

    private void numInit() {
        PlayerNum = getIntent().getIntExtra("PlayerNum", 0);
    }

    private void nameInit() {
        Intent intentMain = getIntent();
        PlayerName[0] = intentMain.getStringExtra(ManagerActivity.EXTRA_NAME1);
        PlayerName[1] = intentMain.getStringExtra(ManagerActivity.EXTRA_NAME2);
        PlayerName[2] = intentMain.getStringExtra(ManagerActivity.EXTRA_NAME3);
        PlayerName[3] = intentMain.getStringExtra(ManagerActivity.EXTRA_NAME4);

        NameText[0] = findViewById(R.id.nameText1);
        NameText[1] = findViewById(R.id.nameText2);
        NameText[2] = findViewById(R.id.nameText3);
        NameText[3] = findViewById(R.id.nameText4);
    }

    private void scoreInit() {
        Scores[0] = getIntent().getIntExtra("score1", 0);
        Scores[1] = getIntent().getIntExtra("score2", 0);
        Scores[2] = getIntent().getIntExtra("score3", 0);
        Scores[3] = getIntent().getIntExtra("score4", 0);

        ScoreText[0] = findViewById(R.id.score1);
        ScoreText[1] = findViewById(R.id.score2);
        ScoreText[2] = findViewById(R.id.score3);
        ScoreText[3] = findViewById(R.id.score4);

        Rank[0] = findViewById(R.id.rank1);
        Rank[1] = findViewById(R.id.rank2);
        Rank[2] = findViewById(R.id.rank3);
        Rank[3] = findViewById(R.id.rank4);
    }

    private void view() {
        int temp;
        String tempString;
        int max;
        int maxNum = 0;
        int i, j;

        //得点の高い順に表示するために配列の中を降順にソート
        for(i = 0; i < PlayerNum-1; i++) {
            max = Scores[i];
            for(j = i+1; j < PlayerNum; j++) {
                if (Scores[j] > max) {
                    max = Scores[j];
                    maxNum = j;
                }
            }

            temp = Scores[i];
            Scores[i] = max;
            Scores[maxNum] = temp;

            tempString = PlayerName[i];
            PlayerName[i] = PlayerName[maxNum];
            PlayerName[maxNum] = tempString;
        }

        ScoreText[0].setText(String.valueOf(Scores[0]));
        ScoreText[1].setText(String.valueOf(Scores[1]));
        ScoreText[2].setText(String.valueOf(Scores[2]));
        ScoreText[3].setText(String.valueOf(Scores[3]));
        NameText[0].setText(PlayerName[0]);
        NameText[1].setText(PlayerName[1]);
        NameText[2].setText(PlayerName[2]);
        NameText[3].setText(PlayerName[3]);
    }

    private void hide() {
        for(int i = PlayerNum; i < 4; i++) {
            ScoreText[i].setVisibility(View.GONE);
            Rank[i].setVisibility(View.GONE);
        }
    }
}