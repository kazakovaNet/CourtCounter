package com.example.android.courtcounter;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String GOAL_TEAM_A = "goalTeamA";
    public static final String GOAL_TEAM_B = "goalTeamB";
    public static final String FREE_KICK_TEAM_A = "freeKickTeamA";
    public static final String FREE_KICK_TEAM_B = "freeKickTeamB";
    int goalTeamA = 0;
    int goalTeamB = 0;
    int freeKickTeamA = 0;
    int freeKickTeamB = 0;
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

        displayScore();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

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
        mGoalTeamATextView = findViewById(R.id.team_a_goal);
        mGoalTeamATextView.setText(String.valueOf(goalTeamA));
    }

    /**
     * Displays the given free kicks for Team A.
     */
    private void displayFreeKickForTeamA() {
        mFreeKickTeamATextView = findViewById(R.id.team_a_free_kick);
        mFreeKickTeamATextView.setText(String.valueOf(freeKickTeamA));
    }

    /**
     * Displays the given goals for Team B.
     */
    public void displayGoalForTeamB() {
        mGoalTeamBTextView = findViewById(R.id.team_b_goal);
        mGoalTeamBTextView.setText(String.valueOf(goalTeamB));
    }

    /**
     * Displays the given free kicks for Team B.
     */
    private void displayFreeKickForTeamB() {
        mFreeKickTeamBTextView = findViewById(R.id.team_b_free_kick);
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
