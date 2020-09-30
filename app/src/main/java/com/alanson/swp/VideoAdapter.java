package com.alanson.swp;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VidViewHolder> {
    private List<VideoItem> videoItems;

    public VideoAdapter(List<VideoItem> videoItems) {
        this.videoItems = videoItems;
    }

    @NonNull
    @Override
    public VidViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_container, parent, false);
        return new VidViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VidViewHolder holder, int position) {
        holder.setVideoData(videoItems.get(position));
    }

    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    public class VidViewHolder extends RecyclerView.ViewHolder {
        VideoView videoView;
        ProgressBar videoProgressBar;
        TextView videoTitle, videoDesc;

        public VidViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.videoView);
            videoProgressBar = itemView.findViewById(R.id.vidProgressBar);
            videoTitle = itemView.findViewById(R.id.vidTitle);
            videoDesc = itemView.findViewById(R.id.vidDescription);
        }

        void setVideoData(final VideoItem videoItem) {
            videoTitle.setText(videoItem.vidTitle);
            videoDesc.setText(videoItem.vidDesc);
            videoView.setVideoPath(videoItem.vidUrl);
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                    float videoRatio = mediaPlayer.getVideoWidth() / (float) mediaPlayer.getVideoHeight();
                    float screenRatio = videoView.getWidth() / (float) videoView.getHeight();
                    float scale = videoRatio / screenRatio;

                    if (scale > 1) {
                        videoView.setScaleX(scale);
                    } else {
                        videoView.setScaleY(scale);
                    }
                }
            });
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });
        }
    }
}
