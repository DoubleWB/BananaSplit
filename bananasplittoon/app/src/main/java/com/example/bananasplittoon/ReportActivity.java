package com.example.bananasplittoon;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.bananasplittoon.resources.*;

public class ReportActivity extends AppCompatActivity {

    String itemShare;
    int desiredShare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == 1) {
                System.out.println("PLEASE SAVE ME");
                this.desiredShare = data.getIntExtra("share", 0);
            }
        }
    }

    protected void fillItemShare(View view) {
        Intent intent = this.getIntent();
        Group group = (Group) intent.getSerializableExtra("grp");
        Person user = group.getById(((Person) intent.getSerializableExtra("usr")).getId());
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        Intent check = new Intent(this.getApplicationContext(), ReviewShareActivity.class);
        //check.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        Item i = new Item(0, editText2.getText().toString(), 4);

        check.putExtra("item", i);
        check.putExtra("share", 25);

        //startActivityForResult(check, 1);

        //group.setDesire(desiredShare);

        group.on_Finished(i, user, this.getApplicationContext(), check);


        System.out.println("Will owes: " + user.getDebts().size() + " debts");

        Intent back = new Intent();
        back.putExtra("nowFinished", group);
        back.putExtra("nowDebted", user);
        setResult(1, back);
        finish();
    }
}
