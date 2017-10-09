package lq.com.mymedia.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;

import lq.com.mymedia.R;

public class SplashActivity extends Activity {

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startMainActivity();
            }
        },2000);

    }

    private Boolean isStart = true;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(isStart){
            startMainActivity();
            isStart = false;
        }
        return super.onTouchEvent(event);
    }

    /**
     * 启动main
     */
    private void startMainActivity() {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}
