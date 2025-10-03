package baseball.domain;

import baseball.global.exception.CustomException;
import baseball.global.exception.ErrorMessage;

public class Number {

    private static final int START = 1;
    private static final int END = 9;
    private Integer value;

    public Number(Integer value) {
        Validator.validateRange(value);
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    private static class Validator {
        public static void validateRange(Integer value) {
            if (isInValidaRange(value, START, END)) {
                throw CustomException.from(ErrorMessage.INVALID_RANGE_ERROR);
            }
        }

        private static boolean isInValidaRange(Integer value, int start, int end) {
            return value < start || value > end;
        }
    }
}
