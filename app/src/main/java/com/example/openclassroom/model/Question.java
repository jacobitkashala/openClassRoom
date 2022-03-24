package com.example.openclassroom.model;

import androidx.annotation.NonNull;

import java.util.List;

public class Question {
    @NonNull
    private final String mQuestion;
    @NonNull
    private final  List<String> mChoiceList;
    private  final int mAnswerIndex;

    public Question(@NonNull String mQuestion,@NonNull List<String> mChoiceList, int mAnswerIndex) {
        this.mQuestion = mQuestion;
        this.mChoiceList = mChoiceList;
        this.mAnswerIndex = mAnswerIndex;
    }

    @NonNull
    public String getQuestion() {
        return mQuestion;
    }

    @NonNull
    public List<String> getChoiceList() {
        return mChoiceList;
    }

    public int getAnswerIndex() {
        return mAnswerIndex;
    }
}
