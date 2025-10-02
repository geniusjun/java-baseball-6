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

    // 이 매서드로만 접근!
    public static BaseballConfig getInstance() {
        return instance;
    }

    private BaseballConfig() {
    }

    // 컨테이너가 싱글톤이면 그 안의 멤버변수들도 싱글톤이겠지? -> 추후에 지피티 검색해보기
    private final Computer computer = new Computer();
    private final Player player = new Player();


    private final ComputerRepository computerRepository = new ComputerRepository(computer);
    private final PlayerRepository playerRepository = new PlayerRepository(player);

    private final BaseballValidate baseballValidate = new BaseballValidate();

    private final PlayerService playerService = new PlayerService(playerRepository);
    private final ComputerService computerService = new ComputerService(playerService, computerRepository,
            playerRepository, baseballValidate);

    private final BaseballController baseballController = new BaseballController(computerService);


    public BaseballController getBaseballController() {
        return baseballController;
    }

}
