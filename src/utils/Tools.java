package utils;

import models.Position;
import models.cases.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.HashMap;

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

    public static HashMap<Position, Case> getLabFromFile(){
        HashMap<Position, Case> hashMap = new HashMap<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("lab.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            StringBuilder sb = new StringBuilder();
            String line = null;
            if (br != null) {
                line = br.readLine();
                String[] parts = line.split(" ");
                Position position = new Position(Integer.valueOf(parts[0]), Integer.valueOf(parts[1]));
                hashMap.put(position, getCaseByID(position.getY()+position.getX()));
            }

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
                if(line == null){
                    break;
                }
                String[] parts = line.split(" ");
                Position position = new Position(Integer.valueOf(parts[0]), Integer.valueOf(parts[1]));
                hashMap.put(position, getCaseByID(position.getY()+position.getX()));
            }

//            String everything = sb.toString();
            return hashMap;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }

    private static Case getCaseByID(int id){
        switch (id){
            case 0:
                return new Case(id);
            case 1:
                return new PlayerCase(id);
            case 2:
                return new FinishCase(id);
            case 3:
                return new GapCase(id);
            case 4:
                return new StartCase(id);
            case 5:
                return new WallCase(id);
            case 6:
                return new CaisseCase(id);
            default:
                return new Case(id);
        }
    }
}
