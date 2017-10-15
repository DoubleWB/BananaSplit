package com.example.bananasplittoon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GroupActivity extends AppCompatActivity {
    String group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        Intent intent = this.getIntent();
        group = intent.getStringExtra("Group");

        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText("Welcome to " + group + "!\nSettle your differences!" );
    }
}
