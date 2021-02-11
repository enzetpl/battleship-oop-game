package pl.pussy.battleshipgame.model;

import lombok.Getter;

@Getter
public class Player {

    private Board board;

    public Player() {
        board = new Board();
    }

    public Result attack(){
        return null;
    }


    public void addShip(Coordinates c, Ship ship) {
        board.addShip(c, ship);
    }
}
