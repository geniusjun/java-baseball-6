package baseball.Repository;

import baseball.domain.Player;

public class PlayerRepository {

    private final Player player;

    public PlayerRepository(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }


}
