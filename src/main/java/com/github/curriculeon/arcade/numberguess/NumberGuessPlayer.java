package com.github.curriculeon.arcade.numberguess;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.PlayerInterface;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessPlayer implements PlayerInterface {
    ArcadeAccount arcadeAccount;
    @Override
    public ArcadeAccount getArcadeAccount() {
        return arcadeAccount;
    }

    @Override
    public void setArcadeAccount(ArcadeAccount arcadeAccount) {
        this.arcadeAccount = arcadeAccount;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }

}