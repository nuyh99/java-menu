package menu.domain.category;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CategoryTest {

    @Test
    @DisplayName("존재하는 메뉴라면 true를 리턴한다")
    void exist() {
        //given
        final String menu = "뇨끼";

        //when
        final boolean result = Category.exist(menu);

        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("존재하지 않는 메뉴라면 false를 리턴한다")
    void notExist() {
        //given
        final String menu = "강원도 감자";

        //when
        final boolean result = Category.exist(menu);

        //then
        assertThat(result).isFalse();
    }
}
