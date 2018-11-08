package models.cases;

import utils.Constants;
import utils.Tools;

import javax.swing.*;

public class GapCase extends Case{
    public GapCase(int id) {
        super(id);
    }

    @Override
    public ImageIcon getImage() {
        return Tools.getImageIcon(Constants.TROU_SLOT_PATH, this.getClass());
    }
}
