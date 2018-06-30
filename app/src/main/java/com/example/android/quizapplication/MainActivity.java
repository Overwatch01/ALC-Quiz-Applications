    package com.example.android.quizapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


 public class MainActivity extends AppCompatActivity {

     int score;

     /**
      * Called when the activity is first created.
      */
     @Override
     public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
     }


     /**
      * This method is called to get the result of question 1
      */
     public void calculateQuestionOne(int questionOneCheckedRadioButtonOption) {
         RadioButton correctAnswer = (RadioButton) findViewById(R.id.questionOneCorrectAnswer);
         if (correctAnswer.getId() == questionOneCheckedRadioButtonOption) {
             score += 1;
         }
     }


     /**
      * This method is called to get the result of question 2
      */
     public void calculateQuestionTwo(int questionTwoCheckedRadioButtonOption) {
         RadioButton correctAnswer = (RadioButton) findViewById(R.id.questionTwoCorrectAnswer);
         if (correctAnswer.getId() == questionTwoCheckedRadioButtonOption) {
             score += 1;
         }
     }

     /**
      * This method is called to get the result of question 3
      */
     public int calculateQuestionThree(boolean isOptionOneSelected, boolean isOptionTwoSelected, boolean isOptionThreeSelected, boolean isOptionFourSelected) {
         if (!isOptionOneSelected && isOptionTwoSelected && !isOptionThreeSelected && isOptionFourSelected) {
             score += 1;
         }
         return score;
     }

     /**
      * This method is called to get the result of question 4
      */
     public int calculateQuestionFour(boolean isOptionOneSelected, boolean isOptionTwoSelected, boolean isOptionThreeSelected, boolean isOptionFourSelected) {
         if (isOptionOneSelected && isOptionTwoSelected && !isOptionThreeSelected && isOptionFourSelected) {
             score += 1;
         }
         return score;
     }

     /**
      * This method is called to get the result of question 5
      */
     public int calculateQuestionFive(String questionFiveText) {
         if (questionFiveText.equals("Hagrid")) {
             score += 1;
         }
         return score;
     }

     /**
      * This method is called to get the result of question 6
      */
     public int calculateQuestionSix(String questionSixText) {
         if (questionSixText.equals("Ginny")) {
             score += 1;
         }
         return score;
     }

     public void submitAnswer(View view) {

         RadioGroup questionOne = (RadioGroup) findViewById(R.id.questionOneOptions);
         int questionOneCheckedRadioButtonOption = questionOne.getCheckedRadioButtonId();

         RadioGroup questionTwo = (RadioGroup) findViewById(R.id.questionTwoOptions);
         int questionTwoCheckedRadioButtonOption = questionTwo.getCheckedRadioButtonId();

         boolean questionThreeOptionOne = ((CheckBox) findViewById(R.id.questionThreeOptionOne)).isChecked();
         boolean questionThreeOptionTwo = ((CheckBox) findViewById(R.id.questionThreeOptionTwo)).isChecked();
         boolean questionThreeOptionThree = ((CheckBox) findViewById(R.id.questionThreeOptionThree)).isChecked();
         boolean questionThreeOptionFour = ((CheckBox) findViewById(R.id.questionThreeOptionFour)).isChecked();

         boolean questionFourOptionOne = ((CheckBox) findViewById(R.id.questionFourOptionOne)).isChecked();
         boolean questionFourOptionTwo = ((CheckBox) findViewById(R.id.questionFourOptionTwo)).isChecked();
         boolean questionFourOptionThree = ((CheckBox) findViewById(R.id.questionFourOptionThree)).isChecked();
         boolean questionFourOptionFour = ((CheckBox) findViewById(R.id.questionFourOptionFour)).isChecked();

         EditText questionFive = (EditText) findViewById(R.id.questionFive);
         String questionFiveAnswer = questionFive.getText().toString();

         EditText questionSix = (EditText) findViewById(R.id.questionSix);
         String questionSixAnswer = questionSix.getText().toString();

         calculateQuestionOne(questionOneCheckedRadioButtonOption);
         calculateQuestionTwo(questionTwoCheckedRadioButtonOption);
         calculateQuestionThree(questionThreeOptionOne, questionThreeOptionTwo, questionThreeOptionThree, questionThreeOptionFour);
         calculateQuestionFour(questionFourOptionOne, questionFourOptionTwo, questionFourOptionThree, questionFourOptionFour);
         calculateQuestionFive(questionFiveAnswer);
         calculateQuestionSix(questionSixAnswer);

         String summary = "Number of questions answered correctly: " + score;
         summary += "\nTotal Score is: " + score * 5;
         Toast.makeText(getApplicationContext(), summary, Toast.LENGTH_SHORT).show();
         score = 0;
     }
 }






