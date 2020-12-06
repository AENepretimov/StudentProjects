package com.example.it_fest_doors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class Choice1Activity extends AppCompatActivity {

    private IvDoor ibDoor11, ibDoor12, ibDoor13;
    private Button btnNext;
    private boolean isLose;
    private Integer doorNumber;

    private ArrayList<IvDoor> ivDoors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice1);

        doorNumber = (int) (Math.random() * 3);

        ibDoor11 = (IvDoor) findViewById(R.id.ib_door11);
        ibDoor12 = (IvDoor) findViewById(R.id.ib_door12);
        ibDoor13 = (IvDoor) findViewById(R.id.ib_door13);

        ivDoors = new ArrayList<>(3);
        ivDoors.add( ibDoor11 );
        ivDoors.add( ibDoor12 );
        ivDoors.add( ibDoor13 );

        ivDoors.get( doorNumber ).setCar( true );

        btnNext = (Button) findViewById(R.id.btn_go_to_choise2);

        ibDoor11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Math.random() > 0.5){
                    if ( ivDoors.get(1).isCar() ){
                        isLose = true;
                        ivDoors.get(1).invalidate();
                        btnNext.setText("Try again?");
                    }else {
                        isLose = false;
                        ivDoors.get(1).invalidate();
                    }
                }else {
                    if ( ivDoors.get(2).isCar() ){
                        isLose = true;
                        ivDoors.get(2).invalidate();
                        btnNext.setText("Try again?");
                    }else {
                        isLose = false;
                        ivDoors.get(2).invalidate();
                    }
                }

            }
        });

        ibDoor12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Math.random() > 0.5){
                    if ( ivDoors.get(0).isCar() ){
                        isLose = true;
                        ivDoors.get(0).invalidate();
                        btnNext.setText("Try again?");
                    }else {
                        isLose = false;
                        ivDoors.get(0).invalidate();
                    }
                }else {
                    if ( ivDoors.get(2).isCar() ){
                        isLose = true;
                        ivDoors.get(2).invalidate();
                        btnNext.setText("Try again?");
                    }else {
                        isLose = false;
                        ivDoors.get(2).invalidate();
                    }
                }

            }
        });

        ibDoor13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Math.random() > 0.5){
                    if ( ivDoors.get(1).isCar() ){
                        isLose = true;
                        ivDoors.get(1).invalidate();
                        btnNext.setText("Try again?");
                    }else {
                        isLose = false;
                        ivDoors.get(1).invalidate();
                    }
                }else {
                    if ( ivDoors.get(0).isCar() ){
                        isLose = true;
                        ivDoors.get(0).invalidate();
                        btnNext.setText("Try again?");
                    }else {
                        isLose = false;
                        ivDoors.get(0).invalidate();
                    }
                }

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                if (isLose){
                    i = new Intent(Choice1Activity.this, MainActivity.class);
                    startActivity(i);
                }else {
                    i = new Intent(Choice1Activity.this, Choice2Activity.class);
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