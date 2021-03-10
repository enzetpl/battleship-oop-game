package pl.pussy.battleshipgame.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pussy.battleshipgame.model.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {


    private final ComputerPlayerService computerPlayerService;
    private HumanPlayer humanPlayer;
    private ComputerPlayer computerPlayer;

    public void startGameWithComputer(HumanPlayer player) {
        humanPlayer = player;
        computerPlayer = new ComputerPlayer();
    }

    public void addShips(List<CoordinatesShipTypeDTO> dtos) {
        Map<Coordinates, Ship> shipMap = convertCoordinatesShipDtoToMap(dtos);
        for (Coordinates c: shipMap.keySet()) {
            humanPlayer.addShip(c, shipMap.get(c));
        }
        addComputerShips(List.copyOf(shipMap.values()));
    }

    private Map<Coordinates, Ship> convertCoordinatesShipDtoToMap(List<CoordinatesShipTypeDTO> dtos) {
        List<Coordinates> coordinates = dtos.stream()
                .map(CoordinatesShipTypeDTO::getCoordinates)
                .collect(Collectors.toList());
        List<Ship> ships = dtos.stream()
                .map(dto->new Ship(ShipType.valueOf(dto.getShipType())))
                .collect(Collectors.toList());
        return IntStream.range(0, coordinates.size()).boxed()
                .collect(Collectors.toMap(coordinates::get, ships::get));
    }

    public void addComputerShips(List<Ship> ships) {
        for (Ship ship: ships) {
            Coordinates coordinates = computerPlayerService.getCoordinatesForShip(computerPlayer.getBoard(), ship);
            computerPlayer.addShip(coordinates, ship);
        }
    }


    public Result attack(Coordinates coordinates) {
       return humanPlayer.attack(coordinates, computerPlayer.getBoard());
    }

    public Result compterAttack() {
        Result result;
        do {
            int row = new Random().nextInt(10);
            int col = new Random().nextInt(10);
            Coordinates coordinates = new Coordinates(row, col);
            result = computerPlayer.attack(coordinates, humanPlayer.getBoard());
        }while (result == Result.BAD_COORDINATES);
        return result;
    }

    public Board getPlayerBoard() {
        return humanPlayer.getBoard();
    }

    public Board getComputerBoard() {
        Board board = new Board(computerPlayer.getBoard());
        return new BoardWithHiddenShips(board).getBoard();
    }

    public Board getComputerBoardWithShips() {
        return computerPlayer.getBoard();
    }
}
