package com.example.soblab.androidgradechart;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                builder.setMessage("A Average: " + String.valueOf(aAverage) + "\n" + "B Average: " + String.valueOf(bAverage) + "\n" + "C Average: " +String.valueOf(cAverage) + "\n"+ "D Average: " +String.valueOf(dAverage) + "\n"+"F Average: " + String.valueOf(fAverage) + "\n").setTitle("Your averages");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Go to next fragment
                    }
                });
                builder.show();
            }
        });
    }
    private void calcPercentage(){
        float totalStudents = Float.parseFloat(numOfStudents.getText().toString());
        aAverage = Float.parseFloat(aStudent.getText().toString()) / totalStudents;
        bAverage = Float.parseFloat(bStudent.getText().toString()) / totalStudents;
        cAverage = Float.parseFloat(cStudent.getText().toString()) / totalStudents;
        dAverage = Float.parseFloat(dStudent.getText().toString()) / totalStudents;
        fAverage = Float.parseFloat(fStudent.getText().toString()) / totalStudents;
    }
}
