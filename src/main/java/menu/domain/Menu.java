package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum Menu {
  M1("규동", Category.JAPANESE),
  M2("우동", Category.JAPANESE),
  M3("미소시루", Category.JAPANESE),
  M4("스시", Category.JAPANESE),
  M5("가츠동", Category.JAPANESE),
  M6("오니기리", Category.JAPANESE),
  M7("하이라이스", Category.JAPANESE),
  M8("라멘", Category.JAPANESE),
  M9("오코노미야끼", Category.JAPANESE),
  M10("김밥", Category.KOREAN),
  M11("김치찌개", Category.KOREAN),
  M12("쌈밥", Category.KOREAN),
  M13("된장찌개", Category.KOREAN),
  M14("비빔밥", Category.KOREAN),
  M15("칼국수", Category.KOREAN),
  M16("불고기", Category.KOREAN),
  M17("떡볶이", Category.KOREAN),
  M18("제육볶음", Category.KOREAN),
  M19("깐풍기", Category.CHINESE),
  M20("볶음면", Category.CHINESE),
  M21("동파육", Category.CHINESE),
  M22("짜장면", Category.CHINESE),
  M23("짬뽕", Category.CHINESE),
  M24("마파두부", Category.CHINESE),
  M25("탕수육", Category.CHINESE),
  M26("토마토 달걀볶음", Category.CHINESE),
  M27("고추잡채", Category.CHINESE),
  M28("팟타이", Category.ASIAN),
  M29("카오 팟", Category.ASIAN),
  M30("나시고렝", Category.ASIAN),
  M31("파인애플 볶음밥", Category.ASIAN),
  M32("쌀국수", Category.ASIAN),
  M33("똠얌꿍", Category.ASIAN),
  M34("반미", Category.ASIAN),
  M35("월남쌈", Category.ASIAN),
  M36("분짜", Category.ASIAN),
  M37("라자냐", Category.WESTERN),
  M38("그라탱", Category.WESTERN),
  M39("뇨끼", Category.WESTERN),
  M40("끼슈", Category.WESTERN),
  M41("프렌치 토스트", Category.WESTERN),
  M42("바게트", Category.WESTERN),
  M43("스파게티", Category.WESTERN),
  M44("피자", Category.WESTERN),
  M45("파니니", Category.WESTERN);

  private static final List<Menu> menus = new ArrayList<>();

  static {
    Collections.addAll(menus, values());
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
    return menus.stream()
        .filter(menu -> menu.name.equals(name))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 메뉴명입니다."));
  }

  // 주어진 카테고리에 속하는 메뉴를 List<String> 형태로 반환
  public static List<String> findMenuNamesByCategory(final Category category) {
    return menus.stream()
        .filter(menu -> menu.category.equals(category))
        .map(menu -> menu.name)
        .collect(Collectors.toList());
  }

  public String getName() {
    return name;
  }
}
