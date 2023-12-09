package com.example.minesweeper;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    GridLayout  gridLayout;
    Button SimpleBt;
    Button MediumBt;
    Button HardBt;
    ImageButton RePlayBt;
    ImageButton Flag;
    GamePlay gamePlay = new GamePlay();
    Grid CheckOutButton(ImageButton imageButton)
    {
        for(int i=1;i<=GameManager.Now_Map_Row;i++)
        {
            for(int j=1;j<=GameManager.Now_Map_Col;j++)
            {
                if (GameManager.grids[i][j].GetImageBt().equals(imageButton))
                {
                    return GameManager.grids[i][j];
                }
            }
        }
        return null;
    }
    void OnEnableBt()
    {
        for(int i=1;i<=GameManager.Now_Map_Row;i++)
        {
            for (int j=1;j<=GameManager.Now_Map_Col;j++)
            {
                GameManager.grids[i][j].GetImageBt().setOnClickListener(this);
            }
        }
    }
    void flush() {
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ArrayList<Grid> grids = new ArrayList<>();
        //DeBug=findViewById(R.id.DeBug);
        gridLayout=findViewById(R.id._gridLayout);
        SimpleBt  =findViewById(R.id.Simple);
        MediumBt  =findViewById(R.id.Medium);
        HardBt    =findViewById(R.id.Hard);
        RePlayBt  =findViewById(R.id.RePlay);
        Flag      =findViewById(R.id.Flag);
        SimpleBt.setOnClickListener(this);
        MediumBt.setOnClickListener(this);
        HardBt  .setOnClickListener(this);
        RePlayBt.setOnClickListener(this);
        Flag.    setOnClickListener(this);
        gridLayout.setUseDefaultMargins(false);
        gamePlay.InitGame(gridLayout);
        OnEnableBt();
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.RePlay)
        {
            gamePlay.RePlay();
            gamePlay.InitGame(gridLayout);
            OnEnableBt();
            //System.out.println("RePlay");
        }
        else if(v.getId()==R.id.Simple)
        {

            gamePlay.RePlay();
            GameManager.ChangeNowLive(GameManager.Live.simple);
            flush();
            //gamePlay.InitGame(gridLayout);
            //OnEnableBt();
            System.out.println("Simple");
        }
        else if(v.getId()==R.id.Medium)
        {
            gamePlay.RePlay();
            GameManager.ChangeNowLive(GameManager.Live.medium);
            flush();
            //gamePlay.InitGame(gridLayout);
            //OnEnableBt();
            //System.out.println("Medium");
        }
        else if(v.getId()==R.id.Hard)
        {
            gamePlay.RePlay();
            GameManager.ChangeNowLive(GameManager.Live.Hard);
            flush();
            //gamePlay.InitGame(gridLayout);
            //OnEnableBt();
            //System.out.println("Hard");
        }
        else if(v.getId()==R.id.Flag)
        {

            if(GameManager.flag)
            {
                GameManager.flag=false;
                Flag.setBackgroundResource(R.drawable.buttonflag);
            }
            else
            {
                GameManager.flag=true;
                Flag.setBackgroundResource(R.drawable.leiflag);
            }
        }
        else
        {
            ImageButton ClickButton = (ImageButton)v;
            //GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
//        GridLayout.LayoutParams layoutParams = (GridLayout.LayoutParams) ClickButton.getLayoutParams();
//        GridLayout.getChildMeasureSpec()
//        DeBug.setText();
            Grid ClickGrid = CheckOutButton(ClickButton);
            if(!GameManager.flag)
            {

                //String text;
                //DeBug.setText(ClickGrid.row+":"+ClickGrid.col);

                gamePlay.OpenSpace(ClickGrid);
                if(gamePlay.IsVictory())
                {
                    gamePlay.StopGame(GameManager.GameOver.Win);
                    AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("提示");
                    builder.setMessage("你赢了");
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                if(ClickGrid.IsMine)
                {
                    gamePlay.StopGame(GameManager.GameOver.Lose);
                    AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("提示");
                    builder.setMessage("你输了");
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
           else
            {
                if(ClickGrid.IsFlag)
                {
                    ClickGrid.ChangeImageId(Grid.ImageId.none);
                    ClickGrid.IsFlag=false;
                }
                else
                {
                    ClickGrid.ChangeImageId(Grid.ImageId.Flag);
                    ClickGrid.IsFlag=true;
                }
            }

        }
    }



}