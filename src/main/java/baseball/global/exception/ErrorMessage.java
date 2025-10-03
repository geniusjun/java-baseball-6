package baseball.global.exception;

public enum ErrorMessage {

    BLANK_INPUT_ERROR("빈 문자열이 입력되었습니다."),
    NOT_NUMBER_ERROR("숫자만을 입력해주세요"),
    INVALID_RANGE_ERROR("1~9까지의 숫자를 입력해주세요"),
    INVALID_LENGTH_ERROR("숫자를 다시 입력해주세요(3자리수)"),
    DUPLICATED_ERROR("서로 다른 3개의 숫자여야 합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
