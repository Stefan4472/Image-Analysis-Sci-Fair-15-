/* image loading, writing, and analysis */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;
import java.util.Vector;

public class HandleImage {
    public static void main(String[] args) {
       AnalyzeImage();
    }
    public static void AnalyzeImage() {
        boolean load = true;
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("testimage"));
        } catch (IOException e) {
            load = false;
            Println("Error reading file");
        }
        if(load) {
            int height = img.getHeight();
            Println("Height is " + height);
            int width = img.getWidth();
            Println("Width is " + width);
            double running_average = 0.0;
            int pixel_counter = 0;
            int running_sum = 0;
            int black_pixels = 0;
            int white_pixels = 0;
            Color myWhite = new Color(255, 255, 255); /* set to color white */
            int white_rgb = myWhite.getRGB(); /* get int rgb value for use later */
            for(int i = 0; i < height; i++) {
                for(int j = 0; j < width; j++) {
                    int pixel_rgb = img.getRGB(j, i);
                    int alpha = (pixel_rgb >> 24) & 0xff;
                    int red = (pixel_rgb >> 16) & 0xff;
                    int green = (pixel_rgb >> 8) & 0xff;
                    int blue = (pixel_rgb) & 0xff;
                    if(red == 0 && green == 0 && blue == 0) {
                        black_pixels++;
                        img.setRGB(j, i, white_rgb);
                    }
                    else if(red == 255 && green == 255 && blue == 255)
                        white_pixels++;
                    Println("RGB: " + alpha + "," + red + "," + green + "," + blue);
                    Println("Average for (" + i + "," + j + ") is " + ((red + green + blue) / 3));
                    pixel_counter++;
                    running_sum = running_sum + red + green + blue;
                    running_average = running_sum / pixel_counter;
                    Println("Running average for " + pixel_counter + " pixels is " + running_average);
                }
            }
            Println("Found " + black_pixels + " black pixels and " + white_pixels + " white pixels.");
            BufferedImage to_save = img;
            File output_file = new File("saved.");
            try {
                ImageIO.write(to_save, "png", output_file);
            } catch(IOException e) {
                Println("Error writing image.");
            }
        }
    }
    public static void Println(String s) {
        System.out.println(s);
    }
}
