package com.example.openclassroom.Controllers.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.openclassroom.Controllers.Fragment.DetailFragment;
import com.example.openclassroom.Controllers.Fragment.MainFragment;
import com.example.openclassroom.R;

public class MainActivity extends AppCompatActivity implements MainFragment.onButtonClickedListener {

    private  MainFragment mainFragment;
    private DetailFragment detailFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureAndShowMainFragment();

        configureAndShowDetailFragment();
    }

    @Override
    public void onButtonCliked(View view) {
        System.out.println("Clicked");
        //Log.e("tag","Cliked bton");
         startActivity(new Intent(this, DetailActivity.class));

    }

    private  void  configureAndShowMainFragment(){
        mainFragment=(MainFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_layout_main);
        if(mainFragment==null){
            mainFragment =new MainFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_layout_main,mainFragment)
                    .commit();
        }
    }

    private  void configureAndShowDetailFragment(){
        detailFragment =(DetailFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_layout_detail);

        if(detailFragment==null && findViewById(R.id.fragment_layout_detail)!=null){
            detailFragment = new DetailFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_layout_detail,detailFragment)
                    .commit();
        }
    }
}