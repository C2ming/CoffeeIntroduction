package cn.studyjams.s1.sj46.chenzhongming;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by Administrator on 2016-04-25.
 */
public class EspressoActivity extends BaseSwipeBackActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.espresso_layout);
    }
}
