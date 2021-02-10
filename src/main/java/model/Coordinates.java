package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coordinates {
    private int row;
    private int col;
    private Direction direction;

    public Coordinates(int row, int col) {
        this.row = row;
        this.col = col;
        this.direction = Direction.NONE;
    }

    public Coordinates(int row, int col, Direction direction) {
        this.row = row;
        this.col = col;
        this.direction = direction;
    }
}
