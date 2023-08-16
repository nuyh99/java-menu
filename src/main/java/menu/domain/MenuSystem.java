package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class MenuSystem {
    private static final int MAX_SIZE_SAME_CATEGORY = 2;
    private final RandomNumberGenerator menuGenerator;
    private final List<String> categoryOfWeek;

    public List<String> getCategoryOfWeek() {
        return categoryOfWeek;
    }

    public MenuSystem(RandomNumberGenerator menuGenerator) {
        this.menuGenerator = menuGenerator;
        categoryOfWeek = new ArrayList<>();
    }

    public void makeMenusOfDay(int day, List<Coach> coaches) {
        int selectedCategory = pickCategory(day);
        coaches.forEach(coach -> {
            decideMenu(selectedCategory, coach);
        });
        categoryOfWeek.add(convertCategoryToName(selectedCategory));
    }

    private String convertCategoryToName(int category) {
        return Arrays.stream(MenuData.values())
                .filter(data -> data.category() == category)
                .findAny()
                .map(MenuData::getName)
                .orElse(null);

    }

    private int pickCategory(int day) {
        int category = menuGenerator.generate();
        boolean possible = isValidCategory(category);

        if (!possible) return pickCategory(day);
        return category;
    }

    private boolean isValidCategory(int category) {
        String name = convertCategoryToName(category);
        return categoryOfWeek.stream()
                .filter(e -> e.equals(name))
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
