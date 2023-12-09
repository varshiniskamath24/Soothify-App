package com.example.soothify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Forgot_password extends AppCompatActivity {
    public Button password_success_button,login3_button;
    EditText edit_password1,edit_password2,edit_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        password_success_button = (Button) findViewById(R.id.change_password_button);
        edit_password1=(EditText) findViewById(R.id.correct_password_edit);
        edit_password2=(EditText) findViewById(R.id.correct_new_password_edit);
        edit_email=(EditText) findViewById(R.id.correct_email_edit);
        password_success_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate())
                {
                    Intent intent=new Intent(Forgot_password.this,Password_changed_successfully.class);
                    startActivity(intent);
                }

            }
            private boolean validate() {
                boolean temp=true;
                String checkemail = edit_email.getText().toString();
                String pass=edit_password1.getText().toString();
                String cpass=edit_password2.getText().toString();
                if(!Patterns.EMAIL_ADDRESS.matcher(checkemail).matches()){
                    Toast.makeText(Forgot_password.this,"Invalid Email Address",Toast.LENGTH_SHORT).show();
                    temp=false;
                }
                else if(!pass.equals(cpass)){
                    Toast.makeText(Forgot_password.this,"Password Not matching",Toast.LENGTH_SHORT).show();
                    temp=false;
                }
                return temp;
            }
        });




    }
}