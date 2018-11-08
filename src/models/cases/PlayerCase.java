package models.cases;

import utils.Constants;
import utils.Tools;

import javax.swing.*;

public class PlayerCase extends Case {

    public PlayerCase(int id) {
        super(id);
    }

    @Override
    public ImageIcon getImage() {
        return Tools.getImageIcon(Constants.PLAYER_SLOT_PATH, this.getClass());
    }
}
