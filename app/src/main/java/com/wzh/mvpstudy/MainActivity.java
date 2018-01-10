package com.wzh.mvpstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wzh.mvpstudy.ui.NewsFragment;

/**
 * @author  wang
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NewsFragment fragment = new NewsFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.framelayout, fragment).commit();

    }
}
