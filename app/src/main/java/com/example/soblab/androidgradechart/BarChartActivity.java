package com.example.soblab.androidgradechart;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class BarChartActivity extends AppCompatActivity {
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String AAVERAGE = "aAverage";
    public static final String BAVERAGE = "bAverage";
    public static final String CAVERAGE = "cAverage";
    public static final String DAVERAGE = "dAverage";
    public static final String FAVERAGE = "fAverage";
    BarChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barchart);
        chart = findViewById(R.id.barchart);
        createBarChart();
    }

    private void createBarChart(){


        SharedPreferences grades = BarChartActivity.this.getSharedPreferences(
                SHARED_PREFS, Context.MODE_PRIVATE);

        ArrayList<BarEntry> NoOfEmp = new ArrayList<>();

        NoOfEmp.add(new BarEntry(grades.getFloat(AAVERAGE, 0.0f), 0));
        NoOfEmp.add(new BarEntry(grades.getFloat(BAVERAGE, 0.0f), 1));
        NoOfEmp.add(new BarEntry(grades.getFloat(CAVERAGE, 0.0f), 2));
        NoOfEmp.add(new BarEntry(grades.getFloat(DAVERAGE, 0.0f), 3));
        NoOfEmp.add(new BarEntry(grades.getFloat(FAVERAGE, 0.0f), 4));

        BarDataSet bardataset = new BarDataSet(NoOfEmp, "Average Grade");
        ArrayList<String> label = new ArrayList<>();

        label.add("A Avg");
        label.add("B Avg");
        label.add("C Avg");
        label.add("D Avg");
        label.add("F Avg");

        chart.animateY(5000);
        chart.setDescription("");
        chart.setDrawBarShadow(true);
        BarData data = new BarData(label, bardataset);
        data.setValueTextSize(30f);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.setData(data);
    }
}