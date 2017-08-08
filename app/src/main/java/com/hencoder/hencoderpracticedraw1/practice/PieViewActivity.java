package com.hencoder.hencoderpracticedraw1.practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hencoder.hencoderpracticedraw1.R;

import java.util.ArrayList;

public class PieViewActivity extends AppCompatActivity {

    private Practice11PieChartView mPieView;
    private ArrayList<PieViewBean> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_view);
        mPieView = (Practice11PieChartView) findViewById(R.id.pieView);

        initData();
        mPieView.onStartDraw(mList);
    }

    private void initData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            PieViewBean pieViewBean = new PieViewBean();
            pieViewBean.setCount(i * 10 + 10);
            mList.add(pieViewBean);
        }
    }
}
