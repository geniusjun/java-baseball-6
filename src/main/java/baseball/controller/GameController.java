package baseball.controller;


import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.service.ComputerService;
import baseball.service.PlayerService;
import baseball.validation.BaseballValidate;

public class GameController {

    private final Computer computer;
    private final Player player;

    public GameController(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }



    ComputerService computerService = new ComputerService(computer, player);
    PlayerService playerService = new PlayerService(player);



}

