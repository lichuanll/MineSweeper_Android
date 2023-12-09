package com.example.minesweeper;

import android.widget.GridLayout;
import android.widget.ImageButton;

public class GameManager {
   public enum Live
    {
        simple,
        medium,
        Hard
    }
    public static int score;

    public static int Simple_MineSum = 10
            ;
    public static int Simple_Map_Row = 9;
    public static int Simple_Map_Col = 9;
    public static int Medium_MineSum = 40;
    public static int Medium_Map_Row = 16;
    public static int Medium_Map_Col = 16;
    public static int Hard_MineSum = 299;
    public static int Hard_Map_Row = 30;
    public static int Hard_Map_Col = 30;
    public static boolean flag = false;
    public static Grid [][] grids = new Grid[50][50];
    public enum GameOver
    {
        Win,
        Lose
    }
    public static Live NowLive=Live.simple;
    public static int Now_Map_Row = Simple_Map_Row;
    public static int Now_Map_Col = Simple_Map_Col;
    public static int Now_MineSum = Simple_MineSum;
    public static void ChangeNowLive(Live l)
    {
        switch (l)
        {
            case simple:
                Now_Map_Row = Simple_Map_Row;
                Now_Map_Col = Simple_Map_Col;
                Now_MineSum = Simple_MineSum;
                break;
            case medium:
                Now_Map_Row = Medium_Map_Row;
                Now_Map_Col = Medium_Map_Col;
                Now_MineSum = Medium_MineSum;
                break;
            case Hard:
                Now_Map_Row = Hard_Map_Row;
                Now_Map_Col = Hard_Map_Col;
                Now_MineSum = Hard_MineSum;
                break;
        }
    }
}
