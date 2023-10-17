package menu;

import menu.controller.MainController;
import menu.domain.category.CategoriesRecommender;
import menu.domain.category.CategoryPicker;
import menu.domain.menu.MenuPicker;
import menu.domain.rand.InRangeNumberPicker;
import menu.view.InputView;
import menu.view.OutputView;

public final class Application {

  public static void main(final String[] args) {

    final MenuPicker menuPicker = new MenuPicker();
    final OutputView outputView = new OutputView();
    final InputView inputView = new InputView();
    final InRangeNumberPicker inRangeNumberPicker = new InRangeNumberPicker(1, 5);
    final CategoryPicker categoryPicker = new CategoryPicker(inRangeNumberPicker);
    final CategoriesRecommender categoriesRecommender = new CategoriesRecommender(categoryPicker);

    final MainController mainController = new MainController(
        menuPicker,
        inputView,
        outputView,
        categoriesRecommender
    );

    mainController.run();

  }
}
