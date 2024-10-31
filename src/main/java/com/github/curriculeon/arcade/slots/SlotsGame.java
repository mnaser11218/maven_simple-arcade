package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame implements GameInterface {
    List<PlayerInterface> players = new ArrayList<>();

    @Override
    public void add(PlayerInterface player) {
        players.add(player);
    }

    @Override
    public void remove(PlayerInterface player) {
        players.remove(player);
    }

//    @Override
//    public void run() {
//
//    }
    Scanner scanner = new Scanner(System.in);
    public int wagerAmount;
    public int stopGame = 0;
    ArrayList<Integer> randomList = new ArrayList<>();

    public String userName;
    public String password;
   // public CasinoAccountManager casinoAccountManager;
    public SlotsPlayer player;
    public Integer userBalance =0;


    public static void main(String[] args) {
    }

    /*===================================
     UML
     ===================================*/

    public ArrayList<Integer> spinWheelYes(boolean isLeverPulled, int size) {
        ArrayList<Integer> newArray = new ArrayList<>();
        Random random = new Random();

        if(isLeverPulled) {
            // creates an array random numbers from 0-9 with size 5
            for (int i = 0; i < size; i++){
                newArray.add(random.nextInt(10));
            }
        }
        this.randomList = newArray;

        System.out.println("\u001B[35m┏---------┬---------┬---------┬---------┬---------┓");
        System.out.println("|         |         |         |         |         | (  )");
        System.out.println("|    \u001B[36m" + newArray.get(0) +
                "\u001B[35m    |    \u001B[36m"  + newArray.get(1) +
                "\u001B[35m    |    \u001B[36m"  + newArray.get(2) +
                "\u001B[35m    |    \u001B[36m"  + newArray.get(3) +
                "\u001B[35m    |    \u001B[36m"  + newArray.get(4) +
                "\u001B[35m    | //");
        System.out.println("|         |         |         |         |         |//");
        System.out.println("┗---------┴---------┴---------┴---------┴---------┛╯\u001B[0m");

        return newArray;
    }

    public boolean checkForMatchThree(ArrayList<Integer> matchThree) {
        int maxCount = 0;
//        int mostFrequent = 0;

        for (int i = 0; i < matchThree.size(); i++){
            int count = 0;
            //checks each element to see how often it appears
            //then adds it to the mostFrequent if it beats
            for (int j = 0; j < matchThree.size(); j++){
                if (matchThree.get(i) == matchThree.get(j)){
                    count++;
                }
            }
            if (count > maxCount){
                maxCount = count;
//                mostFrequent = matchThree.get(i);
            }
        }
        if (maxCount < 5 && maxCount >=3){
            System.out.println("\u001B[32mYou matched 3!\u001B[0m");
            return true;
        } else {
            System.out.println("\u001B[31mYou lost your wager of " + this.wagerAmount +". Womp Womp.\u001B[0m");
            System.out.println("Your new balance is: \u001B[32m" + userBalance + "\u001B[0m");
            return false;
        }
    }

    public boolean checkForMatchFive(ArrayList<Integer> matchFive) {
        int maxCount = 0;

        for (int i = 0; i < matchFive.size(); i++){
            int count = 0;

            for (int j = 0; j < matchFive.size(); j++){
                if (matchFive.get(i) == matchFive.get(j)){
                    count++;
                }
            }
            if (count > maxCount){
                maxCount = count;
            }
        }

        if (maxCount == 5){
            System.out.println("\u001B[32mYou matched 5!\u001B[0m");
            return true;
        } else {
            return false;
        }
    }

    public boolean checkForjackpot(ArrayList<Integer> allSevens) {
        for(int number : allSevens) {
            if (number != 7){
                return false;
            }
        }
        System.out.println("\u001B[32mJACKPOT\u001B[0m");
        return true;
    }

    public int payOutForThree(int payOutThree, int wagerAmount) {
        payOutThree = 15;
        int payout = payOutThree * wagerAmount;
        userBalance += payout;
        System.out.println("\u001B[32mYou got paid: " + payout + "\nYour new balance is: \u001B[32m"
                + userBalance + "\u001B[0m");
        return payout;
    }

    public int payOutForFive(int payOutFive, int wagerAmount) {
        payOutFive = 100;
        int payout = payOutFive * wagerAmount;
        userBalance += payout;
        System.out.println("\u001B[32mYou got paid: " + payout + "\nYour new balance is: \u001B[32m"
                + userBalance + "\u001B[0m");
        return payout;
    }

    public int payOutForJackpot(int payOutJackpot, int wagerAmount) {
        payOutJackpot = 1000;
        int payout = payOutJackpot * wagerAmount;
        userBalance +=  payout;
        System.out.println("\u001B[32mYou got paid: " + payout + "\nYour new balance is: \u001B[32m"
                + userBalance + "\u001B[0m");
        return payout;
    }

    /*===================================
    NEW METHODS
    ===================================*/

    public void placeWager(int bet) {
        System.out.print("How much would you like to bet? Press '0' to stop gambling.\n[5, 10, 20, 50, 100, 250]: ");
        bet = 0;
        while (true) {
            bet = scanner.nextInt();
            switch (bet) {
                case 0:
                    System.out.println("Thank you for playing slots! See you soon!\n\n");
                    this.stopLever();
                    return;
                case 5:
                    this.wagerAmount = bet;
                    userBalance -= 5;
                    this.spinWheelYes(true, 5);
                    return;
                case 10:
                    this.wagerAmount = bet;
                    userBalance -= 10;
                    this.spinWheelYes(true, 5);
                    return;
                case 20:
                    this.wagerAmount = bet;
                    userBalance -= 20;
                    this.spinWheelYes(true, 5);
                    return;
                case 50:
                    this.wagerAmount = bet;
                    userBalance -= 50;
                    this.spinWheelYes(true, 5);
                    return;
                case 100:
                    this.wagerAmount = bet;
                    userBalance -= 100;
                    this.spinWheelYes(true, 5);
                    return;
                case 250:
                    this.wagerAmount = bet;
                    userBalance -= 250;
                    this.spinWheelYes(true, 5);
                    return;
                default:
                    System.out.println("\u001B[31mThat's not an option.\u001B[0m" +
                            "\nHow much would you like to bet? 5, 10, 20, 50, 100, 250");
            }
        }
    }

    public boolean pullLever() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Would you like to continue? \u001B[32m[Yes]\u001B[0m \u001B[31m[No]\u001B[0m");
        while (true) {
            String choice = scanner1.nextLine();
            switch (choice) {
                case "yes":
                    System.out.println("Your Current Balance is: \u001B[32m" + userBalance + "\u001B[0m");
                    return true;
                case "no":
                    System.out.println("Thank you for playing Slots. Come gamble again!\n\n");
                    return false;
                default:
                    System.out.println("That's not an option. Would you like to continue? \u001B[32m[Yes]\u001B[0m \u001B[31m[No]\u001B[0m");
            }
        }
    }

    public int stopLever() {
        stopGame = 1;
        return stopGame;
    }

    @Override
    public void run() {
        int startGambling = 0;
        System.out.println("\u001B[0mYour Current Balance is: \u001B[32m" + userBalance + "\u001B[0m");

        while (startGambling == 0) {
            placeWager(wagerAmount);

            if (stopGame == 1) {
                break;
            }
            if (checkForjackpot(randomList)){
                payOutForJackpot(100, wagerAmount);
                if (!pullLever()) {
                    startGambling = 1;
                }
            } else if (checkForMatchFive(randomList)) {
                payOutForFive(40, wagerAmount);
                if (!pullLever()) {
                    startGambling = 1;
                }
            } else if (checkForMatchThree(randomList)) {
                payOutForThree(15, wagerAmount);
                if (!pullLever()) {
                    startGambling = 1;
                }
            }
        }
    }
}
