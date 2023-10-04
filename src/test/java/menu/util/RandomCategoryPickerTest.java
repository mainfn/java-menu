package menu.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.category.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomCategoryPickerTest {

  @DisplayName("")
  @Test
  void test() {
    // given
    final List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    final List<RandomCategoryPicker> categoryPickers = numbers.stream()
        .map(n -> new RandomCategoryPicker(() -> n)).collect(Collectors.toList());

    // when
    final List<Category> pickedCategories = categoryPickers.stream().map(
        RandomCategoryPicker::pick
    ).collect(Collectors.toList());

    // then
    assertThat(pickedCategories)
        .containsExactly(
            Category.of(1),
            Category.of(2),
            Category.of(3),
            Category.of(4),
            Category.of(5)
        );
  }

}