package com.example.utop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView snake, dots;
    private ImageView rect1, rect2;
    private Handler handler = new Handler();

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try{
                Random rn = new Random();
                rect1.setColorFilter(Color.rgb(rn.nextInt()%255, rn.nextInt()%255, rn.nextInt()%255));
                rect2.setColorFilter(Color.rgb(rn.nextInt()%255, rn.nextInt()%255, rn.nextInt()%255));
                handler.postDelayed(runnable, 500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        snake = (ImageView) findViewById(R.id.snake);
        dots = (ImageView) findViewById(R.id.dots);
        rect1 = (ImageView) findViewById(R.id.rect1);
        rect2 = (ImageView) findViewById(R.id.rect2);

        runnable.run();

        snake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , SnakeGameActivity.class);
                startActivity(intent);
            }
        });

        dots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , DotGameActivity.class);
                startActivity(intent);
            }
        });
    }
}