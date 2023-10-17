package menu.domain.menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.category.Category;

public final class MenuPicker {

  public Menu pickByCategory(final Category category) {
    final List<String> menuNames = Menu.getMenuNamesByCategory(category).stream()
        .map(Menu::getName)
        .collect(
            Collectors.toList());
    return Menu.of(Randoms.shuffle(menuNames).get(0));
  }
}
