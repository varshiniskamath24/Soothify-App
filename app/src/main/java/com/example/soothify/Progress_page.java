package com.example.soothify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Progress_page extends AppCompatActivity {

    Button b1, b2, b3, b4, b5, home;
    ProgressBar p;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_page);
        t1 = (TextView) findViewById(R.id.status);
        home = (Button) findViewById(R.id.Login2_button);
        b1 = (Button) findViewById(R.id.button_1);
        b2 = (Button) findViewById(R.id.button_2);
        b3 = (Button) findViewById(R.id.button_3);
        b4 = (Button) findViewById(R.id.button_4);
        b5 = (Button) findViewById(R.id.button_5);
        p = (ProgressBar) findViewById(R.id.progressBar2);
        Intent intent = getIntent();
        if(intent.getStringExtra("Condition") != null) {
            t1.setText(intent.getStringExtra("Condition"));
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b1.setClickable(false);
                b1.setBackgroundColor(R.color.white);
                p.setProgress(p.getProgress() + 20);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b2.setClickable(false);
                b2.setBackgroundColor(R.color.white);
                p.setProgress(p.getProgress() + 20);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b3.setClickable(false);
                b3.setBackgroundColor(R.color.white);
                p.setProgress(p.getProgress() + 20);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b4.setClickable(false);
                b4.setBackgroundColor(R.color.white);
                p.setProgress(p.getProgress() + 20);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b5.setClickable(false);
                b5.setBackgroundColor(R.color.white);
                p.setProgress(p.getProgress() + 20);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Progress_page.this, Login_Page.class);
                intent.putExtra("Condition", t1.getText());
                startActivity(intent);
            }
        });
    }
}