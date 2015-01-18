/* image loading, writing, and analysis */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Vector;
import java.util.HashSet;
import java.util.Set;


public class HandleImage {
    public static void main(String[] args) {
        //try{Thread.sleep(2000);}
        //catch(InterruptedException e) {}
        boolean[] success = new boolean[1];
        BufferedImage img = LoadImage("circle_test.png", success);
        if(success[0]) {
            img = ScreenImage(img, Settings.GetRed(), Settings.GetGreen(), Settings.GetBlue(), Settings.GetVariance());
            AnalyzeImage(img);
            //Graphics g = img.getGraphics();
            //g.DrawImage(img, 0, 0, 600, 800, null); /* scales to 600 x 800 */
            SaveImage("save_test", img);
        }
    }
    /* Idea: Get the int array of the buffered image and manipulate that, then copy it back - much faster */
    public static BufferedImage ScreenImage(BufferedImage img, int r, int g, int b, double variance) {
        Println("RGB: " + r + "," + g + "," + b);
        /* set acceptable values for pixel color using guidelines and variance */
        int r_low = (int)(r - r * variance);
        int r_high = (int)(r + r * variance);
        int g_low = (int)(g - g * variance);
        int g_high = (int)(g + g * variance);
        int b_low = (int)(b - b * variance);
        int b_high = (int)(b + b * variance);
        Println("Values are " + r_low +","+ r_high+"," + g_low+"," + g_high+"," + b_low+"," + b_high);
        int height = img.getHeight();
        int width = img.getWidth();
        int replaced = 0;
        /* initializes a blank, transparent buffered image the same size as img */
        BufferedImage screened = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                int pixel_rgb = img.getRGB(i, j); /* get color of pixel from img */
                /* parse from bytes to integer RGB values */
                int red = (pixel_rgb >> 16) & 0xff;
                int green = (pixel_rgb >> 8) & 0xff;
                int blue = (pixel_rgb) & 0xff;
                /* pixel color fits within accepted range */
                if(!(red >= r_low && red <= r_high && green >= g_low && green <= g_high && blue >= b_low && b <= b_high)) {
                    screened.setRGB(i, j, pixel_rgb); /* copy pixel to screened */
                } else
                    replaced++;
            }
        }
        Println(replaced + " pixels replaced.");
        return screened;
    }
    public static BufferedImage FilterGrayscale(BufferedImage img) {
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
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                int pixel_rgb = img.getRGB(j, i);
                int alpha = (pixel_rgb >> 24) & 0xff;
                    if(alpha == 255) { /* only analyzes opaque pixels */
                        int red = (pixel_rgb >> 16) & 0xff;
                        int green = (pixel_rgb >> 8) & 0xff;
                        int blue = (pixel_rgb) & 0xff;
                        if (red < 50 && green < 50 && blue < 50)
                             black_pixels++;
                        pixel_counter++;
                        running_sum += red + green + blue;
                    }
                }
            }
            running_average = running_sum / pixel_counter;
            Println((height * width) + " total pixels scanned.");
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
