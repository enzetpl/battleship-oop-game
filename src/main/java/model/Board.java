package model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Board {

    private static final int BOARD_SIZE = 10;
    List<Ship> ships;


    private BoardCell [][] boardCells;

    public BoardCell getCell(Coordinates coordinates) {
        return boardCells[coordinates.getRow()][coordinates.getCol()];
    }

    public BoardCell setCell(Coordinates coordinates, BoardCell cell) {
        return boardCells[coordinates.getRow()][coordinates.getCol()] = cell;
    }

    public Board() {
        boardCells = new BoardCell[BOARD_SIZE][BOARD_SIZE];
        this.ships = initializeShips();
        initializeBoardByEmptyCells();
    }

    private void initializeBoardByEmptyCells() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                boardCells[i][j] = BoardCell.EMPTY;
            }
        }
    }
    private List<Ship> initializeShips() {
        List<Ship> ships = new ArrayList<>();

        return ships;
    }
    public void addShip(Coordinates coordinates, Ship ship) {
        if(!ships.contains(ship)) {
            if(areCoordinatesCorrect(coordinates, ship.getType().getSize())){
                addShipToBoard(coordinates, ship);
            }

        }
    }

    private void addShipToBoard(Coordinates coordinates, Ship ship) {
        if(coordinates.getDirection().equals(Direction.HORRIZONTALLY)){
            addShipHorizontally(coordinates, ship);
        } else if(coordinates.getDirection().equals(Direction.VERTICALLY)) {
            addShipVertically(coordinates, ship);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void addShipVertically(Coordinates coordinates, Ship ship) {
        int col = coordinates.getCol();
        for (int i = coordinates.getRow(); i < coordinates.getRow()+ship.getType().getSize(); i++) {
            boardCells[i][col] = BoardCell.SHIP;
        }
    }

    private void addShipHorizontally(Coordinates coordinates, Ship ship) {
        int row = coordinates.getRow();
        for (int i = coordinates.getCol(); i < coordinates.getCol()+ship.getType().getSize(); i++) {
            boardCells[row][i] = BoardCell.SHIP;
        }
    }

    private boolean areCoordinatesCorrect(Coordinates coordinates, int size) {
        return true;
    }
}
