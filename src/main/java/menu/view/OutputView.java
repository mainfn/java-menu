package menu.view;

import menu.constant.Message;

public final class OutputView {

  public static void printStartMessage() {
    System.out.println(Message.START_MESSAGE);
  }

  public static void printInputCoachNames() {
    System.out.println();
    System.out.println(Message.INPUT_COACH_NAMES);
  }

  public static void printInputCannotEatMenu(final String coachName) {
    System.out.println();
    System.out.printf("%s %s\n", coachName, Message.INPUT_CANNOT_EAT_MENU_SUFFIX);
  }

  // TODO: 메뉴 추천 결과 렌더링 추가
  public static void printMenuRecommendationResult() {
    System.out.println();
    System.out.println(Message.OUTPUT_MENU_RECOMMENDATION_RESULT);
  }

  public static void printEndMessage() {
    System.out.println();
    System.out.println(Message.END_MESSAGE);
  }
}
