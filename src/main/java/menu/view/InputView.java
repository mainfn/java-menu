package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class InputView {

  private static final String INPUT_DELIMITER = ",";

  public static List<String> inputCoachNames() {
    OutputView.printStartMessage();
    OutputView.printInputCoachNames();

    return readIntoStringList();
  }

  public static List<String> inputCannotEatMenus(final String coachName) {
    OutputView.printInputCannotEatMenu(coachName);

    return readIntoStringList();
  }

  private static List<String> readIntoStringList() {
    return Arrays.stream(Console.readLine().trim()
            .split(INPUT_DELIMITER))
        .collect(Collectors.toList());
  }
}

