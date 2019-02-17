package com.example.mvp.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.mvp.R;
import com.example.mvp.model.JsonBean;
import com.example.mvp.presenter.MaiinPresenter;
import com.example.mvp.view.adapter.MyAdapter;
import com.example.mvp.view.interfaces.MainInterfaces;

public class MainActivity extends AppCompatActivity implements  MainInterfaces{


    private RecyclerView recycler;
    private MaiinPresenter presenter;
    private MyAdapter myAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();

    }



    private void initView() {
        recycler = findViewById(R.id.recycler);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(OrientationHelper.VERTICAL);
        recycler.setLayoutManager(manager);

    }
    private void initData() {
        presenter = new MaiinPresenter();
        presenter.setView(this);
        presenter.login("http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=%E5%8D%AB%E8%A1%A3&page=1&count=30");
        myAdapter = new MyAdapter(MainActivity.this);
        recycler.setAdapter(myAdapter);
    }


    @Override
    public void Success(JsonBean bean) {
        myAdapter.setData(bean.getResult());
    }

    @Override
    public void Fail(String s) {

    }
    protected  void  onDestroy(){
        super.onDestroy();
        presenter.dettachView();
    }
}
