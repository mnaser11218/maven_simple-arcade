package com.github.curriculeon.arcade.numberguess;

import com.github.curriculeon.arcade.AbstractGame;
import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame extends AbstractGame {

    private Integer userNumber =0;
    private int randomNumber=0;
    private boolean appClosed = false;
    public NumberGuessPlayer player;
    public boolean gamerunning=true;

    private final IOConsole console = new IOConsole(AnsiColor.BLUE);

    public NumberGuessGame() {
    }



    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber= userNumber;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }


    public boolean isCloseApp() {
        return appClosed;
    }

    public void setCloseApp(boolean appClosed) {
        this.appClosed = appClosed;
    }

    public boolean checkIfNumberTooHighOrTooLow(int userNumber){
        if(userNumber > randomNumber){
            console.println("My Number is less than " + userNumber);
            return false;
        } else if(userNumber < randomNumber){
            console.println("My Number is greater than " + userNumber);
            return false;
        }

        String userInput = console.getStringInput(" Well Done ! It took you " + 0 +" amount of tries \n Would you like to play again? yes/no");
        if(userInput.equalsIgnoreCase("no")){
            this.gamerunning = false;
            return true;
        }

        generateRandomNumber();
        return true;
    }

    public int generateRandomNumber(){
        int r = (int) (Math.random() * (100 - 1)) + 1;
        this.randomNumber = r;
        return r;
    }


    @Override
    public void evaluatePlayer(PlayerInterface playerInterface) {
        generateRandomNumber();
        Integer numberGuessed= playerInterface.play();
    while(numberGuessed != randomNumber){

        checkIfNumberTooHighOrTooLow(numberGuessed);
       numberGuessed= playerInterface.play();
    }
        gamerunning = false;
        console.println("Congrats you got it in " + playerInterface.getCounter()  + " amount of tries");
    }

    @Override
    public boolean isGameRunning() {
        return gamerunning;
    }

}