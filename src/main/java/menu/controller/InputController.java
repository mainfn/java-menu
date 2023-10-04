package menu.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.coach.Coaches;
import menu.view.InputView;

public final class InputController {

  private final InputView inputView;
  private final InputValidator inputValidator;

  public InputController(
      final InputView inputView,
      final InputValidator inputValidator
  ) {
    this.inputView = inputView;
    this.inputValidator = inputValidator;
  }

  public Coaches inputCoaches() {
    final String coachNamesString = inputView.inputCoachNames();
    inputValidator.validateCoachNames(coachNamesString);

    final List<String> coachNames = Arrays.stream(coachNamesString.split(","))
        .collect(Collectors.toList());

    return Coaches.from(coachNames);
  }
}
