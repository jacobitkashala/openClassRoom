package com.example.openclassroom.Controllers.Activites;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.openclassroom.Controllers.Fragment.DetailFragment;
import com.example.openclassroom.Controllers.Fragment.MainFragment;
import com.example.openclassroom.R;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_BUTTON_TAG = "com.example.openclassroom.Controllers.Activites.DetailActivity.EXTRA_BUTTON_TAG";
    private DetailFragment detailFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        this.configureAndShowDetailFragment();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.updateDetailFragmentTextViewWthIntentTag();
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
    //metre à jour datailfragmament
    private  void   updateDetailFragmentTextViewWthIntentTag(){
        int buttonTag=getIntent().getByteExtra(EXTRA_BUTTON_TAG, (byte) 0);
        detailFragment.updateTextView(buttonTag);
    }
}