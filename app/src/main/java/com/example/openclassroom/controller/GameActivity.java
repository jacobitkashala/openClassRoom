package com.example.openclassroom.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.openclassroom.R;
import com.example.openclassroom.model.Question;
import com.example.openclassroom.model.QuestionBank;

import java.util.Arrays;


public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextViewQuestion;

    private Button AnswerOneButton;
    private Button AnswerTwoButton;
    private Button AnswerTreeButton;
    private Button AnswerFourButton;

     QuestionBank mQuestionBank;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mTextViewQuestion = findViewById(R.id.game_activity_button_1);
        AnswerOneButton= findViewById(R.id.game_activity_button_1);
        AnswerTwoButton=findViewById(R.id.game_activity_button_2);
        AnswerTreeButton=findViewById(R.id.game_activity_button_3);
        AnswerFourButton=findViewById(R.id.game_activity_button_4);

        // Utilise le même écouteur pour les quatre boutons.
        // La valeur de l'identifiant de la vue sera utilisée pour distinguer le bouton déclenché

        AnswerTreeButton.setOnClickListener(this);
        AnswerTwoButton.setOnClickListener(this);
        AnswerFourButton.setOnClickListener(this);
        AnswerOneButton.setOnClickListener(this);

        displayQuestion(mQuestionBank.getCurrentQuestion());
    }

    private void displayQuestion(final Question question){

        mTextViewQuestion.setText(question.getQuestion());

        AnswerOneButton.setText(question.getChoiceList().get(0));
        AnswerFourButton.setText(question.getChoiceList().get(1));
        AnswerTreeButton.setText(question.getChoiceList().get(2));
        AnswerFourButton.setText(question.getChoiceList().get(3));

    }

    @Override
    public void onClick(View v) {
        int index;
        if(v==AnswerOneButton){
            index=0;
        }else if(v==AnswerTwoButton){
            index=1;
        }else if(v==AnswerTreeButton){
            index=2;
        }else if(v==AnswerFourButton){
            index=3;
        }else{
            throw new IllegalStateException("Vue cliquée inconnue : " + v);
        }

    }


    private QuestionBank generateQuestionBank() {
        Question question1 = new Question(
                "Qui est le créateur d'Android?",
                Arrays.asList(
                        "Andy Rubin",
                        "Steve Wozniak",
                        "Jake Wharton",
                        "Paul Smith"
                ),
                0
        );

        Question question2 = new Question(
                "Quand le premier homme a-t-il atterri sur la lune?",
                Arrays.asList(
                        "1958",
                        "1962",
                        "1967",
                        "1969"
                ),
                3
        );

        Question question3 = new Question(
                        "Quel est le numéro de maison des Simpson ??",
                Arrays.asList(
                        "42",
                        "101",
                        "666",
                        "742"
                ),
                3
        );

        Question question4 = new Question(
                        "Qui a peint la Joconde ?",
                Arrays.asList(
                        "Michelangelo",
                        "Leonardo Da Vinci",
                        "Raphael",
                        "Carravagio"
                ),
                1
        );

        Question question5 = new Question(
                        "Quel est le domaine national de premier niveau de la Belgique?",
                Arrays.asList(
                        ".bg",
                        ".bm",
                        ".bl",
                        ".be"
                ),
                3
        );

        return new QuestionBank(Arrays.asList(question1, question2, question3, question4, question5));
    }
}