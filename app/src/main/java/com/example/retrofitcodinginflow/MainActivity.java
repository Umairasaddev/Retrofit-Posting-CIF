package com.example.retrofitcodinginflow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private JsonPlaceholderApi jsonPlaceholderApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);

        Retrofit retrofit = new Retrofit.Builder()
              //  .baseUrl("https://catfact.ninja/")
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //not call new jsonplaceholderapi  bcz it is interface without providing actual method implementation
         jsonPlaceholderApi = retrofit.create(JsonPlaceholderApi.class);

        // getPosts();
        getComments();
    }



    private void getPosts() {
        Call<Facts> call = jsonPlaceholderApi.getFacts();

        //     Call<List<Post>> call = jsonPlaceholderApi.getPost();

        call.enqueue(new Callback<Facts>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call<Facts> call, Response<Facts> response) {

                if (!response.isSuccessful()) {
                    tvResult.setText("Code" + response.code());//to get http code like 404 or something like this
                    return;
                }



                Facts facts = response.body();

                String content = "";
                content += "fact: " + facts.getFact() + "\n";
                content += "length: " + facts.getLength() + "\n\n";
//
                tvResult.append(content);
//                for (Facts fact: facts) {
//                    String content = "";
//                    content += "fact: " + fact.getFact() + "\n";
//                    content += "length: " + fact.getLength() + "\n\n";
//
//                    tvResult.append(content);
//                }
            }

            @Override
            public void onFailure(Call<Facts> call, Throwable t) {
                tvResult.setText(t.getMessage());

            }
        });

    }


    private void getComments() {
    Call<List<Comment>> call = jsonPlaceholderApi.getComments(3);
    call.enqueue(new Callback<List<Comment>>() {
        @Override
        public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {

            if(!response.isSuccessful())
            {
                tvResult.setText("Code"+response.code());
                return;
            }
            List<Comment> comments = response.body();
            for(Comment comment:comments){
                {
                    String content = "";
                    content += "ID: " +comment.getId() +"\n";
                    content += "Post ID" +comment.getPostId() +"\n";
                    content += "Name" +comment.getName() +"\n";
                    content += "Email" +comment.getEmail() +"\n";


                    tvResult.append(content);
                }
            }
        }

        @Override
        public void onFailure(Call<List<Comment>> call, Throwable t) {

            tvResult.setText(t.getMessage());
        }
    });

    }
}


        /*
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if(!response.isSuccessful()){
                    tvResult.setText("Code"+ response.code());//to get http code like 404 or something like this
                    return;

                }
                List<Post> posts = response.body();

                for (Post post:posts)
                {
                    String content = "";
                    content += "fact: "+ post.getFact()+ "\n";
                    content += "length: " +post.getLength() +"\n\n";




                for (Post post:posts){
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "User Id: " + post.getUserId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Text: " + post.getText() + "\n\n";



        //    @Override
       //     public void onFailure(Call<List<Post>> call, Throwable t) {


*/