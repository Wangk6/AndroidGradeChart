package com.example.soblab.androidgradechart;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.github.mikephil.charting.charts.BarChart;


public class MainActivity extends AppCompatActivity {

    EditText numOfStudents, aStudent, bStudent, cStudent, dStudent, fStudent;
    Button calculate;
    float aAverage, bAverage, cAverage, dAverage, fAverage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numOfStudents = findViewById(R.id.editTextNumOfStudents);
        aStudent = findViewById(R.id.editTextAStudent);
        bStudent = findViewById(R.id.editTextBStudent);
        cStudent = findViewById(R.id.editTextCStudent);
        dStudent = findViewById(R.id.editTextDStudent);
        fStudent = findViewById(R.id.editTextFStudent);
        calculate = findViewById(R.id.btnCalculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcPercentage();

                //Alert Dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("A Average: " + String.valueOf(aAverage) + "%\n" + "B Average: " + String.valueOf(bAverage) + "%\n"
                        + "C Average: " +String.valueOf(cAverage) + "%\n"+ "D Average: " +String.valueOf(dAverage) +
                        "%\n"+"F Average: " + String.valueOf(fAverage) + "%\n").setTitle("Your averages");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Go to next fragment
                        Intent I = new Intent(MainActivity.this, BarChartActivity.class);
                        startActivity(I);
                    }
                });
                builder.show();
            }
        });
    }
    private void calcPercentage(){
        float totalStudents = Float.parseFloat(numOfStudents.getText().toString());
        aAverage = (Float.parseFloat(aStudent.getText().toString()) / totalStudents) * 100;
        bAverage = (Float.parseFloat(bStudent.getText().toString()) / totalStudents) * 100;
        cAverage = (Float.parseFloat(cStudent.getText().toString()) / totalStudents) * 100;
        dAverage = (Float.parseFloat(dStudent.getText().toString()) / totalStudents) * 100;
        fAverage = (Float.parseFloat(fStudent.getText().toString()) / totalStudents) * 100;

        int studentTotal = Integer.parseInt(numOfStudents.getText().toString());
        if(studentTotal <= 0 && studentTotal >= 100){
            //Display error
            numOfStudents.setText("*");
        }

        if(aAverage <= 0f && aAverage >= 100f){
            //Display error
            aStudent.setText("*");
        }
        if(bAverage <= 0f && bAverage >= 100f){
            //Display error
            bStudent.setText("*");
        }
        if(cAverage <= 0f && cAverage >= 100f){
            //Display error
            cStudent.setText("*");
        }
        if(dAverage <= 0f && dAverage >= 100f){
            //Display error
            dStudent.setText("*");
        }
        if(fAverage <= 0f && fAverage >= 100f){
            //Display error
            fStudent.setText("*");
        }
    }
}
