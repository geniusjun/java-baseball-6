package baseball.view;

import baseball.view.ui.ConsoleReader;
import baseball.view.ui.ConsoleWriter;
import java.util.List;

public class InputView {

    public List<Integer> enterNumber() {
        ConsoleWriter.printMessage("숫자를 입력해주세요 : ");
        return Validator.validateNumber(ConsoleReader.reader());
    }

    private static class Validator {
        private static List<Integer> validateNumber(String message) {
            List<String> numbers = parseStringToList(message);

            return numbers.stream()
                    .map(baseball.global.validator.Validator::checkNumber)
                    .toList();
        }

        private static List<String> parseStringToList(String message) {
            return message.chars()
                    .mapToObj(c -> String.valueOf((char) c))
                    .toList();
        }


    }
}
