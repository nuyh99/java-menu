package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BannedMenusTest {

    @Test
    @DisplayName("메뉴는 0 ~ 2개이다")
    void construct() {
        //given
        final List<String> menus = List.of("메뉴1", "메뉴2");

        //when, then
        assertDoesNotThrow(() -> new BannedMenus(menus));
    }

    @Test
    @DisplayName("메뉴는 0 ~ 2개가 아니면 예외가 발생한다")
    void construct_fail() {
        //given
        final List<String> menus = List.of("메뉴1", "메뉴2", "메뉴3");

        //when, then
        assertThatThrownBy(() -> new BannedMenus(menus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 못 먹는 메뉴는 0 ~ 2개여야 합니다.");
    }

    @Test
    @DisplayName("금지된 메뉴라면 true를 리턴한다")
    void hasBanned_true() {
        //given
        final BannedMenus bannedMenus = new BannedMenus(List.of("라면", "피자"));
        final String menu = "라면";

        //when
        final boolean result = bannedMenus.hasBanned(menu);

        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("금지된 메뉴가 아니라면 false를 리턴한다")
    void hasBanned_false() {
        //given
        final BannedMenus bannedMenus = new BannedMenus(List.of("피자"));
        final String menu = "라면";

        //when
        final boolean result = bannedMenus.hasBanned(menu);

        //then
        assertThat(result).isFalse();
    }
}
