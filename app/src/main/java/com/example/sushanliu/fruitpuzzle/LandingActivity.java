package com.example.sushanliu.fruitpuzzle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LandingActivity extends BaseActivity {
    Button btnLogin;
    EditText etName;
    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        // login button
        btnLogin = findViewById(R.id.btn_Login);
        etName = findViewById(R.id.et_name);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LandingActivity.this, LevelActivity.class);
                st = etName.getText().toString();
                i.putExtra("Value", st);
                startActivity(i);
                finish();
            }
        });
    }




}

