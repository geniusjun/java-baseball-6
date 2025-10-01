package baseball.Repository;

import baseball.config.BaseballConfig;
import baseball.domain.Computer;

public class ComputerRepository {

    Computer computer = BaseballConfig.getInstance().getComputer();

    public Computer getComputer(){
        return computer;
    }

}
