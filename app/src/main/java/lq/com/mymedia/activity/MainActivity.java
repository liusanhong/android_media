package lq.com.mymedia.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import java.util.ArrayList;

import lq.com.mymedia.R;
import lq.com.mymedia.base.BasePager;
import lq.com.mymedia.pager.AutioPager;
import lq.com.mymedia.pager.NetAutioPager;
import lq.com.mymedia.pager.NetVideoPager;
import lq.com.mymedia.pager.VideoPager;

public class MainActivity extends FragmentActivity {
    private RadioGroup rg_button_tag;
    private ArrayList<BasePager> basePagers;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg_button_tag = (RadioGroup)findViewById(R.id.rg_button_tag);

        basePagers = new ArrayList<>();
        basePagers.add(new VideoPager(this));//0
        basePagers.add(new AutioPager(this));//1
        basePagers.add(new NetVideoPager(this));//2
        basePagers.add(new NetAutioPager(this));//3

        rg_button_tag.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        rg_button_tag.check(R.id.rb_video);//默认选择首页

    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
            switch (i){
                default:
                    position = 0;
                    break;
                case R.id.rb_audio:
                    position = 1;
                    break;
                case R.id.rb_video_net:
                    position = 2;
                    break;
                case R.id.rb_audio_net:
                    position = 3;
                    break;
            }

            setFragment();

        }
    }

    /**
     * 把页面添加到fragment中
     */
    private void setFragment() {
       FragmentManager manager =  getSupportFragmentManager();
       FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.fl_main_content,new Fragment(){
            @Nullable
            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                BasePager basePager = getBasePager();
                if(basePager != null){
                    return basePager.rootView;
                }

                return null;
            }
        });
        ft.commit();
    }

    private BasePager getBasePager() {
        BasePager basePager = basePagers.get(position);
        if(basePager!= null){
            basePager.initData(); //只有initView才调用initData；
        }
        return basePager;
    }
}
