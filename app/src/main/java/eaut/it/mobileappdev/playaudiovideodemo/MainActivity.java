package eaut.it.mobileappdev.playaudiovideodemo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id==R.id.playVideoBtn){
            Intent intent = new Intent(this, VideoActivity.class);
            startActivity(intent);
        }else if(id==R.id.streamingBtn){
            Intent intent = new Intent(this, StreamingActivity.class);
            startActivity(intent);
        }else{
            mp = MediaPlayer.create(this, R.raw.demo_sound);
            mp.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mp!=null) mp.stop();
    }
}