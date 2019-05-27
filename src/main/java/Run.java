import controller.Controller;
import controller.ExcelAndMailController;
import model.ExcelAndMailModel;
import model.Model;
import view.MainWindow;
import view.SwingView;

import java.io.IOException;

public class Run {

    public static void main(String[] args) throws IOException {

        Controller controller = new ExcelAndMailController();
        SwingView view = new MainWindow(controller);
        Model model = new ExcelAndMailModel(view);
        controller.initModel(model);
        view.start();
    }
}
