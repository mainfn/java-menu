package menu.view;

import menu.domain.coach.CoachesCompleted;

public final class OutputView {

  public void printResult(final CoachesCompleted coachesCompleted) {
    System.out.println("메뉴 추천 결과입니다.");
    System.out.println(coachesCompleted);
    System.out.println();
    System.out.println("추천을 완료했습니다.");
  }
}
