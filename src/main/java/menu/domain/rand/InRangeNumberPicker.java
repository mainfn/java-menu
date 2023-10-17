package menu.domain.rand;

import camp.nextstep.edu.missionutils.Randoms;

public final class InRangeNumberPicker implements NumberPicker {

  private final int startInclusive;
  private final int endInclusive;

  public InRangeNumberPicker(
      final int startInclusive,
      final int endInclusive
  ) {
    this.startInclusive = startInclusive;
    this.endInclusive = endInclusive;
  }


  @Override
  public int pick() {
    return Randoms.pickNumberInRange(startInclusive, endInclusive);
  }
}
