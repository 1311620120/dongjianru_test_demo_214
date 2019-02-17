package com.example.mvp.model;

import android.annotation.SuppressLint;
import android.os.Message;
import android.util.Log;
import android.widget.VideoView;

import com.example.mvp.presenter.MaiinPresenter;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Auther: 白俊岭
 * @Date: 2019/2/16 16:08:23
 * @Description:
 */
public class OkHttp <T>{
    public  static OkHttp instance;
    JsonBean bean;
    public  OkHttp(){

    }
    public   static  OkHttp getInstance(){
        if (instance ==null){
            return  new OkHttp();
        }else {
            return  instance;
        }
    }


    android.os.Handler handler = new android.os.Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            T obj =(T) msg.obj;
            gv.chenggong(obj);
        }
    };

     public  void  doGet(String path){
         OkHttpClient okHttpClient = new OkHttpClient();
         Request request = new Request.Builder().url(path).get().build();
         Call call = okHttpClient.newCall(request);
         call.enqueue(new Callback() {
             @Override
             public void onFailure(Call call, IOException e) {

             }

             @Override
             public void onResponse(Call call, Response response) throws IOException {
                 String string = response.body().string();
                 Log.e("+++++++",string+"");
                 Gson gson = new Gson();
                 T t = (T) gson.fromJson(string, JsonBean.class);
                 Message message = handler.obtainMessage();
                 message.obj=t;
                 handler.sendMessage(message);

             }
         });
     }
       public  void  doPost(String url,String name,String page, String count){
           final OkHttpClient httpClient = new OkHttpClient.Builder()
                   .readTimeout(3, TimeUnit.SECONDS)
                   .connectTimeout(3, TimeUnit.SECONDS)
                   .build();
           FormBody body = new FormBody.Builder()
                   .add("keyword", name)
                   .add("count", page)
                   .add("count", count)
                   .build();
           Request request = new Request.Builder()
                   .url(url)
                   .post(body)
                   .build();
           Call call = httpClient.newCall(request);
           call.enqueue(new Callback() {
               @Override
               public void onFailure(Call call, IOException e) {

               }

               @Override
               public void onResponse(Call call, Response response) throws IOException {
                   String string = response.body().string();
                   Log.e("++++++",string+"");
                   Gson gson = new Gson();
                   T t = (T) gson.fromJson(string, JsonBean.class);
                   Message message = handler.obtainMessage();
                   message.obj=t;
                   handler.sendMessage(message);
               }
           });
       }
 public  interface  getView<D>{
         public  void  chenggong(D d);
         public  void  shibai();
 }
 getView gv;
     public  void  HuiDiao(getView gv){
         this.gv=gv;
     }

}
