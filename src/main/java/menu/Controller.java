package menu;

import menu.domain.Coach;
import menu.domain.MenuSystem;
import menu.domain.RandomMenuGenerator;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public final class Controller {

    private static final int REPEAT_SIZE = 5;
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        MenuSystem menuSystem = new MenuSystem(new RandomMenuGenerator());
        List<Coach> coaches = makeCoachesInformation();

        for (int i = 0; i < REPEAT_SIZE; i++) {
            recommendMenus(menuSystem, i, coaches);
        }

        outputView.printMenuResult(menuSystem.getCategoryOfWeek(), coaches);
    }

    private void recommendMenus(MenuSystem menuSystem, int day, List<Coach> coaches) {
        menuSystem.makeMenusOfDay(day, coaches);
    }

    private List<Coach> makeCoachesInformation() {
        List<Coach> coaches = new ArrayList<>();
        List<String> names = getCoachesName();

        names.forEach(coach -> {
            List<String> menus = getBanMenus(coach);
            coaches.add(new Coach(coach, menus));
        });

        return coaches;
    }

    private List<String> getCoachesName() {
        outputView.printInputCoachesName();

        return inputView.readCoachesName();
    }

    private List<String> getBanMenus(String coach) {
        outputView.printInputBanMenus(coach);
        return inputView.readBanMenus();
    }
}
