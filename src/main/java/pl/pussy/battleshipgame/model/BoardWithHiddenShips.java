package pl.pussy.battleshipgame.model;

public class BoardWithHiddenShips {
    final int BOARD_SIZE = 10;
    private Board board;

    public BoardWithHiddenShips(Board another) {
        this.board = new Board();
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                Coordinates coordinates = new Coordinates(i,j);
                if(board.getCell(coordinates).equals(BoardCell.SHIP)) {
                    this.board.setCell(coordinates, BoardCell.EMPTY);
                }
                this.board.setCell(coordinates, BoardCell.valueOf(another.getCell(coordinates).name()));
            }
        }
    }

    public Board getBoard() {
        return board;
    }

}
