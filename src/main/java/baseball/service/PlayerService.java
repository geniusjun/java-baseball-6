package baseball.service;

import baseball.domain.Player;
import baseball.validation.BaseballValidate;
import camp.nextstep.edu.missionutils.Console;

public class PlayerService {

    private final Player player;

    public PlayerService(Player player) {
        this.player = player;
    }

    public void playerInput(Player player){
        player.setInput(Console.readLine());
    }

}
