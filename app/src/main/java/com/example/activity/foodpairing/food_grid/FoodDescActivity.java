package com.example.activity.foodpairing.food_grid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.activity.foodpairing.R;
import com.example.activity.foodpairing.bean.FoodBean;

public class FoodDescActivity extends AppCompatActivity {
    TextView titleTv1,titleTv2,descTv,notTv;
    ImageView backIv,bigPicIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_desc);
        initView();
        //接收上一级页面传来的数据
        Intent intent = getIntent();
        FoodBean foodBean = (FoodBean)intent.getSerializableExtra("food");
        //设置显示控件
        titleTv1.setText(foodBean.getTitle());
        titleTv2.setText(foodBean.getTitle());
        descTv.setText(foodBean.getDesc());
        notTv.setText(foodBean.getNotmatch());
        bigPicIv.setImageResource(foodBean.getPicId());
    }

    private void initView() {
        titleTv1 = findViewById(R.id.fooddesc_tv_title1);
        titleTv2 = findViewById(R.id.fooddesc_tv_title2);
        descTv = findViewById(R.id.foodesc_tv_desc);
        notTv = findViewById(R.id.foodesc_tv_not);
        backIv = findViewById(R.id.fooddesc_iv_back);
        bigPicIv = findViewById(R.id.foodesc_iv_bigpic);
        backIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}