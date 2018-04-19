package com.example.kimayadesai.quizkv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    CardView scoreCard, marathonCard,warmUpCard, workOutCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        scoreCard = (CardView)findViewById(R.id.scoreCard);
        marathonCard = (CardView)findViewById(R.id.marathonCard);
        warmUpCard = (CardView)findViewById(R.id.warmUpCard);
        workOutCard= (CardView)findViewById(R.id.workOutCard);

        scoreCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v) {
                Intent intent = new Intent(MenuActivity.this, ScoreActivity.class);
                startActivity(intent);
                finish();

            }
        });
        marathonCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v) {
                Intent intent = new Intent(MenuActivity.this, MarathonActivity.class);
                startActivity(intent);

            }
        });
        warmUpCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v) {
                Intent intent = new Intent(MenuActivity.this, WarmUpActivity.class);
                startActivity(intent);

            }
        });
        workOutCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v) {
                Intent intent = new Intent(MenuActivity.this, WorkOutActivity.class);
                startActivity(intent);

            }
        });



    }

}