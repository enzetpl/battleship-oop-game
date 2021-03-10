package pl.pussy.battleshipgame.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import pl.pussy.battleshipgame.model.*;
import org.springframework.web.bind.annotation.*;
import pl.pussy.battleshipgame.service.GameServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class BattleshipController {

    private final GameServiceImpl gameService;

    @PostMapping("/start")
    public void startGame(@RequestBody HumanPlayer player){
        gameService.startGameWithComputer(player);
    }

    @PostMapping("/ship")
    public void setShips(@RequestBody List<CoordinatesShipTypeDTO> dtos) {
        gameService.addShips(dtos);
    }

    @PostMapping("/player/attack")
    public ResponseEntity<?> attack(@RequestBody Coordinates coordinates) {
        Result result = gameService.attack(coordinates);
        return ResponseEntity.ok(result);
    }
    @PostMapping("/computer/attack")
    public ResponseEntity<?> computerattack() {
        Result result = gameService.compterAttack();
        return ResponseEntity.ok(result);
    }
    @GetMapping("/player/board")
    public ResponseEntity<?> getPlayerBoard() {
        return ResponseEntity.ok(gameService.getPlayerBoard());
    }
    @GetMapping("/computer/board")
    public ResponseEntity<?> getComputerBoard() {
        return ResponseEntity.ok(gameService.getComputerBoard());
    }
    @GetMapping("/computer/boardShips")
    public ResponseEntity<?> getComputerBoardWithShips() {
        return ResponseEntity.ok(gameService.getComputerBoardWithShips());
    }
}
