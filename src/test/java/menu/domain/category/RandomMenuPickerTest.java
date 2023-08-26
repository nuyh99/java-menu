package menu.domain.category;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMenuPickerTest {

    @RepeatedTest(value = 10)
    @DisplayName("받은 메뉴 리스트 중 한 메뉴를 추천한다")
    void next() {
        //given
        final RandomMenuPicker randomMenuPicker = new RandomMenuPicker();
        final List<String> menus = List.of("라면", "피자");

        //when
        final String recommended = randomMenuPicker.next(menus);

        //then
        assertThat(menus).contains(recommended);
    }
}
