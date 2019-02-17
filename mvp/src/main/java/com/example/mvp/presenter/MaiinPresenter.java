package com.example.mvp.presenter;

import android.view.View;

import com.example.mvp.model.JsonBean;
import com.example.mvp.model.OkHttp;
import com.example.mvp.view.interfaces.MainInterfaces;

/**
 * @Auther: 白俊岭
 * @Date: 2019/2/16 15:21:48
 * @Description:
 */
public class MaiinPresenter extends  BasePresenter implements  OkHttp.getView<JsonBean>{


    private final OkHttp instance;

    public  MaiinPresenter(){
        instance = OkHttp.getInstance();

       instance.HuiDiao(this);

     }
    public  void  login(String url){

          instance.doGet(url);
    }
     private  void reg(String name,String pass){

     }

    @Override
    public void chenggong(JsonBean o) {
         getView().Success(o);
    }

    @Override
    public void shibai() {

    }
}
