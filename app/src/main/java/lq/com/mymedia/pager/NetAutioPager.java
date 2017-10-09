package lq.com.mymedia.pager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import lq.com.mymedia.base.BasePager;
import lq.com.mymedia.utils.LogUtil;

/**
 * Created by lq on 2017/10/9.
 */

public class NetAutioPager extends BasePager {
    private TextView textView;
    public NetAutioPager(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        LogUtil.e("网络音频页面init ok");
        textView = new TextView(context);
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    public void initData() {
        LogUtil.e("网络音频数据init ok");

        textView.setText("网络音频界面");
    }
}
