package menu.domain.coach;

import java.util.List;

public class EatenMenus {

    final List<String> menus;

    public EatenMenus(final List<String> menus) {
        this.menus = menus;
    }

    public boolean eatIfPossible(final String menu) {
        if (hasEaten(menu)) {
            return false;
        }

        return menus.add(menu);
    }

    private boolean hasEaten(final String menu) {
        return menus.contains(menu);
    }
}
