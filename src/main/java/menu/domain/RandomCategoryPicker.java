package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomCategoryPicker {

  public Category pick() {
    final int code = Randoms.pickNumberInRange(1, 5);
    return Category.of(code);
  }

}
