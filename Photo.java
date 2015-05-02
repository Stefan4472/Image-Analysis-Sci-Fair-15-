/* image loading, writing, and analysis */
import net.coobird.thumbnailator.Thumbnails;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.ImageObserver;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Vector;
import java.util.HashSet;
import java.util.Set;


public class Photo {
    public int pixels_replaced = 0;
    /* Idea: Get the int array of the buffered image and manipulate that, then copy it back - much faster */
    public BufferedImage ScreenImage(BufferedImage img, int r, int g, int b, double variance) {
        /* set acceptable values for pixel color using guidelines and variance */
        int r_low = (int)(r - 255 * variance);
        int r_high = (int)(r + 255 * variance);
        int g_low = (int)(g - 255 * variance);
        int g_high = (int)(g + 255 * variance);
        int b_low = (int)(b - 255 * variance);
        int b_high = (int)(b + 255 * variance);
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
                if(red < r_low || red > r_high || green < g_low || green > g_high || blue < b_low || b > b_high) {
                    screened.setRGB(i, j, pixel_rgb); /* copy pixel to screened */
                } else
                    replaced++;
            }
        }
        pixels_replaced = replaced;
        return screened;
    }
    public int GetPixelsReplaced() {return pixels_replaced;}
    public BufferedImage ResizeImage(BufferedImage img, int width, int height) {
        //return Thumbnails.of(img).size(width, height).asBufferedImage();
        return img;
    }           
    public BufferedImage FilterGrayscale(BufferedImage img) {
        return img;
    }
    public double AnalyzeImage(BufferedImage img) {
        double average;
        int height = img.getHeight();
        int width = img.getWidth();
        int pixel_counter = 0;
        long running_sum = 0;
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                int pixel_rgb = img.getRGB(j, i);
                int alpha = (pixel_rgb >> 24) & 0xff;
                    if(alpha == 255) { /* only analyzes opaque pixels */
                        int red = (pixel_rgb >> 16) & 0xff;
                        int green = (pixel_rgb >> 8) & 0xff;
                        int blue = (pixel_rgb) & 0xff;
                        pixel_counter++;
                        running_sum += red + green + blue;
                    }
                }
            }
        if(pixel_counter == 0 || running_sum == 0)
            average = 0.0;
        else   
            average = Math.floor(running_sum / pixel_counter * 100) / 100;
        return average;
    }
    public BufferedImage loadImage(String image_name, boolean load[]) {
        load[0] = true;
        try {
            return ImageIO.read(new File(image_name));
        } catch (IOException e) {
            load[0] = false;
            Println("Error reading file");
            return null;
        }
    }
    public boolean saveImage(String file_name, String ending, BufferedImage to_save) {
        boolean success = true;
        File output_file = new File(file_name + "." + ending);
        try {
            ImageIO.write(to_save, ending, output_file);
        } catch(IOException e) {
            Println("Error writing image.");
            success = false;
        }
        return success;
    }
    /* scales bufferedimage to 600x600 for image display */
    public BufferedImage getScaledImage(BufferedImage image) throws IOException {
        return Thumbnails.of(image).size(800, 800).asBufferedImage();
    }
    public BufferedImage getCroppedImage(int pixels, BufferedImage image) {
        /* get size of new image */
        int cropped_width = image.getWidth() - 2 * pixels;
        int cropped_height = image.getHeight() - 2 * pixels;
        return image.getSubimage(pixels, pixels, cropped_width, cropped_height);
    }
    public void Println(String s) {
        System.out.println(s);
    }
}
