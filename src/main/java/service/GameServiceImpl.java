package service;

import model.*;

import java.util.List;
import java.util.Map;

public class GameServiceImpl implements GameService {

    private HumanPlayer humanPlayer;
    private ComputerPlayer computerPlayer;

    public void startGameWithComputer(HumanPlayer player) {
        humanPlayer = player;
        computerPlayer = new ComputerPlayer();
    }

    public void addShips(Map<Coordinates, Ship> shipMap) {
        for (Coordinates c: shipMap.keySet()) {
            humanPlayer.addShip(c, shipMap.get(c));
        }
    }



}
