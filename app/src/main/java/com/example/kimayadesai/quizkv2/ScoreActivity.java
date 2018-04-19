package com.example.kimayadesai.quizkv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ScoreActivity extends AppCompatActivity {

    ListView scoreList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        scoreList = (ListView) findViewById(R.id.scoreList);
    }
}
