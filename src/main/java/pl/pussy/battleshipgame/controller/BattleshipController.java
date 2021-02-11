package pl.pussy.battleshipgame.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import pl.pussy.battleshipgame.model.*;
import org.springframework.web.bind.annotation.*;
import pl.pussy.battleshipgame.service.GameServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BattleshipController {

    private final GameServiceImpl gameService;

    @PostMapping("/start")
    public void startGame(@RequestBody HumanPlayer player){
        gameService.startGameWithComputer(player);
    }

    @PostMapping("/addShips")
    public void setShips(@RequestBody List<CoordinatesShipTypeDTO> dtos) {
        gameService.addShips(dtos);
    }
    @GetMapping("/a")
    public String setShipsa() {
        System.out.println("ADA");
        return "DSDS";
    }
}
