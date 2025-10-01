package baseball.config;

import baseball.Repository.ComputerRepository;
import baseball.Repository.PlayerRepository;
import baseball.controller.BaseballController;
import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.service.ComputerService;
import baseball.service.PlayerService;
import baseball.validation.BaseballValidate;

public class BaseballConfig {

    // 싱글톤 DI컨테이너 따라하기
    private static final BaseballConfig instance = new BaseballConfig();

    private BaseballConfig(){
    };

    public static BaseballConfig getInstance(){
        return instance;
    }


    // 컨테이너가 싱글톤이면 그 안의 멤버변수들도 싱글톤이겠지? -> 추후에 지피티 검색해보기
    private final static Computer computer = new Computer();
    private final static Player player = new Player();

    private final static BaseballController baseballController = new BaseballController();

    private final static ComputerService computerService = new ComputerService();
    private final static PlayerService playerService = new PlayerService();

    private final static ComputerRepository computerRepository = new ComputerRepository();
    private final static PlayerRepository playerRepository = new PlayerRepository();

    private final static BaseballValidate baseballValidate = new BaseballValidate();



    public BaseballController getBaseballController(){
        return baseballController;
    }

    public ComputerService getComputerService(){
        return computerService;
    }

    public PlayerService getPlayerService(){
        return playerService;
    }

    public ComputerRepository getComputerRepository(){
        return computerRepository;
    }

    public PlayerRepository getPlayerRepository(){
        return playerRepository;
    }

    public BaseballValidate getBaseballValidate(){
        return baseballValidate;
    }

}
