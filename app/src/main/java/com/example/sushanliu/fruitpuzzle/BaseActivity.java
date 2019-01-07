package com.example.sushanliu.fruitpuzzle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

    }


    //Menu

    @Override
    public boolean onCreateOptionsMenu (Menu menu){

        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id==R.id.mnuShare)
        {
            Toast.makeText(this, "Share menu is Clicked", Toast.LENGTH_SHORT).show();
        }
        else  if (id==R.id.mnuAbout){
            Toast.makeText(this, "About menu is clicked", Toast.LENGTH_SHORT).show();
            Intent intentAbout = new Intent(this,AboutActivity.class);
            startActivity(intentAbout);

        }else if(id==R.id.mnuSettings){
            Toast.makeText(this,"Setting menu is clicked", Toast.LENGTH_SHORT ).show();
            Intent intentSetting = new Intent(BaseActivity.this,SettingActivity.class);
            startActivity(intentSetting);
        }
        return super.onOptionsItemSelected(item);
    }




}