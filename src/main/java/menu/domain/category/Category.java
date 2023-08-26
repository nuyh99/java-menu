package menu.domain.category;

import java.util.List;

public abstract class Category {

    private final int number;
    private final List<String> menus;
    private final MenuPicker menuPicker;

    private static final List<Category> allCategories = List.of(
            Japanese.create(),
            Korean.create(),
            Chinese.create(),
            Asian.create(),
            American.create()
    );

    private Category(final int number, final List<String> menus, final MenuPicker menuPicker) {
        this.number = number;
        this.menus = menus;
        this.menuPicker = menuPicker;
    }

    protected Category(final int number, final List<String> menus) {
        this(number, menus, new RandomMenuPicker());
    }

    public String recommendNextMenu() {
        return menuPicker.next(menus);
    }

    public static boolean exist(final String menu) {
        return allCategories.stream()
                .map(category -> category.menus)
                .anyMatch(categories -> categories.contains(menu));
    }
}
