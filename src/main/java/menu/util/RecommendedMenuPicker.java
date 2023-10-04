package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.category.Category;
import menu.domain.menu.Menu;

public final class RecommendedMenuPicker {

  public Menu pick(final Category category) {
    final List<Menu> menus = Menu.findMenusByCategory(category);
    final List<String> menuNames = menus.stream().map(Menu::getName).collect(Collectors.toList());
    return Menu.of(Randoms.shuffle(menuNames).get(0));
  }
}
