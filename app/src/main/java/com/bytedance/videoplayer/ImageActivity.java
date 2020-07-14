package com.bytedance.videoplayer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class ImageActivity extends AppCompatActivity {
    private ImageView imageView;
    private String url;
    private String url2;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_image);
        imageView = findViewById(R.id.imageView);
        url = "https://s3.pstatp.com/toutiao/static/img/logo.271e845.png";//存在透明部分，用占位图会成为背景而产生重叠效果
        url2 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1562328963755&di=f4aa87b95c87dc01ff0ca2c9150845c8&imgtype=0&src=http%3A%2F%2Fwww.uimaker.com%2Fuploads%2Fallimg%2F121105%2F1_121105084854_2.jpg";
        Glide.with(this)
                .load(url2)
                .placeholder(R.drawable.icon_progress)
                .error(R.drawable.icon_failure)
                .fallback(R.drawable.ic_launcher_background)
                .transition(withCrossFade(3000))
                .transform(new GlideRoundTransform(10))
                .into(imageView);
    }
}
