package com.task.tiktakgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,CallBack {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
    Button p1b1,p1b2,p1b3,p1b4,p1b5,p1b6,p1b7,p1b8,p1b9;
    Button p2b1,p2b2,p2b3,p2b4,p2b5,p2b6,p2b7,p2b8,p2b9;

    Button reset;

    int count;
    List<Integer> playerOne=new ArrayList<>();
    List<Integer> playerTwo=new ArrayList<>();

    List<Integer> check1,check2,check3,check4,check5,check6,check7,check8;
    Boolean winStatus=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        /*int[][] winningPositions = {
                {0,1,2}, {3,4,5}, {6,7,8}, //hor
                {0,3,6}, {1,4,7}, {2,5,8}, // ver
                {0,4,8}, {2,4,6}
        };*/

        //{[0,0][0,1][0,2]} {[1,0][1,1][1,2]} {[2,0][2,1][2,2]} horizontal
        //{[0,0][1,0][2,0]} {[0,1][1,1][2,1]} {[0,2][1,2][2,2]} vertical
        //{[0,0][1,1][2,2]} {[0,2][1,1][2.0]} cross section

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });

    }

    public void init(){
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);
        b5=findViewById(R.id.button5);
        b6=findViewById(R.id.button6);
        b7=findViewById(R.id.button7);
        b8=findViewById(R.id.button8);
        b9=findViewById(R.id.button9);

        p1b1=findViewById(R.id.button1p1turn);
        p1b2=findViewById(R.id.button2p1turn);
        p1b3=findViewById(R.id.button3p1turn);
        p1b4=findViewById(R.id.button4p1turn);
        p1b5=findViewById(R.id.button5p1turn);
        p1b6=findViewById(R.id.button6p1turn);
        p1b7=findViewById(R.id.button7p1turn);
        p1b8=findViewById(R.id.button8p1turn);
        p1b9=findViewById(R.id.button9p1turn);

        p2b1=findViewById(R.id.button1p2turn);
        p2b2=findViewById(R.id.button2p2turn);
        p2b3=findViewById(R.id.button3p2turn);
        p2b4=findViewById(R.id.button4p2turn);
        p2b5=findViewById(R.id.button5p2turn);
        p2b6=findViewById(R.id.button6p2turn);
        p2b7=findViewById(R.id.button7p2turn);
        p2b8=findViewById(R.id.button8p2turn);
        p2b9=findViewById(R.id.button9p2turn);

        reset=findViewById(R.id.reset);
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button1:
                if(count%2==0)
                    playerOne.add(0);
                else
                    playerTwo.add(0);
                showScreen(0,0);
                break;
            case R.id.button2:
                if(count%2==0)
                    playerOne.add(1);
                else
                    playerTwo.add(1);
                showScreen(0,1);
                break;
            case R.id.button3:
                if(count%2==0)
                    playerOne.add(2);
                else
                    playerTwo.add(2);
                showScreen(0,2);
                break;
            case R.id.button4:
                if(count%2==0)
                    playerOne.add(3);
                else
                    playerTwo.add(3);
                showScreen(1,0);
                break;
            case R.id.button5:
                if(count%2==0)
                    playerOne.add(4);
                else
                    playerTwo.add(4);
                showScreen(1,1);
                break;
            case R.id.button6:
                if(count%2==0)
                    playerOne.add(5);
                else
                    playerTwo.add(5);
                showScreen(1,2);
                break;
            case R.id.button7:
                if(count%2==0)
                    playerOne.add(6);
                else
                    playerTwo.add(6);
                showScreen(2,0);
                break;
            case R.id.button8:
                if(count%2==0)
                    playerOne.add(7);
                else
                    playerTwo.add(7);
                showScreen(2,1);
                break;
            case R.id.button9:
                if(count%2==0)
                    playerOne.add(8);
                else
                    playerTwo.add(8);
                showScreen(2,2);
                break;
        }
        count++;
        if(count>3)
            checkResult();
        if(count==9){
            if(!winStatus)
               Draw();
        }

    }

    public void playerOneResult(){
        String TAG = "Player1";
        //player 1 wins
        Log.e(TAG, "WON");
        winStatus=true;
    }

    public void playerTwoResult(){
        String TAG = "Player2";
        //player 2 wins
        Log.e(TAG, "WON");
        winStatus=true;
    }

    public void Draw(){
        Log.e("MATCH", "DRAW");
    }

    @Override
    public void showScreen(int x, int y) {
        if(x==0&& y==0){
            if(count%2==0) {
                b1.setVisibility(View.GONE);
                p1b1.setVisibility(View.VISIBLE);
                p2b1.setVisibility(View.GONE);
            }
            if(count%2==1){
                b1.setVisibility(View.GONE);
                p1b1.setVisibility(View.GONE);
                p2b1.setVisibility(View.VISIBLE);
            }
        }
        else if(x==0 && y==1){
            if(count%2==0) {
                b2.setVisibility(View.GONE);
                p1b2.setVisibility(View.VISIBLE);
                p2b2.setVisibility(View.GONE);
            }
            if(count%2==1){
                b2.setVisibility(View.GONE);
                p1b2.setVisibility(View.GONE);
                p2b2.setVisibility(View.VISIBLE);
            }
        }else if(x==0&&y==2){
            if(count%2==0) {
                b3.setVisibility(View.GONE);
                p1b3.setVisibility(View.VISIBLE);
                p2b3.setVisibility(View.GONE);
            }
            if(count%2==1){
                b3.setVisibility(View.GONE);
                p1b3.setVisibility(View.GONE);
                p2b3.setVisibility(View.VISIBLE);
            }
        }else if(x==1&&y==0){
            if(count%2==0) {
                b4.setVisibility(View.GONE);
                p1b4.setVisibility(View.VISIBLE);
                p2b4.setVisibility(View.GONE);
            }
            if(count%2==1){
                b4.setVisibility(View.GONE);
                p1b4.setVisibility(View.GONE);
                p2b4.setVisibility(View.VISIBLE);
            }
        }else if(x==1&&y==1){
            if(count%2==0) {
                b5.setVisibility(View.GONE);
                p1b5.setVisibility(View.VISIBLE);
                p2b5.setVisibility(View.GONE);
            }
            if(count%2==1){
                b5.setVisibility(View.GONE);
                p1b5.setVisibility(View.GONE);
                p2b5.setVisibility(View.VISIBLE);
            }
        }else if(x==1&&y==2){
            if(count%2==0) {
                b6.setVisibility(View.GONE);
                p1b6.setVisibility(View.VISIBLE);
                p2b6.setVisibility(View.GONE);
            }
            if(count%2==1){
                b6.setVisibility(View.GONE);
                p1b6.setVisibility(View.GONE);
                p2b6.setVisibility(View.VISIBLE);
            }
        }else if(x==2&&y==0){
            if(count%2==0) {
                b7.setVisibility(View.GONE);
                p1b7.setVisibility(View.VISIBLE);
                p2b7.setVisibility(View.GONE);
            }
            if(count%2==1){
                b7.setVisibility(View.GONE);
                p1b7.setVisibility(View.GONE);
                p2b7.setVisibility(View.VISIBLE);
            }
        }else if(x==2&&y==1){
            if(count%2==0) {
                b8.setVisibility(View.GONE);
                p1b8.setVisibility(View.VISIBLE);
                p2b8.setVisibility(View.GONE);
            }
            if(count%2==1){
                b8.setVisibility(View.GONE);
                p1b8.setVisibility(View.GONE);
                p2b8.setVisibility(View.VISIBLE);
            }
        }else {
            if(count%2==0) {
                b9.setVisibility(View.GONE);
                p1b9.setVisibility(View.VISIBLE);
                p2b9.setVisibility(View.GONE);
            }
            if(count%2==1){
                b9.setVisibility(View.GONE);
                p1b9.setVisibility(View.GONE);
                p2b9.setVisibility(View.VISIBLE);
            }
        }
    }

    public void checkResult(){

        /*int[][] winningPositions = {
                {0,1,2}, {3,4,5}, {6,7,8}, //hor
                {0,3,6}, {1,4,7}, {2,5,8}, // ver
                {0,4,8}, {2,4,6}
        };*/
        getWinningPossion();

        if(checkResultInLoop(playerOne,check1)==3){
            playerOneResult();
        }
        if(checkResultInLoop(playerOne,check2)==3){
            playerOneResult();
        }
        if(checkResultInLoop(playerOne,check3)==3){
            playerOneResult();
        }
        if(checkResultInLoop(playerOne,check4)==3){
            playerOneResult();
        }
        if(checkResultInLoop(playerOne,check5)==3){
            playerOneResult();
        }
        if(checkResultInLoop(playerOne,check6)==3){
            playerOneResult();
        }
        if(checkResultInLoop(playerOne,check7)==3){
            playerOneResult();
        }
        if(checkResultInLoop(playerOne,check8)==3){
            playerOneResult();
        }


        if(checkResultInLoop(playerTwo,check1)==3){
          playerTwoResult();
        }
        if(checkResultInLoop(playerTwo,check2)==3){
            playerTwoResult();
        }
        if(checkResultInLoop(playerTwo,check3)==3){
            playerTwoResult();
        }
        if(checkResultInLoop(playerTwo,check4)==3){
            playerTwoResult();
        }
        if(checkResultInLoop(playerTwo,check5)==3){
            playerTwoResult();
        }
        if(checkResultInLoop(playerTwo,check6)==3){
            playerTwoResult();
        }
        if(checkResultInLoop(playerTwo,check7)==3){
            playerTwoResult();
        }
        if(checkResultInLoop(playerTwo,check8)==3){
            playerTwoResult();
        }
    }

    public void getWinningPossion(){
        check1=new ArrayList<>();
        check1.add(0);
        check1.add(1);
        check1.add(2);

        check2=new ArrayList<>();
        check2.add(3);
        check2.add(4);
        check2.add(5);

       check3=new ArrayList<>();
        check3.add(6);
        check3.add(7);
        check3.add(8);

         check4=new ArrayList<>();
        check4.add(0);
        check4.add(3);
        check4.add(6);

         check5=new ArrayList<>();
        check5.add(1);
        check5.add(4);
        check5.add(7);

        check6=new ArrayList<>();
        check6.add(2);
        check6.add(5);
        check6.add(7);

        check7=new ArrayList<>();
        check7.add(0);
        check7.add(4);
        check7.add(8);

        check8=new ArrayList<>();
        check8.add(2);
        check8.add(4);
        check8.add(6);
    }
    public int checkResultInLoop(List<Integer> players,List<Integer> combinationList){
        int combinationCount=0;
        for(int i=0;i<players.size();i++){
            for(int j=0;j<combinationList.size();j++){
                if(players.get(i).equals(combinationList.get(j))){
                    combinationCount++;
                }
            }
        }
        return combinationCount;
    }

    public void resetGame(){
        b1.setVisibility(View.VISIBLE);
        b2.setVisibility(View.VISIBLE);
        b3.setVisibility(View.VISIBLE);
        b4.setVisibility(View.VISIBLE);
        b5.setVisibility(View.VISIBLE);
        b6.setVisibility(View.VISIBLE);
        b7.setVisibility(View.VISIBLE);
        b8.setVisibility(View.VISIBLE);
        b9.setVisibility(View.VISIBLE);

        p1b1.setVisibility(View.GONE);
        p1b2.setVisibility(View.GONE);
        p1b3.setVisibility(View.GONE);
        p1b4.setVisibility(View.GONE);
        p1b5.setVisibility(View.GONE);
        p1b6.setVisibility(View.GONE);
        p1b7.setVisibility(View.GONE);
        p1b8.setVisibility(View.GONE);
        p1b9.setVisibility(View.GONE);

        p2b1.setVisibility(View.GONE);
        p2b2.setVisibility(View.GONE);
        p2b3.setVisibility(View.GONE);
        p2b4.setVisibility(View.GONE);
        p2b5.setVisibility(View.GONE);
        p2b6.setVisibility(View.GONE);
        p2b7.setVisibility(View.GONE);
        p2b8.setVisibility(View.GONE);
        p2b9.setVisibility(View.GONE);

        playerOne.clear();
        playerTwo.clear();
        count=0;
    }
}