package baseball.global.validator;

import baseball.global.exception.CustomException;
import baseball.global.exception.ErrorMessage;

public class Validator {

    public static int checkNumber(String message) {
        if (!isNumber(message)) {
            throw CustomException.from(ErrorMessage.NOT_NUMBER_ERROR);
        }
        return Integer.parseInt(message);
    }

    private static boolean isNumber(String str) { // 범위 체크는 도메인에서..! 사실 0을 넣었을 시에 범위 에러밖에 없음.. 나머진 length()에서 걸릴듯.
        return (str.charAt(0) >= '0' && str.charAt(0) <= '9');
    }
}
