package com.example.it_fest_doors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Choice2Activity extends AppCompatActivity {

    private ImageButton ibDoor21, ibDoor22;
    private Button btnNext;
    private boolean isLose;

    private Integer doorNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice2);

        /*Intent i = getIntent();
        doorNumber = i.getIntExtra(MainActivity.MSG_NAME, 0);*/

        doorNumber = (int) (Math.random() * 2 + 1);

        ibDoor21 = (ImageButton) findViewById(R.id.ib_door21);
        ibDoor22 = (ImageButton) findViewById(R.id.ib_door22);

        btnNext = (Button) findViewById(R.id.btn_go_to_final);

        ibDoor21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (doorNumber == 1){
                    isLose = false;
                    ibDoor22.setImageResource(R.drawable.ic_goat);
                }else {
                    isLose = true;
                    ibDoor22.setImageResource(R.drawable.ic_black_car);
                    btnNext.setText( R.string.try_again );
                }

            }
        });

        ibDoor22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (doorNumber == 2){
                    isLose = false;
                    ibDoor21.setImageResource(R.drawable.ic_goat);
                }else {
                    isLose = true;
                    ibDoor21.setImageResource(R.drawable.ic_black_car);
                    btnNext.setText( R.string.try_again );
                }

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                if (isLose){
                    i = new Intent(Choice2Activity.this, MainActivity.class);
                    startActivity(i);
                }else {
                    i = new Intent(Choice2Activity.this, WinActivity.class);
                    //i.putExtra(MainActivity.MSG_NAME, doorNumber);
                    startActivity(i);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, R.string.back_button, Toast.LENGTH_SHORT).show();
    }

}