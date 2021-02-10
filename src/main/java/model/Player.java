package model;

import java.util.Set;

public class Player {

    private Board board;

    public Player() {
    }

    public Result attack(){
        return null;
    }


    public void addShip(Coordinates c, Ship ship) {
        board.addShip(c, ship);
    }
}
