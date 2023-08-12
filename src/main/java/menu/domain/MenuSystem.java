package menu.domain;

import java.util.ArrayList;
import java.util.List;

public final class MenuSystem {
    private final RandomNumberGenerator menuGenerator;
    private final List<List<String>> menuResultOfWeek;

    public MenuSystem(RandomNumberGenerator menuGenerator) {
        this.menuGenerator = menuGenerator;
        menuResultOfWeek = new ArrayList<>();
    }

    public void makeMenusOfDay(int day, List<Coach> coaches) {
        List<String> pickedMenu = new ArrayList<>();

        coaches.forEach(coach -> {
            pickedMenu.add(getPossibleMenu(pickedMenu, coach));
        });

        menuResultOfWeek.add(pickedMenu);
    }

    private String getPossibleMenu(List<String> pickedMenu, Coach coach) {
        String menu = menuGenerator.generate();
        if (pickedMenu.contains(menu) || coach.isPossibleMenu(menu)) return getPossibleMenu(pickedMenu, coach);
        coach.eatenMenus.add(menu);
        return menu;
    }

}
