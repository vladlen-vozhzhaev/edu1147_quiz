package com.example.quiz_1147;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button yesBtn;
    Button noBtn;
    Button getAnswer;
    TextView textView;
    Question[] questions = {
      new Question(R.string.question1, true),
      new Question(R.string.question2, true),
      new Question(R.string.question3, true),
      new Question(R.string.question4, false),
      new Question(R.string.question5, false)
    };
    int questionIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SYSTEM INFO:", "Вызван метод onCreate()");
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null){
            questionIndex = savedInstanceState.getInt("questionIndex");
        }
        yesBtn = findViewById(R.id.yesBtn);
        noBtn = findViewById(R.id.noBtn);
        textView = findViewById(R.id.textView);
        getAnswer = findViewById(R.id.getAnswer);
        textView.setText(questions[questionIndex].getQuestionText());

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });
        getAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Создаём намерение (интент) указывая кто и какую активность хочет запустить
                Intent intent = new Intent(MainActivity.this, AnswerActivity.class);
                // Кладём дополнения (их может быть несколько)
                intent.putExtra("answer", questions[questionIndex].isAnswerTrue());
                // Стартуем активность
                startActivity(intent);
            }
        });
    }

    public void checkAnswer(boolean btn){
        if((questions[questionIndex].isAnswerTrue() && btn) || (!questions[questionIndex].isAnswerTrue() && !btn))
            Toast.makeText(MainActivity.this, R.string.correct_answer, Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, R.string.incorrect_answer, Toast.LENGTH_SHORT).show();
        questionIndex = (questionIndex+1)%questions.length;
        textView.setText(questions[questionIndex].getQuestionText());
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d("SYSTEM INFO: ", "Вызван метод onStart()");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d("SYSTEM INFO: ", "Вызван метод onResume()");
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.d("SYSTEM INFO: ", "Вызван метод onSaveInstanceState()");
        savedInstanceState.putInt("questionIndex", questionIndex);
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d("SYSTEM INFO: ", "Вызван метод onPause()");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d("SYSTEM INFO: ", "Вызван метод onStop()");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("SYSTEM INFO: ", "Вызван метод onDestroy()");
    }
}