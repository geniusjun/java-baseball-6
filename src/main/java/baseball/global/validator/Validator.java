package baseball.global.validator;

import baseball.global.exception.CustomException;
import baseball.global.exception.ErrorMessage;

public class Validator {

    public void validateStartInput(String playerInput) {
        if (playerInput.length() != 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; i++) {
            if (playerInput.charAt(i) > 0 && playerInput.charAt(i) < 10) {
                throw new IllegalArgumentException();
            }
        }
    }


    public boolean validateReStartInput(String playerInput) {
        if (playerInput.equals("1")) {
            return true;
        } else if (playerInput.equals("2")) {
            System.out.println("게임 종료");
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean isCorrect(int strikeCnt) {
        if (strikeCnt == 3) {
            return true;
        }
        return false;
    }


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
