package com.example.hp.ss;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;
import java.util.Locale;


public class StartingQuizActivity extends AppCompatActivity {

    public static final String EXTRA_SCORE = "extraScore";
    public static final long COUNTDOWN_IN_MILLISEC = 45000;
    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewCountDown;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private Button buttonConfirmNext;

    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultcd;

    private CountDownTimer countdowntimer;
    private long timeleft;

    private List<Question> queList;
    private int questionCountTotal;
    private int questionCounter;
    private Question currentQuestion;

    private int score;
    private boolean answered;
    private long backPressedTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_quiz);
        textViewQuestion = findViewById(R.id.text_view_question);
        textViewScore = findViewById(R.id.text_view_score);
        textViewQuestionCount = findViewById(R.id.text_view_que_count);
        textViewCountDown = findViewById(R.id.text_view_countdown);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button_1);
        rb2 = findViewById(R.id.radio_button_2);
        rb3 = findViewById(R.id.radio_button_3);
        rb4 = findViewById(R.id.radio_button_4);
        buttonConfirmNext = findViewById(R.id.button_confirm_next);

        textColorDefaultRb = rb1.getTextColors();
        textColorDefaultcd = textViewCountDown.getTextColors();


        QuizDBHelper dbHelper = new QuizDBHelper(this);
        queList = dbHelper.getAllQue();

        questionCountTotal = queList.size();
        Collections.shuffle(queList);

        showNextQue();
        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked())
                        checkAnswer();
                    else
                        Toast.makeText(StartingQuizActivity.this, "Please select the option", Toast.LENGTH_SHORT).show();
                } else
                    showNextQue();
            }
        });

    }

    public void showNextQue() {
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        rb4.setTextColor(textColorDefaultRb);
        rbGroup.clearCheck();

        if (questionCounter < questionCountTotal) {

            currentQuestion = queList.get(questionCounter);

            textViewQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());

            questionCounter++;
            textViewQuestionCount.setText("Question: " + questionCounter + "/" + questionCountTotal);
            answered = false;
            buttonConfirmNext.setText("Confirm");

            timeleft = COUNTDOWN_IN_MILLISEC;
            startCountdown();
        } else {
            finishQuiz();
        }
    }


    private void checkAnswer() {
        answered = true;
        countdowntimer.cancel();
        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answer = rbGroup.indexOfChild(rbSelected) + 1;
        if (answer == currentQuestion.getAnswerNr()) {
            score++;
            textViewScore.setText("Score: " + score);
        }
        showSolution();
    }

    private void showSolution() {
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);
        Toast right = Toast.makeText(this, "Option " + currentQuestion.getAnswerNr() + " is Correct", Toast.LENGTH_SHORT);

        switch (currentQuestion.getAnswerNr()) {
            case 1:
                rb1.setTextColor(Color.GREEN);
                right.show();
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                right.show();
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                right.show();
                break;
            case 4:
                rb4.setTextColor(Color.GREEN);
                right.show();
                break;

        }
        if (questionCounter < questionCountTotal) {
            buttonConfirmNext.setText("Next");
        } else
            buttonConfirmNext.setText("Finish");

    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE, score);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "Press back again to finish", Toast.LENGTH_SHORT).show();
        }

        backPressedTime = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countdowntimer != null) {
            countdowntimer.cancel();
        }
    }

    private void startCountdown() {
        countdowntimer = new CountDownTimer(timeleft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeleft = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeleft = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();

    }

    private void updateCountDownText() {
        int mins = (int) (timeleft / 1000) / 60;
        int secs = (int) (timeleft / 1000) % 60;
        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", mins, secs);
        textViewCountDown.setText(timeFormatted);
        if (timeleft < 10000) {
            textViewCountDown.setTextColor(Color.RED);
        } else {
            textViewCountDown.setTextColor(textColorDefaultcd);
        }

    }
}

