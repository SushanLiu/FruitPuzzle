package com.example.sushanliu.fruitpuzzle;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game_master extends BaseActivity {

    private TextView masterCounTlable;
    private ImageView masterQuestionsImages;
    private Button masterAnswerBtn1;
    private Button masterAnswerBtn2;
    private Button masterAnswerBtn3;
    private Button masterAnswerBtn4;

    private String masterRightAnswer;
    private int masterRightAnswerCount = 0;
    private int masterQuizCount = 1;

    ArrayList<ArrayList<String>> quizArrayMaster = new ArrayList<>();
    String quizDataMaster[][] = {
            // {"Image name", "right answer", "choice1", "choice2","choice3"}

            {"m10","10","9","8","7"},
            {"m8","8","7","9","5"},
            {"m11","11","6","8","9"},
            {"m9","9","7","10","12"},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_master);

        masterCounTlable =findViewById(R.id.mCountLabel);
        masterQuestionsImages =findViewById(R.id.mQuestionImage);
        masterAnswerBtn1 =findViewById(R.id.mAnswer1);
        masterAnswerBtn2 =findViewById(R.id.mAanswer2);
        masterAnswerBtn3 =findViewById(R.id.mAanswer3);
        masterAnswerBtn4 =findViewById(R.id.mAnswer4);

        //create quizArray from quizData

        for (int i=0; i<quizDataMaster.length; i++){
            //prepare array
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizDataMaster[i][0]);
            tmpArray.add(quizDataMaster[i][1]); //Right answer
            tmpArray.add(quizDataMaster[i][2]); //choice1
            tmpArray.add(quizDataMaster[i][3]); //choice2
            tmpArray.add(quizDataMaster[i][4]); //choice3

            //add tmpArray to quizArray.
            quizArrayMaster.add(tmpArray);

        }
        showNextQuiz();
    }
    private void showNextQuiz() {

        // update quizCountLabel.
        masterCounTlable.setText("Q" + masterQuizCount);

        //Generate random number between 0 and 4(quizArray's size -1)

        Random random = new Random();
        int randomNum = random.nextInt(quizArrayMaster.size());

        // pick one quiz set.
        ArrayList<String> quiz = quizArrayMaster.get(randomNum);

        //set Image and right answer.

        //Array format
        masterQuestionsImages.setImageResource(
                getResources().getIdentifier(quiz.get(0), "drawable", getPackageName()));

        masterRightAnswer= quiz.get(1);

        //remove "Image Name" from quiz and shuffle choice.
        quiz.remove(0);
        Collections.shuffle(quiz);

        //set Choices.
        masterAnswerBtn1.setText(quiz.get(0));
        masterAnswerBtn2.setText(quiz.get(1));
        masterAnswerBtn3.setText(quiz.get(2));
        masterAnswerBtn4.setText(quiz.get(3));

        // remove this quiz from quizArray
        quizArrayMaster.remove(randomNum);

    }

    public void checkAnswer(View view){

        //get pushed button.
        Button answerBtn = findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle;

        if(btnText.equals(masterRightAnswer)){
            //correct!!
            alertTitle = "Correct!";
            masterRightAnswerCount++;

        }else {
            //wrong
            alertTitle = "Wrong...";

        }

        //create Dialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Answer: "+masterRightAnswer);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (quizArrayMaster.size() <1){
                    //quizArray is empty.
                    //showResult
                    showResult();
                }else {
                    masterQuizCount++;
                    showNextQuiz();
                }

            }
        });
        builder.setCancelable(false);
        builder.show();
    }
    public void showResult(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Result");
        builder.setMessage(masterRightAnswerCount +" /5");
        builder.setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i){
                recreate();
            }
        });
        builder.setNegativeButton("Try Other Level", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.show();
    }

}

