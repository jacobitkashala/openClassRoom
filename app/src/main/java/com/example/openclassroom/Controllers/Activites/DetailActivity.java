package com.example.openclassroom.Controllers.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.openclassroom.Controllers.Fragment.DetailFragment;
import com.example.openclassroom.Controllers.Fragment.MainFragment;
import com.example.openclassroom.R;

public class DetailActivity extends AppCompatActivity {

    private DetailFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        this.configureAndShowDetailFragment();
    }

    private  void  configureAndShowDetailFragment(){
        detailFragment=(DetailFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_layout_detail);

        if(detailFragment==null){
            detailFragment =new DetailFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_layout_main,detailFragment)
                    .commit();
        }
    }
}