package menu.domain;

import java.util.List;

public enum MenuData {
    JAPAN(1,List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREA(2,List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINA(3,List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    ASIAN(4,List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토","달걀볶음", "고추잡채")),
    WESTERN(5,List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    private final int category;
    private final List<String> menus;

    MenuData(int category, List<String> menus){
        this.category = category;
        this.menus = menus;
    }

    public int category(){
        return category;
    }

    public List<String> menus(){
        return menus;
    }



}
