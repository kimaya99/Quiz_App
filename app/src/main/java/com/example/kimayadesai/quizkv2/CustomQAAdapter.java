package com.example.kimayadesai.quizkv2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by kimayadesai on 4/15/18.
 */

public class CustomQAAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    int count;

    Context mContext;
    String[] questions;
    String[] option1;
    String[] option2;
    String[] option3;
    String[] option4;

    String[] answer;
    TextView score;

    public CustomQAAdapter(Context context, String[] questions, String[] option1, String[] option2, String[] option3, String[] option4, String answer[],TextView score) {
        mInflater = LayoutInflater.from(context);
        this.questions = questions;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
        this.score = score;
    }

    @Override
    public int getCount() {
        return questions.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.question_answer_item,null);
        final TextView tv = convertView.findViewById(R.id.q_text);
        final CardView optionA = convertView.findViewById(R.id.option1);
        final CardView optionB = convertView.findViewById(R.id.option2);
        final CardView optionC = convertView.findViewById(R.id.option3);
        final CardView optionD = convertView.findViewById(R.id.option4);


        tv.setText(questions[position]);
        tv.setBackgroundColor(Color.BLACK);
        tv.setTextColor(Color.YELLOW);


        final TextView o1 = convertView.findViewById(R.id.o1);
        o1.setText(option1[position]);
        final TextView o2 = convertView.findViewById(R.id.o2);
        o2.setText(option2[position]);
        final TextView o3 = convertView.findViewById(R.id.o3);
        o3.setText(option3[position]);
        final TextView o4 = convertView.findViewById(R.id.o4);
        o4.setText(option4[position]);

       String actualAnswer="";
        if (answer[position].equals("a"))
            actualAnswer = option1[position];
        else if (answer[position].equals("b"))
            actualAnswer = option2[position];
        else if (answer[position].equals("c"))
            actualAnswer = option3[position];
        else if (answer[position].equals("d"))
            actualAnswer = option4[position];


        final String finalActualAnswer = actualAnswer;
        o1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (o1.getText().toString().equals(finalActualAnswer)) {
                    optionA.setCardBackgroundColor(Color.GREEN);
                    score.setText(Integer.toString(Integer.parseInt(score.getText().toString())+ 1));

                }
                else {
                    optionA.setCardBackgroundColor(Color.RED);

                }

                o1.setClickable(false);
                o2.setClickable(false);
                o3.setClickable(false);
                o4.setClickable(false);
            }
        });

        o2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (o2.getText().toString().equals(finalActualAnswer)) {
                    optionB.setCardBackgroundColor(Color.GREEN);

                    score.setText(Integer.toString(Integer.parseInt(score.getText().toString())+ 1));

                }
                else {
                    optionB.setCardBackgroundColor(Color.RED);

                }
                o1.setClickable(false);
                o2.setClickable(false);
                o3.setClickable(false);
                o4.setClickable(false);
            }


        });

        o3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (o3.getText().toString().equals(finalActualAnswer)){
                    optionC.setCardBackgroundColor(Color.GREEN);
                    score.setText(Integer.toString(Integer.parseInt(score.getText().toString())+ 1));

            }
                else {
                    optionC.setCardBackgroundColor(Color.RED);

                }
                o1.setClickable(false);
                o2.setClickable(false);
                o3.setClickable(false);
                o4.setClickable(false);
            }
        });

        o4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (o4.getText().toString().equals(finalActualAnswer)){
                    optionD.setCardBackgroundColor(Color.GREEN);
                    score.setText(Integer.toString(Integer.parseInt(score.getText().toString())+ 1));

                }

                else {
                    optionD.setCardBackgroundColor(Color.RED);

                }
                o1.setClickable(false);
                o2.setClickable(false);
                o3.setClickable(false);
                o4.setClickable(false);
            }


        });


        return convertView;
    }
}
