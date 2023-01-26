package com.project.frontend.web;

import com.project.frontend.DTO.LoginDTO;
import com.project.frontend.DTO.MemberDTO;
import com.project.frontend.DTO.ResultDTO;
import com.project.frontend.DTO.UserDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitService {
    /**회원 가입*/
    @POST("/member/signup")
    Call<ResultDTO> signUp(@Body UserDTO userDTO);

    /**로그인*/
    @POST("/login")
    Call<MemberDTO> login(@Body LoginDTO loginDTO);

}
