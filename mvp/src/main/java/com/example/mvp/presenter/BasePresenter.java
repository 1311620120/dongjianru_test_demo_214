package com.example.mvp.presenter;

import com.example.mvp.view.activity.MainActivity;

/**
 * @Auther: 白俊岭
 * @Date: 2019/2/16 15:21:20
 * @Description:
 */
public class BasePresenter {
      MainActivity activity;
    public  void  setView(MainActivity activity){
          this.activity=activity;
    }
    public  MainActivity getView(){
          return  activity;
    }
       public  void  dettachView(){
          activity=null;
       }
}
