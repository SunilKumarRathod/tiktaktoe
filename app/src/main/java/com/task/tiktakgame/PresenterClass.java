package com.task.tiktakgame;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class PresenterClass implements ClickHandler {
    int count;
    CallBack callBack;

    Context context;
    List<Integer> playerOne=new ArrayList<>();
    List<Integer> playerTwo=new ArrayList<>();

    public PresenterClass(Context context) {
        this.context = context;
    }

    @Override
    public void ButtonClickHandler(View view) {

       if(count==9){

       }

        switch (view.getId()) {
            case R.id.button1:
                if(count%2==0)
                    playerOne.add(0);
                else
                    playerTwo.add(0);
                callBack.showScreen(0,0);
                break;
            case R.id.button2:
                if(count%2==0)
                    playerOne.add(1);
                else
                    playerTwo.add(1);
                callBack.showScreen(0,1);
                break;
            case R.id.button3:
                if(count%2==0)
                    playerOne.add(2);
                else
                    playerTwo.add(2);
                callBack.showScreen(0,2);
                break;
            case R.id.button4:
                if(count%2==0)
                    playerOne.add(3);
                else
                    playerTwo.add(3);
                callBack.showScreen(1,0);
                break;
            case R.id.button5:
                if(count%2==0)
                    playerOne.add(4);
                else
                    playerTwo.add(4);
                callBack.showScreen(1,1);
                break;
            case R.id.button6:
                if(count%2==0)
                    playerOne.add(5);
                else
                    playerTwo.add(5);
                callBack.showScreen(1,2);
                break;
            case R.id.button7:
                if(count%2==0)
                    playerOne.add(6);
                else
                    playerTwo.add(6);
                callBack.showScreen(2,0);
                break;
            case R.id.button8:
                if(count%2==0)
                    playerOne.add(7);
                else
                    playerTwo.add(7);
                callBack.showScreen(2,1);
                break;
            case R.id.button9:
                if(count%2==0)
                    playerOne.add(8);
                else
                    playerTwo.add(8);
                 callBack.showScreen(2,2);
                break;
        }
       if(count>3)
       checkResult();
        count++;
    }

    public void checkResult(){

        /*int[][] winningPositions = {
                {0,1,2}, {3,4,5}, {6,7,8}, //hor
                {0,3,6}, {1,4,7}, {2,5,8}, // ver
                {0,4,8}, {2,4,6}
        };*/
        List<Integer> check1=new ArrayList<>();
        check1.add(0);
        check1.add(1);
        check1.add(2);

        List<Integer> check2=new ArrayList<>();
        check2.add(3);
        check2.add(4);
        check2.add(5);

        List<Integer> check3=new ArrayList<>();
        check3.add(6);
        check3.add(7);
        check3.add(8);

        List<Integer> check4=new ArrayList<>();
        check4.add(0);
        check4.add(3);
        check4.add(6);

        List<Integer> check5=new ArrayList<>();
        check5.add(1);
        check5.add(4);
        check5.add(7);

        List<Integer> check6=new ArrayList<>();
        check6.add(2);
        check6.add(5);
        check6.add(7);

        List<Integer> check7=new ArrayList<>();
        check7.add(0);
        check7.add(4);
        check7.add(8);

        List<Integer> check8=new ArrayList<>();
        check8.add(2);
        check8.add(4);
        check8.add(6);





        if(playerOne.contains(check1) || playerOne.contains(check2)
        || playerOne.contains(check3)|| playerOne.contains(check4)
        || playerOne.contains(check5) || playerOne.contains(check6)
        || playerOne.contains(check7) || playerOne.contains(check8)){
            String TAG="Player1";
            //player 1 wins
            Log.e(TAG,"WON");
        }

        if(playerTwo.contains(check1) || playerTwo.contains(check2)
                || playerTwo.contains(check3)|| playerTwo.contains(check4)
                || playerTwo.contains(check5) || playerTwo.contains(check6)
                || playerTwo.contains(check7) || playerTwo.contains(check8)){
            //player 2 wins
            String TAG="Player2";
            //player 1 wins
            Log.e(TAG,"WON");
        }
    }
}
