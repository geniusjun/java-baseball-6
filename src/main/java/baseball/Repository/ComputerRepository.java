package baseball.Repository;

import baseball.domain.Computer;

public class ComputerRepository {

    private final Computer computer;

    public ComputerRepository(Computer computer) {
        this.computer = computer;
    }

    public Computer getComputer(){
        return computer;
    }

}
