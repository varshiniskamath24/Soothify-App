package com.example.soothify;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;



public class is_new_user extends AppCompatActivity {
    public Button signup_button,login2_button;
    DBHelper DB;
    EditText username, password, conpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_is_new_user);
        DB = new DBHelper(this);

        username = (EditText) findViewById(R.id.username_edit);
        password = (EditText) findViewById(R.id.password_edit);
        conpass = (EditText) findViewById(R.id.confirm_edit);
        signup_button = (Button) findViewById(R.id.sign_up_button);
        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String conf = conpass.getText().toString();
                if (user.equals("") || pass.equals("") || conf.equals("")) {
                    Toast.makeText(is_new_user.this, "Please Fill All Fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (pass.equals(conf)) {
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser == false) {
                            Boolean insert = DB.insertData(user, pass);
                            if (insert == true) {
                                Toast.makeText(is_new_user.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(is_new_user.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(is_new_user.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(is_new_user.this, "User already exists", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(is_new_user.this, "Passwords dont match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        login2_button = (Button) findViewById(R.id.Login2_button);
        login2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(is_new_user.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}