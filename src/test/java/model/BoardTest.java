package model;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Board board = new Board();

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7,8,9})
    void testConstructorFillingByEmpty(int value){
        for (int i = 0; i < 10; i++) {
            Coordinates coordinates = new Coordinates(value,i);
            assertEquals(BoardCell.EMPTY, board.getCell(coordinates));
        }
    }
    @Test
    void addShipDestroyer(){
        //given
        Coordinates coordinates = new Coordinates(0,0, Direction.HORRIZONTALLY);
        Ship ship = new Ship(ShipType.DESTOYER);
        //when
        BoardCell[][] cells = board.getBoardCells();
        cells[0][0] = BoardCell.SHIP;
        cells[0][1] = BoardCell.SHIP;
        board.addShip(coordinates, ship);
        //then
        assertArrayEquals(cells, board.getBoardCells());
   }

}