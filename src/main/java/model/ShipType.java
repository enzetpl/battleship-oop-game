package model;

public enum ShipType {
    AIRCRAFT_CARRIER(5),
    BATTLESHIP(4),
    SUBMARINE(3),
    CRUISER(3),
    DESTOYER(2);

    private final int size;

    ShipType(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
