package pl.pussy.battleshipgame.service;

import pl.pussy.battleshipgame.model.Board;
import pl.pussy.battleshipgame.model.Coordinates;
import pl.pussy.battleshipgame.model.Direction;
import pl.pussy.battleshipgame.model.Ship;
import org.springframework.stereotype.Service;

@Service
public class ComputerPlayerService {

    private static final int BOARD_SIZE = 10;

    public Coordinates getCoordinatesForShip(Board board, Ship ship) {
        while(true) {
            int max = BOARD_SIZE - ship.getType().getSize();
            int row = getRandomCell(max);
            int col = getRandomCell(max);
            Direction direction = getRandomDirection();
            Coordinates coordinates = new Coordinates(row, col, direction);
            if (board.isPossibleToPutShipOnCoordinates(ship, coordinates)) {
                return coordinates;
            }
        }
    }

    private Direction getRandomDirection() {
        double randomNumber =  Math.random();
        if(randomNumber>0.5)
            return Direction.HORRIZONTALLY;
        return Direction.VERTICALLY;
    }

    private int getRandomCell(int max) {
        return (int) (Math.random() * (max + 1));
    }
}
