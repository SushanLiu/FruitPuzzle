package com.example.sushanliu.fruitpuzzle;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ValueMaster extends BaseActivity {

    private TextView textViewTimer2, tv3, tv4;
    private Button btnReady2;

    private static int SPLASH_TIME_OUT = 30000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_master);


        textViewTimer2 = (TextView)findViewById(R.id.Time2);
        Timer2();

        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        btnReady2 =(Button)findViewById(R.id.btn_ready2);

        btnReady2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToGame2();
            }
        });


        // Splash time out
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent game2Intent = new Intent(ValueMaster.this, Game_master.class);
                startActivity(game2Intent);
                finish();
            }
        }, SPLASH_TIME_OUT);

    }


    // Ready button to play game

    private void moveToGame2() {
        Intent intentGame2 = new Intent(this, Game_master.class);
        startActivity(intentGame2);
    }

    // Time countdown

    private void Timer2(){

        new CountDownTimer(30000, 3000) {
            @Override
            public void onTick(long millisUntilFinished) {

                textViewTimer2.setText("Timer is : "+ millisUntilFinished / 1000 +"s");
            }

            @Override
            public void onFinish() {
                textViewTimer2.setText("Timer is finished");

            }
        }.start();
    }
}
