package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class InputView {

  private static final String COACH_NAME_REGEX = "^(\\p{L}+)$";
  private static final String COACH_NAMES_REGEX = "^(\\p{L}+,)+(\\p{L}+)$";

  public List<String> inputCoachNames() {
    System.out.println("점심 메뉴 추천을 시작합니다.");
    System.out.println();
    System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");

    final String input = readLine();
    validateInput(input);

    return Arrays.stream(input.split(","))
        .collect(Collectors.toList());
  }

  // K W J C A
  public List<String> inputUneatableMenuNames(final String coachName) {
    System.out.println();
    System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.", coachName);

    final String input = readLine();
    if ("".equals(input)) {
      return List.of();
    }
    validateInput(input);

    return Arrays.stream(input.split(","))
        .collect(Collectors.toList());
  }

  private String readLine() {
    return Console.readLine().trim();
  }

  private void validateInput(final String input) {
    if (Pattern.matches(COACH_NAME_REGEX, input) || Pattern.matches(COACH_NAMES_REGEX, input)) {
      return;
    }
    throw new IllegalArgumentException("유효하지 않은 입력입니다.\n반드시 ,로 구분된 문자열을 입력해야 합니다.");
  }
}
