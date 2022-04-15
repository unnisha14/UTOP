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

public class ThirtySixBox extends AppCompatActivity {
    private Button player1, player2;
    private String player1_name, player2_name;
    private int size, player, box, node;
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
                    x = 4;
                    y = 5;
                    id = 3;
                    //Toast.makeText(NineBox.this, "4", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line5:
                    x = 5;
                    y = 6;
                    id = 4;
                    //Toast.makeText(NineBox.this, "5", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line6:
                    x = 6;
                    y = 7;
                    id = 5;
                    //Toast.makeText(NineBox.this, "6", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line7:
                    x = 1;
                    y = 8;
                    id = 6;
                    //Toast.makeText(NineBox.this, "7", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line8:
                    x = 2;
                    y = 9;
                    id = 7;
                    //Toast.makeText(NineBox.this, "8", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line9:
                    x = 3;
                    y = 10;
                    id = 8;
                    //Toast.makeText(NineBox.this, "9", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line10:
                    x = 4;
                    y = 11;
                    id = 9;
                    //Toast.makeText(NineBox.this, "10", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line11:
                    x = 5;
                    y = 12;
                    id = 10;
                    //Toast.makeText(NineBox.this, "11", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line12:
                    x = 6;
                    y = 13;
                    id = 11;
                    //Toast.makeText(NineBox.this, "12", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line13:
                    x = 7;
                    y = 14;
                    id = 12;
                    //Toast.makeText(NineBox.this, "13", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line14:
                    x = 8;
                    y = 9;
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
                    x = 12;
                    y = 13;
                    id = 17;
                    //Toast.makeText(NineBox.this, "18", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line19:
                    x = 13;
                    y = 14;
                    id = 18;
                    //Toast.makeText(NineBox.this, "19", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line20:
                    x = 18;
                    y = 15;
                    id = 19;
                    //Toast.makeText(NineBox.this, "20", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line21:
                    x = 9;
                    y = 16;
                    id = 20;
                    //Toast.makeText(NineBox.this, "21", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line22:
                    x = 10;
                    y = 17;
                    id = 21;
                    //Toast.makeText(NineBox.this, "22", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line23:
                    x = 11;
                    y = 18;
                    id = 22;
                    //Toast.makeText(NineBox.this, "23", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line24:
                    x = 12;
                    y = 19;
                    id = 23;
                    //Toast.makeText(NineBox.this, "24", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line25:
                    x = 13;
                    y = 20;
                    id = 24;
                    //Toast.makeText(NineBox.this, "1", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line26:
                    x = 14;
                    y = 21;
                    id = 25;
                    //Toast.makeText(NineBox.this, "2", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line27:
                    x = 15;
                    y = 16;
                    id = 26;
                    //Toast.makeText(NineBox.this, "3", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line28:
                    x = 16;
                    y = 17;
                    id = 27;
                    //Toast.makeText(NineBox.this, "4", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line29:
                    x = 17;
                    y = 18;
                    id = 28;
                    //Toast.makeText(NineBox.this, "5", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line30:
                    x = 18;
                    y = 19;
                    id = 29;
                    //Toast.makeText(NineBox.this, "6", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line31:
                    x = 19;
                    y = 20;
                    id = 30;
                    //Toast.makeText(NineBox.this, "7", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line32:
                    x = 20;
                    y = 21;
                    id = 31;
                    //Toast.makeText(NineBox.this, "8", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line33:
                    x = 15;
                    y = 22;
                    id = 32;
                    //Toast.makeText(NineBox.this, "9", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line34:
                    x = 16;
                    y = 23;
                    id = 33;
                    //Toast.makeText(NineBox.this, "10", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line35:
                    x = 17;
                    y = 24;
                    id = 34;
                    //Toast.makeText(NineBox.this, "11", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line36:
                    x = 18;
                    y = 25;
                    id = 35;
                    //Toast.makeText(NineBox.this, "12", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line37:
                    x = 19;
                    y = 26;
                    id = 36;
                    //Toast.makeText(NineBox.this, "13", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line38:
                    x = 20;
                    y = 27;
                    id = 37;
                    //Toast.makeText(NineBox.this, "14", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line39:
                    x = 21;
                    y = 28;
                    id = 38;
                    //Toast.makeText(NineBox.this, "15", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line40:
                    x = 22;
                    y = 23;
                    id = 39;
                    //Toast.makeText(NineBox.this, "16", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line41:
                    x = 23;
                    y = 24;
                    id = 40;
                    //Toast.makeText(NineBox.this, "1", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line42:
                    x = 24;
                    y = 25;
                    id = 41;
                    //Toast.makeText(NineBox.this, "2", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line43:
                    x = 25;
                    y = 26;
                    id = 42;
                    //Toast.makeText(NineBox.this, "3", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line44:
                    x = 26;
                    y = 27;
                    id = 43;
                    //Toast.makeText(NineBox.this, "4", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line45:
                    x = 27;
                    y = 28;
                    id = 44;
                    //Toast.makeText(NineBox.this, "5", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line46:
                    x = 22;
                    y = 29;
                    id = 45;
                    //Toast.makeText(NineBox.this, "6", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line47:
                    x = 23;
                    y = 30;
                    id = 46;
                    //Toast.makeText(NineBox.this, "7", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line48:
                    x = 24;
                    y = 31;
                    id = 47;
                    //Toast.makeText(NineBox.this, "8", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line49:
                    x = 25;
                    y = 32;
                    id = 48;
                    //Toast.makeText(NineBox.this, "9", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line50:
                    x = 26;
                    y = 33;
                    id = 49;
                    //Toast.makeText(NineBox.this, "10", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line51:
                    x = 27;
                    y = 34;
                    id = 50;
                    //Toast.makeText(NineBox.this, "11", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line52:
                    x = 28;
                    y = 35;
                    id = 51;
                    //Toast.makeText(NineBox.this, "12", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line53:
                    x = 29;
                    y = 30;
                    id = 52;
                    //Toast.makeText(NineBox.this, "13", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line54:
                    x = 30;
                    y = 31;
                    id = 53;
                    //Toast.makeText(NineBox.this, "14", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line55:
                    x = 31;
                    y = 32;
                    id = 54;
                    //Toast.makeText(NineBox.this, "15", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line56:
                    x = 32;
                    y = 33;
                    id = 55;
                    //Toast.makeText(NineBox.this, "16", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line57:
                    x = 33;
                    y = 34;
                    id = 56;
                    //Toast.makeText(NineBox.this, "17", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line58:
                    x = 34;
                    y = 35;
                    id = 57;
                    //Toast.makeText(NineBox.this, "18", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line59:
                    x = 29;
                    y = 36;
                    id = 58;
                    //Toast.makeText(NineBox.this, "19", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line60:
                    x = 30;
                    y = 37;
                    id = 59;
                    //Toast.makeText(NineBox.this, "20", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line61:
                    x = 31;
                    y = 38;
                    id = 60;
                    //Toast.makeText(NineBox.this, "1", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line62:
                    x = 32;
                    y = 39;
                    id = 61;
                    //Toast.makeText(NineBox.this, "2", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line63:
                    x = 33;
                    y = 40;
                    id = 62;
                    //Toast.makeText(NineBox.this, "3", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line64:
                    x = 34;
                    y = 41;
                    id = 63;
                    //Toast.makeText(NineBox.this, "4", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line65:
                    x = 35;
                    y = 42;
                    id = 64;
                    //Toast.makeText(NineBox.this, "5", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line66:
                    x = 36;
                    y = 37;
                    id = 65;
                    //Toast.makeText(NineBox.this, "6", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line67:
                    x = 37;
                    y = 38;
                    id = 66;
                    //Toast.makeText(NineBox.this, "7", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line68:
                    x = 38;
                    y = 39;
                    id = 67;
                    //Toast.makeText(NineBox.this, "8", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line69:
                    x = 39;
                    y = 40;
                    id = 68;
                    //Toast.makeText(NineBox.this, "9", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line70:
                    x = 40;
                    y = 41;
                    id = 69;
                    //Toast.makeText(NineBox.this, "10", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line71:
                    x = 41;
                    y = 42;
                    id = 70;
                    //Toast.makeText(NineBox.this, "11", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line72:
                    x = 36;
                    y = 43;
                    id = 71;
                    //Toast.makeText(NineBox.this, "12", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line73:
                    x = 37;
                    y = 44;
                    id = 72;
                    //Toast.makeText(NineBox.this, "13", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line74:
                    x = 38;
                    y = 45;
                    id = 73;
                    //Toast.makeText(NineBox.this, "14", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line75:
                    x = 39;
                    y = 46;
                    id = 74;
                    //Toast.makeText(NineBox.this, "15", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line76:
                    x = 40;
                    y = 47;
                    id = 75;
                    //Toast.makeText(NineBox.this, "16", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line77:
                    x = 41;
                    y = 48;
                    id = 76;
                    //Toast.makeText(NineBox.this, "17", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line78:
                    x = 42;
                    y = 49;
                    id = 77;
                    //Toast.makeText(NineBox.this, "18", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line79:
                    x = 43;
                    y = 44;
                    id = 78;
                    //Toast.makeText(NineBox.this, "19", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line80:
                    x = 44;
                    y = 45;
                    id = 79;
                    //Toast.makeText(NineBox.this, "20", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line81:
                    x = 45;
                    y = 46;
                    id = 80;
                    //Toast.makeText(NineBox.this, "21", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line82:
                    x = 46;
                    y = 47;
                    id = 81;
                    //Toast.makeText(NineBox.this, "22", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line83:
                    x = 47;
                    y = 48;
                    id = 82;
                    //Toast.makeText(NineBox.this, "23", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.line84:
                    x = 48;
                    y = 49;
                    id = 83;
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
                Toast.makeText(ThirtySixBox.this, "Invalid", Toast.LENGTH_SHORT).show();
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
            Intent intent = new Intent(ThirtySixBox.this, Winner.class);
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
        setContentView(R.layout.activity_thirty_six_box);
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
        lines.add(findViewById(R.id.line25));
        lines.add(findViewById(R.id.line26));
        lines.add(findViewById(R.id.line27));
        lines.add(findViewById(R.id.line28));
        lines.add(findViewById(R.id.line29));
        lines.add(findViewById(R.id.line30));
        lines.add(findViewById(R.id.line31));
        lines.add(findViewById(R.id.line32));
        lines.add(findViewById(R.id.line33));
        lines.add(findViewById(R.id.line34));
        lines.add(findViewById(R.id.line35));
        lines.add(findViewById(R.id.line36));
        lines.add(findViewById(R.id.line37));
        lines.add(findViewById(R.id.line38));
        lines.add(findViewById(R.id.line39));
        lines.add(findViewById(R.id.line40));
        lines.add(findViewById(R.id.line41));
        lines.add(findViewById(R.id.line42));
        lines.add(findViewById(R.id.line43));
        lines.add(findViewById(R.id.line44));
        lines.add(findViewById(R.id.line45));
        lines.add(findViewById(R.id.line46));
        lines.add(findViewById(R.id.line47));
        lines.add(findViewById(R.id.line48));
        lines.add(findViewById(R.id.line49));
        lines.add(findViewById(R.id.line50));
        lines.add(findViewById(R.id.line51));
        lines.add(findViewById(R.id.line52));
        lines.add(findViewById(R.id.line53));
        lines.add(findViewById(R.id.line54));
        lines.add(findViewById(R.id.line55));
        lines.add(findViewById(R.id.line56));
        lines.add(findViewById(R.id.line57));
        lines.add(findViewById(R.id.line58));
        lines.add(findViewById(R.id.line59));
        lines.add(findViewById(R.id.line60));
        lines.add(findViewById(R.id.line61));
        lines.add(findViewById(R.id.line62));
        lines.add(findViewById(R.id.line63));
        lines.add(findViewById(R.id.line64));
        lines.add(findViewById(R.id.line65));
        lines.add(findViewById(R.id.line66));
        lines.add(findViewById(R.id.line67));
        lines.add(findViewById(R.id.line68));
        lines.add(findViewById(R.id.line69));
        lines.add(findViewById(R.id.line70));
        lines.add(findViewById(R.id.line71));
        lines.add(findViewById(R.id.line72));
        lines.add(findViewById(R.id.line73));
        lines.add(findViewById(R.id.line74));
        lines.add(findViewById(R.id.line75));
        lines.add(findViewById(R.id.line76));
        lines.add(findViewById(R.id.line77));
        lines.add(findViewById(R.id.line78));
        lines.add(findViewById(R.id.line79));
        lines.add(findViewById(R.id.line80));
        lines.add(findViewById(R.id.line81));
        lines.add(findViewById(R.id.line82));
        lines.add(findViewById(R.id.line83));
        lines.add(findViewById(R.id.line84));

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
        circles.add(findViewById(R.id.circle17));
        circles.add(findViewById(R.id.circle18));
        circles.add(findViewById(R.id.circle19));
        circles.add(findViewById(R.id.circle20));
        circles.add(findViewById(R.id.circle21));
        circles.add(findViewById(R.id.circle22));
        circles.add(findViewById(R.id.circle23));
        circles.add(findViewById(R.id.circle24));
        circles.add(findViewById(R.id.circle25));
        circles.add(findViewById(R.id.circle26));
        circles.add(findViewById(R.id.circle27));
        circles.add(findViewById(R.id.circle28));
        circles.add(findViewById(R.id.circle29));
        circles.add(findViewById(R.id.circle30));
        circles.add(findViewById(R.id.circle31));
        circles.add(findViewById(R.id.circle32));
        circles.add(findViewById(R.id.circle33));
        circles.add(findViewById(R.id.circle34));
        circles.add(findViewById(R.id.circle35));
        circles.add(findViewById(R.id.circle36));
        circles.add(findViewById(R.id.circle37));
        circles.add(findViewById(R.id.circle38));
        circles.add(findViewById(R.id.circle39));
        circles.add(findViewById(R.id.circle40));
        circles.add(findViewById(R.id.circle41));
        circles.add(findViewById(R.id.circle42));
        circles.add(findViewById(R.id.circle43));
        circles.add(findViewById(R.id.circle44));
        circles.add(findViewById(R.id.circle45));
        circles.add(findViewById(R.id.circle46));
        circles.add(findViewById(R.id.circle47));
        circles.add(findViewById(R.id.circle48));
        circles.add(findViewById(R.id.circle49));

        for (int i = 0;i < 49; i++) {
            Random rn = new Random();
            int r, g, b;
            r = rn.nextInt()%255;
            b = rn.nextInt()%255;
            g = rn.nextInt()%255;
            circles.get(i).setColorFilter(Color.rgb(r, g, b));
        }

        size = lines.size();
        box = 36;
        node = 50;
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