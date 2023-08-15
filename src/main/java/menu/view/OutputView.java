package menu.view;

import menu.domain.Coach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class OutputView {

    private static final String DELETER = " | ";
    private static final String LINE_START_WORD = "[ ";
    private static final String LINE_END_WORD = " ]";
    private static final String CATEGORY_TITLE = "카테고리";

    private static final Map<Integer, String> DAY_MAPPER = new HashMap<>() {
        {
            put(0, "월요일");
            put(1, "화요일");
            put(2, "수요일");
            put(3, "목요일");
            put(4, "금요일");
            put(5, "토요일");
            put(6, "일요일");
        }
    };
    private static final String DAY_TITLE = "구분";
    private static final int WEEK_LENGTH = 7;

    static {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printInputCoachesName() {
        System.out.println("코치의 이름을 입력해주세요. (, 로 구분)");
    }

    public void printInputBanMenus(String coach) {
        System.out.println(coach + "(이)가 못 먹는 메뉴를 입력해 주세요");
    }

    public void printMenuResult(List<String> week, List<Coach> coaches) {
        System.out.println("메뉴 추천 결과입니다.");
        printDaysTitle(week);
        printCategories(week);
        coaches.forEach(this::printResultInformaiton);
        System.out.println("추천을 완료했습니다.");
    }

    private void printDaysTitle(List<String> week) {
        List<String> dayResult = new ArrayList<>();
        dayResult.add(DAY_TITLE);
        for (int i = 0; i < week.size(); i++) {
            dayResult.add(DAY_MAPPER.get(i % WEEK_LENGTH));
        }
        printToFormattedSentence(dayResult);
    }

    private void printCategories(List<String> week) {
        week.add(0, CATEGORY_TITLE);

        printToFormattedSentence(new ArrayList<>(week));
    }

    private void printResultInformaiton(Coach coach) {
        List<String> menuResult = new ArrayList<>() {
            {
                add(coach.getName());
            }
        };
        menuResult.addAll(coach.getEatenMenus());
        printToFormattedSentence(menuResult);
    }

    private void printToFormattedSentence(List<String> words) {
        String print = String.join(DELETER, words);
        System.out.println(LINE_START_WORD + print + LINE_END_WORD);
    }
}

