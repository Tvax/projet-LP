package models.cases;

import utils.Constants;
import utils.Tools;

import javax.swing.*;
import java.awt.*;

public class Case {
    private int id;
    private JLabel jLabel;

    public int getID() {
        return id;
    }

    public Case(int id){
        this.id = id;
        jLabel = new JLabel(getImage());
    }

    public ImageIcon getImage() {
        return Tools.getImageIcon(Constants.EMPTY_SLOT_PATH, this.getClass());
    }


    public Component getComponent() {
        return jLabel;
    }
}