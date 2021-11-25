package com.example.a6master;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private int PlayerNum = 0;
    private String Name[] = new String[4];
    private int Scores[] = new int[4];
    private TextView ScoreText[] = new TextView[4];
    private TextView Rank[] = new TextView[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //人数用の変数を初期化するための関数呼び出し
        numInit();
        //スコア用の変数を初期化するための関数呼び出し
        scoreInit();
        //プレイする人数以外のテキストを非表示にする関数を呼び出し
        hide();
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
        ScoreText[0].setText(String.valueOf(Scores[0]));
        ScoreText[1].setText(String.valueOf(Scores[1]));
        ScoreText[2].setText(String.valueOf(Scores[2]));
        ScoreText[3].setText(String.valueOf(Scores[3]));

        Rank[0] = findViewById(R.id.rank1);
        Rank[1] = findViewById(R.id.rank2);
        Rank[2] = findViewById(R.id.rank3);
        Rank[3] = findViewById(R.id.rank4);
    }

    private void numInit() {
        PlayerNum = getIntent().getIntExtra("PlayerNum", 0);
    }

    private void hide() {
        for(int i = PlayerNum; i < 4; i++) {
            ScoreText[i].setVisibility(View.GONE);
            Rank[i].setVisibility(View.GONE);
        }
    }
}