package baseball.Repository;

import baseball.config.BaseballConfig;
import baseball.domain.Player;

public class PlayerRepository {

    Player player = BaseballConfig.getInstance().getPlayer();

    public Player getPlayer(){
        return player;
    }

}
