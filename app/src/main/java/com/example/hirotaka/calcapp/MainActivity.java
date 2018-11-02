package com.example.hirotaka.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText1;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText1 = findViewById(R.id.editText1);
        mEditText2 = findViewById(R.id.editText2);

        Button tasu = findViewById(R.id.button1);
        tasu.setOnClickListener(this);

        Button hiku = findViewById(R.id.button2);
        hiku.setOnClickListener(this);

        Button kake = findViewById(R.id.button3);
        kake.setOnClickListener(this);

        Button waru = findViewById(R.id.button4);
        waru.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (mEditText1.length() == 0 || mEditText2.length() == 0) {
            return;
        }

        Double num1 = Double.parseDouble(mEditText1.getText().toString());
        Double num2 = Double.parseDouble(mEditText2.getText().toString());
        Intent intent = new Intent(this, SecondActivity.class);
        if (v.getId() == R.id.button1) {
            intent.putExtra("VALUE", num1 + num2);
        } else if (v.getId() == R.id.button2) {
            intent.putExtra("VALUE", num1 - num2);
        } else if (v.getId() == R.id.button3) {
            intent.putExtra("VALUE", num1 * num2);
        } else if (v.getId() == R.id.button4) {
            intent.putExtra("VALUE", num1 / num2);
        }
        startActivity(intent);
    }
}
