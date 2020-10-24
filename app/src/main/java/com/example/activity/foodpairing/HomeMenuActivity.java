package com.example.activity.foodpairing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.activity.foodpairing.food_grid.FoodGridActivity;
import com.example.activity.foodpairing.food_list.InfoListActivity;

public class HomeMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_menu);
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.home_btn1:
                intent.setClass(HomeMenuActivity.this, InfoListActivity.class);
                break;
            case R.id.home_btn2:
                intent.setClass(HomeMenuActivity.this, FoodGridActivity.class);

                break;
            case R.id.home_btn3:
                intent.setClass(HomeMenuActivity.this, AboutActivity.class);
                break;
        }
        startActivity(intent);
    }
}