package baseball;

import baseball.config.BaseballConfig;
import baseball.controller.BaseballController;

public class Application {
    public static void main(String[] args) {

        BaseballController baseballController = BaseballConfig.getInstance().getBaseballController();
        baseballController.start();

        baseballController.count();

    }
}
