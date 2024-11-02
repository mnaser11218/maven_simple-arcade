package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.PlayerInterface;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer implements PlayerInterface {
    ArcadeAccount arcadeAccount;

    public SlotsPlayer(ArcadeAccount arcadeAccount) {
        this.arcadeAccount=arcadeAccount;
    }

    @Override
    public ArcadeAccount getArcadeAccount() {
        return arcadeAccount;
    }

    @Override
    public int getCounter() {
        return 0;
    }


    public Integer play() {
        System.out.println("player is playing");
        return null;
    }
}