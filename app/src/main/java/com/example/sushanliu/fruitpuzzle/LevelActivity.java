package com.example.sushanliu.fruitpuzzle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LevelActivity extends BaseActivity {

    private Button btnEasy, btnMaster, btnQuit;

    int count = 0;

    TextView tv, tvTime;
    String st;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        // passing name from Login page
        tv = findViewById(R.id.tv_name2);
        st= getIntent().getExtras().getString("Value");
        tv.setText(st);

        //Easy button, Master button, Quit button
        btnEasy = (Button)findViewById(R.id.btn_easy);
        btnMaster = (Button)findViewById(R.id.btn_master);
        btnQuit = (Button)findViewById(R.id.btn_quit);

        btnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEasyGame();
            }
        });

        btnMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasterGame();
            }
        });

        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quitGame();
            }
        });

    }

    //

    private void quitGame() {
        Intent intentQuit = new Intent(getApplicationContext(), LandingActivity.class);
        startActivity(intentQuit);
    }

    private void openMasterGame() {
        Intent intentMaster = new Intent(getApplicationContext(), ValueMaster.class);
        startActivity(intentMaster);
    }

    private void openEasyGame() {

        Intent intentEasy = new Intent(getApplicationContext(),ValueEasy.class);
        startActivity(intentEasy);
    }
}
