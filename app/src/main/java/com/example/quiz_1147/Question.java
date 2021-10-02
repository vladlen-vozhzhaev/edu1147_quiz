package com.example.quiz_1147;

public class Question {
    private int questionText;
    private boolean answerTrue;

    public Question(int questionText, boolean answerTrue) {
        this.questionText = questionText;
        this.answerTrue = answerTrue;
    }

    public int getQuestionText() {
        return questionText;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }
}
