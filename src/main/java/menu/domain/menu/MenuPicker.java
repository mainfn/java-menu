package menu.domain.menu;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.category.Category;

public final class MenuPicker {

  public Menu pickByCategory(final Category category) {
    return Randoms.shuffle(Menu.getMenuNamesByCategory(category)).get(0);
  }
}
