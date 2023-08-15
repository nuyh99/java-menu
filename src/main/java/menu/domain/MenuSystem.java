package menu.domain;

import java.util.ArrayList;
import java.util.List;

public final class MenuSystem {
    private static final int MAX_SIZE_SAME_CATEGORY = 2;
    private final RandomNumberGenerator menuGenerator;
    private final List<Integer> categoryOfWeek;

    public MenuSystem(RandomNumberGenerator menuGenerator) {
        this.menuGenerator = menuGenerator;
        categoryOfWeek = new ArrayList<>();
    }

    public void makeMenusOfDay(int day, List<Coach> coaches) {
        int selectedCategory = pickCategory(day);
        coaches.forEach(coach -> {
            decideMenu(selectedCategory, coach);
        });
        categoryOfWeek.add(selectedCategory);
    }

    private int pickCategory(int day) {
        int category = menuGenerator.generate();
        boolean possible = isValidCategory(category);

        if (!possible) return pickCategory(day);
        return category;
    }

    private boolean isValidCategory(int category) {
        return categoryOfWeek.stream()
                .filter(e -> e == category)
                .count() < MAX_SIZE_SAME_CATEGORY;
    }

    private void decideMenu(int category, Coach coach) {
        String menu = ((RandomMenuGenerator) menuGenerator).getMenuFromCategory(category);

        if (!coach.isPossibleMenu(menu)) {
            decideMenu(category, coach);
            return;
        }
        coach.eatenMenus.add(menu);
    }
}
