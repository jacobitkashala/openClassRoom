package com.example.openclassroom.controller;
//Log.d(TAG, "onStart() called");

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.openclassroom.R;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_GAME_ACTIVITY=42;

    private Button mPlayButtom;
    private EditText mNameEditText;
    private TextView mGreetingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // Log.d(TAG, "onStart() called");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayButtom = findViewById(R.id.main_button_play);
        mNameEditText = findViewById(R.id.main_edittext_name);
        mGreetingTextView = findViewById(R.id.main_textview_greeting);

        mPlayButtom.setEnabled(false);

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

                startActivityForResult(new Intent(MainActivity.this, GameActivity.class), REQUEST_CODE_GAME_ACTIVITY);
                /*
                *
                 Intent gameActivityIntent=new Intent(MainActivity.this,GameActivity.class);
                 startActivity(gameActivityIntent);
                 *
                 * */
            }
        });
        /*
        PlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user just clicked
            }
        });


        mPlayButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  startActivityForResult(new Intent(MainActivity.this, GameActivity.class), REQUEST_CODE_GAME_ACTIVITY);
                startActivityForResult(new Intent(MainActivity.this,GameActivity.class),REQUEST_CODE_GAMA_ACTIVITY);

                // Intent gameActivityIntent = new Intent(MainActivity.this, GameActivity.class);

                // startActivity(gameActivityIntent);

            }
        });*/
    }

}