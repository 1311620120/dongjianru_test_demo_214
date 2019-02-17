package com.example.mvp.view.interfaces;

import com.example.mvp.model.JsonBean;

/**
 * @Auther: 白俊岭
 * @Date: 2019/2/16 14:51:58
 * @Description:
 */
public interface MainInterfaces extends  BaseIntergaces {
   void  Success(JsonBean bean);
   void  Fail(String s);

}
