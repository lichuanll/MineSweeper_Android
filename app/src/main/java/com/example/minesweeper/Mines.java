package com.example.minesweeper;

public class Mines {
    public static Vector2[] mines;//是否用static，如果用到static在切换难度的时候，数组要用的数组的长度会发生变化。如果从长变短多余出来的数组后缀那部分数据不会用到，所以没有影响，如果从短变长setupmines函数会将之前的数组数据完全覆盖掉，综上所述，可以用static解决其它多个类访问这个成员的问题
    public Mines()
    {
        mines = new Vector2[305];
    }


    void SetupMines()
    {
        boolean flag=true;
        for(int i = 0; i < GameManager.Now_MineSum; i++)
        {
            Vector2 m = new Vector2();
            m.x=(int)(Math.random()* GameManager.Now_Map_Row+1);
            m.y=(int)(Math.random()* GameManager.Now_Map_Col+1);
            for(int j = 0; j < i; j++)
            {
                if(m.x==mines[j].x && m.y==mines[j].y)
                {
                    i--;
                    flag=false;
                    break;
                }
            }
            if(flag)
            {
                mines[i]=m;
            }
            else
            {
                m=null;
            }
            flag=true;
        }
    }
    public Vector2[] GetMineData()
    {
        return mines;
    }
}
