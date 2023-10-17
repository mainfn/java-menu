package menu.domain.menu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class UneatableMenus {

  private final List<Menu> uneatableMenus;

  private UneatableMenus(final List<Menu> uneatableMenus) {
    this.uneatableMenus = uneatableMenus;
  }

  public static UneatableMenus from(final List<String> uneatableMenuNames) {
    final List<Menu> uneatableMenus = new ArrayList<>();

    for (final String uneatableMenuName : uneatableMenuNames) {
      uneatableMenus.add(Menu.of(uneatableMenuName));
    }

    return new UneatableMenus(uneatableMenus);
  }

  private static void validateLength(final List<Menu> uneatableMenus) {
    if (uneatableMenus.size() > 2) {
      throw new IllegalArgumentException("못 먹는 메뉴는 최대 2개까지만 등록할 수 있습니다.");
    }
  }

  private void validateDuplication(final List<Menu> menus) {
    final Set<Menu> set = new HashSet<>(menus);
    if (set.size() != menus.size()) {
      throw new IllegalArgumentException("못 먹는 메뉴에 중복이 존재합니다.");
    }
  }

  public void addUneatableMenus(final List<Menu> menus) {
    validateLength(menus);
    validateDuplication(menus);
    uneatableMenus.addAll(menus);
  }

  public boolean isEatable(final Menu menu) {
    return uneatableMenus.stream()
        .noneMatch(m -> m == menu);
  }
}
