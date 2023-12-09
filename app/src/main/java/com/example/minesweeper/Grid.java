package com.example.minesweeper;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import java.security.PublicKey;


public class Grid {
    public int row;
    public int col;
    public Boolean IsMine;
    public Boolean IsOpen;
    public Boolean IsFlag;
    public int MineCount;
    public ImageButton imageButton;
    public enum ImageId
    {
        num1,num2,num3,num4,
        num5,num6,num7,num8,
        Mine,Flag,MineFlag,none,
        NULL,ButtonFlag
    }
    public ImageId imageId;
    public Grid()
    {
        IsMine=false;
        IsOpen=false;
        IsFlag=false;
        imageId=ImageId.NULL;
        MineCount=0;
    }
    public void SetImageBt(GridLayout gridLayout)
    {
        Context context = gridLayout.getContext();
        imageButton=new ImageButton(context);
        imageButton.setBackgroundColor(Color.blue(0));
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();

        layoutParams.width=0;
        layoutParams.height=0;
        layoutParams.rowSpec = GridLayout.spec(row-1,1f);
        layoutParams.columnSpec=GridLayout.spec(col-1,1f);
        imageButton.setLayoutParams(layoutParams);
        //imageButton.setOnClickListener();
        ChangeImageId(ImageId.none);
        imageButton.setScaleType(ImageButton.ScaleType.FIT_XY);
    }
    public ImageButton GetImageBt()
    {
        return imageButton;
    }
    public void ChangeImageId(ImageId id)
    {
        switch (id)
        {
            case none:
                imageButton.setBackgroundResource(R.drawable.top);
                break;
            case num1:
                imageButton.setBackgroundResource(R.drawable.num1);
                break;
            case num2:
                imageButton.setBackgroundResource(R.drawable.num2);
                break;
            case num3:
                imageButton.setBackgroundResource(R.drawable.num3);
                break;
            case num4:
                imageButton.setBackgroundResource(R.drawable.num4);
                break;
            case num5:
                imageButton.setBackgroundResource(R.drawable.num5);
                break;
            case num6:
                imageButton.setBackgroundResource(R.drawable.num6);
                break;
            case num7:
                imageButton.setBackgroundResource(R.drawable.num7);
                break;
            case num8:
                imageButton.setBackgroundResource(R.drawable.num8);
                break;
            case Mine:
                imageButton.setBackgroundResource(R.drawable.lei);
                break;
            case Flag:
                imageButton.setBackgroundResource(R.drawable.flag);
                break;
            case MineFlag:
                imageButton.setBackgroundResource(R.drawable.leiflag);
                break;
            case NULL:
                imageButton.setBackgroundResource(R.drawable.nullptr);
                break;
            case ButtonFlag:
                imageButton.setBackgroundResource(R.drawable.buttonflag);
                break;
        }
    }
    public void ChangeImageId()
    {
        switch (imageId)
        {
            case none:
                imageButton.setBackgroundResource(R.drawable.top);
                break;
            case num1:
                imageButton.setBackgroundResource(R.drawable.num1);
                break;
            case num2:
                imageButton.setBackgroundResource(R.drawable.num2);
                break;
            case num3:
                imageButton.setBackgroundResource(R.drawable.num3);
                break;
            case num4:
                imageButton.setBackgroundResource(R.drawable.num4);
                break;
            case num5:
                imageButton.setBackgroundResource(R.drawable.num5);
                break;
            case num6:
                imageButton.setBackgroundResource(R.drawable.num6);
                break;
            case num7:
                imageButton.setBackgroundResource(R.drawable.num7);
                break;
            case num8:
                imageButton.setBackgroundResource(R.drawable.num8);
                break;
            case Mine:
                imageButton.setBackgroundResource(R.drawable.lei);
                break;
            case Flag:
                imageButton.setBackgroundResource(R.drawable.flag);
                break;
            case MineFlag:
                imageButton.setBackgroundResource(R.drawable.leiflag);
                break;
            case NULL:
                imageButton.setBackgroundResource(R.drawable.nullptr);
                break;
            case ButtonFlag:
                imageButton.setBackgroundResource(R.drawable.buttonflag);
                break;
        }
    }
}
