package models.cases;

import utils.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Case {
    private int id;
    private JLabel jLabel;

    public int getID() {
        return id;
    }

    public Case(int id){
        this.id = id;
        try {
            jLabel = new JLabel(getImage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ImageIcon getImage() throws IOException {
        URL url = this.getClass().getResource(Constants.EMPTY_SLOT_PATH);
        BufferedImage img = ImageIO.read(new File(url.getFile()));
        return new ImageIcon(img);
    }


    public Component getComponent() {
        return jLabel;
    }
}