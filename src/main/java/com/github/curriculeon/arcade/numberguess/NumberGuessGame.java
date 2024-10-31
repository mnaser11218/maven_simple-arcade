package com.github.curriculeon.arcade.numberguess;

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
public class NumberGuessGame implements GameInterface {

    private int userNumber =0;
    private int randomNumber=0;
    private ArrayList<Integer> userInputs = new ArrayList<>();
    private boolean appClosed = false;
    public NumberGuessPlayer player;

    List<PlayerInterface> players = new ArrayList<>();

    public String userName;
    public String password;

    private final IOConsole console = new IOConsole(AnsiColor.BLUE);

    public NumberGuessGame() {
    }
    public void add(PlayerInterface player){
        players.add(player);
    }

    @Override
    public void remove(PlayerInterface player) {
        players.remove(player);
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
        Scanner scanner = new Scanner(System.in);
        this.userInputs.add(this.userNumber);
        if(this.userNumber > randomNumber){
            System.out.println("My Number is less than " + this.userNumber);
            return false;
        } else if(this.userNumber < randomNumber){
            System.out.println("My Number is greater than " + this.userNumber);
            return false;
        }
        System.out.println("Well Done ! It took you " + userInputs.size() + " amount of tries");
        System.out.println("Would you like to play again? yes/no");
        String userInput = scanner.nextLine();
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
        System.out.println(this.players.get(0).getArcadeAccount().getAccountName());

        //implementing two players:


        System.out.println("Welcome");

        System.out.println("\u001B[33m ███▄    █  █    ██  ███▄ ▄███▓ ▄▄▄▄   ▓█████  ██▀███  \n" +
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
                "░ ░   ░  ░░░ ░ ░    ░   ░  ░  ░  ░  ░  ░               \n" +
                "      ░    ░        ░  ░      ░        ░               ");
//        System.out.println("Welcome, your balance is : " + myPlayerAccount.getAccountBalance());
// TODO FINISIH TWO PLAYER GAME:
//        int userInput = console.getIntegerInput("Click 1 for one player, or 2 for two players.");
//        if(userInput == 2){
//            for(CasinoAccount c:  arcadeAccountList){
//                if(!c.getAccountName().equals(userName)) {
//                    System.out.println("player name -> " + c.getAccountName() + " \nBalance amount: " + c.getAccountBalance());
//                }
//            }
//            String userInputString = console.getStringInput("Please select user name for second player: ");
//         // secondPlayer= arcadeAccountList.get(userInputString)
//        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a number between 0 to 100");
        generateRandomNumber();
        while(!appClosed){
            System.out.println("Please enter a number");
            userNumber = scanner.nextInt();
            checkIfNumberTooHighOrTooLow();
        }

    }


//    @Override
//    public void remove(PlayerInterface player) {
//        this.player = null;
//    }
}