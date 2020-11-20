package com.deitel.littlethinkers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.view.View;
import android.widget.Button;

public class zero_to_6numbers extends AppCompatActivity {
    private SoundPool soundPool;
    private int s0,s1, s2,s3,s4,s5,s6;
    private Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnNext, btnBack;
    //private TextView txtZero, txtOne, txtTwo, txtThree, txtFour, txtFive, txtSix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zero_to_6numbers);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(7)
                    .setAudioAttributes(audioAttributes)
                    .build();

        } else {
            soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
        }

        s0 = soundPool.load(this, R.raw.zero,1);
        s1 = soundPool.load(this, R.raw.one,1);
        s2 = soundPool.load(this, R.raw.two,1);
        s3 = soundPool.load(this, R.raw.three,1);
        s4 = soundPool.load(this, R.raw.four,1);
        s5 = soundPool.load(this, R.raw.five,1);
        s6 = soundPool.load(this, R.raw.six,1);



        btnZero = (Button) findViewById(R.id.btnZero);
        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo =(Button) findViewById(R.id.btnTwo);
        btnThree = (Button) findViewById(R.id.btnThree);
        btnFour = (Button) findViewById(R.id.btnFour);
        btnNext = (Button) findViewById(R.id.btnNext);
        //btnBack = (Button) findViewById(R.id.btnBack);

        btnFive = (Button) findViewById(R.id.btnFive);
        btnSix = (Button) findViewById(R.id.btnSix);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.zero);
        final MediaPlayer mediaPlayer1 = MediaPlayer.create(this,R.raw.one);
        final MediaPlayer mediaPlayer2 = MediaPlayer.create(this,R.raw.two);
        final MediaPlayer mediaPlayer3 = MediaPlayer.create(this,R.raw.three);
        final MediaPlayer mediaPlayer4 = MediaPlayer.create(this,R.raw.four);
        final MediaPlayer mediaPlayer5 = MediaPlayer.create(this,R.raw.five);
        final MediaPlayer mediaPlayer6 = MediaPlayer.create(this,R.raw.six);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(zero_to_6numbers.this,seven_to_10numbers.class));
            }
        });


        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                //txtOne.setVisibility(View.VISIBLE);
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer2.start();

            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer3.start();

            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer4.start();

            }
        });

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer1.start();

            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer5.start();

            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer6.start();

            }
        });

    }
    public void playSound(View v){
        switch (v.getId()){
            case R.id.btnZero:
                soundPool.play(s0,1,1, 0, 0, 1);
                break;
            case R.id.btnOne:
                soundPool.play(s1,1,1, 0, 0, 1);
                break;
            case R.id.btnTwo:
                soundPool.play(s2,1,1, 0, 0, 1);
                break;
            case R.id.btnThree:
                soundPool.play(s3,1,1, 0, 0, 1);
                break;
            case R.id.btnFour:
                soundPool.play(s4,1,1, 0, 0, 1);
                break;
            case R.id.btnFive:
                soundPool.play(s5,1,1, 0, 0, 1);
                break;
            case R.id.btnSix:
                soundPool.play(s6,1,1, 0, 0, 1);
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool= null;
    }
}