package menu.view;

import camp.nextstep.edu.missionutils.Console;

public final class InputView {

  public String inputCoachNames() {
    System.out.println("점심 메뉴 추천을 시작합니다.");
    System.out.println();
    System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    return readLine();
  }

  public String inputUneatableMenuNames(final String coachName) {
    System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", coachName);
    return readLine();
  }

  private String readLine() {
    return Console.readLine().trim();
  }
}
