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
    private ArrayList<Integer> userInputs = new ArrayList<>();
    private boolean appClosed = false;
    public NumberGuessPlayer player;
    public String userName;
    public String password;

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

    public ArrayList<Integer> getUserInputs() {
        return userInputs;
    }

    public void setUserInputs(ArrayList<Integer> userInputs) {
        this.userInputs = userInputs;
    }

    public boolean isCloseApp() {
        return appClosed;
    }

    public void setCloseApp(boolean appClosed) {
        this.appClosed = appClosed;
    }

    public boolean checkIfNumberTooHighOrTooLow(){
        this.userInputs.add(this.userNumber);
        if(this.userNumber > randomNumber){
            console.println("My Number is less than " + this.userNumber);
            return false;
        } else if(this.userNumber < randomNumber){
            console.println("My Number is greater than " + this.userNumber);
            return false;
        }

        String userInput = console.getStringInput(" Well Done ! It took you " + userInputs.size() +" amount of tries \n Would you like to play again? yes/no");
        if(userInput.equalsIgnoreCase("no")){
            this.appClosed = true;
            return true;
        }
        userInputs.clear();
        generateRandomNumber();
        return true;
    }

    public int generateRandomNumber(){
        int r = (int) (Math.random() * (100 - 1)) + 1;
        this.randomNumber = r;
        return r;
    }


    public void run(){

        console.println("Welcome " +this.getPlayerList().get(0).getArcadeAccount().getAccountName()   + "\n " + "\u001B[33m ███▄    █  █    ██  ███▄ ▄███▓ ▄▄▄▄   ▓█████  ██▀███  \n" +
                " ██ ▀█   █  ██  ▓██▒▓██▒▀█▀ ██▒▓█████▄ ▓█   ▀ ▓██ ▒ ██▒\n" +
                "▓██  ▀█ ██▒▓██  ▒██░▓██    ▓██░▒██▒ ▄██▒███   ▓██ ░▄█ ▒\n" +
                "▓██▒  ▐▌██▒▓▓█  ░██░▒██    ▒██ ▒██░█▀  ▒▓█  ▄ ▒██▀▀█▄  \n" +
                "▒██░   ▓██░▒▒█████▓ ▒██▒   ░██▒░▓█  ▀█▓░▒████▒░██▓ ▒██▒\n" +
                "░ ▒░   ▒ ▒ ░▒▓▒ ▒ ▒ ░ ▒░   ░  ░░▒▓███▀▒░░ ▒░ ░░ ▒▓ ░▒▓░\n" +
                "░ ░░   ░ ▒░░░▒░ ░ ░ ░  ░      ░▒░▒   ░  ░ ░  ░  ░▒ ░ ▒░\n" +
                "   ░   ░ ░  ░░░ ░ ░ ░      ░    ░    ░    ░     ░░   ░ \n" +
                "         ░    ░            ░    ░         ░  ░   ░     \n" +
                "                                     ░                 \n" +
                "  ▄████  █    ██ ▓█████   ██████   ██████              \n" +
                " ██▒ ▀█▒ ██  ▓██▒▓█   ▀ ▒██    ▒ ▒██    ▒              \n" +
                "▒██░▄▄▄░▓██  ▒██░▒███   ░ ▓██▄   ░ ▓██▄                \n" +
                "░▓█  ██▓▓▓█  ░██░▒▓█  ▄   ▒   ██▒  ▒   ██▒             \n" +
                "░▒▓███▀▒▒▒█████▓ ░▒████▒▒██████▒▒▒██████▒▒             \n" +
                " ░▒   ▒ ░▒▓▒ ▒ ▒ ░░ ▒░ ░▒ ▒▓▒ ▒ ░▒ ▒▓▒ ▒ ░             \n" +
                "  ░   ░ ░░▒░ ░ ░  ░ ░  ░░ ░▒  ░ ░░ ░▒  ░ ░             \n" +
                "░ ░   ░  ░░░ ░ ░    ░   ░  ░  ░  ░  ░  ░               \n \n" +
                "      ░    ░        ░  ░      ░        ░               ");


        generateRandomNumber();
        while(!appClosed){
            userNumber = console.getIntegerInput("Please enter a number");
            checkIfNumberTooHighOrTooLow();
        }

    }

}