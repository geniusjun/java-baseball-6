package baseball.domain;

import baseball.global.exception.CustomException;
import baseball.global.exception.ErrorMessage;
import java.util.List;

public class Numbers {

    private static final int COUNT = 3;
    private List<Number> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = Validator.validate(numbers);
    }

    public int get(int index) {
        return numbers.get(index).getValue();
    }

    public int getSize() {
        return numbers.size();
    }

    private static class Validator {

        public static List<Number> validate(List<Integer> numbers) {
            validateDuplicated(numbers);
            validateLength(numbers);
            return numbers.stream()
                    .map(Number::new)
                    .toList();
        }

        private static void validateLength(List<Integer> numbers) {
            if (numbers.size() != COUNT) {
                throw CustomException.from(ErrorMessage.INVALID_LENGTH_ERROR);
            }
        }

        private static void validateDuplicated(List<Integer> numbers) {
            if (hasDuplicatedNumber(numbers)) {
                throw CustomException.from(ErrorMessage.DUPLICATED_ERROR);
            }
        }

        private static boolean hasDuplicatedNumber(List<Integer> numbers) {
            return numbers.size() != calculateUniqueNumberCount(numbers);
        }

        private static int calculateUniqueNumberCount(List<Integer> numbers) {
            return (int) numbers.stream()
                    .distinct()
                    .count();
        }

    }
}
