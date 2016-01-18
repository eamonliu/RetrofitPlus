package net.masonliu.retrofit2plus.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import net.masonliu.retrofit2plus.demo.model.GitResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Call<GitResult> call = RestApi.getApiService().getUsersByName("Mason");
        call.enqueue(new Callback<GitResult>() {

            @Override
            public void onResponse(Call<GitResult> call, Response<GitResult> response) {
                GitResult gitResult = response.body();
                Log.e("retrofit_plus", "success:" + response.raw().request().url().toString() + "\n"
                        + gitResult.getTotalCount());
            }

            @Override
            public void onFailure(Call<GitResult> call, Throwable t) {
                Log.e("retrofit_plus", "failure");
            }

            @Override
            public void onStart() {
                Log.e("retrofit_plus", "start");
            }

            @Override
            public void onFinish() {
                Log.e("retrofit_plus", "finish");
            }

        });
    }
}
