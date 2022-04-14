package com.example.utop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class Winner extends AppCompatActivity {
    private TextView textView;
    private LinearLayout layout;

    private Handler handler = new Handler();

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try{
                Random rn = new Random();
                layout.setBackgroundColor(Color.rgb(rn.nextInt()%255, rn.nextInt()%255, rn.nextInt()%255));
                handler.postDelayed(runnable, 500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Intent intent = getIntent();
        String player = intent.getExtras().getString("winner");

        textView = (TextView) findViewById(R.id.winner);
        textView.setText(player);

        layout = (LinearLayout) findViewById(R.id.layout);
        runnable.run();
    }
}