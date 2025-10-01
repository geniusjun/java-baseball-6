package baseball.controller;

import baseball.config.BaseballConfig;
import baseball.service.ComputerService;
import baseball.service.PlayerService;

public class BaseballController {

    private final ComputerService computerService = BaseballConfig.getInstance().getComputerService();
    private final PlayerService playerService = BaseballConfig.getInstance().getPlayerService();


}

