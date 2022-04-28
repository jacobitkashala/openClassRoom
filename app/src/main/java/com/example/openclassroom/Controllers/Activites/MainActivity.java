package com.example.openclassroom.Controllers.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.openclassroom.Controllers.Fragment.MainFragment;
import com.example.openclassroom.R;

public class MainActivity extends AppCompatActivity implements MainFragment.onButtonClickedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onButtonCliked(View view) {
        System.out.println("Clicked");
        //Log.e("tag","Cliked bton");
    }
}