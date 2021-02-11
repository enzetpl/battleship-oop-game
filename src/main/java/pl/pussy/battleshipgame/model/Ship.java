package pl.pussy.battleshipgame.model;

import lombok.Data;

@Data
public class Ship {

    private ShipType type;
    private boolean Setted;
    private boolean isSunk;
    private boolean isHited;

    public Ship(ShipType type) {
        this.type = type;
    }
}
