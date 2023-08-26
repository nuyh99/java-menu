package menu.domain.controller;

import menu.domain.service.MenuService;
import menu.domain.view.InputView;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class MenuController {

    public void run() {
        final MenuService menuService = doUntilValid(MenuService::of, InputView::readNames);
        final List<String> names = menuService.getAllCoachNames();

        names.forEach(name -> updateBannedMenus(menuService, name));
    }

    private <T, R> R doUntilValid(final Function<T, R> function, final Supplier<T> supplier) {
        try {
            final T parameter = supplier.get();
            return function.apply(parameter);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return doUntilValid(function, supplier);
    }

    private void updateBannedMenus(final MenuService menuService, final String name) {
        try {
            final List<String> bannedMenus = InputView.readBannedMenusFor(name);
            menuService.updateBannedMenusFor(name, bannedMenus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            updateBannedMenus(menuService, name);
        }
    }
}
