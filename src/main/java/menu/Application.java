package menu;

import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        new Controller(new InputView(), new OutputView()).run();
    }
}
