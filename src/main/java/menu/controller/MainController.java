package menu.controller;

import menu.domain.coach.CoachesRecommending;
import menu.domain.menu.UneatableMenus;
import menu.util.RecommendedMenuPicker;
import menu.view.OutputView;

public final class MainController {

  private final InputController inputController;

  private final OutputView outputView;

  private final RecommendedMenuPicker menuPicker;

  public MainController(
      final InputController inputController,
      final OutputView outputView,
      final RecommendedMenuPicker menuPicker
  ) {
    this.inputController = inputController;
    this.outputView = outputView;
    this.menuPicker = menuPicker;
  }

  public void run() {
    // 코치 추가
    final CoachesRecommending coaches = getCoaches();

    // 메뉴 추천
    coaches.recommendMenus(menuPicker);

    // 결과 출력
    outputView.printResult(coaches.intoCompleted());
  }

  private CoachesRecommending getCoaches() {
    // 1. 코치 생성
    final CoachesRecommending coaches = inputController.inputCoaches();

    // 2. 못 먹는 메뉴 추가
    for (final String coachName : coaches.getCoachNames()) {
      final UneatableMenus uneatableMenus = inputController.inputUneatableMenusByCoachName(
          coachName);
      coaches.addUneatableMenusTo(coachName, uneatableMenus);
    }

    return coaches;
  }


}
