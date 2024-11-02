package com.github.curriculeon.arcade;

import java.util.ArrayList;
import java.util.List;

abstract public class AbstractGame implements GameInterface{
private final List<PlayerInterface> players;
    private int randomNumber;



    public AbstractGame(List<PlayerInterface> players) {
        this.players = players;
    }

    public AbstractGame() {
        this(new ArrayList<>());
    }

    public List<PlayerInterface> getPlayerList() {
        return players;
    }

}
