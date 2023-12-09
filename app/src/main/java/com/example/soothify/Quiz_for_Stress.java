package com.example.soothify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Quiz_for_Stress extends AppCompatActivity {
    int marks = 0;
    String condition;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_for_stress);

        submit = (Button) findViewById(R.id.Submit_button);

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                radioGroup = (RadioGroup) findViewById(R.id.q1);
                int sel = radioGroup.getCheckedRadioButtonId();
                if (sel < 0)
                {
                    Toast.makeText(Quiz_for_Stress.this, "Answer All Questions!", Toast.LENGTH_SHORT).show();
                    return;
                }
                radioGroup = (RadioGroup) findViewById(R.id.q2);
                sel = radioGroup.getCheckedRadioButtonId();
                if (sel < 0)
                {
                    Toast.makeText(Quiz_for_Stress.this, "Answer All Questions!", Toast.LENGTH_SHORT).show();
                    return;
                }
                radioGroup = (RadioGroup) findViewById(R.id.q3);
                sel = radioGroup.getCheckedRadioButtonId();
                if (sel < 0)
                {
                    Toast.makeText(Quiz_for_Stress.this, "Answer All Questions!", Toast.LENGTH_SHORT).show();
                    return;
                }
                radioGroup = (RadioGroup) findViewById(R.id.q4);
                sel = radioGroup.getCheckedRadioButtonId();
                if (sel < 0)
                {
                    Toast.makeText(Quiz_for_Stress.this, "Answer All Questions!", Toast.LENGTH_SHORT).show();
                    return;
                }
                radioGroup = (RadioGroup) findViewById(R.id.q5);
                sel = radioGroup.getCheckedRadioButtonId();
                if (sel < 0)
                {
                    Toast.makeText(Quiz_for_Stress.this, "Answer All Questions!", Toast.LENGTH_SHORT).show();
                    return;
                }
                radioGroup = (RadioGroup) findViewById(R.id.q6);
                sel = radioGroup.getCheckedRadioButtonId();
                if (sel < 0)
                {
                    Toast.makeText(Quiz_for_Stress.this, "Answer All Questions!", Toast.LENGTH_SHORT).show();
                    return;
                }
                radioGroup = (RadioGroup) findViewById(R.id.q7);
                sel = radioGroup.getCheckedRadioButtonId();
                if (sel < 0)
                {
                    Toast.makeText(Quiz_for_Stress.this, "Answer All Questions!", Toast.LENGTH_SHORT).show();
                    return;
                }
                radioGroup = (RadioGroup) findViewById(R.id.q8);
                sel = radioGroup.getCheckedRadioButtonId();
                if (sel < 0)
                {
                    Toast.makeText(Quiz_for_Stress.this, "Answer All Questions!", Toast.LENGTH_SHORT).show();
                    return;
                }
                radioGroup = (RadioGroup) findViewById(R.id.q9);
                sel = radioGroup.getCheckedRadioButtonId();
                if (sel < 0)
                {
                    Toast.makeText(Quiz_for_Stress.this, "Answer All Questions!", Toast.LENGTH_SHORT).show();
                    return;
                }
                radioGroup = (RadioGroup) findViewById(R.id.q10);
                sel = radioGroup.getCheckedRadioButtonId();
                if (sel < 0)
                {
                    Toast.makeText(Quiz_for_Stress.this, "Answer All Questions!", Toast.LENGTH_SHORT).show();
                    return;
                }
                radioGroup = (RadioGroup) findViewById(R.id.q11);
                sel = radioGroup.getCheckedRadioButtonId();
                if (sel < 0)
                {
                    Toast.makeText(Quiz_for_Stress.this, "Answer All Questions!", Toast.LENGTH_SHORT).show();
                    return;
                }
                radioGroup = (RadioGroup) findViewById(R.id.q12);
                sel = radioGroup.getCheckedRadioButtonId();
                if (sel < 0)
                {
                    Toast.makeText(Quiz_for_Stress.this, "Answer All Questions!", Toast.LENGTH_SHORT).show();
                    return;
                }
                radioGroup = (RadioGroup) findViewById(R.id.q13);
                sel = radioGroup.getCheckedRadioButtonId();
                if (sel < 0)
                {
                    Toast.makeText(Quiz_for_Stress.this, "Answer All Questions!", Toast.LENGTH_SHORT).show();
                    return;
                }
                radioGroup = (RadioGroup) findViewById(R.id.q14);
                sel = radioGroup.getCheckedRadioButtonId();
                if (sel < 0)
                {
                    Toast.makeText(Quiz_for_Stress.this, "Answer All Questions!", Toast.LENGTH_SHORT).show();
                    return;
                }
                marks = 0;
                radioButton = (RadioButton) findViewById(R.id.q1_2);
                if(radioButton.isChecked()) {
                    marks += 1;
                }
                radioButton = (RadioButton) findViewById(R.id.q1_3);
                if(radioButton.isChecked()) {
                    marks += 2;
                }
                radioButton = (RadioButton) findViewById(R.id.q1_4);
                if(radioButton.isChecked()) {
                    marks += 3;
                }
                radioButton = (RadioButton) findViewById(R.id.q2_2);
                if(radioButton.isChecked()) {
                    marks += 1;
                }
                radioButton = (RadioButton) findViewById(R.id.q2_3);
                if(radioButton.isChecked()) {
                    marks += 2;
                }
                radioButton = (RadioButton) findViewById(R.id.q2_4);
                if(radioButton.isChecked()) {
                    marks += 3;
                }
                radioButton = (RadioButton) findViewById(R.id.q3_2);
                if(radioButton.isChecked()) {
                    marks += 1;
                }
                radioButton = (RadioButton) findViewById(R.id.q3_3);
                if(radioButton.isChecked()) {
                    marks += 2;
                }
                radioButton = (RadioButton) findViewById(R.id.q3_4);
                if(radioButton.isChecked()) {
                    marks += 3;
                }
                radioButton = (RadioButton) findViewById(R.id.q4_2);
                if(radioButton.isChecked()) {
                    marks += 1;
                }
                radioButton = (RadioButton) findViewById(R.id.q4_3);
                if(radioButton.isChecked()) {
                    marks += 2;
                }
                radioButton = (RadioButton) findViewById(R.id.q4_4);
                if(radioButton.isChecked()) {
                    marks += 3;
                }
                radioButton = (RadioButton) findViewById(R.id.q5_2);
                if(radioButton.isChecked()) {
                    marks += 1;
                }
                radioButton = (RadioButton) findViewById(R.id.q5_3);
                if(radioButton.isChecked()) {
                    marks += 2;
                }
                radioButton = (RadioButton) findViewById(R.id.q5_4);
                if(radioButton.isChecked()) {
                    marks += 3;
                }
                radioButton = (RadioButton) findViewById(R.id.q6_2);
                if(radioButton.isChecked()) {
                    marks += 1;
                }
                radioButton = (RadioButton) findViewById(R.id.q6_3);
                if(radioButton.isChecked()) {
                    marks += 2;
                }
                radioButton = (RadioButton) findViewById(R.id.q6_4);
                if(radioButton.isChecked()) {
                    marks += 3;
                }
                radioButton = (RadioButton) findViewById(R.id.q7_2);
                if(radioButton.isChecked()) {
                    marks += 1;
                }
                radioButton = (RadioButton) findViewById(R.id.q7_3);
                if(radioButton.isChecked()) {
                    marks += 2;
                }
                radioButton = (RadioButton) findViewById(R.id.q7_4);
                if(radioButton.isChecked()) {
                    marks += 3;
                }
                radioButton = (RadioButton) findViewById(R.id.q8_2);
                if(radioButton.isChecked()) {
                    marks += 1;
                }
                radioButton = (RadioButton) findViewById(R.id.q8_3);
                if(radioButton.isChecked()) {
                    marks += 2;
                }
                radioButton = (RadioButton) findViewById(R.id.q8_4);
                if(radioButton.isChecked()) {
                    marks += 3;
                }
                radioButton = (RadioButton) findViewById(R.id.q9_2);
                if(radioButton.isChecked()) {
                    marks += 1;
                }
                radioButton = (RadioButton) findViewById(R.id.q9_3);
                if(radioButton.isChecked()) {
                    marks += 2;
                }
                radioButton = (RadioButton) findViewById(R.id.q9_4);
                if(radioButton.isChecked()) {
                    marks += 3;
                }
                radioButton = (RadioButton) findViewById(R.id.q10_2);
                if(radioButton.isChecked()) {
                    marks += 1;
                }
                radioButton = (RadioButton) findViewById(R.id.q10_3);
                if(radioButton.isChecked()) {
                    marks += 2;
                }
                radioButton = (RadioButton) findViewById(R.id.q10_4);
                if(radioButton.isChecked()) {
                    marks += 3;
                }
                radioButton = (RadioButton) findViewById(R.id.q11_2);
                if(radioButton.isChecked()) {
                    marks += 1;
                }
                radioButton = (RadioButton) findViewById(R.id.q11_3);
                if(radioButton.isChecked()) {
                    marks += 2;
                }
                radioButton = (RadioButton) findViewById(R.id.q11_4);
                if(radioButton.isChecked()) {
                    marks += 3;
                }
                radioButton = (RadioButton) findViewById(R.id.q12_2);
                if(radioButton.isChecked()) {
                    marks += 1;
                }
                radioButton = (RadioButton) findViewById(R.id.q12_3);
                if(radioButton.isChecked()) {
                    marks += 2;
                }
                radioButton = (RadioButton) findViewById(R.id.q12_4);
                if(radioButton.isChecked()) {
                    marks += 3;
                }
                radioButton = (RadioButton) findViewById(R.id.q13_2);
                if(radioButton.isChecked()) {
                    marks += 1;
                }
                radioButton = (RadioButton) findViewById(R.id.q13_3);
                if(radioButton.isChecked()) {
                    marks += 2;
                }
                radioButton = (RadioButton) findViewById(R.id.q13_4);
                if(radioButton.isChecked()) {
                    marks += 3;
                }
                radioButton = (RadioButton) findViewById(R.id.q14_2);
                if(radioButton.isChecked()) {
                    marks += 1;
                }
                radioButton = (RadioButton) findViewById(R.id.q14_3);
                if(radioButton.isChecked()) {
                    marks += 2;
                }
                radioButton = (RadioButton) findViewById(R.id.q14_4);
                if(radioButton.isChecked()) {
                    marks += 3;
                }
                if(marks <=11)
                {
                    condition = "Normal";
                }
                else if (marks <= 18)
                {
                    condition = "Mild";
                }
                else if (marks <= 25)
                {
                    condition = "Moderate";
                }
                else if (marks <= 33)
                {
                    condition = "Severe";
                }
                else
                {
                    condition = "Extremely severe";
                }
                Intent intent = new Intent(Quiz_for_Stress.this, Progress_page.class);
                intent.putExtra("Condition", condition);
                startActivity(intent);
            }
        });
    }
}