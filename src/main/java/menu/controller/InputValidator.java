package menu.controller;

import java.util.regex.Pattern;

public final class InputValidator {

  private static final String COMMAS_SEPERATED_INPUT_PATTERN = "^(\\w+,)+\\w+$";
  private static final String ONLY_WORDS_PATTERN = "^\\w+$";


  public void validateCoachNames(final String coachNames) {
    if (!isValidInput(coachNames)) {
      throw new IllegalArgumentException("코치 이름은 반드시 ,로 구분되어야 합니다. ex: 토미,제임스,포코");
    }
  }

  public void validateUneatableMenuNames(final String uneatableMenuNames) {
    if (!isValidInput(uneatableMenuNames)) {
      throw new IllegalArgumentException("못 먹는 메뉴 목록은 반드시 ,로 구분되어야 합니다. ex: 마파두부,고추잡채");
    }
  }

  private boolean isValidInput(final String input) {
    return "".equals(input) ||
        Pattern.matches(ONLY_WORDS_PATTERN, input) ||
        Pattern.matches(COMMAS_SEPERATED_INPUT_PATTERN, input);
  }
}
