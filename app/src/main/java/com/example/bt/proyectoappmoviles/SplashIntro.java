package com.example.bt.proyectoappmoviles;

/**
 * Created by bt on 09/02/2018.
 */
        import android.content.Intent;
        import android.content.pm.ActivityInfo;
        import android.net.Uri;
        import android.os.Bundle;
        import android.view.WindowManager;
        import android.widget.VideoView;
        import android.app.Activity;
        import android.media.MediaPlayer;


/**
 * Created by Nelson on 9/2/2018.
 */

public class SplashIntro extends Activity{
    @Override
    protected void onCreate (Bundle sa) {
        super.onCreate(sa);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        try{
            VideoView videoView = new VideoView(this);
            setContentView(videoView);
            Uri path = Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.intro);
            videoView.setVideoURI(path);

            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){

                public void onCompletion (MediaPlayer mediaPlayer){
                    jump();
                }
            });

            videoView.start();

        }catch (Exception e){
            jump();
        }
    }
    private void jump() {
        if(isFinishing())
            return;
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}

