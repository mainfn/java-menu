package menu.domain.menu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class UneatableMenus extends Menus {

  private UneatableMenus(final List<Menu> menus) {
    super(menus);
  }

  public static UneatableMenus empty() {
    return new UneatableMenus(new ArrayList<>());
  }

  public static UneatableMenus of(final List<Menu> menus) {
    return new UneatableMenus(menus);
  }

  public void addAll(final UneatableMenus newMenus) {
    menus.addAll(newMenus.menus);
    validateUneatableMenusCount();
    validateDuplicateMenus();
  }

  private void validateDuplicateMenus() {
    final Set<Menu> menusSet = new HashSet<>(menus);
    if (menusSet.size() != menus.size()) {
      throw new IllegalArgumentException("중복되는 먹지 못하는 메뉴가 있습니다.");
    }
  }

  private void validateUneatableMenusCount() {
    if (menus.size() > 2) {
      throw new IllegalArgumentException("먹지 못하는 메뉴는 최대 2개 존재할 수 있습니다.");
    }
  }

  public boolean canEat(final Menu menu) {
    return menus.stream().noneMatch(m -> m == menu);
  }
}
