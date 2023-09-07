package menu.domain;

import java.util.ArrayList;
import java.util.List;

public final class UneatableMenus {

  // 못 먹는 음식 목록
  private final List<Menu> menus;

  private UneatableMenus(final List<Menu> menus) {
    validateMenusLength(menus);
    validateMenusDuplication(menus);
    this.menus = menus;
  }

  public static UneatableMenus of(final List<String> menuNames) {
    final List<Menu> menus = new ArrayList<>();
    for (final String menuName : menuNames) {
      menus.add(Menu.of(menuName));
    }
    return new UneatableMenus(menus);
  }

  private static void validateMenusLength(final List<Menu> uneatableMenus) {
    if (uneatableMenus.size() > 2) {
      throw new IllegalStateException("[ERROR] 각 코치는 최소 0개, 최대 2개의 못 먹는 메뉴가 있다.");
    }
  }

  public void validateMenusDuplication(final List<Menu> uneatableMenu) {
    for (final Menu menu : uneatableMenu) {
      final boolean isDuplicateMenu = uneatableMenu.stream()
          .filter(menu::equals)
          .count() > 1;

      if (isDuplicateMenu) {
        throw new IllegalStateException("[ERROR] 중복된 메뉴가 못 먹는 메뉴로 입력 되었습니다.");

      }
    }
  }

  public boolean canEat(final Menu menu) {
    return menus.stream()
        .noneMatch(menu::equals);
  }
}
