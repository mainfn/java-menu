package menu.domain.menu;

import static menu.domain.menu.Category.ASIAN;
import static menu.domain.menu.Category.CHINESE;
import static menu.domain.menu.Category.JAPENESE;
import static menu.domain.menu.Category.KOREAN;
import static menu.domain.menu.Category.WESTERN;

import java.util.HashMap;
import java.util.Map;

public enum Menu {
  M1("규동", JAPENESE),
  M2("우동", JAPENESE),
  M3("미소시루", JAPENESE),
  M4("스시", JAPENESE),
  M5("가츠동", JAPENESE),
  M6("오니기리", JAPENESE),
  M7("하이라이스", JAPENESE),
  M8("라멘", JAPENESE),
  M9("오코노미야끼", JAPENESE),
  M10("김밥", KOREAN),
  M11("김치찌개", KOREAN),
  M12("쌈밥", KOREAN),
  M13("된장찌개", KOREAN),
  M14("비빔밥", KOREAN),
  M15("칼국수", KOREAN),
  M16("불고기", KOREAN),
  M17("떡볶이", KOREAN),
  M18("제육볶음", KOREAN),
  M19("깐풍기", CHINESE),
  M20("볶음면", CHINESE),
  M21("동파육", CHINESE),
  M22("짜장면", CHINESE),
  M23("짬뽕", CHINESE),
  M24("마파두부", CHINESE),
  M25("탕수육", CHINESE),
  M26("토마토 달걀볶음", CHINESE),
  M27("고추잡채", CHINESE),
  M28("팟타이", ASIAN),
  M29("카오 팟", ASIAN),
  M30("나시고렝", ASIAN),
  M31("파인애플 볶음밥", ASIAN),
  M32("쌀국수", ASIAN),
  M33("똠얌꿍", ASIAN),
  M34("반미", ASIAN),
  M35("월남쌈", ASIAN),
  M36("분짜", ASIAN),
  M37("라자냐", WESTERN),
  M38("그라탱", WESTERN),
  M39("뇨끼", WESTERN),
  M40("끼슈", WESTERN),
  M41("프렌치 토스트", WESTERN),
  M42("바게트", WESTERN),
  M43("스파게티", WESTERN),
  M44("피자", WESTERN),
  M45("파니니", WESTERN);

  private static final Map<String, Menu> mp = new HashMap<>();

  static {
    for (final Menu menu : values()) {
      mp.put(menu.name, menu);
    }
  }

  private final String name;
  private final Category category;

  Menu(
      final String name,
      final Category category
  ) {
    this.name = name;
    this.category = category;
  }

  public static Menu of(final String name) {
    final Menu menu = mp.get(name);
    if (menu == null) {
      throw new IllegalArgumentException("존재하지 않는 메뉴명입니다.");
    }
    return menu;
  }
}
