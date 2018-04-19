package com.example.kimayadesai.quizkv2;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by kimayadesai on 4/11/18.
 */

public class CustomCardAdapter extends BaseAdapter {

    LayoutInflater mInflater;

    Context mContext;
    String[] cards;
    String[] meaningFromFirebase;



    public CustomCardAdapter(Context context, String[] cards, String[] meaningFromFirebase){
        mContext = context;
        mInflater = LayoutInflater.from(context);
        this.cards = cards;
        this.meaningFromFirebase = meaningFromFirebase;

    }

    @Override
    public int getCount() {
        return cards.length;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.list_item,null);
        final TextView tv = convertView.findViewById(R.id.cardText);
        final CardView cv = convertView.findViewById(R.id.cardItem);
        tv.setText(cards[position]);
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cv.setAnimation(MyAnimation.flipAnimation());
                ViewPropertyAnimator vpa = v.animate();
                vpa.rotationXBy(360);
                if (tv.getText().equals(cards[position]))
                {
                    tv.setText(meaningFromFirebase[position]);
                }
                else
                {
                    tv.setText(cards[position]);
                }
            }
        });
        return convertView;
    }
}
