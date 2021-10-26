package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button true_Button;
    private Button false_Button;
    private Button next_Button;
    private TextView question_Text_View;
    private  int currentIndex = 0;

    private Question[] questions = new Question[] {
            new Question(R.string.q_activity, true),
            new Question(R.string.q_find_resources, false),
            new Question(R.string.q_listener, true),
            new Question(R.string.q_resources, true),
            new Question(R.string.q_version, false),
    };

    private void setNextQuestion() {
        question_Text_View.setText(questions[currentIndex].getQuestionId());
    }

    private void checkAnswerCorrectness(boolean userAnswer) {
        boolean correctAnswer = questions[currentIndex].isTrueAnswer();
        int resultMessageId = 0;
        if(userAnswer == correctAnswer) {
            resultMessageId = R.string.correct_answer;
        } else {
            resultMessageId = R.string.incorrect_answer;
        }
        Toast.makeText(this, resultMessageId, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        true_Button = findViewById(R.id.TrueButton);
        false_Button = findViewById(R.id.FalseButton);
        next_Button = findViewById(R.id.NextButton);
        question_Text_View = findViewById(R.id.QuestionTextView);

        true_Button.setOnClickListener(new View.OnClickListener() {
        @Override
                public void onClick (View v) {
                    checkAnswerCorrectness(true);
                }
        });

        false_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                checkAnswerCorrectness(false);
            }
        });

        next_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                currentIndex = (currentIndex + 1)%questions.length;
                setNextQuestion();
            }
        });
    }
}
