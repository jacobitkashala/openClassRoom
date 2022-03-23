package com.example.openclassroom;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class GameActivity extends AppCompatActivity {
    private Button AnswerOne;
    private Button AnswerTwo;
    private Button AnswerTree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        AnswerOne.findViewById(R.id.game_activity_button_1);
        AnswerTwo.findViewById(R.id.game_activity_button_2);
        AnswerTree.findViewById(R.id.game_activity_button_3);
    }
}