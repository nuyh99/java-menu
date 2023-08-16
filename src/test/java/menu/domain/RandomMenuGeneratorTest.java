package menu.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class RandomMenuGeneratorTest {

    private final RandomNumberGenerator generator = new RandomMenuGenerator();

    @Test
    @DisplayName("카테고리가 1 ~ 5 사이만 존재하면 True를 반환한다.")
    void generate() {
        List<Integer> results = Stream.generate(generator::generate)
                .limit(10)
                .collect(Collectors.toList());

        Assertions.assertThat(results).allMatch(e -> 1 <= e && e <= 5);
    }

    @Test
    @DisplayName("카테고리가 일식일 때, 일식집 메뉴 중 하나가 나온다.")
    void getMenuFromCategory() {
        RandomMenuGenerator testGenerator = (RandomMenuGenerator) generator;
        List<String> japanMenu =
                List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼");
        Assertions.assertThat(testGenerator.getMenuFromCategory(1))
                .matches(japanMenu::contains)
                .isNotEmpty();
    }
}