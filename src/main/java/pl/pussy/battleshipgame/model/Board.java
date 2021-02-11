package pl.pussy.battleshipgame.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Board {

    private static final int BOARD_SIZE = 10;

    private List<Ship> ships;
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
    public void addShip(Coordinates coordinates, Ship ship) {
        if(!ships.contains(ship)) {
            if(isPossibleToPutShipOnCoordinates(ship, coordinates)){
                addShipToBoard(coordinates, ship);
            }
        }
    }

    public boolean isPossibleToPutShipOnCoordinates(Ship ship, Coordinates coordinates){
        int startRow = coordinates.getRow();
        int startCol = coordinates.getCol();
        int shipSize = ship.getType().getSize();
        if(coordinates.getDirection()==Direction.HORRIZONTALLY) {
            for (int i = startCol; i < startCol+shipSize; i++) {
                if(boardCells[startRow][i]!=BoardCell.EMPTY)
                    return false;
            }
            return true;
        }
        if(coordinates.getDirection()==Direction.VERTICALLY) {
            for (int i = startRow; i < startRow+shipSize; i++) {
                if(boardCells[i][startRow]!=BoardCell.EMPTY)
                    return false;
            }
            return true;
        }
        return true;
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

}
