package baseball.view.ui;

public class ConsoleWriter {
    public static void printMessage(String message) {
        System.out.print(message);
    }

    public static void printlnMessage(String message) {
        System.out.println(message);
    }

    public static void printFormat(String message, Object... args) {
        printlnMessage(String.format(message, args));
    }
}
