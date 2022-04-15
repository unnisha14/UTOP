package com.unnisha.utop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class SnakeGameActivity extends AppCompatActivity implements View.OnTouchListener{
    private GameEngine gameEngine;
    private SnakeView snakeView;
    private final Handler handler=new Handler();
    private final long updateDelay=500;

    private float prevX=0,prevY=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snake_game);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        gameEngine=new GameEngine();
        gameEngine.initGame();

        snakeView=(SnakeView)findViewById(R.id.snakeView);
        snakeView.setOnTouchListener(this);

        startUpdateHandler();
    }

    private void startUpdateHandler(){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                gameEngine.Update();

                if(gameEngine.getCurrentGameState()== GameState.Running){
                    handler.postDelayed(this,updateDelay);
                }

                if(gameEngine.getCurrentGameState()== GameState.Lost){
                    OnGameLost();
                }
                snakeView.setSnakeViewMap(gameEngine.getMap());
                snakeView.invalidate();
            }
        },updateDelay);
    }

    private void OnGameLost() {
        Toast.makeText(this, "You Lost", Toast.LENGTH_SHORT).show();
        AlertDialog.Builder builder = new AlertDialog.Builder(SnakeGameActivity.this);
        builder.setTitle("Snake Game");
        builder.setMessage("New game??");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = getIntent();
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
        builder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SnakeGameActivity.this);
                builder.setTitle(R.string.app_name);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setMessage("Do you want to exit?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public boolean onTouch(View view , MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                prevX=event.getX();
                prevY=event.getY();
                break;
            case MotionEvent.ACTION_UP:
                float newX=event.getX();
                float newY=event.getY();

                //calculate where we swiped
                if(Math.abs(newX-prevX)>Math.abs(newY-prevY)){
                    //Left-Right direction
                    if(newX>prevX){
                        //Right
                        gameEngine.UpdateDirection(Direction.East);
                    }else{
                        //Left
                        gameEngine.UpdateDirection(Direction.West);
                    }

                }
                else{
                    //Up-Down direction
                    if(newY>prevY){
                        //Down
                        gameEngine.UpdateDirection(Direction.South);
                    }else{
                        //Up
                        gameEngine.UpdateDirection(Direction.North);
                    }
                }
                break;
        }
        return true;
    }
}