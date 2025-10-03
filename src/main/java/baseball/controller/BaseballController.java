package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.HintResult;
import baseball.domain.Numbers;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.function.Supplier;

public class BaseballController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Computer computer;

    public BaseballController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.outputView.start();
        this.computer = new Computer();
    }

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            computer.generate();
            isRunning = play();
        }
    }

    private boolean play() {
        while (true) {
            Numbers numbers = retry(() -> {
                return new Numbers(inputView.enterNumber());
            });
            HintResult hintResult = computer.generateHintResult(numbers);
            outputView.printHintResult(hintResult);
            if (isSuccess(hintResult)) {
                break;
            }
        }
        outputView.printGameOver();
        return retry(() -> {
            return inputView.enterRestartOrQuit().isRunning();
        });
    }

    private boolean isSuccess(HintResult hintResult) {
        return hintResult.strike() == 3;
    }

    private static <T> T retry(Supplier<T> supplier) {

        while (true) {
            //    try {
            //        return supplier.get();
            //    } catch (IllegalArgumentException e) {
            //        ConsoleWriter.printlnMessage(e.getMessage());
            //    }  -> 에러 메시지 보고 싶다면 이렇게
            return supplier.get();
        }
    }
}

