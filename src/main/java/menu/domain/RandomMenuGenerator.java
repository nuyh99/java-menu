package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RandomMenuGenerator implements RandomNumberGenerator{
    private static final int CATEGORY_LOWER_BOUND = 1;
    private static final int CATEGORY_UPPER_BOUND = 5;

    @Override
    public String generate() {
        int category = Randoms.pickNumberInRange(CATEGORY_LOWER_BOUND,CATEGORY_UPPER_BOUND);

        List<String> menus = getMenusByCategory(category).menus();
        if(menus == null) return generate();

        return Randoms.shuffle(menus).get(0);
    }

    private MenuData getMenusByCategory(int category) {
        return Arrays.stream(MenuData.values())
                .filter(menu -> menu.category() == category)
                .findAny()
                .orElse(null);
    }
}