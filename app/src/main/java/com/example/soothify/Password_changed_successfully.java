package com.example.soothify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Password_changed_successfully extends AppCompatActivity {
    public Button login2_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_changed_successfully);
        login2_button = (Button) findViewById(R.id.Login2_button);
        login2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Password_changed_successfully.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}