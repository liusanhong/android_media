package lq.com.mymedia.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import lq.com.mymedia.R;

public class MainActivity extends Activity {
    private FrameLayout fl_main_content;
    private RadioGroup rg_button_tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fl_main_content = (FrameLayout) findViewById(R.id.fl_main_content);
        rg_button_tag = (RadioGroup) findViewById(R.id.rg_button_tag);
        rg_button_tag.check(R.id.rb_video);//默认选择首页
    }
}
