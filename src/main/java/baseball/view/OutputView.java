package baseball.view;

import baseball.domain.HintResult;
import baseball.view.ui.ConsoleWriter;

public class OutputView {
    public static final String BALL = "%d볼";
    public static final String STRIKE = "%d스트라이크";
    public static final String BOTH = "%s %s";
    private static final String NOTHING = "낫싱";

    public void start() {
        ConsoleWriter.printlnMessage("숫자 야구 게임을 시작합니다.");
    }


    public void printHintResult(HintResult hintResult) {
        int strike = hintResult.strike();
        int ball = hintResult.ball();

        ConsoleWriter.printlnMessage(generateResultMessage(strike, ball));
    }

    public String generateResultMessage(int strike, int ball) {
        if (strike != 0 && ball != 0) {
            return String.format(BOTH,
                    String.format(BALL, ball),
                    String.format(STRIKE, strike)
            );
        }
        if (ball != 0) {
            return String.format(BALL, ball);
        }
        if (strike != 0) {
            return String.format(STRIKE, strike);
        }
        return NOTHING;
    }

    public void printGameOver() {
        ConsoleWriter.printlnMessage("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
