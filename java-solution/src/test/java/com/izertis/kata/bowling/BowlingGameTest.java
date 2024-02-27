package com.izertis.kata.bowling;

import org.junit.Assert;
import org.junit.Test;

public class BowlingGameTest {

    @Test
    public void testGame0() {
        BowlingGame game = new BowlingGame();
        rollMany(game, 20, 0);
        Assert.assertEquals(0, game.getScore());
    }

    @Test
    public void testGameAll1() {
        BowlingGame game = new BowlingGame();
        rollMany(game, 20, 1);
        Assert.assertEquals(20, game.getScore());
    }

    @Test
    public void testGameSpare() {
        BowlingGame game = new BowlingGame();
        game.roll(5);
        game.roll(5);
        game.roll(3);
        rollMany(game, 17, 0);
        Assert.assertEquals(16, game.getScore());
    }

    @Test
    public void testGameNotSpare() {
        BowlingGame game = new BowlingGame();
        game.roll(0);
        game.roll(5);
        game.roll(5);
        game.roll(3);
        rollMany(game, 16, 0);
        Assert.assertEquals(13, game.getScore());
    }

    @Test
    public void testGameStrike() {
        BowlingGame game = new BowlingGame();
        game.roll(10);
        game.roll(3);
        game.roll(2);
        rollMany(game, 16, 0);
        Assert.assertEquals(20, game.getScore());
    }

    @Test
    public void testGameNotStrikeYesSpare() {
        BowlingGame game = new BowlingGame();
        game.roll(0);
        game.roll(10);
        game.roll(3);
        game.roll(2);
        rollMany(game, 16, 0);
        Assert.assertEquals(18, game.getScore());
    }

    @Test
    public void testStrikeInLast() {
        BowlingGame game = new BowlingGame();
        rollMany(game, 18, 0);
        game.roll(10);
        game.roll(1);
        game.roll(1);
        Assert.assertEquals(12, game.getScore());
    }

    @Test
    public void testGame300() {
        BowlingGame game = new BowlingGame();
        rollMany(game, 12, 10);
        Assert.assertEquals(300, game.getScore());
    }

    private void rollMany(BowlingGame game, int times, int pins) {
        for (int i = 0; i < times; i++) {
            game.roll(pins);
        }
    }

}
