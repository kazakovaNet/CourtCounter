package com.example.android.courtcounter.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.android.courtcounter.R;


public class MainActivity extends AppCompatActivity {
    private final String GOAL_TEAM_A = "goalTeamA";
    private final String GOAL_TEAM_B = "goalTeamB";
    private final String FREE_KICK_TEAM_A = "freeKickTeamA";
    private final String FREE_KICK_TEAM_B = "freeKickTeamB";
    private int goalTeamA = 0;
    private int goalTeamB = 0;
    private int freeKickTeamA = 0;
    private int freeKickTeamB = 0;
    private TextView mGoalTeamATextView;
    private TextView mFreeKickTeamATextView;
    private TextView mGoalTeamBTextView;
    private TextView mFreeKickTeamBTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null && savedInstanceState.containsKey(GOAL_TEAM_A)) {
            goalTeamA = savedInstanceState.getInt(GOAL_TEAM_A);
        }
        if (savedInstanceState != null && savedInstanceState.containsKey(GOAL_TEAM_B)) {
            goalTeamB = savedInstanceState.getInt(GOAL_TEAM_B);
        }
        if (savedInstanceState != null && savedInstanceState.containsKey(FREE_KICK_TEAM_A)) {
            freeKickTeamA = savedInstanceState.getInt(FREE_KICK_TEAM_A);
        }
        if (savedInstanceState != null && savedInstanceState.containsKey(FREE_KICK_TEAM_B)) {
            freeKickTeamB = savedInstanceState.getInt(FREE_KICK_TEAM_B);
        }

        mGoalTeamATextView = findViewById(R.id.team_a_goal);
        mFreeKickTeamATextView = findViewById(R.id.team_a_free_kick);
        mGoalTeamBTextView = findViewById(R.id.team_b_goal);
        mFreeKickTeamBTextView = findViewById(R.id.team_b_free_kick);

        displayScore();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(GOAL_TEAM_A, Integer.parseInt(String.valueOf(mGoalTeamATextView.getText())));
        outState.putInt(GOAL_TEAM_B, Integer.parseInt(String.valueOf(mGoalTeamBTextView.getText())));
        outState.putInt(FREE_KICK_TEAM_A, Integer.parseInt(String.valueOf(mFreeKickTeamATextView.getText())));
        outState.putInt(FREE_KICK_TEAM_B, Integer.parseInt(String.valueOf(mFreeKickTeamBTextView.getText())));
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
        mGoalTeamATextView.setText(String.valueOf(goalTeamA));
    }

    /**
     * Displays the given free kicks for Team A.
     */
    private void displayFreeKickForTeamA() {
        mFreeKickTeamATextView.setText(String.valueOf(freeKickTeamA));
    }

    /**
     * Displays the given goals for Team B.
     */
    public void displayGoalForTeamB() {
        mGoalTeamBTextView.setText(String.valueOf(goalTeamB));
    }

    /**
     * Displays the given free kicks for Team B.
     */
    private void displayFreeKickForTeamB() {
        mFreeKickTeamBTextView.setText(String.valueOf(freeKickTeamB));
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
