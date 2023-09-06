package menu.domain;

import java.util.ArrayList;
import java.util.List;

public final class Coach {

  private final String name;

  private final List<Menu> uneatableMenus = new ArrayList<>();
  private final List<Menu> recommendedMenus = new ArrayList<>();

  private Coach(final String name) {
    validateNameLength(name);
    this.name = name;
  }

  public static Coach of(final String name) {
    return new Coach(name);
  }

  private void validateNameLength(final String name) {
    if (name == null || name.length() < 2 || name.length() > 4) {
      throw new IllegalArgumentException("[ERROR] 코치 이름은 최소 2글자, 최대 4글자이다.");
    }
  }

  // 못 먹는 음식 추가
  public void addUneatableMenu(final Menu menu) {
    uneatableMenus.add(menu);
  }

  // 추천 음식 추가
  public void addRecommendedMenu(final Menu menu) {
    recommendedMenus.add(menu);
  }
}
