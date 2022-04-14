package com.example.utop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class DotGameActivity extends AppCompatActivity {
    private EditText player1, player2;
    private Button startButton, instrButton;
    private Spinner level_spinner;
    private int level;
    private String player1_name, player2_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dot_game);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        player1 = (EditText) findViewById(R.id.player1);
        player2 = (EditText) findViewById(R.id.player2);
        level_spinner = (Spinner) findViewById(R.id.level);
        startButton = (Button) findViewById(R.id.start);
        instrButton = (Button) findViewById(R.id.instr);
        setSpinner();
        startButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (level){
                    case 1:
                        Intent intent1 = new Intent(DotGameActivity.this, NineBox.class);
                        player1_name = player1.getText().toString();
                        player2_name = player2.getText().toString();
                        //Toast.makeText(MainActivity.this , player1_name , Toast.LENGTH_SHORT).show();
                        if (player1_name.isEmpty()){
                            player1_name = "Player1";
                        }
                        if (player2_name.isEmpty()){
                            player2_name = "Player2";
                        }
                        intent1.putExtra("Player1", player1_name);
                        intent1.putExtra("Player2", player2_name);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(DotGameActivity.this, SixteenBox.class);
                        player1_name = player1.getText().toString();
                        player2_name = player2.getText().toString();
                        //Toast.makeText(MainActivity.this , player1_name , Toast.LENGTH_SHORT).show();
                        if (player1_name.isEmpty()){
                            player1_name = "Player1";
                        }
                        if (player2_name.isEmpty()){
                            player2_name = "Player2";
                        }
                        intent2.putExtra("Player1", player1_name);
                        intent2.putExtra("Player2", player2_name);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(DotGameActivity.this, TwentyFiveBox.class);
                        player1_name = player1.getText().toString();
                        player2_name = player2.getText().toString();
                        //Toast.makeText(MainActivity.this , player1_name , Toast.LENGTH_SHORT).show();
                        if (player1_name.isEmpty()){
                            player1_name = "Player1";
                        }
                        if (player2_name.isEmpty()){
                            player2_name = "Player2";
                        }
                        intent3.putExtra("Player1", player1_name);
                        intent3.putExtra("Player2", player2_name);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(DotGameActivity.this, ThirtySixBox.class);
                        player1_name = player1.getText().toString();
                        player2_name = player2.getText().toString();
                        //Toast.makeText(MainActivity.this , player1_name , Toast.LENGTH_SHORT).show();
                        if (player1_name.isEmpty()){
                            player1_name = "Player1";
                        }
                        if (player2_name.isEmpty()){
                            player2_name = "Player2";
                        }
                        intent4.putExtra("Player1", player1_name);
                        intent4.putExtra("Player2", player2_name);
                        startActivity(intent4);
                        break;
                    default:
                        break;
                }
            }
        });

        instrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DotGameActivity.this, Instructions.class));
            }
        });
    }

    private void setSpinner(){
        List<String> level_list = new ArrayList<String>();
        level_list.add("Easy 4*4");
        level_list.add("Medium 5*5");
        level_list.add("Hard 6*6");
        level_list.add("Expert 7*7");
        ArrayAdapter levelSpinnerAdapter = new ArrayAdapter<String>(DotGameActivity.this, R.layout.spinner_list , level_list);
        levelSpinnerAdapter.setDropDownViewResource(R.layout.spinner_list);
        level_spinner.setAdapter(levelSpinnerAdapter);

        level_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent , View view , int position , long id) {
                String selection = (String) parent.getItemAtPosition(position);

                switch (selection){
                    case "Easy 4*4":
                        level = 1;
                        break;
                    case "Medium 5*5":
                        level = 2;
                        break;
                    case "Hard 6*6":
                        level = 3;
                        break;
                    case "Expert 7*7":
                        level = 4;
                        break;
                    default:
                        level = 0;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                level = 0;
            }
        });
    }
}