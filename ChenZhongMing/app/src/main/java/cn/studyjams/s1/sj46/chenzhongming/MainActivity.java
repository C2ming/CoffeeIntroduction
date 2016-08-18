package cn.studyjams.s1.sj46.chenzhongming;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MainActivity extends Activity implements ViewPager.OnPageChangeListener {

    private ConvenientBanner convenientBanner;//顶部广告栏控件
    private ArrayList<Integer> localImages = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4 全透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0 全透明实现
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);//calculateStatusColor(Color.WHITE, (int) alphaValue)
        }

        setContentView(R.layout.activity_main);
        convenientBanner = (ConvenientBanner) findViewById(R.id.convenientBanner);
        init();
        Log.v("MainActivity","onCreate execute");
    }

    private void init() {
        loadTestDatas();
//        本地图片例子
        convenientBanner.setPages(new CBViewHolderCreator<LocalImageHolderView>() {
            @Override
            public LocalImageHolderView createHolder() {
                return new LocalImageHolderView();
            }
        }, localImages)
//                设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
//                设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);

        convenientBanner.setManualPageable(false);//设置不能手动影响
    }

    private void loadTestDatas() {
        //        本地图片集合
        for (int position = 0; position < 5; position++)
            localImages.add(getResId("ic_test_" + position, R.drawable.class));
    }

    public static int getResId(String variableName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(variableName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    // 开始自动翻页
    @Override
    protected void onResume() {
        super.onResume();
        //开始自动翻页
        convenientBanner.startTurning(5000);
    }

    // 停止自动翻页
    @Override
    protected void onPause() {
        super.onPause();
        //停止翻页
        convenientBanner.stopTurning();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
//        Toast.makeText(this,"监听到翻到第"+position+"了",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    public void onClickEspresso(View v){
        Intent intent = new Intent(MainActivity.this,EspressoActivity.class);
        startActivity(intent);
    }

    public void onClickAmericano(View v){
        Intent intent = new Intent(MainActivity.this,AmericanoActivity.class);
        startActivity(intent);
    }

    public void onClickMacchiato(View v){
        Intent intent = new Intent(MainActivity.this,MacchiatoActivity.class);
        startActivity(intent);
    }

    public void onClickCappuccino(View v){
        Intent intent = new Intent(MainActivity.this,CappuccinoActivity.class);
        startActivity(intent);
    }

    public void onClickMocha(View v){
        Intent intent = new Intent(MainActivity.this,MochaActivity.class);
        startActivity(intent);
    }
}
