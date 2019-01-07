package com.example.sushanliu.fruitpuzzle;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ValueEasy extends BaseActivity {

    private TextView textViewTimer, tv1, tv2;
    private Button btnReady;

    private static int SPLASH_TIME_OUT = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_easy);
        textViewTimer = (TextView)findViewById(R.id.Timer);
        Timer();


        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        btnReady =(Button)findViewById(R.id.btn_ready);

        btnReady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToGame();
            }
        });


        // Splash time out
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent gameIntent = new Intent(ValueEasy.this, Game_easy.class);
                startActivity(gameIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);

    }

    // Ready button to play game

    private void moveToGame() {
        Intent intent = new Intent(this, Game_easy.class);
        startActivity(intent);
    }

    // Time countdown

    private void Timer(){

        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                textViewTimer.setText("Timer is : "+ millisUntilFinished / 1000 +"s");
            }

            @Override
            public void onFinish() {
                textViewTimer.setText("Timer is finished");

            }
        }.start();
    }


}
