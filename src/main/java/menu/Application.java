package menu;

import menu.controller.InputController;
import menu.controller.InputValidator;
import menu.controller.MainController;
import menu.util.NumberPicker;
import menu.util.RandomCategoryPicker;
import menu.util.RandomNumberPicker;
import menu.util.RecommendedCategoriesGenerator;
import menu.util.RecommendedMenuPicker;
import menu.view.InputView;
import menu.view.OutputView;

public final class Application {

  public static void main(final String[] args) {
    final InputView inputView = new InputView();
    final OutputView outputView = new OutputView();
    final InputValidator inputValidator = new InputValidator();
    final NumberPicker numberPicker = new RandomNumberPicker(1, 5);
    final RandomCategoryPicker randomCategoryPicker = new RandomCategoryPicker(numberPicker);
    final RecommendedMenuPicker recommendedMenuPicker = new RecommendedMenuPicker();
    final RecommendedCategoriesGenerator recommendedCategoriesGenerator = new RecommendedCategoriesGenerator(
        randomCategoryPicker);
    final InputController inputController = new InputController(inputView, inputValidator,
        recommendedCategoriesGenerator);
    final MainController mainController = new MainController(inputController, outputView,
        recommendedMenuPicker);

    mainController.run();
  }
}
