
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Settings {
    public static int red = 0;
    public static int green = 0;
    public static int blue = 0;
    public static double variance = 0.0;
    public static String file_import = "Enter file name here";
    /// note: it is better practice to access these variables with "getter" and "setter" methods
    public static int GetRed() {return red;}
    public static void SetRed(int set) {red = set; UpdateSettings();};
    public static int GetGreen() {return green;}
    public static void SetGreen(int set) {green = set; UpdateSettings();};
    public static int GetBlue() {return blue;}
    public static void SetBlue(int set) {blue = set; UpdateSettings();}
    public static double GetVariance() {return variance;}
    public static void SetVariance(double set) {variance = set;}
    public static String GetFileImport() {return file_import;}
    public static void SetFileImport(String file_name) {
        file_import = file_name;
        UpdateSettings();
    } 
    public static boolean LoadSettings() {
        boolean load = true;
        try {
            FileReader file = new FileReader("AppleAnalysis_Settings");
            BufferedReader read_settings = new BufferedReader(file);
            String line = "";
            int line_counter = 1;
            while((line = read_settings.readLine()) != null) {
                switch(line_counter) {
                    case 1: 
                        file_import = line;
                        break;
                    case 2:
                        red = Integer.parseInt(line.trim());
                        break;
                    case 3:
                        green = Integer.parseInt(line.trim());
                        break;
                    case 4:
                        blue = Integer.parseInt(line.trim());
                        break;
                        
                }
                line_counter++;
            }
        } catch (IOException e) {
            //Print("Error reading settings file\n");
            load = false;
        }
        return load; /* returns whether "TextManipulator_Settings" was accessed and read */
    }
    /* updates "TextManipulator_Settings" with new values from program - will be run every time the user changes settings */
    public static boolean UpdateSettings() {
        boolean success = true;
        try {
            FileWriter file = new FileWriter("AppleAnalysis_Settings");
            BufferedWriter write_settings = new BufferedWriter(file);
            /* write settings to file (in the correct order), first converting each value to a char and comma-separating them */
            write_settings.write(file_import);
            write_settings.newLine();
            write_settings.write(Integer.toString(red));
            write_settings.newLine();
            write_settings.write(Integer.toString(green));
            write_settings.newLine();
            write_settings.write(Integer.toString(blue));
            write_settings.close();
        } catch(IOException e) {
            //Print("Error writing to file\n");
            success = false;
        }
        return success;
    }

}
