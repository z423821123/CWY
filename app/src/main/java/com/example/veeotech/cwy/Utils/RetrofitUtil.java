package com.example.veeotech.cwy.Utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CWY on 2018/5/15.
 */


public class RetrofitUtil {
        private static final String BASE_URL = "http://192.168.1.105/zwx/public/";

        private static RetrofitUtil mRetrofitManager;

        private Retrofit mRetrofit;

        private RetrofitUtil(){
            initRetrofit();
        }

        public static synchronized RetrofitUtil getInstance(){
            if(mRetrofitManager == null){
                mRetrofitManager = new RetrofitUtil();
            }
            return mRetrofitManager;
        }

        private void initRetrofit(){
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            //设定日志级别
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder builder = new OkHttpClient.Builder();

            builder.connectTimeout(15, TimeUnit.SECONDS);
            builder.readTimeout(20,TimeUnit.SECONDS);
            builder.writeTimeout(20,TimeUnit.SECONDS);
            builder.retryOnConnectionFailure(true);
            builder.addInterceptor(httpLoggingInterceptor);
            OkHttpClient client = builder.build();

            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build();
        }

        public <T> T createReq(Class<T> reqServer){
            return mRetrofit.create(reqServer);
        }
}
