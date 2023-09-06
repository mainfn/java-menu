package menu.domain;

import java.util.ArrayList;
import java.util.List;

public final class UneatableMenus {

  // 못 먹는 음식 목록
  private final List<Menu> menus;

  private UneatableMenus(final List<Menu> menus) {
    validateMenusLength(menus);
    this.menus = menus;
  }

  // 못 먹는 음식은 0 ~ 2개로 제한.
  // 검증 기능 추가
  private static void validateMenusLength(final List<Menu> menus) {
    if (menus.size() > 2) {
      throw new IllegalStateException("[ERROR] 각 코치는 최소 0개, 최대 2개의 못 먹는 메뉴가 있다.");
    }
  }

  // 메뉴명 리스트를 정적 팩토리 메소드 내에서 메뉴 리스트로 변환 및 생성자 호출
  public static UneatableMenus of(final List<String> menuNames) {
    final List<Menu> menus = new ArrayList<>();

    for (final String menuName : menuNames) {
      final Menu menu = Menu.of(menuName);
      menus.add(menu);
    }

    return new UneatableMenus(menus);
  }
}
