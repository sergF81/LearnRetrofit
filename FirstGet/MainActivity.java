package com.example.proba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
private TextView textViewReult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewReult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
                .build();


     InterfaceGitHub client = retrofit.create(InterfaceGitHub.class);
    Call<List<UserGitHub>> call = client.userProp();

    call.enqueue(new Callback<List<UserGitHub>>() {
        @Override
        public void onResponse(Call<List<UserGitHub>> call, Response<List<UserGitHub>> response) {

           if (!response.isSuccessful()){
               textViewReult.setText("code: " + response.code());
               return;
           }
           List<UserGitHub> ugit = response.body();

           for( UserGitHub gitHub : ugit ){
               String content = "";
               content += "Repos : " + gitHub.getName() + "\n";
               content += "id : "+ gitHub.getIdRepos() + "\n";
               content += "html_url : " + gitHub.getHtml_url() + "\n\n";
               textViewReult.append(content);
            }
        }

        @Override
        public void onFailure(Call<List<UserGitHub>> call, Throwable t) {
            textViewReult.setText(t.getMessage());

        }
    });

}

}