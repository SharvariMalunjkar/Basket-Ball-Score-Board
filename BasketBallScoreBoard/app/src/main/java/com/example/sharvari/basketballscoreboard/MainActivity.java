package com.example.sharvari.basketballscoreboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.os.CountDownTimer;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    int score1 =0;
    int score2 =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Reset(View view) {
        score1 = 0;
        score2 = 0;
        displayTeam1(score1);
        displayTeam2(score2);
    }

    public void ThreePoints1(View view){
        score1=score1+3;
        displayTeam1(score1);
    }

    public void OnePoint1(View view){
        score1=score1+1;
        displayTeam1(score1);
    }
    public void decrement1(View view){
        score1=score1-1;
        displayTeam1(score1);
    }


    public void ThreePoints2(View view){
        score2=score2+3;
        displayTeam2(score2);
    }

    public void OnePoint2(View view){
        score2=score2+1;
        displayTeam2(score2);
    }

    public void decrement2(View view){
        score2=score2-1;
        displayTeam2(score2);
    }

    public void Restart (View view){
        score1=0;
        score2 =0;
        displayTeam1(score1);
        displayTeam2(score2);
    }

    public void EndGame (View view){
        String WonTeam = "";
        if (score1>score2){
            WonTeam= "Team A";
        }else{
            WonTeam= "Team B";
        }
        displayResults(WonTeam);

    }

    public void Timer (View view) {

        new CountDownTimer((10*60*1000), 1000) {

            public void onTick(long millisUntilFinished) {
                TextView timerView = (TextView)findViewById(R.id.timerView);
               // timerView.setText( ""+(millisUntilFinished/1000));
                String hms = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)), TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
                timerView.setText(hms);//set text


            }

            public void onFinish() {
                TextView timerView = (TextView)findViewById(R.id.timerView);
                timerView.setText("00:00");
            }

        }.start();


    }

    private void displayTeam1(int number){
        TextView scoreView = (TextView)findViewById(R.id.ScoreView1);
        scoreView.setText(""+number);
    }


    private void displayTeam2(int number){
        TextView scoreView = (TextView)findViewById(R.id.ScoreView2);
        scoreView.setText(""+number);
    }

    private void displayResults(String team){
        TextView resultView = (TextView)findViewById(R.id.resultString);
        resultView.setText("    Congratutions!  "+ "\n"+team+ " won the match!");
    }



}
