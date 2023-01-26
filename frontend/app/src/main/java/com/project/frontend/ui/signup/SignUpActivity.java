package com.project.frontend.ui.signup;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.project.frontend.DTO.ResultDTO;
import com.project.frontend.DTO.UserDTO;
import com.project.frontend.R;
import com.project.frontend.ui.login.LoginActivity;
import com.project.frontend.web.RetrofitClient;
import com.project.frontend.web.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    RetrofitService retrofitService = RetrofitClient.getRetrofitService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Component
        EditText userId = findViewById(R.id.userId);
        EditText password = findViewById(R.id.password);
        EditText nickname = findViewById(R.id.nickname);
        EditText introduction = findViewById(R.id.introduction);
        Button signUpButton = findViewById(R.id.signupButton);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = userId.getText().toString();
                String pw = password.getText().toString();
                String nick = nickname.getText().toString();
                String intro = introduction.getText().toString();

                if(id.equals("") || pw.equals("") || nick.equals("")) {
                    Toast.makeText(SignUpActivity.this, "아이디, 패스워드, 닉네임을 작성하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                UserDTO userDTO = new UserDTO(id, pw, nick, intro);

                retrofitService.signUp(userDTO).enqueue(new Callback<ResultDTO>() {
                    @Override
                    public void onResponse(Call<ResultDTO> call, Response<ResultDTO> response) {

                        if(response.isSuccessful()) {
                            Log.d("TEST", response.body().getMessage());
                            finish();
                        }
                        else if(response.code() == 401){
                            Log.d("TEST", response.errorBody().toString());
                            Toast.makeText(SignUpActivity.this, "중복된 아이디가 존재합니다. 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Log.d("TEST", response.errorBody().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResultDTO> call, Throwable t) {
                        Log.d("TEST", t.getMessage());
                        Log.d("TEST", "Sign Up Failed");
                    }
                });
            }
        });
    }
}