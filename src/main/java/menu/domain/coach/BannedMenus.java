package menu.domain.coach;

import java.util.List;

public class BannedMenus {

    private static final int MAX_BANNED_MENUS_SIZE = 2;

    final List<String> menus;

    public BannedMenus(final List<String> menus) {
        validate(menus);
        this.menus = menus;
    }

    private void validate(final List<String> menus) {
        if (menus.size() > MAX_BANNED_MENUS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 못 먹는 메뉴는 0 ~ 2개여야 합니다.");
        }
    }

    public boolean hasBanned(final String menu) {
        return menus.contains(menu);
    }
}
