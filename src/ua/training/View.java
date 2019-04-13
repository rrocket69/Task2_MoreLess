package ua.training;

public class View {
    public static final String MIN = "minimal number";
    public static final String MAX = "maximal number";
    public static final String TRY = "Last tries: ";
    public static final String FORMAT = "Formats: ";
    public static final String MORE = "More, ";
    public static final String LESS = "Less, ";
    public static final String OUT = "out of range ";
    public static final String VICTORY = "You won!";
    public static final String ASK_INPUT = "Please input: ";
    public static final String ERROR_FORMAT = "Wrong format, try again: ";
    public static final String HISTORY_INT = "Integer";
    public static final String HISTORY_WRONG = "Wrong Format";

    public void printMessage(String message) {
        System.out.println(message);
    }
}
