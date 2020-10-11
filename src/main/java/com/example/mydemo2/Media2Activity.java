package com.example.mydemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.concurrent.TimeUnit;

public class Media2Activity extends AppCompatActivity {

    private ImageButton playBtn,rewindBtn,forwardBtn,pauseBtn;
    private TextView tv1, tv2;
    private ImageView thumbnailIcon;
    private ImageView iv;
    private MediaPlayer mediaPlayer;

    private double startTime = 0;
    private double finalTime = 0;

    private Handler myHandler = new Handler();;
    private int forwardTime = 5000;
    private int backwardTime = 5000;
    private SeekBar seekbar;
    public static int oneTimeOnly = 0;

    //Commit 5
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        playBtn = (ImageButton) findViewById(R.id.playButton);
        rewindBtn = (ImageButton) findViewById(R.id.rewindBtn);
        forwardBtn = (ImageButton)findViewById(R.id.forwadBtn);
        pauseBtn = (ImageButton)findViewById(R.id.pauseBtn);
        pauseBtn.setBackgroundResource(R.mipmap.pause_disabled);

        //Edit text
        tv1 = (TextView) findViewById(R.id.editTextAlbumName);
        tv1.setText("Photograph");

        tv2 = (TextView) findViewById(R.id.editTextSingerName);
        tv2.setText("Rob gulzar");

        //Image View
        thumbnailIcon = (ImageView) findViewById(R.id.imageThumbnail);
        thumbnailIcon.setImageResource(R.drawable.photograph2);

        mediaPlayer = MediaPlayer.create(this, R.raw.song1);
        seekbar = (SeekBar)findViewById(R.id.seekBar2);
        seekbar.setClickable(false);
        pauseBtn.setEnabled(false);
        //setContentView(R.layout.activity_media);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();

                finalTime = mediaPlayer.getDuration();
                startTime = mediaPlayer.getCurrentPosition();

                if (oneTimeOnly == 0) {
                    seekbar.setMax((int) finalTime);
                    oneTimeOnly = 1;
                }
                seekbar.setProgress((int)startTime);
                myHandler.postDelayed(UpdateSongTime,100);
                pauseBtn.setEnabled(true);
                playBtn.setEnabled(false);
                playBtn.setBackgroundResource(R.mipmap.play_disabled);
                pauseBtn.setBackgroundResource(R.mipmap.pause);
            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        mediaPlayer.pause();
                pauseBtn.setEnabled(false);
                playBtn.setEnabled(true);
                playBtn.setBackgroundResource(R.mipmap.play);
                pauseBtn.setBackgroundResource(R.mipmap.pause_disabled);
            }
        });
        rewindBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int)startTime;

                if((temp-backwardTime)>0) {
                    startTime = startTime - backwardTime;
                    mediaPlayer.seekTo((int) startTime);
                }
            }
        });
        forwardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int)startTime;

                if((temp+forwardTime)<=finalTime) {
                    startTime = startTime + forwardTime;
                    mediaPlayer.seekTo((int) startTime);
                }
            }
        });
    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();
//            tx1.setText(String.format("%d min, %d sec",
//                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
//                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
//                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
//                                    toMinutes((long) startTime)))
            //);
            seekbar.setProgress((int)startTime);
            myHandler.postDelayed(this, 100);
        }
    };
}
