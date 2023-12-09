package com.example.minesweeper;

public class Numbers {
   public static void SetupNumbers()
    {
        for(int i=0;i<GameManager.Now_MineSum;i++)
        {
            if(GameManager.grids[Mines.mines[i].x + 1][Mines.mines[i].y] != null)
            {
                if(!GameManager.grids[Mines.mines[i].x + 1][Mines.mines[i].y].IsMine)
                    GameManager.grids[Mines.mines[i].x + 1][Mines.mines[i].y].MineCount++;
            }
            if(GameManager.grids[Mines.mines[i].x - 1][Mines.mines[i].y] != null)
            {
                if(!GameManager.grids[Mines.mines[i].x - 1][Mines.mines[i].y].IsMine)
                    GameManager.grids[Mines.mines[i].x - 1][Mines.mines[i].y].MineCount++;
            }
            if(GameManager.grids[Mines.mines[i].x][Mines.mines[i].y + 1] != null)
            {
                if(!GameManager.grids[Mines.mines[i].x][Mines.mines[i].y + 1].IsMine)
                    GameManager.grids[Mines.mines[i].x][Mines.mines[i].y + 1].MineCount++;
            }
            if(GameManager.grids[Mines.mines[i].x][Mines.mines[i].y - 1] != null)
            {
                if(!GameManager.grids[Mines.mines[i].x][Mines.mines[i].y - 1].IsMine)
                    GameManager.grids[Mines.mines[i].x][Mines.mines[i].y - 1].MineCount++;
            }
            if(GameManager.grids[Mines.mines[i].x + 1][Mines.mines[i].y + 1] != null)
            {
                if(!GameManager.grids[Mines.mines[i].x + 1][Mines.mines[i].y + 1].IsMine)
                    GameManager.grids[Mines.mines[i].x + 1][Mines.mines[i].y + 1].MineCount++;
            }
            if(GameManager.grids[Mines.mines[i].x + 1][Mines.mines[i].y - 1] != null)
            {
                if(!GameManager.grids[Mines.mines[i].x + 1][Mines.mines[i].y - 1].IsMine)
                    GameManager.grids[Mines.mines[i].x + 1][Mines.mines[i].y - 1].MineCount++;
            }
            if(GameManager.grids[Mines.mines[i].x - 1][Mines.mines[i].y + 1] != null)
            {
                if(!GameManager.grids[Mines.mines[i].x - 1][Mines.mines[i].y + 1].IsMine)
                    GameManager.grids[Mines.mines[i].x - 1][Mines.mines[i].y + 1].MineCount++;
            }
            if(GameManager.grids[Mines.mines[i].x - 1][Mines.mines[i].y - 1] != null)
            {
                if(!GameManager.grids[Mines.mines[i].x - 1][Mines.mines[i].y - 1].IsMine)
                    GameManager.grids[Mines.mines[i].x - 1][Mines.mines[i].y - 1].MineCount++;
            }
        }
    }
}
