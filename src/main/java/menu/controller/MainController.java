package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.domain.category.CategoriesRecommender;
import menu.domain.category.RecommendedCategories;
import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;
import menu.domain.menu.MenuPicker;
import menu.domain.menu.UneatableMenus;
import menu.view.InputView;
import menu.view.OutputView;

public final class MainController {

  private final MenuPicker menuPicker;

  private final InputView inputView;
  private final OutputView outputView;
  private final CategoriesRecommender categoriesRecommender;

  public MainController(
      final MenuPicker menuPicker,
      final InputView inputView,
      final OutputView outputView,
      final CategoriesRecommender categoriesRecommender
  ) {
    this.menuPicker = menuPicker;
    this.inputView = inputView;
    this.outputView = outputView;
    this.categoriesRecommender = categoriesRecommender;
  }

  public void run() {
    final Coaches coaches = inputCoaches();
    coaches.recommend(menuPicker);
    outputView.printResult(coaches);
  }

  private Coaches inputCoaches() {
    final List<Coach> coaches = new ArrayList<>();
    final List<String> coachNames = inputView.inputCoachNames();

    for (final String coachName : coachNames) {
      final UneatableMenus uneatableMenus = UneatableMenus.from(
          inputView.inputUneatableMenuNames(coachName)
      );
      coaches.add(Coach.of(coachName, uneatableMenus));
    }

    final RecommendedCategories recommendedCategories = categoriesRecommender.recommend();
    return Coaches.of(coaches, recommendedCategories);
  }
}
