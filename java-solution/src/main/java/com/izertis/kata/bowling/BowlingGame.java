package com.izertis.kata.bowling;

public class BowlingGame {

    private static final int NUM_FRAMES = 10;

    int[] rows = new int[24];
    private int currentRoll = 0;

    public void roll(int pins) {
        rows[currentRoll++] = pins;
        if (currentRoll % 2 != 0 && pins == 10) { // Strike
            rows[currentRoll++] = 0;
        }
    }

    public int getScore() {
        int score = 0;
        for (int frame = 0; frame < NUM_FRAMES; frame++) {
            score += row(frame, 0) + row(frame, 1);
            if (isStrike(frame)) {
                score += row(frame + 1, 0);
                if (isStrike(frame+1)) {
                    score += row(frame + 2, 0);
                } else {
                    score += row(frame + 1, 1);
                }
            } else if (isSpare(frame)) {
                score += row(frame + 1, 0);
            }
        }
        return score;
    }

    private int row(int frame, int frameRoll) {
        return rows[frame * 2 + frameRoll];
    }

    private boolean isStrike(int frame) {
        return rows[frame * 2] == 10;
    }

    private boolean isSpare(int frame) {
        return row(frame, 0) + row(frame, 1) == 10;
    }
}
