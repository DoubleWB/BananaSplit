package com.example.bananasplittoon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText mEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEdit = (EditText) findViewById(R.id.editText);
    }

    protected void signIn(View view) {
        Intent intent = new Intent(this, UserActivity.class);
        intent.putExtra("username", mEdit.getText().toString());
        startActivity(intent);
    }
}
