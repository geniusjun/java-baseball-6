package baseball.view.ui;

import baseball.global.exception.CustomException;
import baseball.global.exception.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;

public final class Input {

    public static String Reader() {
        return Console.readLine();
    }

    public static class Validator {
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
