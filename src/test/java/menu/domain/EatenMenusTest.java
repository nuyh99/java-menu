package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EatenMenusTest {

    @Test
    @DisplayName("먹었던 음식이라면 false를 리턴한다")
    void eat_false() {
        //given
        final EatenMenus eatenMenus = new EatenMenus(List.of("라면"));

        //when
        final boolean eaten = eatenMenus.eatIfPossible("라면");

        //then
        assertThat(eaten).isFalse();
    }

    @Test
    @DisplayName("먹었던 음식이 아니라면 true를 리턴한다")
    void eat_true() {
        //given
        final EatenMenus eatenMenus = new EatenMenus(new ArrayList<>(List.of("라면")));

        //when
        final boolean eaten = eatenMenus.eatIfPossible("피자");

        //then
        assertThat(eaten).isTrue();
    }
}
