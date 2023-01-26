package com.project.frontend.ui.login;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.project.frontend.DTO.LoginDTO;
import com.project.frontend.DTO.MemberDTO;
import com.project.frontend.R;
import com.project.frontend.web.RetrofitClient;
import com.project.frontend.web.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

//    private RetrofitClient retrofitClient = RetrofitClient.getInstance();
    private RetrofitService retrofitService = RetrofitClient.getRetrofitService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d("TEST", "TEST");
        //Button list
        Button loginButton = findViewById(R.id.loginButton);
        EditText userId = findViewById(R.id.userId);
        EditText password = findViewById(R.id.password);

        loginButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = userId.getText().toString();
                String pw = password.getText().toString();
                Log.d("TEST", "Login Button Clicked");
                Log.d("TEST", "id : " + id + " pw : " + pw);
                if(id.equals("") || pw.equals("")) {
                    Toast.makeText(LoginActivity.this, "아이디와 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                LoginDTO loginDTO = new LoginDTO(id, pw);
                retrofitService.login(loginDTO).enqueue(new Callback<MemberDTO>() {
                    @Override
                    public void onResponse(Call<MemberDTO> call, Response<MemberDTO> response) {
                        if(response.isSuccessful()) {
                            MemberDTO memberDTO = response.body();
                            Log.d("TEST", memberDTO.toString());
                        }
                        else {

                        }
                    }
                    @Override
                    public void onFailure(Call<MemberDTO> call, Throwable t) {
                        Log.e("TEST", "Login Failed");
                    }
                });
            }
        });
    }
}