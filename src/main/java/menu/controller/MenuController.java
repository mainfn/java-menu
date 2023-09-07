package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.domain.CategoryRecommender;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.RandomCategoryPicker;
import menu.domain.RandomMenuPicker;
import menu.domain.UneatableMenus;
import menu.view.InputView;
import menu.view.OutputView;

public final class MenuController {

  private final InputView inputView;
  private final OutputView outputView;
  private final RandomCategoryPicker randomCategoryPicker;
  private final RandomMenuPicker randomMenuPicker;

  public MenuController(
      final InputView inputView,
      final OutputView outputView,
      final RandomCategoryPicker randomCategoryPicker,
      final RandomMenuPicker randomMenuPicker
  ) {
    this.inputView = inputView;
    this.outputView = outputView;
    this.randomCategoryPicker = randomCategoryPicker;
    this.randomMenuPicker = randomMenuPicker;
  }

  public void start() {
    // 코치를 받아옴(못 먹는 메뉴까지 포함)
    final Coaches coaches = getCoaches();

    // 카테고리 추천 및 중복 제어기 생성
    final CategoryRecommender categoryRecommender = new CategoryRecommender(randomCategoryPicker);

    // 모든 코치에게 주간 메뉴 추천
    coaches.recommend(categoryRecommender, randomMenuPicker);

    // 메뉴 추천 결과 출력
    outputView.printMenuRecommendationResults();
  }

  private Coaches getCoaches() {
    final List<Coach> coaches = new ArrayList<>();

    // 코치 이름 받아옴
    final List<String> coachNames = inputView.inputCoachNames();

    for (final String coachName : coachNames) {
      // 코치 생성 및 추가
      final Coach coach = getCoachWithUneatableMenus(coachName);
      coaches.add(coach);
    }

    // Coaches 생성 및 반환
    return Coaches.of(coaches);
  }

  private Coach getCoachWithUneatableMenus(final String coachName) {
    // 코치 별 못 먹는 메뉴명 입력
    final List<String> uneatableMenuNames = inputView.inputUneatableMenuNames(coachName);
    // 코치명 + 못 먹는 메뉴명 리스트로 Coach 생성 및 반환
    return Coach.of(coachName, UneatableMenus.of(uneatableMenuNames));
  }
}
