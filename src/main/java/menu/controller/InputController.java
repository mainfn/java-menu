package menu.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.coach.CoachesRecommending;
import menu.domain.menu.Menu;
import menu.domain.menu.UneatableMenus;
import menu.util.RecommendedCategoriesGenerator;
import menu.view.InputView;

public final class InputController {

  private final InputView inputView;
  private final InputValidator inputValidator;

  private final RecommendedCategoriesGenerator recommendedCategoriesGenerator;

  public InputController(
      final InputView inputView,
      final InputValidator inputValidator,
      final RecommendedCategoriesGenerator recommendedCategoriesGenerator
  ) {
    this.inputView = inputView;
    this.inputValidator = inputValidator;
    this.recommendedCategoriesGenerator = recommendedCategoriesGenerator;
  }

  public CoachesRecommending inputCoaches() {
    final String coachNamesString = inputView.inputCoachNames();
//    inputValidator.validateCoachNames(coachNamesString);

    final List<String> coachNames = Arrays.stream(coachNamesString.split(","))
        .collect(Collectors.toList());

    return CoachesRecommending.from(coachNames, recommendedCategoriesGenerator.generate());
  }

  public UneatableMenus inputUneatableMenusByCoachName(final String coachName) {
    final String uneatableMenuNamesString = inputView.inputUneatableMenuNames(coachName);
//    inputValidator.validateUneatableMenuNames(uneatableMenuNamesString);

    return UneatableMenus.of(Arrays.stream(uneatableMenuNamesString.split(","))
        .filter(m -> !m.isEmpty())
        .map(Menu::of)
        .collect(Collectors.toList()));
  }
}
