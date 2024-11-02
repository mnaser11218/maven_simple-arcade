package com.github.curriculeon.arcade.numberguess;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.IOConsole;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessPlayer implements PlayerInterface {
    ArcadeAccount arcadeAccount;
    private int counter;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }


    public NumberGuessPlayer(ArcadeAccount arcadeAccount) {
        this.arcadeAccount=arcadeAccount;
    }

    @Override
    public ArcadeAccount getArcadeAccount() {
        return arcadeAccount;
    }

    @Override
    public Integer play() {
        Integer userNumber = new IOConsole().getIntegerInput("[ %s ], Please enter a number", getArcadeAccount().getAccountName());
        counter++;
        return userNumber;
    }

}