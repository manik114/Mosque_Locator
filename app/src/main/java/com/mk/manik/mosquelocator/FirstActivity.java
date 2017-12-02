package com.mk.manik.mosquelocator;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    MySQLite mySQLite;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        textView = (TextView) findViewById(R.id.textView2);
        mySQLite = new MySQLite(this,null,null,1);
        mySQLite.addProduct();
        MediaPlayer ring = MediaPlayer.create(FirstActivity.this,R.raw.rr);
        ring.start();

        printData();

    }
    public void printData(){
        String show = mySQLite.readData();
        textView.setText(show);
    }
    public void onClick(View v){
        Intent intent = new Intent(this,MapsActivity.class);
        startActivity(intent);
    }
    public void aboutmethod(View v){
        Intent intent1 = new Intent(this,About.class);
        startActivity(intent1);
    }
}
