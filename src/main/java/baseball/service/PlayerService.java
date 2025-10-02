package baseball.service;

import baseball.Repository.PlayerRepository;
import baseball.domain.Player;
import camp.nextstep.edu.missionutils.Console;

public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void playerInput(Player player) {
        player.setInput(Console.readLine());
    }


}
