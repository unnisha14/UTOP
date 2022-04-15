package com.unnisha.utop;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class NineBox extends AppCompatActivity {
    private Button player1, player2;
    private int size, player, box, node;
    private String player1_name, player2_name;
    private static ArrayList<Integer>[] nodes;
    private static int p1, p2, z;
    private static HashSet<Integer[]> combo;
    private List<Button> lines;
    private List<ImageView> circles;
    private Integer[] visited;

    private View.OnClickListener onClickListener = new View.OnClickListener(){
        @SuppressLint("ResourceAsColor")
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onClick(View v) {
            //Toast.makeText(NineBox.this, " View " + v.getId(), Toast.LENGTH_SHORT).show();
            int x, y, id;
            x = y = id = -1;
            switch (v.getId()){
                case R.id.line1:
                    x = 1;
                    y = 2;
                    id = 0;
                    //Toast.makeText(NineBox.this, "1", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line2:
                    x = 2;
                    y = 3;
                    id = 1;
                    //Toast.makeText(NineBox.this, "2", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line3:
                    x = 3;
                    y = 4;
                    id = 2;
                    //Toast.makeText(NineBox.this, "3", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line4:
                    x = 1;
                    y = 5;
                    id = 3;
                    //Toast.makeText(NineBox.this, "4", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line5:
                    x = 2;
                    y = 6;
                    id = 4;
                    //Toast.makeText(NineBox.this, "5", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line6:
                    x = 3;
                    y = 7;
                    id = 5;
                    //Toast.makeText(NineBox.this, "6", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line7:
                    x = 4;
                    y = 8;
                    id = 6;
                    //Toast.makeText(NineBox.this, "7", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line8:
                    x = 5;
                    y = 6;
                    id = 7;
                    //Toast.makeText(NineBox.this, "8", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line9:
                    x = 6;
                    y = 7;
                    id = 8;
                    //Toast.makeText(NineBox.this, "9", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line10:
                    x = 7;
                    y = 8;
                    id = 9;
                    //Toast.makeText(NineBox.this, "10", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line11:
                    x = 5;
                    y = 9;
                    id = 10;
                    //Toast.makeText(NineBox.this, "11", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line12:
                    x = 6;
                    y = 10;
                    id = 11;
                    //Toast.makeText(NineBox.this, "12", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line13:
                    x = 7;
                    y = 11;
                    id = 12;
                    //Toast.makeText(NineBox.this, "13", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line14:
                    x = 8;
                    y = 12;
                    id = 13;
                    //Toast.makeText(NineBox.this, "14", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line15:
                    x = 9;
                    y = 10;
                    id = 14;
                    //Toast.makeText(NineBox.this, "15", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line16:
                    x = 10;
                    y = 11;
                    id = 15;
                    //Toast.makeText(NineBox.this, "16", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line17:
                    x = 11;
                    y = 12;
                    id = 16;
                    //Toast.makeText(NineBox.this, "17", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line18:
                    x = 9;
                    y = 13;
                    id = 17;
                    //Toast.makeText(NineBox.this, "18", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line19:
                    x = 10;
                    y = 14;
                    id = 18;
                    //Toast.makeText(NineBox.this, "19", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line20:
                    x = 11;
                    y = 15;
                    id = 19;
                    //Toast.makeText(NineBox.this, "20", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line21:
                    x = 12;
                    y = 16;
                    id = 20;
                    //Toast.makeText(NineBox.this, "21", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line22:
                    x = 13;
                    y = 14;
                    id = 21;
                    //Toast.makeText(NineBox.this, "22", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line23:
                    x = 14;
                    y = 15;
                    id = 22;
                    //Toast.makeText(NineBox.this, "23", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line24:
                    x = 15;
                    y = 16;
                    id = 23;
                    //Toast.makeText(NineBox.this, "24", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    x = -1;
                    y = -1;
                    id = -1;
                    //Toast.makeText(NineBox.this, "Default ", Toast.LENGTH_SHORT).show();
                    break;
            }

            if (id != -1 && visited[id] == 0){
                visited[id] = 1;
                //Toast.makeText(ThirtySixBox.this, "x " + x + " y = " + y, Toast.LENGTH_SHORT).show();
                nodesConnected(x, y, v);
            }
            else
                Toast.makeText(NineBox.this, "Invalid", Toast.LENGTH_SHORT).show();
        }
    };

    public void nodesConnected(int x , int y, View v){
        z = detect_loop(x, y);
        nodes[x].add(y);
        nodes[y].add(x);
        //Toast.makeText(BackEndClass.this, Integer.toString(z), Toast.LENGTH_SHORT).show();

        if (z == -1){
            player = player * z;
            //Toast.makeText(FourBox.this, "player " + player, Toast.LENGTH_SHORT).show();
            if (player == 1) {
                v.setBackgroundColor(getResources().getColor(R.color.player_2));
                player1.setBackgroundColor(getResources().getColor(R.color.player_1));
                player2.setBackgroundColor(getResources().getColor(R.color.grey));
            }
            else {
                v.setBackgroundColor(getResources().getColor(R.color.player_1));
                player1.setBackgroundColor(getResources().getColor(R.color.grey));
                player2.setBackgroundColor(getResources().getColor(R.color.player_2));
            }
        }
        else{
            //Toast.makeText(FourBox.this, "player " + player, Toast.LENGTH_SHORT).show();
            if (player == 1) {
                p1+=z;
                v.setBackgroundColor(getResources().getColor(R.color.player_1));
            }
            else{
                p2+=z;
                v.setBackgroundColor(getResources().getColor(R.color.player_2));
            }
            //Toast.makeText(FourBox.this,"player 1 = " + player1 + "player2 = " + player2,Toast.LENGTH_SHORT).show();
        }

        if (combo.size() == box){
            Intent intent = new Intent(NineBox.this, Winner.class);
            String info;
            if (p1 == p2)
                info = "Draw";
            else if (p1 > p2)
                info = player1_name;
            else
                info = player2_name;
            intent.putExtra("winner", info);
            startActivity(intent);
            finish();
        }
    }

    private static int detect_loop(int x , int y) {
        boolean flag = false;
        int i = 0, j = 0,count = 0;

        for (i = 0; i < nodes[x].size(); i++) {
            int k = nodes[x].get(i);
            for (j = 0; j < nodes[y].size(); j++) {
                if (nodes[k].contains(nodes[y].get(j)) == true) {
                    Integer arr[] = new Integer[4];
                    arr[0] = x;
                    arr[1] = y;
                    arr[2] = nodes[x].get(i);
                    arr[3] = nodes[y].get(j);
                    combo.add(arr);
                    flag = true;
                    count++;
                }
            }
        }

        if (flag == true){
            return count;
        }

        return -1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine_box);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        player1 = (Button) findViewById(R.id.player1);
        player2 = (Button) findViewById(R.id.player2);

        Intent intent = getIntent();
        player1_name = intent.getStringExtra("Player1");
        player2_name = intent.getStringExtra("Player2");

        player1.setText(player1_name);
        player2.setText(player2_name);

        lines = new ArrayList<Button>();
        lines.add(findViewById(R.id.line1));
        lines.add(findViewById(R.id.line2));
        lines.add(findViewById(R.id.line3));
        lines.add(findViewById(R.id.line4));
        lines.add(findViewById(R.id.line5));
        lines.add(findViewById(R.id.line6));
        lines.add(findViewById(R.id.line7));
        lines.add(findViewById(R.id.line8));
        lines.add(findViewById(R.id.line9));
        lines.add(findViewById(R.id.line10));
        lines.add(findViewById(R.id.line11));
        lines.add(findViewById(R.id.line12));
        lines.add(findViewById(R.id.line13));
        lines.add(findViewById(R.id.line14));
        lines.add(findViewById(R.id.line15));
        lines.add(findViewById(R.id.line16));
        lines.add(findViewById(R.id.line17));
        lines.add(findViewById(R.id.line18));
        lines.add(findViewById(R.id.line19));
        lines.add(findViewById(R.id.line20));
        lines.add(findViewById(R.id.line21));
        lines.add(findViewById(R.id.line22));
        lines.add(findViewById(R.id.line23));
        lines.add(findViewById(R.id.line24));

        circles = new ArrayList<ImageView>();
        circles.add(findViewById(R.id.circle1));
        circles.add(findViewById(R.id.circle2));
        circles.add(findViewById(R.id.circle3));
        circles.add(findViewById(R.id.circle4));
        circles.add(findViewById(R.id.circle5));
        circles.add(findViewById(R.id.circle6));
        circles.add(findViewById(R.id.circle7));
        circles.add(findViewById(R.id.circle8));
        circles.add(findViewById(R.id.circle9));
        circles.add(findViewById(R.id.circle10));
        circles.add(findViewById(R.id.circle11));
        circles.add(findViewById(R.id.circle12));
        circles.add(findViewById(R.id.circle13));
        circles.add(findViewById(R.id.circle14));
        circles.add(findViewById(R.id.circle15));
        circles.add(findViewById(R.id.circle16));

        for (int i = 0;i < 16; i++) {
            Random rn = new Random();
            int r, g, b;
            r = rn.nextInt()%255;
            b = rn.nextInt()%255;
            g = rn.nextInt()%255;
            circles.get(i).setColorFilter(Color.rgb(r, g, b));
        }

        size = lines.size();
        box = 9;
        node = 17;
        player = 1;
        p1 = p2 = 0;
        nodes = new ArrayList[node];
        for (int i = 0; i < node; i++) {
            nodes[i] = new ArrayList<Integer>();
        }
        combo = new HashSet<>();

        visited = new Integer[size];
        Arrays.fill(visited, 0);

        for (int i = 0;i < size; i++)
            lines.get(i).setOnClickListener(onClickListener);
    }
}