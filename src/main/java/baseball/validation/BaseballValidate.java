package baseball.validation;

public class BaseballValidate {

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
}
