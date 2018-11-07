package models.cases;

import utils.Constants;
import utils.Tools;

import javax.swing.*;

public class WallCase extends Case {
    public WallCase(int id) {
        super(id);
    }

    @Override
    public ImageIcon getImage() {
        return Tools.getImageIcon(Constants.BLACK_SLOT_PATH, this.getClass());
    }
}
