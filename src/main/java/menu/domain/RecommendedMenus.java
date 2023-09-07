package menu.domain;

import java.util.ArrayList;
import java.util.List;

public final class RecommendedMenus {

  private final List<Menu> recommendedMenus = new ArrayList<>();

  private RecommendedMenus() {
  }

  public static RecommendedMenus empty() {
    return new RecommendedMenus();
  }

  // 추천 받은 음식 추가
  public void add(
      final RandomMenuPicker randomMenuPicker,
      final Category category
  ) {
    final Menu menu = randomMenuPicker.pickByCategory(category);

    if (isDuplicateMenu(menu)) {
      add(randomMenuPicker, category);
      return;
    }

    recommendedMenus.add(menu);
  }

  // 이미 추천 받은 음식인지 확인
  private boolean isDuplicateMenu(final Menu menu) {
    return recommendedMenus.stream()
        .anyMatch(m -> m.equals(menu));
  }

}
