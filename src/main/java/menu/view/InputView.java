package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class InputView {

  public List<String> inputCoachNames() {
    System.out.println("점심 메뉴 추천을 시작합니다.");
    return Arrays.stream(readLine()
            .split(","))
        .collect(Collectors.toList());
  }

  public List<String> inputUneatableMenuNames(final String coachName) {
    System.out.println();
    System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", coachName);
    return Arrays.stream(readLine()
            .split(" "))
        .collect(Collectors.toList());
  }

  private String readLine() {
    return Console.readLine().trim();
  }
}
