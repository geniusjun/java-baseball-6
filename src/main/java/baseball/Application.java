package baseball;


import baseball.controller.GameController;
import baseball.domain.Computer;
import baseball.domain.Player;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Player player = new Player();

        GameController gameController = new GameController(computer, player);



    }
}
