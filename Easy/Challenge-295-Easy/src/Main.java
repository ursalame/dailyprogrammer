import Controller.LetterTransformerController;
import View.Console;

public class Main {

    public static void main(String[] args) {
        String start = "floor";
        String end = "broke";

        LetterTransformerController letterTransformerController = new LetterTransformerController(new Console());
        letterTransformerController.transform(start, end);
    }
}
