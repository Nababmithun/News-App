package com.example.news_api_create.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.news_api_create.Model.Response;
import com.example.news_api_create.R;
import com.example.news_api_create.Service.EndpointUrl;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {



    private TextView textViewResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://itechnotion.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EndpointUrl endpointUrl = retrofit.create(EndpointUrl.class);

        Call<List<Response>> call = endpointUrl.getPosts();



        call.enqueue(new Callback<List<Response>>() {
            @Override
            public void onResponse(Call<List<Response>> call, retrofit2.Response<List<Response>> response) {


                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Response> posts = response.body();

                for (Response post : posts) {
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "User ID: " + post.getDate() + "\n";
                    content += "date: " + post.getDateGmt() + "\n";
                    content += "guild: " + post.getGuid() + "\n\n";

                    content += "modified: " + post.getModified() + "\n\n";

                    content += "gmt: " + post.getModifiedGmt() + "\n\n";

                    content += "slug: " + post.getSlug() + "\n\n";
                    content += "status: " + post.getStatus() + "\n\n";
                    content += "sticky: " + post.getSticky() + "\n\n";
                    content += "type: " + post.getType() + "\n\n";

                    content += "link: " + post.getLink() + "\n\n";
                    content += "title: " + post.getTitle() + "\n\n";

                    content += "content: " + post.getContent() + "\n\n";


                    content += "expert: " + post.getExcerpt() + "\n\n";
                    content += "author: " + post.getAuthor() + "\n\n";
                    content += "midea: " + post.getFeaturedMedia() + "\n\n";
                    content += "cmmtstatus: " + post.getCommentStatus() + "\n\n";
                    content += "sticky: " + post.getSticky() + "\n\n";
                    content += "templete: " + post.getTemplate() + "\n\n";
                    content += "formate: " + post.getFormat() + "\n\n";
                    content += "meta: " + post.getMeta() + "\n\n";

                    content += "cate: " + post.getCategories() + "\n\n";

                    content += "tag: " + post.getTags() + "\n\n";
                    content += "imagelink: " + post.getFeaturedImageLink() + "\n\n";
                    content += "cate: " + post.getCategoryArr() + "\n\n";

                    content += "comment: " + post.getCommentCount() + "\n\n";
                    content += "post: " + post.getRelatedPost() + "\n\n";
                    content += "video: " + post.getVideoUrl() + "\n\n";


                    textViewResult.append(content);
                }


            }

            @Override
            public void onFailure(Call<List<Response>> call, Throwable t) {

                textViewResult.setText(t.getMessage());



            }
        });




    }
}