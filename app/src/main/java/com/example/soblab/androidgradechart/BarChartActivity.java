package com.example.soblab.androidgradechart;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barchart);
        BarChart chart = findViewById(R.id.barchart);

        ArrayList<BarEntry> NoOfEmp = new ArrayList<>();

        NoOfEmp.add(new BarEntry(945f, 0));
        NoOfEmp.add(new BarEntry(1040f, 1));
        NoOfEmp.add(new BarEntry(1133f, 2));
        NoOfEmp.add(new BarEntry(1240f, 3));
        NoOfEmp.add(new BarEntry(1369f, 4));

        BarDataSet bardataset = new BarDataSet(NoOfEmp, "Average Grade");

        ArrayList<String> label = new ArrayList<>();

        label.add("A");
        label.add("B");
        label.add("C");
        label.add("D");
        label.add("F");

        chart.animateY(5000);

        BarData data = new BarData(label, bardataset);

        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.setData(data);
    }
}