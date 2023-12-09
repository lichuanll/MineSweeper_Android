package com.example.minesweeper;

import android.widget.GridLayout;
import android.widget.ImageButton;

public class GamePlay {
    Integer test=0;
    Vector2[] MinesNumData;
    Mines mines = new Mines();
    int map_Row = 0;
    int map_col = 0;

    void InitMines()
    {
        MinesNumData=mines.GetMineData();//获取雷的一组行列数据
        for(int i=0;i<GameManager.Now_MineSum;i++)
        {
            GameManager.grids[MinesNumData[i].x][MinesNumData[i].y].IsMine=true;
            GameManager.grids[MinesNumData[i].x][MinesNumData[i].y].imageId=Grid.ImageId.Mine;
            GameManager.grids[MinesNumData[i].x][MinesNumData[i].y].MineCount = -1;
            //System.out.println(MinesNumData[i].x+ " " +MinesNumData[i].y);
        }
    }
    void InitNumber()
    {
        Numbers.SetupNumbers();//建立每个Grid实例的雷的数量
        for(int i = 1;i <= map_Row;i++)
        {
            for(int j =1;j <= map_col;j++)
            {
                switch (GameManager.grids[i][j].MineCount)
                {
                    case 1:
                        GameManager.grids[i][j].imageId=Grid.ImageId.num1;
                        break;
                    case 2:
                        GameManager.grids[i][j].imageId=Grid.ImageId.num2;
                        break;
                    case 3:
                        GameManager.grids[i][j].imageId=Grid.ImageId.num3;
                        break;
                    case 4:
                        GameManager.grids[i][j].imageId=Grid.ImageId.num4;
                        break;
                    case 5:
                        GameManager.grids[i][j].imageId=Grid.ImageId.num5;
                        break;
                    case 6:
                        GameManager.grids[i][j].imageId=Grid.ImageId.num6;
                        break;
                    case 7:
                        GameManager.grids[i][j].imageId=Grid.ImageId.num7;
                        break;
                    case 8:
                        GameManager.grids[i][j].imageId=Grid.ImageId.num8;
                        break;
                }
                //System.out.print(GameManager.grids[i][j].MineCount+" ");
            }
            //System.out.println();
        }
    }
    boolean OnMineArea(int x,int y)
    {
        if(x>=1&&x<=GameManager.Now_Map_Row&&y>=1&&y<=GameManager.Now_Map_Col)
        {
            return true;
        }
        return false;
    }
    public void InitGame(GridLayout gridLayout)
    {
        gridLayout.setRowCount(GameManager.Now_Map_Row);
        gridLayout.setColumnCount(GameManager.Now_Map_Col);
        map_Row=GameManager.Now_Map_Row;
        map_col=GameManager.Now_Map_Col;
        for(int i=1;i<=map_Row;i++)
        {
            for(int j=1;j<=map_col;j++)
            {
                Grid g =new Grid();
                g.row=i;
                g.col=j;
                g.SetImageBt(gridLayout);
                g.ChangeImageId(Grid.ImageId.none);
                ImageButton _imageButton= g.GetImageBt();
                gridLayout.addView(_imageButton);
                GameManager.grids[i][j] = g;
                test++;
            }
        }
        mines.SetupMines();//创建一组雷的行列数据
        InitMines();
        InitNumber();
    }
    public void OpenSpace(Grid g)
    {
        g.IsOpen=true;
        g.ChangeImageId();
        g.GetImageBt().setEnabled(false);
        if(g.imageId == Grid.ImageId.NULL)
        {
            for(int i = g.row-1;i<=g.row+1;i++)
            {
                for(int j = g.col-1;j<=g.col+1;j++)
                {
                    if((i!=g.row||j!=g.col) )
                    {
                        if(OnMineArea(i,j))
                        {
                            if(!GameManager.grids[i][j].IsMine && !GameManager.grids[i][j].IsOpen)
                            {
                                GameManager.grids[i][j].IsOpen=true;
                                GameManager.grids[i][j].ChangeImageId();
                                GameManager.grids[i][j].GetImageBt().setEnabled(false);
                                //System.out.println("Open Row:"+GameManager.grids[i][j].row+" Col:"+GameManager.grids[i][j].col);
                                OpenSpace(GameManager.grids[i][j]);
                            }
                        }
                    }
                }
            }
        }
    }
    public void RePlay()
    {
        for(int i=1;i<=GameManager.Now_Map_Row;i++)
        {
            for(int j=1;j<=GameManager.Now_Map_Col;j++)
            {
                GameManager.grids[i][j].ChangeImageId(Grid.ImageId.NULL);
                GameManager.grids[i][j]=null;
            }
        }
    }
    public boolean IsVictory()
    {
        int NoMineCount=0;
        for(int i=1;i<=map_Row;i++)
        {
            for(int j=1;j<=map_col;j++)
            {
                if(!GameManager.grids[i][j].IsOpen)
                {
                    NoMineCount++;
                }
            }
        }
        if(GameManager.Now_MineSum==NoMineCount)
        {
            return true;
        }
        return false;
    }
    public void StopGame(GameManager.GameOver g)
    {
        if(g == GameManager.GameOver.Win)
        {
            for(int i=0;i<GameManager.Now_MineSum;i++)
            {

                GameManager.grids[MinesNumData[i].x][MinesNumData[i].y].ChangeImageId(Grid.ImageId.MineFlag);
                //System.out.println(MinesNumData[i].x+ " " +MinesNumData[i].y);
            }
        }
        else if(g == GameManager.GameOver.Lose)
        {
            for(int i=0;i<GameManager.Now_MineSum;i++)
            {

                GameManager.grids[MinesNumData[i].x][MinesNumData[i].y].ChangeImageId(Grid.ImageId.Mine);
                //System.out.println(MinesNumData[i].x+ " " +MinesNumData[i].y);
            }
        }
        for(int i=1;i<=map_Row;i++)
        {
            for(int j=1;j<=map_col;j++)
            {
                GameManager.grids[i][j].imageButton.setEnabled(false);
            }
        }
    }
}
