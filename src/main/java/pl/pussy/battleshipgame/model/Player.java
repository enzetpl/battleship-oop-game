package pl.pussy.battleshipgame.model;

import lombok.Getter;

@Getter
public class Player {

    private Board board;

    public Player() {
        board = new Board();
    }

    public Result attack(Coordinates coordinates, Board oppositePlayerBoard){
        BoardCell attackedCell = oppositePlayerBoard.getCell(coordinates);
        System.out.println(attackedCell+ "|"+coordinates.getRow()+"|"+coordinates.getCol());
        if (attackedCell.equals(BoardCell.EMPTY_ATTACKED) || attackedCell.equals(BoardCell.SHIP_ATTACKED) || attackedCell.equals(BoardCell.NEXT_TO_THE_SUNKEN_SHIP)) {
            return Result.BAD_COORDINATES;
        } else if(attackedCell.equals(BoardCell.EMPTY)) {
            oppositePlayerBoard.setCell(coordinates, BoardCell.EMPTY_ATTACKED);
            return Result.MISSED;
        } else if(attackedCell.equals(BoardCell.SHIP)) {
            oppositePlayerBoard.setCell(coordinates, BoardCell.SHIP_ATTACKED);
            return oppositePlayerBoard.checkIfWin(coordinates, oppositePlayerBoard);
        }
        throw new IllegalArgumentException();
    }


    public void addShip(Coordinates c, Ship ship) {
        board.addShip(c, ship);
    }
}
