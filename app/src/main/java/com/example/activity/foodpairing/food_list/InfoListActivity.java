package com.example.activity.foodpairing.food_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.activity.foodpairing.R;
import com.example.activity.foodpairing.bean.FoodBean;
import com.example.activity.foodpairing.bean.FoodUtils;
import com.example.activity.foodpairing.food_grid.FoodDescActivity;

import java.util.ArrayList;
import java.util.List;

public class InfoListActivity extends AppCompatActivity implements View.OnClickListener {
    EditText searchEt;
    ImageView searchIv,flushIv;
    ListView showLv;
    List<FoodBean> mDatas;
    List<FoodBean>allFoodList;
    private InfoListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_list);
//        查找控件
        initView();
        mDatas = new ArrayList<>();
        allFoodList = FoodUtils.getAllFoodList();
        mDatas.addAll(allFoodList);
        //创建适配器
        adapter = new InfoListAdapter(this,mDatas);
        showLv.setAdapter(adapter);
        //设置单项点击监听功能
        setListener();

    }

    private void setListener() {
        showLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            FoodBean foodBean =   mDatas.get(position);
            Intent intent = new Intent(InfoListActivity.this, FoodDescActivity.class);
            intent.putExtra("food",foodBean);
            startActivity(intent);

            }
        });
    }

    private void initView() {
        searchEt = findViewById(R.id.info_et_search);
        searchIv = findViewById(R.id.info_iv_search);
        flushIv = findViewById(R.id.info_iv_flush);
        showLv = findViewById(R.id.infolist_lv);
        searchIv.setOnClickListener(this);//添加点击事件
        flushIv.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.info_iv_flush:  //刷新点击
                searchEt.setText("");
                mDatas.clear();
                mDatas.addAll(allFoodList);
                adapter.notifyDataSetChanged();
                break;
            case R.id.info_iv_search: //搜索点击
                String msg = searchEt.getText().toString().trim();
                if (TextUtils.isEmpty(msg)){
                    Toast.makeText(this,"输入内容不能为空！",Toast.LENGTH_SHORT).show();
                    return;
                }
                List<FoodBean> list = new ArrayList<>();
                for (int i=0;i<allFoodList.size();i++){
                    String title = allFoodList.get(i).getTitle();
                    if (title.contains(msg)){
                        list.add(allFoodList.get(i));
                    }
                }
                mDatas.clear();
                mDatas.addAll(list);
                adapter.notifyDataSetChanged();
                break;
        }

    }
}