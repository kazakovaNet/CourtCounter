package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int goalTeamA = 0;
    int goalTeamB = 0;
    int freeKickTeamA = 0;
    int freeKickTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayScore();
    }

    /**
     * Метод устанавливает значения TextView голов и штрафных ударов
     */
    private void displayScore() {
        displayGoalForTeamA();
        displayGoalForTeamB();
        displayFreeKickForTeamA();
        displayFreeKickForTeamB();
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addFreeKickForTeamA(View v) {
        freeKickTeamA++;

        displayFreeKickForTeamA();
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void addGoalForTeamA(View v) {
        goalTeamA++;

        displayGoalForTeamA();
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    public void addGoalForTeamB(View v) {
        goalTeamB++;

        displayGoalForTeamB();
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void addFreeKickForTeamB(View v) {
        freeKickTeamB++;

        displayFreeKickForTeamB();
    }

    /**
     * Displays the given goals for Team A.
     */
    public void displayGoalForTeamA() {
        TextView goalTeamATextView = findViewById(R.id.team_a_goal);
        goalTeamATextView.setText(String.valueOf(goalTeamA));
    }

    /**
     * Displays the given free kicks for Team A.
     */
    private void displayFreeKickForTeamA() {
        TextView freeKickTeamATextView = findViewById(R.id.team_a_free_kick);
        freeKickTeamATextView.setText(String.valueOf(freeKickTeamA));
    }

    /**
     * Displays the given goals for Team B.
     */
    public void displayGoalForTeamB() {
        TextView goalTeamBTextView = findViewById(R.id.team_b_goal);
        goalTeamBTextView.setText(String.valueOf(goalTeamB));
    }

    /**
     * Displays the given free kicks for Team B.
     */
    private void displayFreeKickForTeamB() {
        TextView FreeKickTeamBTextView = findViewById(R.id.team_b_free_kick);
        FreeKickTeamBTextView.setText(String.valueOf(freeKickTeamB));
    }

    /**
     * Resets the score for both teams back to 0.
     */
    public void resetScore(View v) {
        goalTeamA = 0;
        goalTeamB = 0;
        freeKickTeamB = 0;
        freeKickTeamA = 0;

        displayScore();
    }
}
