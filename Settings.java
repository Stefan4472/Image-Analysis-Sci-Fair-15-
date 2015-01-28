import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class Settings {
    public static int red = 0;
    public static int green = 0;
    public static int blue = 0;
    public static double variance = 0.0;
    public static String file_import = "Enter file name here";
    //public static Trial[] loaded_trials = new Trial[20];
    //Vector<String> myVector=new Vector<String>(10,2);
    public Vector<Trial> loaded_trials = new Vector<Trial>(0,1);
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
    public static void SetFileImport(String file_name) {file_import = file_name; UpdateSettings();}
    //public static Trial[] GetTrials() {return loaded_trials;};
    public Vector<Trial> GetTrials() {return loaded_trials;}
    public void AddTrial(Trial add) { /* adds trial to vector of trials */
        loaded_trials.addElement(add);
        boolean success = Settings.UpdateTrials();
    }
    public void PrintTrials() {
        for(int i = 0; i < loaded_trials.size(); i++)
            Trial.Println(loaded_trials.get(i));
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
    public boolean LoadTrials() {
        boolean load = true;
        try {
            FileReader file = new FileReader("AppleAnalysis_Trials");
            BufferedReader read_trials = new BufferedReader(file);
            String line = "";
            while((line = read_trials.readLine()) != null) {
                boolean success[] = new boolean[1];
                Trial load_trial = Trial.ReadDataFile(line, success); /* attempts to read
                in trial data */
                if(success[0]) {
                    AddTrial(load_trial); /* add trial to array */
                } 
            }   
        } catch (IOException e) {
            //Print("Error reading settings file\n");
            load = false;
        }
        return load; /* returns whether "TextManipulator_Settings" was accessed and read */
    }
    public boolean UpdateTrials() {
        boolean success = true;
        try {
            FileWriter file = new FileWriter("AppleAnalysis_Trials");
            BufferedWriter write_trials = new BufferedWriter(file);
            /* write settings to file (in the correct order), first converting each value to a char and comma-separating them */
            for(int i = 0; i < loaded_trials.size(); i++) {
                Trial write_trial = loaded_trials.get(i);
                write_trials.write(write_trial.GetFileName()); /* write file name of the trial to file */
                write_trials.newLine();
            }
            write_trials.close();
        } catch(IOException e) {
            //Print("Error writing to file\n");
            success = false;
        }
        return success;
    }

}
