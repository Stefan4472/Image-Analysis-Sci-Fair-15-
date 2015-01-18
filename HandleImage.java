/* image loading, writing, and analysis */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Vector;
import java.util.HashSet;
import java.util.Set;


public class HandleImage {
    public static void main(String[] args) {
        boolean[] success = new boolean[1];
        BufferedImage img = LoadImage("circle_test.png", success);
        if(success[0]) {
            ScreenImage(img, 255, 255, 255, 0.5);
            AnalyzeImage(img);
            SaveImage("save_test", img);
        }
    }
    /* Idea: Get the int array of the buffered image and manipulate that, then copy it back - much faster */
    public static BufferedImage ScreenImage(BufferedImage img, int r, int g, int b, double variance) {
        int r_low = (int)(r - r * variance);
        int r_high = (int)(r + r * variance);
        int g_low = (int)(g - g * variance);
        int g_high = (int)(g + g * variance);
        int b_low = (int)(b - b * variance);
        int b_high = (int)(b + b * variance);
        int height = img.getHeight();
        int width = img.getWidth();
        int replaced = 0;
        Color transparent = new Color(200, 0, 0, 0);
        int transparent_rgb = transparent.getRGB();
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                int pixel_rgb = img.getRGB(i, j);
                int red = (pixel_rgb >> 16) & 0xff;
                int green = (pixel_rgb >> 8) & 0xff;
                int blue = (pixel_rgb) & 0xff;
                if((red < r_low || red > r_high) || (green < g_low || green > g_high) || (blue < b_low || b > b_high)) {
                    img.setRGB(i, j, transparent_rgb); /* set transparent */
                    replaced++;
                }
            }
        }
        Println(replaced + " pixels replaced.");
        return img;
    }
    public static void AnalyzeImage(BufferedImage img) {
        int height = img.getHeight();
        int width = img.getWidth();
        double running_average = 0.0;
        int pixel_counter = 0;
        int running_sum = 0;
        int black_pixels = 0;
        int white_pixels = 0;
        Color myWhite = new Color(255, 255, 255); /* set to color white */
        int white_rgb = myWhite.getRGB(); /* get int rgb value for use later */
        Vector x_coordinates = new Vector(0,1);
        x_coordinates.add(1);
        Vector y_coordinates = new Vector(0,1);
        y_coordinates.add(1);
        x_coordinates.add(y_coordinates);

        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                int pixel_rgb = img.getRGB(j, i);
                   //int alpha = (pixel_rgb >> 24) & 0xff;
                int red = (pixel_rgb >> 16) & 0xff;
                int green = (pixel_rgb >> 8) & 0xff;
                int blue = (pixel_rgb) & 0xff;
                if(red < 50 && green < 50 && blue < 50) {
                    black_pixels++;
                       //img.setRGB(j, i, white_rgb);
                }
                else {

                }
                pixel_counter++;
                running_sum += red + green + blue;
                }
            }
            running_average = running_sum / pixel_counter;
            Println("Average for " + pixel_counter + " pixels is " + running_average);
            Println("Found " + black_pixels + " black pixels and " + white_pixels + " white pixels.");
    }
    public static BufferedImage LoadImage(String image_name, boolean load[]) {
        load[0] = true;
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(image_name));
        } catch (IOException e) {
            load[0] = false;
            Println("Error reading file");
        }
        return img;
    }
    public static boolean SaveImage(String file_name, BufferedImage to_save) {
        boolean success = true;
        File output_file = new File(file_name + ".png");
        try {
            ImageIO.write(to_save, "png", output_file);
            Println("File saved as " + file_name + ".png");
        } catch(IOException e) {
            Println("Error writing image.");
            success = false;
        }
        return success;
    }
    public static void GetSupportedFileTypes() {
        Set<String> set = new HashSet<String>(); /* this reads hash values (?) */
        String[] formatNames = ImageIO.getReaderFormatNames(); /* returns array of hash */
        for (int i = 0; i < formatNames.length; i++)
            set.add(formatNames[i].toLowerCase()); /* converts to lowercase strings */
        System.out.println("Supported read formats: " + set);
        set.clear();
        formatNames = ImageIO.getWriterFormatNames();
        for(int i = 0; i < formatNames.length; i++)
            set.add(formatNames[i].toLowerCase());
        System.out.println("Supported write formats: " + set);
    }
    public static void Println(String s) {
        System.out.println(s);
    }
}
