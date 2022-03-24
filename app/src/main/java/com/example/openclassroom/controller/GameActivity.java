package com.example.openclassroom.controller;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.openclassroom.R;
import com.example.openclassroom.model.QuestionBank;


public class GameActivity extends AppCompatActivity {
    private Button AnswerOne;
    private Button AnswerTwo;
    private Button AnswerTree;

    //QuestionBank mQuestionBank=generateQuestion();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        AnswerOne.findViewById(R.id.game_activity_button_1);
        AnswerTwo.findViewById(R.id.game_activity_button_2);
        AnswerTree.findViewById(R.id.game_activity_button_3);
    }

/*    private QuestionBank generateQuestion(){
        Question question1 = new Question(
                "Capital RDC?",
                Arrays.asList(
                        "Andy Rubin",
                        "Steve Wozniak",
                        "Jake Wharton",
                        "Paul Smith"
                ),
                0
        );
        Question question2 = new Question(
                "When did the first man land on the moon?",
                Arrays.asList(
                        "1958",
                        "1962",
                        "1967",
                        "1969"
                ),
                3
        );

        Question question3 = new Question(
                "What is the house number of The Simpsons?",
                Arrays.asList(
                        "42",
                        "101",
                        "666",
                        "742"
                ),
                3
        );

        return new QuestionBank(Arrays.asList(question1, question2, question3));
    }
*/
}