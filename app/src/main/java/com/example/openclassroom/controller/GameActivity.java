package com.example.openclassroom.controller;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

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

    private int mRemainingQuestionCount;
    private int mScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mTextViewQuestion = findViewById(R.id.game_activity_textview_question);

        AnswerOneButton= findViewById(R.id.game_activity_button_1);
        AnswerTwoButton=findViewById(R.id.game_activity_button_2);
        AnswerTreeButton=findViewById(R.id.game_activity_button_3);
        AnswerFourButton=findViewById(R.id.game_activity_button_4);

        mRemainingQuestionCount=4;
        mScore=0;
        // Utilise le même écouteur pour les quatre boutons.
        // La valeur de l'identifiant de la vue sera utilisée pour distinguer le bouton déclenché

        AnswerTreeButton.setOnClickListener(this);
        AnswerTwoButton.setOnClickListener(this);
        AnswerFourButton.setOnClickListener(this);
        AnswerOneButton.setOnClickListener(this);

        mQuestionBank = generateQuestionBank();

        //System.out.println(mQuestionBank.getCurrentQuestion());

        displayQuestion(mQuestionBank.getCurrentQuestion());
    }

    private void displayQuestion(final Question question){
      /*
*
        mTextViewQuestion.setText("Question une");
*/
        mTextViewQuestion.setText(question.getQuestion());

        AnswerOneButton.setText(question.getChoiceList().get(0));
        AnswerTwoButton.setText(question.getChoiceList().get(1));
        AnswerTreeButton.setText(question.getChoiceList().get(2));
        AnswerFourButton.setText(question.getChoiceList().get(3));

    }

    @Override
    public void onClick(View v ) {
        int index;

        mRemainingQuestionCount--;

        if(v==AnswerOneButton){
            //System.out.println("0");
            index=0;
           // mTextViewQuestion.setBackground(ContextCompat.getDrawable(context,R.color.red));
        }else if(v==AnswerTwoButton){
            index=1;
            System.out.println("1");
        }else if(v==AnswerTreeButton){
            index=2;
            System.out.println("2");
        }else if(v==AnswerFourButton){
            index=3;
            System.out.println("3");
        }else{
            throw new IllegalStateException("Vue cliquée inconnue : " + v);
        }

        if (index == mQuestionBank.getCurrentQuestion().getAnswerIndex()) {
            mTextViewQuestion.setText("Correct");
            mScore=mScore+4;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
           // mScore++;
        } else {
            mTextViewQuestion.setText("Incorrect");
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }

        if(mRemainingQuestionCount==0){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Merci d'avoir participer a notre jeux!")
                    .setMessage("Votre Score est de :" + mScore)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .create()
                    .show();
        }else {
            displayQuestion(mQuestionBank.getNextQuestion());
        }
        ;
    }


    private QuestionBank generateQuestionBank() {
        Question question1 = new Question(
                "Quelle pièce est absolument à protéger dans un jeu d’échec?",
                Arrays.asList(
                        "Le roi",
                        "La dame",
                        "Le tour",
                        "Le pion"
                ),
                0
        );

        Question question2 = new Question(
                "Quel est la capitale de l’Australie ?",
                Arrays.asList(
                        "Bamako",
                        "Bagdad",
                        "Bakou",
                        "Canberra"
                ),
                3
        );

        Question question3 = new Question(
                        "Quelle année a suivi l’an 1 avant JC ?",
                Arrays.asList(
                        "L’an 2 après JC",
                        "L’an 2 avant JC",
                        "L’an 1 avant JC",
                        "L’an 1 après JC"
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
                        "De combien de syllabes est composé un alexandrin ?",
                Arrays.asList(
                        "11",
                        "10",
                        "2",
                        "12"
                ),
                3
        );

        return new QuestionBank(Arrays.asList(question1, question2, question3, question4, question5));
    }
}