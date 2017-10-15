package com.example.bananasplittoon;

import android.content.Intent;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.example.bananasplittoon.resources.*;

import java.util.ArrayList;

public class GroupActivity extends AppCompatActivity {
    String group;
    Group grp;
    Person usr;
    RadioGroup debtGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        Intent intent = this.getIntent();
        group = intent.getStringExtra("Group");
        ArrayList<Person> people = new ArrayList<Person>();
        Person will = new Person(10001, "Will");
        Person anthony = new Person(10002, "Anthony");
        Person kevin = new Person(10003, "Kevin");
        Person ben = new Person(10004, "Ben Lerner");

        people.add(will);
        people.add(anthony);
        people.add(kevin);
        people.add(ben);

        Receipt r = new Receipt(anthony, null, new Date(12, 1));

        grp = new Group(people);
        grp.addReceipt(r);
        usr = will;

        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText("Welcome to " + group + "!\nSettle your differences!" );

        ArrayList<Debt> debts = usr.getDebts();
        debtGroup = (RadioGroup) findViewById(R.id.radioGroup2);
        RadioButton button;
        for(Debt debt : debts) {
            button = new RadioButton(this);
            button.setText(debt.toString());
            debtGroup.addView(button);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1) {
            if(resultCode == 1) {
                System.out.println("Successfully received Result");
                grp = (Group) data.getSerializableExtra("nowFinished");
                usr = grp.getById(((Person) data.getSerializableExtra("nowDebted")).getId());
                TextView textView = (TextView) findViewById(R.id.textView2);
                textView.setText("Welcome to " + group + "!\nSettle your differences!" );

                ArrayList<Debt> debts = usr.getDebts();
                debtGroup = (RadioGroup) findViewById(R.id.radioGroup2);
                RadioButton button;

                int count = debtGroup.getChildCount();
                if(count>0) {
                    for (int i=count-1;i>=0;i--) {
                        View o = debtGroup.getChildAt(i);
                        if (o instanceof RadioButton) {
                            debtGroup.removeViewAt(i);
                        }
                    }
                }

                for(Debt debt : debts) {
                    System.out.println(debt.toString());
                    button = new RadioButton(this);
                    button.setText(debt.toString());
                    debtGroup.addView(button);
                }
            }
        }
    }

    protected void reportFinished(View view){
        Intent intent = new Intent(this, ReportActivity.class);
        intent.putExtra("grp", grp);
        intent.putExtra("usr", usr);
        startActivityForResult(intent, 1);
    }
}
