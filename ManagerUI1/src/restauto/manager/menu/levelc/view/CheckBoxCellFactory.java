package restauto.manager.menu.levelc.view;

import restauto.manager.menu.levelc.model.Type;
import javafx.scene.control.TableCell;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.util.Callback;

public class CheckBoxCellFactory implements Callback {
    @Override
    public TableCell call(Object param) {
        CheckBoxTableCell<Type,Boolean> checkBoxCell = new CheckBoxTableCell();
        return checkBoxCell;
    }
}