package models.cases;

import utils.Constants;
import utils.Tools;

import javax.swing.*;

public class BusyCase extends Case {

    public BusyCase(int id) {
        super(id);
    }

    @Override
    public ImageIcon getImage() {
        return Tools.getImageIcon(Constants.GREEN_SLOT_PATH, this.getClass());
    }
}
