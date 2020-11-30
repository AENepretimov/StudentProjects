package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private MyButton btn1, btn2, btn3;

    private Integer score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (MyButton) findViewById(R.id.btn_1);
        btn2 = (MyButton) findViewById(R.id.btn_2);
        btn3 = (MyButton) findViewById(R.id.btn_3);

        btn1.randColor();
        btn2.randColor();
        btn3.randColor();

        tv = (TextView) findViewById(R.id.tv);
        tv.setText( score.toString() );

        MyLis myLis = new MyLis();

        btn1.setOnClickListener( myLis );
        btn2.setOnClickListener( myLis );
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyButton myButton = (MyButton) view;

                if ( myButton.getIsGreen() ){
                    score++;
                    tv.setText( score.toString() );
                }else {
                    score--;
                    tv.setText( score.toString() );
                }

                btn1.randColor();
                btn2.randColor();
                btn3.randColor();
            }
        });

    }

    class MyLis implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            MyButton myButton = (MyButton) view;

            if ( myButton.getIsGreen() ){
                score++;
                tv.setText( score.toString() );
            }else {
                score--;
                tv.setText( score.toString() );
            }

            btn1.randColor();
            btn2.randColor();
            btn3.randColor();

        }

    }

}