package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.domain.Computer;
import baseball.domain.HintResult;
import baseball.domain.Numbers;
import baseball.view.OutputView;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HintGeneratorTest {

    Computer computer;
    OutputView outputView;

    @BeforeEach
    void setUp() {
        computer = new Computer();
        outputView = new OutputView();
        computer.setNumbers(List.of(1, 2, 3));
    }

    @Test
    public void 볼1_스트라이크1() {
        // given
        List<Integer> player = List.of(1, 3, 4);
        // when
        HintResult hintResult = computer.generateHintResult(Numbers.from(player));
        // then
        int strike = hintResult.strike();
        int ball = hintResult.ball();
        assertEquals("1볼 1스트라이크", outputView.generateResultMessage(strike, ball));
    }

    @Test
    public void 볼2_스트라이크1() {
        // given
        List<Integer> player = List.of(1, 3, 2);
        // when
        HintResult hintResult = computer.generateHintResult(Numbers.from(player));
        // then
        int strike = hintResult.strike();
        int ball = hintResult.ball();
        assertEquals("2볼 1스트라이크", outputView.generateResultMessage(strike, ball));
    }

    @Test
    public void 스트라이크3() {
        // given
        List<Integer> player = List.of(1, 2, 3);
        // when
        HintResult hintResult = computer.generateHintResult(Numbers.from(player));
        // then
        int strike = hintResult.strike();
        int ball = hintResult.ball();
        assertEquals("3스트라이크", outputView.generateResultMessage(strike, ball));
    }

    @Test
    public void 낫싱() {
        // given
        List<Integer> player = List.of(4, 5, 6);
        // when
        HintResult hintResult = computer.generateHintResult(Numbers.from(player));
        // then
        int strike = hintResult.strike();
        int ball = hintResult.ball();
        assertEquals("낫싱", outputView.generateResultMessage(strike, ball));
    }

    @Test
    public void 볼3() {
        // given
        List<Integer> player = List.of(3, 1, 2);
        // when
        HintResult hintResult = computer.generateHintResult(Numbers.from(player));
        // then
        int strike = hintResult.strike();
        int ball = hintResult.ball();
        assertEquals("3볼", outputView.generateResultMessage(strike, ball));
    }

    @Test
    public void sout() {
        System.out.println("hi");
    }

}
