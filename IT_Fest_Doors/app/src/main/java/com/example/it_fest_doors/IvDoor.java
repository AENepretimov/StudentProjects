package com.example.it_fest_doors;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.Nullable;

@SuppressLint("AppCompatCustomView")
public class IvDoor extends ImageView {

    private boolean isCar;


    public IvDoor(Context context) {
        super(context);
    }

    public IvDoor(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public IvDoor(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public IvDoor(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public boolean isCar() {
        return isCar;
    }

    public void setCar(boolean car) {
        isCar = car;
    }

    public void setOpen(){
        this.setImageResource( isCar ? R.drawable.ic_black_car : R.drawable.ic_goat );
    }
}
