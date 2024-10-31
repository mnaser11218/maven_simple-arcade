package com.github.curriculeon;

import com.github.curriculeon.arcade.numberguess.NumberGuessGame;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class NumberGuessGameTest {
    @Test
    public void generateRandomNumberTest(){
        NumberGuessGame numberGuessGame = new NumberGuessGame();
        Integer randomNum =(Integer) numberGuessGame.generateRandomNumber();

        assertTrue(randomNum instanceof Integer);
    }
    //
    @Test
    public void getAndSetRandomNumberTest(){
        NumberGuessGame numberGuessGame = new NumberGuessGame();
        numberGuessGame.setRandomNumber(50);
        int expected = numberGuessGame.getRandomNumber();
        Assert.assertEquals(expected, 50);
    }
}
