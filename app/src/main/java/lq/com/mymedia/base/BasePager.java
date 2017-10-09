package lq.com.mymedia.base;

import android.content.Context;
import android.view.View;

/**
 * Created by lq on 2017/10/9.
 */

public abstract class BasePager {
    public final Context context;
    public View rootView;

    public BasePager(Context context) {
        this.context = context;
        rootView = initView();
    }

    /**
     * 强制实现View
     * @return
     */
    public abstract View initView();

    public void  initData(){}

}
