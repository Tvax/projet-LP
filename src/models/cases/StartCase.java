package models.cases;

import utils.Constants;
import utils.Tools;

import javax.swing.*;

public class StartCase extends Case{
    public StartCase(int id) {
        super(id);
    }

    @Override
    public ImageIcon getImage() {
        return Tools.getImageIcon(Constants.GREEN_SLOT_PATH, this.getClass());
    }
}
