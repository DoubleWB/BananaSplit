package com.example.bananasplittoon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.security.acl.Group;
import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {
    String name;
    ArrayList<String> groupNames = new ArrayList<String>();
    RadioGroup group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Intent intent = getIntent();
        name = intent.getStringExtra("username");
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Welcome to Banana Split, " + name + "!\nSelect one of your groups!" );
        groupNames.add("Roommates");
        groupNames.add("Family");
        groupNames.add("HackGT FAM");
        group = (RadioGroup) findViewById(R.id.radioGroup);
        RadioButton button;
        for(String name : groupNames) {
            button = new RadioButton(this);
            button.setText("Group: " + name);
            group.addView(button);
        }
    }

    protected void enterGroup(View view) {
        Intent intent = new Intent(this, GroupActivity.class);
        RadioButton rb = (RadioButton) findViewById(group.getCheckedRadioButtonId());
        intent.putExtra("Group", rb.getText().toString());
        startActivity(intent);
    }
}
