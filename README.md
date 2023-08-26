# 미션 - 점심 메뉴 추천

- [ ] 코치의 이름을 입력 받는 기능
    - 이름은 앞 뒤 공백을 제외한 2 ~ 4 글자
    - 코치는 2 ~ 5명
- [ ] 각 코치의 못 먹는 메뉴를 입력 받는 기능
    - 전체 메뉴 목록 안에 존재해야 함
    - 0개면 빈 값
    - 최대 2개
- [ ] 메뉴를 추천하는 기능
    - [ ] 한 주의 카테고리를 정하는 기능
        - 중복 카테고리는 최대 2회
    - [ ] 각 코치의 요일별 메뉴를 정하는 기능
        - 한 코치에게 같은 메뉴 중복 불가능
        - 싫어하는 메뉴 불가능

# 도메인 명세

- [ ] 코치
    - 2 ~ 5명
    - [x] 이름
        - 앞 뒤 공백을 제외한 2 ~ 4 글자
    - [ ] 못 먹는 메뉴
        - 0 ~ 2개
    - [ ] 이미 먹은 메뉴
- [ ] 카테고리
    - 숫자를 가진다
    - 메뉴 리스트를 가진다
    - 메뉴를 추천한다
        - [ ] MenuPicker
            - 셔플하고 0번 인덱스를 리턴하는 애

### 카테고리와 메뉴 요구 사항

```
일식(1): 규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼
한식(2): 김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음
중식(3): 깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채
아시안(4): 팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜
양식(5): 라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니
```

#### 카테고리(추천할 수 있을 때까지 반복)

- 카테고리 추천(난수 가공 가능)

```java
String category=categories.get(Randoms.pickNumberInRange(1,5));
```

- 카테고리 내에서 메뉴 추천(List<String> 형태로 menus 제공)

```java
String menu=Randoms.shuffle(menus).get(0);
```

# 입출력 요구 사항

#### 입력

- 메뉴 추천을 받을 코치의 이름을 입력받는다. 올바른 값이 아니면 예외 처리한다.

```
토미,제임스,포코
```

- 각 코치가 못 먹는 메뉴를 입력받는다.

```
우동,스시
```

#### 출력

- 서비스 시작 문구

```
점심 메뉴 추천을 시작합니다.
```

- 서비스 종료 문구

```
메뉴 추천 결과입니다.
[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]
[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]
[ 토미 | 쌈밥 | 김치찌개 | 미소시루 | 짜장면 | 팟타이 ]
[ 제임스 | 된장찌개 | 비빔밥 | 가츠동 | 토마토 달걀볶음 | 파인애플 볶음밥 ]
[ 포코 | 된장찌개 | 불고기 | 하이라이스 | 탕수육 | 나시고렝 ]

추천을 완료했습니다.
```

- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

```
[ERROR] 코치는 최소 2명 이상 입력해야 합니다.
```

#### 실행 결과 예시

```
점심 메뉴 추천을 시작합니다.

코치의 이름을 입력해 주세요. (, 로 구분)
토미,제임스,포코

토미(이)가 못 먹는 메뉴를 입력해 주세요.
우동,스시

제임스(이)가 못 먹는 메뉴를 입력해 주세요.
뇨끼,월남쌈

포코(이)가 못 먹는 메뉴를 입력해 주세요.
마파두부,고추잡채

메뉴 추천 결과입니다.
[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]
[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]
[ 토미 | 쌈밥 | 김치찌개 | 미소시루 | 짜장면 | 팟타이 ]
[ 제임스 | 된장찌개 | 비빔밥 | 가츠동 | 토마토 달걀볶음 | 파인애플 볶음밥 ]
[ 포코 | 된장찌개 | 불고기 | 하이라이스 | 탕수육 | 나시고렝 ]

추천을 완료했습니다.
```
