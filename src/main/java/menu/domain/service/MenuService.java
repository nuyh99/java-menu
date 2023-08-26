package menu.domain.service;

import menu.domain.MenuRecommender;
import menu.domain.category.Category;

import java.util.List;

public class MenuService {

    private MenuRecommender menuRecommender;

    private MenuService(final MenuRecommender menuRecommender) {
        this.menuRecommender = menuRecommender;
    }

    public static MenuService of(final List<String> names) {
        final MenuRecommender menuRecommender = MenuRecommender.of(names);

        return new MenuService(menuRecommender);
    }

    public List<String> getAllCoachNames() {
        return menuRecommender.getAllCoachNames();
    }

    public void updateBannedMenusFor(final String name, final List<String> bannedMenus) {
        if (bannedMenus.stream().allMatch(Category::exist)) {
            menuRecommender.updateBannedMenusTo(name, bannedMenus);
        }

        throw new IllegalArgumentException("[ERROR] 싫어하는 메뉴는 존재하는 메뉴만 입력할 수 있습니다.");
    }
}
