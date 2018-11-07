package utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public final class Tools {
    public static ImageIcon getImageIcon(String imageName, Class aClass){
        URL url = aClass.getResource(imageName);
        BufferedImage img;
        try {
            img = ImageIO.read(new File(url.getFile()));
            return new ImageIcon(img);
        } catch (IOException e) {
            return null;
        }
    }
}
