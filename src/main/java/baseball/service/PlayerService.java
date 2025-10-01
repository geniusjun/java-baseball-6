package baseball.service;

import baseball.Repository.PlayerRepository;
import baseball.config.BaseballConfig;
import baseball.domain.Player;
import camp.nextstep.edu.missionutils.Console;

public class PlayerService {

    private final PlayerRepository playerRepository = BaseballConfig.getInstance().getPlayerRepository();


    public void playerInput(Player player){
        player.setInput(Console.readLine());
    }

}
