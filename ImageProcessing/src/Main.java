import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    final static String IMAGE = "data/iron-man.jpg";

    private static void showImage(BufferedImage img) {
        JFrame jFrame = new JFrame();
        JLabel label = new JLabel(new ImageIcon(img));
        jFrame.getContentPane().add(label);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        System.out.println("-- Image Processing --");
        System.out.println("Running");

        try {
            BufferedImage img = ImageIO.read(new File(IMAGE));
            darken(img);
            showImage(img);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }

    private static void darken(BufferedImage img) {
        Color color;
        for (int i = 1; i < img.getHeight()-1; i++) {
            for (int j = 1; j < img.getWidth()-1; j++) {
                color = new Color(img.getRGB(j,i)).darker();
                img.setRGB(j,i,color.getRGB());
            }
        }
    }
}
