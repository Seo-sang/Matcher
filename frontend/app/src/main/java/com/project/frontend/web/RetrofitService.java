package com.project.frontend.web;

import com.project.frontend.DTO.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitService {
    /**회원 가입*/
    @POST("/member/signup")
    Call<ResultDTO> signUp(@Body UserDTO userDTO);

    /**로그인*/
    @POST("/login")
    Call<MemberDTO> login(@Body LoginDTO loginDTO);

    /**Friend 목록*/
    @GET("/member/{userId}/friends")
    Call<FriendDTO> getFriends(@Path(value = "userId", encoded = true) String userId);

}
