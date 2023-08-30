# 메뉴

## 메뉴를 어떤 식으로 구현할 것인가.

> 메뉴는 정해졌으며 변하지 않는다.
> 
> 또한 순서도 중요하지 않다.
>
> 입력 받은대로 고를 수만 있으면 된다.
>
> -> 가장 단순한 형태로는 Menu 클래스를 만든 뒤,
> 
> HashMap 형태로 미리 저장해둘 수 있을 것이다.

```java
class Menu {
  private final String name;
  private final String category;
}

Map<String, Menu> menus;
```

또한 enum을 사용해 볼 수도 있을 것 같다.

```java
enum Menu {
  MENU1("된장찌개", "한식"),
  MENU2("비빔밥", "한식"),
  ;

  private final String name;
  private final String category;

  private static final Map<String, Menu> kv = new HashMap<>();

  static {
    for (final Menu menu : values()) {
      kv.put(menu.name, menu);
    }
  }

  public String getName() {
    return name;
  }

  public String getCategory() {
    return category;
  }

  public static Menu of(final String name) {
    if (!kv.containsKey(name)) {
      // 오류
    }
    return kv.get(name); 
  }
}
```
rust에서는 ENUM의 각 필드를 VARIANT라고 불렀었다.

이 VARIANT를 영어로 모두 옮기기엔 실제 상황에서는

시간이 부족할 수도 있기 때문에 앞선 방법을 사용하거나,

일단 MENU1과 같은 식으로 작성해두고 나중에 리팩토링 하는 것이 좋을 듯하다.

# 메뉴 추천기

`MenuRecommender`라는 클래스를 만들어서,

`Randoms` 기반으로 메뉴를 섞어서, 코치가 못 먹는 메뉴를 제하고 요일 별로 추천해주면 된다.

이 때, Randoms.pickNumberInRange()의 결과가 1이면 일식, 2면 한식, 3이면 중식, 4면 아시안, 5면 양식을 추천해야 한다.

그리고 카테고리 안에서 메뉴를 정해야 하는데,

Randoms.shuffle()을 통해 임의의 순서로 섞은 후, 첫 번째 값을 사용해야 한다.

즉, 메뉴 추천 로직 흐름은 다음과 같이 전개된다.

총 월 ~ 금까지 5번의 카테고리 선택을 반복한다.
1. 각 요일의 카테고리를 랜덤으로 정한다.
(모든 코치는 같은 요일에 같은 카테고리 음식을 먹는다.)

2. 각 코치마다 음식을 랜덤으로 뽑는다.
3. 추천할 수 없는 음식이면 섞어서 다시 첫 번째 값을 사용한다.
(이 때 추천할 수 없는 조건이 여러 가지이므로 따로 Validator를 만들어서 모든 조건을 검사한 뒤에 재추천 하면 될 것이다.)




 

카테고리 - 메뉴로 구분된다.

종류