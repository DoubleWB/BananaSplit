package com.example.bananasplittoon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.PointerIcon;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.bananasplittoon.resources.Group;
import com.example.bananasplittoon.resources.Item;
import com.example.bananasplittoon.resources.Person;

public class ReviewShareActivity extends AppCompatActivity {

    public TextView textView2;
    public int share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_share);
        Intent i = this.getIntent();
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView2 = (TextView) findViewById(R.id.textView3);

        share = i.getIntExtra("share", 0);
        Item underReview = (Item) i.getSerializableExtra("item");
        //Person user = (Person) i.getSerializableExtra("me");

        textView.setText("Rate your satisfaction with " + share + " percent of: " + underReview.getName());

        SeekBar slider = (SeekBar) findViewById(R.id.seekBar);
        slider.setProgress(slider.getMax()/2);
        textView2.setText("I want: " + (share*((slider.getProgress() - slider.getMax()/2)/slider.getMax()) + share) + " percent ");
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView2.setText("I want: " + (share*((progress - seekBar.getMax()/2)/seekBar.getMax()) + share) + " percent ");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    protected void moveOn(View view) {
        //Person user = (Person) this.getIntent().getSerializableExtra("me");
        SeekBar slider = (SeekBar) findViewById(R.id.seekBar);
        Intent I = new Intent();
        //I.putExtra("share", (share*((slider.getProgress() - slider.getMax()/2)/slider.getMax()) + share) + " percent ");
        I.putExtra("share", 15);
        setResult(1, I);
        finish();
    }

}
