package cn.studyjams.s1.sj46.chenzhongming;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
