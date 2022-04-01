package com.example.openclassroom.controller;
//Log.d(TAG, "onStart() called");

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.openclassroom.R;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_GAME_ACTIVITY=42;

    private Button mPlayButtom;
    private EditText mNameEditText;
    private TextView mGreetingTextView;

    private static final String SHARED_PREF_USER_INFO = "SHARED_PREF_USER_INFO";
    private static final String SHARED_PREF_USER_INFO_NAME = "SHARED_PREF_USER_INFO_NAME";
    private static final String SHARED_PREF_USER_INFO_SCORE = "SHARED_PREF_USER_INFO_SCORE";


    /*
        ActivityResultLauncher<Intent> activityLaucher=registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                       Log.d("TAG","onActivityResult");
                    }
                }

        );
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayButtom = findViewById(R.id.main_button_play);
        mNameEditText = findViewById(R.id.main_edittext_name);
        mGreetingTextView = findViewById(R.id.main_textview_greeting);

        mPlayButtom.setEnabled(false);

        String firstName=getSharedPreferences(SHARED_PREF_USER_INFO,MODE_PRIVATE)
                .getString(SHARED_PREF_USER_INFO_NAME,null);
       // Log.e("TAG","I shouldn't be here");
        //Log.e(TAG,"I shouldn't be here");
        mNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mPlayButtom.setEnabled(!s.toString().isEmpty());

            }
        });
        mPlayButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getSharedPreferences(SHARED_PREF_USER_INFO,MODE_PRIVATE)
                        .edit()
                        .putString(SHARED_PREF_USER_INFO_NAME, String.valueOf(mNameEditText.getText()));
                Intent gameActivityIntent=new Intent(MainActivity.this,GameActivity.class);
                // startActivity(gameActivityIntent);
                //Permet de recuperer le resultant d'une activité

                startActivityForResult(gameActivityIntent, REQUEST_CODE_GAME_ACTIVITY);

                //startActivityForResult(new Intent(MainActivity.this, GameActivity.class), REQUEST_CODE_GAME_ACTIVITY);

                //startActivityForResult(new Intent(MainActivity.this, GameActivity.class), REQUEST_CODE_GAME_ACTIVITY);
                // startActivity(gameActivityIntent);

              //  Log.d("TAG","click");
             //   startActivityForResult(new Intent(MainActivity.this, GameActivity.class), REQUEST_CODE_GAME_ACTIVITY);
                /*
                *
                * Intent gameActivityIntent=new Intent(MainActivity.this,GameActivity.class);
                * startActivity(gameActivityIntent);
                 * */
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQUEST_CODE_GAME_ACTIVITY == requestCode && RESULT_OK == resultCode) {
            // Récupérer le score de l'intention
            int score = data.getIntExtra(GameActivity.BUNDLE_EXTRA_SCORE, 0);
        }

    }
}