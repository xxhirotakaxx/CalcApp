package com.example.hirotaka.calcapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("エラー");
            alertDialogBuilder.setMessage("入力欄に空白があります。");

            alertDialogBuilder.setPositiveButton("閉じる",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            return;
        }

        Double num1, num2;
        try {
            num1 = Double.parseDouble(mEditText1.getText().toString());
            num2 = Double.parseDouble(mEditText2.getText().toString());
        } catch (Exception e) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("エラー");
            alertDialogBuilder.setMessage("数字を入力してください。");

            alertDialogBuilder.setPositiveButton("閉じる",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            return;
        }

        Intent intent = new Intent(this, SecondActivity.class);
        if (v.getId() == R.id.button1) {
            intent.putExtra("VALUE", num1 + num2);
        } else if (v.getId() == R.id.button2) {
            intent.putExtra("VALUE", num1 - num2);
        } else if (v.getId() == R.id.button3) {
            intent.putExtra("VALUE", num1 * num2);
        } else if (v.getId() == R.id.button4) {
            if (num2 == 0) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setTitle("エラー");
                alertDialogBuilder.setMessage("0での割り算はできません。");

                alertDialogBuilder.setPositiveButton("閉じる",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                return;
            }

            intent.putExtra("VALUE", num1 / num2);
        }
        startActivity(intent);
    }
}
