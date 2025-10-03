package baseball.view.ui;

import baseball.global.exception.CustomException;
import baseball.global.exception.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;

public final class ConsoleReader {

    public static String reader() {
        return Validator.validate(Console.readLine());
    }

    private static class Validator {
        public static String validate(String message) {
            ValidateInputBlank(message);
            return message;
        }

        private static void ValidateInputBlank(String message) {

            if (message.isBlank()) {
                throw CustomException.from(ErrorMessage.BLANK_INPUT_ERROR);
            }

        }
    }
}
