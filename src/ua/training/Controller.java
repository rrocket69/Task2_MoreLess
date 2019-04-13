package ua.training;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;


    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void startAction() {
        Scanner scanner = new Scanner(System.in);

        model.rand(askInputNum(scanner, View.MIN),
                askInputNum(scanner, View.MAX));

        while (model.checkInGame()) view.printMessage(model.checkRange(askInputNum(scanner, model.inRange())));

        view.printMessage(View.TRY + model.getInputs());
        view.printMessage(View.FORMAT + model.getResults());
    }

    public int askInputNum(Scanner scanner, String output) {
        view.printMessage(View.TRY + model.getInputs());
        view.printMessage(View.ASK_INPUT + output);

        while (!scanner.hasNextInt()) {
            view.printMessage(View.ERROR_FORMAT);
            model.logHistory(View.HISTORY_WRONG, scanner.next());
        }
        return scanner.nextInt();
    }

}
