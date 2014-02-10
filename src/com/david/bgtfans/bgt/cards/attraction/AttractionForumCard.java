package com.david.bgtfans.bgt.cards.attraction;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.david.bgtfans.R;

import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created by david.hodge on 2/10/14.
 */
public class AttractionForumCard extends Card {

    TextView hours;

    /**
     * Constructor with a custom inner layout
     *
     * @param context
     */
    public AttractionForumCard(Context context) {
        this(context, R.layout.today_hours_card);
    }

    /**
     * @param context
     * @param innerLayout
     */
    public AttractionForumCard(Context context, int innerLayout) {
        super(context, innerLayout);
        init();
    }

    /**
     * Init
     */
    private void init() {

        //No Header

        /*
        //Set a OnClickListener listener
        setOnClickListener(new OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
                Toast.makeText(getContext(), "Click Listener card=", Toast.LENGTH_LONG).show();
            }
        });*/
    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {

        //Retrieve elements
        hours = (TextView) parent.findViewById(R.id.hours);
        hours.setText("10am - 9pm");

    }
}