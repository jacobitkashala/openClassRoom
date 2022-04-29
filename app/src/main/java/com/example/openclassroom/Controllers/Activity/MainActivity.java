package com.example.openclassroom.Controllers.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;



import com.example.openclassroom.Adapters.PageAdapter;
import com.example.openclassroom.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.configureViewPager();
    }

    private void configureViewPager(){
        ViewPager viewPager=(ViewPager) findViewById(R.id.activity_main_view_pager);

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),getResources().getIntArray(R.array.colorPagesViewPager)));
    }
}