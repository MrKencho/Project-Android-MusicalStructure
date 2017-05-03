package com.example.android.musicalstructure;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this,R.raw.battlesymphony);
        Button stop = (Button) findViewById(R.id.stop);
        Button play = (Button) findViewById(R.id.play);
        ImageView image = (ImageView) findViewById(R.id.albumArt);
        Button playList = (Button) findViewById(R.id.myPlaylist);
        stop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mp.stop();
            }
        });
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent temp = new Intent(getApplicationContext(),artistinfo.class);
                startActivity(temp);
            }
        });
        play.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(mp.isPlaying())
                    mp.pause();
                else
                    mp.start();
            }
        });
        playList.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent temp = new Intent(getApplicationContext(),plist.class);
                startActivity(temp);
            }
        });
    }
}
