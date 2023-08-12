package menu.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuDataTest {


    @Test
    @DisplayName("ASIAN이 4번이 맞으면 True를 반환한다.")
    void validCategoryMatched() {
        MenuData menuData = MenuData.ASIAN;
        Assertions.assertThat(menuData.category() == 4).isTrue();
    }

    @Test
    @DisplayName("일본에 규동이라는 메뉴가 포함되면 True를 반환한다.")
    void validMenuInCategory() {
        MenuData menuData = MenuData.JAPAN;
        Assertions.assertThat(menuData.menus().contains("규동")).isTrue();
    }

    @Test
    @DisplayName("중국에 규동이라는 메뉴가 포함되면 False를 반환한다.")
    void menus() {
        MenuData menuData = MenuData.CHINA;
        Assertions.assertThat(menuData.menus().contains("규동")).isFalse();
    }

}