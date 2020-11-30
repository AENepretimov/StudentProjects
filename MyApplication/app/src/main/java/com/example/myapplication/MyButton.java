package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.Nullable;

@SuppressLint("AppCompatCustomView")
public class MyButton extends ImageView {

    private boolean isGreen;

    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void randColor(){
        if (Math.random() < 0.3){
            this.setBackgroundColor(getResources().getColor( R.color.myRed ));
            isGreen = false;
        }else {
            this.setBackgroundColor(getResources().getColor( R.color.myGreen ));
            isGreen = true;
        }
    }

    public boolean getIsGreen(){
        return isGreen;
    }
}
