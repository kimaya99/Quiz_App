package com.example.kimayadesai.quizkv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class WarmUpActivity extends AppCompatActivity {

    ListView warmUp;

    CustomCardAdapter mCardAdapter;
//    String[] cards = {"apple","banana","watermelon","kiwi"};
    String[] cardsFromFirebase;
    String[] meaningFromFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warm_up);
        warmUp = (ListView)findViewById(R.id.listWarmUp);
        cardsFromFirebase = new String[1365];
        meaningFromFirebase = new String[1365];





        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("0");

        myRef.child("wordlist").child("listUpdated").setValue("0");//means not yet updated

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String value = dataSnapshot.child("wordlist").child("listUpdated").getValue().toString();
                Log.d("kim", "Value is: " + value);

                if(value.equals("0"))
                {
                    Iterator iterator = dataSnapshot.child("wordlist").getChildren().iterator();
                    int i = 0;
                    while(iterator.hasNext())
                    {
                        DataSnapshot ds = (DataSnapshot) iterator.next();
                        if(!(ds.getKey().equals("listUpdated"))) {
                            cardsFromFirebase[i] = ds.child("WORD").getValue().toString();
                            meaningFromFirebase[i] = ds.child("DEFINITION").getValue().toString();
                            i++;
                        }
                    }

                    mCardAdapter = new CustomCardAdapter(getApplicationContext(),cardsFromFirebase,meaningFromFirebase);
                    warmUp.setAdapter(mCardAdapter);
                    myRef.child("wordlist").child("listUpdated").setValue("0");
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
    }



}
