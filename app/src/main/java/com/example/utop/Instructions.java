package com.example.utop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Instructions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        TextView textView = (TextView) findViewById(R.id.text);
        String str;
        str = "Dots and Boxes is a game where two players play and click on any grey buttons horizontal or vertical. \n" +
                "And as they keep on playing a condition comes where when one player taps the grey button which results in forming a square of unit size. This square formed is the gain point.\n" +
                "And as the player has got one gain point so he gets a repeated chance. And the fun goes on.\n" +
                "So the player with more unit squares is the winner.";
        textView.setText(str);
    }
}