package com.mjn.libs.api;

import com.mjn.libs.comm.bean.IUser;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("user/iuser/login")
    Observable<ResponseResult<IUser>> login(@FieldMap Map<String, String> map);
}
