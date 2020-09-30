package com.alanson.swp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_main);

        //hooks
        viewPager = findViewById(R.id.vidPager);

        List<VideoItem> videoItemList = new ArrayList<>();
        videoItemList.add(new VideoItem(
                "https://www.infinityandroid.com/videos/video1.mp4",
                "Celebration",
                "Celebrate who you are in your deepest. Love your self and the world will love you."));
        videoItemList.add(new VideoItem(
                "https://www.infinityandroid.com/videos/video2.mp4",
                "Party",
                "You gotta have your way."));
        videoItemList.add(new VideoItem(
                "https://www.infinityandroid.com/videos/video3.mp4",
                "Exercise",
                "Whenever i need to exercise, i lie down until it goes away."));
        videoItemList.add(new VideoItem(
                "https://www.infinityandroid.com/videos/video4.mp4",
                "Nature",
                "In every walk in with Nature one receives far more than he seek."));
        videoItemList.add(new VideoItem(
                "https://www.infinityandroid.com/videos/video5.mp4",
                "Travel",
                "It is better to travel well than to arrive"));
        videoItemList.add(new VideoItem(
                "https://www.infinityandroid.com/videos/video6.mp4",
                "Chill",
                "Life is so much easier when you just chill out"));

        viewPager.setAdapter(new VideoAdapter(videoItemList));
    }
}