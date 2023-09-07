package menu.domain;

import java.util.ArrayList;
import java.util.List;

public final class UneatableMenus {

  private boolean isRegistered = false;
  // 못 먹는 음식 목록
  private List<Menu> menus;

  private UneatableMenus() {
  }

  private static void validateMenusLength(final List<Menu> uneatableMenus) {
    if (uneatableMenus.size() > 2) {
      throw new IllegalStateException("[ERROR] 각 코치는 최소 0개, 최대 2개의 못 먹는 메뉴가 있다.");
    }
  }

  public static UneatableMenus empty() {
    return new UneatableMenus();
  }

  // 못 먹는 음식 목록 한 번에 추가
  public void register(final List<String> uneatableMenuNames) {
    // 이미 한 번 초기화 되었으면 예외 발생
    ensureIsNotRegistered();

    final List<Menu> uneatableMenus = new ArrayList<>();
    for (final String uneatableMenuName : uneatableMenuNames) {
      final Menu menu = Menu.of(uneatableMenuName);
      uneatableMenus.add(menu);
    }

    // 못 먹는 음식 갯수 검증
    validateMenusLength(uneatableMenus);
    // 메뉴 중복 검증
    validateMenusDuplication(uneatableMenus);
    this.menus = uneatableMenus;
  }

  public void validateMenusDuplication(final List<Menu> uneatableMenu) {
    for (final Menu menu : uneatableMenu) {
      final boolean isDuplicateMenu = uneatableMenu.stream()
          .filter(m -> m.equals(menu))
          .count() > 1;

      if (isDuplicateMenu) {
        throw new IllegalStateException("[ERROR] 중복된 메뉴가 못 먹는 메뉴로 입력 되었습니다.");

      }
    }
  }

  private void ensureIsNotRegistered() {
    // 이미 한 번 초기화 되었는지 확인
    if (isRegistered) {
      throw new IllegalStateException("[ERROR] 이미 못 먹는 음식을 등록했습니다.");
    }
    isRegistered = true;
  }

  public boolean canEat(final Menu menu) {
    return menus.stream()
        .noneMatch(m -> m.equals(menu));
  }
}
