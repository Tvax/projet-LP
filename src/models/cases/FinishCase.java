package models.cases;

import utils.Constants;
import utils.Tools;

import javax.swing.*;

public class FinishCase extends Case{
    public FinishCase(int id) {
        super(id);
    }

    @Override
    public ImageIcon getImage() {
        return Tools.getImageIcon(Constants.RED_SLOT_PATH, this.getClass());
    }
}
