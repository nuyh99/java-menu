package menu.domain.category;

import java.util.List;

public abstract class Category {

    private final int number;
    private final List<String> menus;
    private final MenuPicker menuPicker;

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
}
