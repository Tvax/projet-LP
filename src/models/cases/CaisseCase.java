package models.cases;

import utils.Constants;
import utils.Tools;

import javax.swing.*;

public class CaisseCase extends Case {
    public CaisseCase(int id) {
        super(id);
    }

    @Override
    public ImageIcon getImage() {
        return Tools.getImageIcon(Constants.CAISSE_SLOT_PATH, this.getClass());
    }
}
