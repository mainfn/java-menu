package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.domain.category.Category;
import menu.domain.menu.Menu;

public final class RecommendedMenuPicker {

  public Menu pick(final Category category) {
    final List<Menu> menus = Menu.findMenusByCategory(category);
    return Randoms.shuffle(menus).get(0);
  }
}
