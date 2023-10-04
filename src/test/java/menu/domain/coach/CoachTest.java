package menu.domain.coach;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoachTest {

  @DisplayName("코치 이름이 2글자 이상 4글자 이하라면 정상 생성")
  @Test
  void createCoach() {
    // given
    final Coach coach = CoachRecommending.of("aa");

    // when
    // then
    assertThat(coach.name).isEqualTo("aa");
  }

  @DisplayName("코치 이름이 2글자 이상 4글자 이하가 아니라면 예외 발생")
  @Test
  void createCoachWithNameLengthIsLessThanTwo() {
    // given
    // when
    // then
    assertThatThrownBy(() -> CoachRecommending.of("a"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Coach 이름은 최소 2글자, 최대 4글자까지 가능합니다.");

    assertThatThrownBy(() -> CoachRecommending.of("aaaaa"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Coach 이름은 최소 2글자, 최대 4글자까지 가능합니다.");
  }

}