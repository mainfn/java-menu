package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.view.InputView;

public final class InputController {

  // 1. 코치 이름 받기
  public static List<Coach> getCoaches() {
    final List<Coach> coaches = new ArrayList<>();
    final List<String> names = InputView.inputCoachNames();

    for (final String name : names) {
      coaches.add(Coach.of(name));
    }

    return coaches;
  }

  // 2. 먹지 못하는 음식 입력 받기
  public static List<Menu> getUneatables(final Coach coach) {
    final List<Menu> uneatables = new ArrayList<>();

    final List<String> uneatableMenuNames = InputView.inputUneatableMenus(coach.getName());
    for (final String uneatableMenu : uneatableMenuNames) {
      uneatables.add(Menu.of(uneatableMenu));
    }

    return uneatables;
  }
}
