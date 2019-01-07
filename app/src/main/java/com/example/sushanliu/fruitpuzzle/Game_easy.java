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

public class Game_easy extends BaseActivity {

    private TextView counTlable;
    private ImageView questionsImages;
    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    private Button answerBtn4;

    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();
    String quizData[][] = {
            // {"Image name", "right answer", "choice1", "choice2","choice3"}

            {"pi5", "5", "3", "4", "7"},
            {"pi6", "6", "7", "9", "5"},
            {"pi7", "7", "6", "8", "9"},
            {"pi8", "8", "7", "10", "15"},
            {"pi9", "9", "6", "11", "7"},
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_easy);

        counTlable=findViewById(R.id.countLabel);
        questionsImages =findViewById(R.id.questionImage);
        answerBtn1 =findViewById(R.id.answer1);
        answerBtn2 =findViewById(R.id.answer2);
        answerBtn3 =findViewById(R.id.answer3);
        answerBtn4 =findViewById(R.id.answer4);


        //create quizArray from quizData

        for (int i=0; i<quizData.length; i++){
            //prepare array
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]);
            tmpArray.add(quizData[i][1]); //Right answer
            tmpArray.add(quizData[i][2]); //choice1
            tmpArray.add(quizData[i][3]); //choice2
            tmpArray.add(quizData[i][4]); //choice3

            //add tmpArray to quizArray.
            quizArray.add(tmpArray);

        }
        showNextQuiz();
    }

    private void showNextQuiz() {

        // update quizCountLabel.
        counTlable.setText("Q" + quizCount);

        //Generate random number between 0 and 4(quizArray's size -1)

        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        // pick one quiz set.
        ArrayList<String> quiz = quizArray.get(randomNum);

        //set Image and right answer.

        //Array format
        questionsImages.setImageResource(
                getResources().getIdentifier(quiz.get(0), "drawable", getPackageName()));

        rightAnswer = quiz.get(1);

        //remove "Image Name" from quiz and shuffle choice.
        quiz.remove(0);
        Collections.shuffle(quiz);

        //set Choices.
        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));

        // remove this quiz from quizArray
        quizArray.remove(randomNum);

    }

    public void checkAnswer(View view){

        //get pushed button.
        Button answerBtn = findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle;

        if(btnText.equals(rightAnswer)){
            //correct!!
            alertTitle = "Correct!";
            rightAnswerCount++;

        }else {
            //wrong
            alertTitle = "Wrong...";

        }

        //create Dialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Answer: "+rightAnswer);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (quizArray.size() <1){
                    //quizArray is empty.
                    //showResult
                    showResult();
                }else {
                    quizCount++;
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
        builder.setMessage(rightAnswerCount +" /5");
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














