package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public final class RandomMenuPicker {

  public Menu pickByCategory(final Category category) {

    // 1. 인자로 전달한 카테고리에 속하는 모든 메뉴의 이름을 가져온다.
    final List<String> menuNames = Menu.findMenuNamesByCategory(category);

    // 2. 메뉴 이름이 담긴 리스트를 섞는다.
    final List<String> shuffledMenuNames = Randoms.shuffle(menuNames);

    // 3. 섞인 이름 중에 첫 번째 요소를 뽑는다.
    final String pickedMenuName = shuffledMenuNames.get(0);

    // 4. 뽑은 메뉴명과 일치하는 Menu variant를 가져온다.
    return Menu.of(pickedMenuName);
  }
}
