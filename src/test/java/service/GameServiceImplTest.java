package service;

import pl.pussy.battleshipgame.model.HumanPlayer;
import pl.pussy.battleshipgame.model.Ship;
import pl.pussy.battleshipgame.model.ShipType;
import org.junit.jupiter.api.Test;
import pl.pussy.battleshipgame.service.ComputerPlayerService;
import pl.pussy.battleshipgame.service.GameServiceImpl;

import java.util.ArrayList;
import java.util.List;

class GameServiceImplTest {

    private ComputerPlayerService computerPlayerService = new ComputerPlayerService();
    private GameServiceImpl gameService = new GameServiceImpl(computerPlayerService);

    @Test
    void addComputerShips() {
        gameService.startGameWithComputer(new HumanPlayer());
        gameService.addComputerShips(getShips());
    }

    private List<Ship> getShips(){
        List<Ship> ships = new ArrayList<>();
        ships.add(new Ship(ShipType.DESTROYER));
        ships.add(new Ship(ShipType.AIRCRAFT_CARRIER));
        ships.add(new Ship(ShipType.BATTLESHIP));
        ships.add(new Ship(ShipType.CRUISER));
        ships.add(new Ship(ShipType.SUBMARINE));
        return ships;
    }
}