package menu.domain.coach;

import menu.domain.category.Category;
import menu.domain.menu.Menu;
import menu.domain.menu.RecommendedMenus;
import menu.domain.menu.UneatableMenus;
import menu.util.RecommendedMenuPicker;

public final class CoachRecommending extends Coach {

  private CoachRecommending(
      final String name,
      final UneatableMenus uneatableMenus,
      final RecommendedMenus recommendedMenus
  ) {
    super(name, uneatableMenus, recommendedMenus);
  }

  public static Coach of(final String name) {
    return new CoachRecommending(
        name,
        UneatableMenus.empty(),
        RecommendedMenus.empty()
    );
  }

  public void addUneatableMenus(final UneatableMenus menus) {
    uneatableMenus.addAll(menus);
  }

  public void recommendByCategory(
      final Category category,
      final RecommendedMenuPicker menuPicker
  ) {
    while (true) {
      final Menu menu = menuPicker.pick(category);
      if (canRecommend(menu)) {
        recommendedMenus.add(menu);
        return;
      }
    }
  }

  public boolean canRecommend(final Menu menu) {
    return recommendedMenus.canRecommend(menu) &&
        uneatableMenus.canEat(menu);
  }

  public CoachCompleted intoCompleted() {
    return new CoachCompleted(name, uneatableMenus, recommendedMenus);
  }

}
