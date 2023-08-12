package menu.view;

public final class OutputView {

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

    public void printMenuResult(String coach) {
        System.out.println(coach + "(이)가 못 먹는 메뉴를 입력해 주세요");
    }

}
