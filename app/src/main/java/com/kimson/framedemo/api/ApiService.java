package com.kimson.framedemo.api;

import com.kimson.framedemo.model.Result;

import java.util.ArrayList;

import com.kimson.framedemo.model.Question;
import com.kimson.framedemo.model.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by zhujianheng on 6/1/16.
 */
public interface ApiService {

    /**
     * 问题列表
     * @param city
     * @return
     */
    @GET(URLs.QUESTIONS)
    Call<Result<ArrayList<Question>>> questions(@Query("city") String city);

    /**
     * 用户登录
     * @param mobile
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST(URLs.LOGIN)
    Call<Result<User>> login(@Field("mobile") String mobile,
                             @Field("password") String password);

}