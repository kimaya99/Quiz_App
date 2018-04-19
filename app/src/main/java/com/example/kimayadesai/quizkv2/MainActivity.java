package com.example.kimayadesai.quizkv2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CardView vocabCard,physicsCard,chemCard,mathsCard, lawCard,biologyCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vocabCard = (CardView)findViewById(R.id.vocabCard);
        physicsCard = (CardView)findViewById(R.id.physicsCard);
        chemCard = (CardView)findViewById(R.id.chemCard);
        mathsCard= (CardView)findViewById(R.id.mathsCard);
        lawCard = (CardView)findViewById(R.id.lawCard);
        biologyCard = (CardView)findViewById(R.id.bioCard);
        vocabCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v) {
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();

            }
        });
        biologyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v) {
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();

            }
        });
        chemCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v) {
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();

            }
        });
        physicsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v) {///search for getChildCount
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();

            }
        });
        lawCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v) {
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();

            }
        });
        mathsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v) {
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }



}
