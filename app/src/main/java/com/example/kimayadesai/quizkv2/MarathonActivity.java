package com.example.kimayadesai.quizkv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

public class MarathonActivity extends AppCompatActivity {

    ListView warmOut;

    CustomQAAdapter mCardAdapter2;
    TextView score;
    String[] word;
    String[] option1;
    String[] option2;
    String[] option3;
    String[] option4;
    String[] answer;
    Button exit,next;
    int countWord = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_out);
        score = (TextView) findViewById(R.id.score);
        warmOut = (ListView)findViewById(R.id.QAList);
        exit = (Button)findViewById(R.id.exit);
        next = (Button)findViewById(R.id.nextButton);
        option1 = new String[2203];
        option2 = new String[2203];
        option3 = new String[2203];
        option4 = new String[2203];
        answer = new String[2203];
        word = new String[2203];



        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("0");

        myRef.child("quizlet").child("listUpdated").setValue("0");//means not yet updated

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String value = dataSnapshot.child("quizlet").child("listUpdated").getValue().toString();
                Log.d("kim", "Value is: " + value);

                if(value.equals("0"))
                {
                    Iterator iterator = dataSnapshot.child("quizlet").getChildren().iterator();
                    int i = 0;
                    while(iterator.hasNext())
                    {
                        DataSnapshot ds = (DataSnapshot) iterator.next();
                        if(!(ds.getKey().equals("listUpdated"))) {
                            word[i] = ds.child("word").getValue().toString();
                            answer[i] = ds.child("answer").getValue().toString();
                            option1[i] = ds.child("option1").getValue().toString();
                            option2[i] = ds.child("option2").getValue().toString();
                            option3[i] = ds.child("option3").getValue().toString();
                            option4[i] = ds.child("option4").getValue().toString();
                            i++;
                        }
                    }
                    Integer scoreX =Integer.parseInt(score.getText().toString());


                    String [] word1 = {word[0]};
                    String [] option11 = {option1[0]};
                    String [] option22 = {option2[0]};
                    String [] option33 = {option3[0]};
                    String [] option44 = {option4[0]};
                    String [] answer00 = {answer[0]};

                    mCardAdapter2 = new CustomQAAdapter(getApplicationContext(),word1,option11,option22,option33,option44,answer00,score);
                    warmOut.setAdapter(mCardAdapter2);
                    countWord = 0;
                    myRef.child("quizlet").child("listUpdated").setValue("0");

//                    mCardAdapter2 = new CustomQAAdapter(getApplicationContext(),word,option1,option2,option3,option4,answer,score);
//                    warmOut.setAdapter(mCardAdapter2);
//                    myRef.child("quizlet").child("listUpdated").setValue("0");
                }
                else
                {//value = 1

                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("", "Failed to read value.", error.toException());
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MarathonActivity.this, MenuActivity.class);
                startActivity(intent);

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newVal = (int) ((Math.random() * 10000) % 2202);
                if(newVal != countWord)
                {
                    countWord = newVal;
                }
                else
                {
                    countWord = (int) ((Math.random() * 10000) % 2202);
                }
                String [] word1 = {word[countWord]};
                String [] option11 = {option1[countWord]};
                String [] option22 = {option2[countWord]};
                String [] option33 = {option3[countWord]};
                String [] option44 = {option4[countWord]};
                String [] answer00 = {answer[countWord]};

                mCardAdapter2 = new CustomQAAdapter(getApplicationContext(),word1,option11,option22,option33,option44,answer00,score);
                warmOut.setAdapter(mCardAdapter2);
                myRef.child("quizlet").child("listUpdated").setValue("0");

            }
        });

    }
}
