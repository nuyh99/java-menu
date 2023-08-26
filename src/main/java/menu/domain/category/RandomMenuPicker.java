package menu.domain.category;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomMenuPicker implements MenuPicker {

    private static final int FIRST = 0;

    @Override
    public String next(final List<String> menus) {
        return Randoms.shuffle(menus).get(FIRST);
    }
}
