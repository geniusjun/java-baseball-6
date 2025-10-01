package baseball;

import baseball.config.BaseballConfig;
import baseball.controller.BaseballController;

public class Application {
    public static void main(String[] args) {

        BaseballController baseballController = BaseballConfig.getInstance().getBaseballController();
        System.out.println("숫자 야구 게임을 시작합니다.");
        baseballController.start();

        baseballController.count();

    }
}
