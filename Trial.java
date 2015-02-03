
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Trial {
    public static String file_name;
    public static String trial_name;
    public static Double brightness_change;
    //public static int rank;
    
    public Trial(String file_name, String trial_name, Double brightness_change) {
        this.file_name = file_name;
        this.trial_name = trial_name;
        this.brightness_change = brightness_change;
    }
    public static void SetTrial(String file, String trial, Double change) {
        file_name = file;
        trial_name = trial;
        brightness_change = change;
    }
    /* methods for setting and getting object attributes */
    public static void SetFileName(String name) {file_name = name;}
    public static String GetFileName() {return file_name;}
    public static void SetTrialName(String name) {trial_name = name;}
    public static String GetTrialName() {return trial_name;}
    public static void SetBrightnessChange(Double change) {brightness_change = change;}
    public static Double GetBrightnessChange() {return brightness_change;}
    public static ArrayList<String> GetArrayList() {
        /*ArrayList<String> trial_data = new ArrayList<>(3);
        trial_data.set(0, file_name);
        trial_data.set(1, trial_name);
        trial_data.set(2, Double.toString(brightness_change)); */
        ArrayList<String> trial_data = new ArrayList<>();
        trial_data.add(file_name);
        trial_data.add(trial_name);
        trial_data.add(Double.toString(brightness_change));
        return trial_data;
    }
    /* prints trial data (for debugging purposes) */
    public static void Print(Trial trial) {
        System.out.print(Trial.GetFileName() + " | " + trial.GetTrialName() + " | " + trial.GetBrightnessChange());
    }
    /* prints trial data (for debugging purposes) */
    public static void Println(Trial trial) {
        System.out.println(trial.GetFileName() + " | " + trial.GetTrialName() + " | " + trial.GetBrightnessChange());
    }
    /* gets trial info from specified file */
    public static Trial ReadDataFile(String file, boolean success[]) {
        success[0] = true;
        file_name = file;
        try {
            FileReader trial = new FileReader(file_name);
            BufferedReader read_trial = new BufferedReader(trial);
            String line = "";
            int line_counter = 1;
            while((line = read_trial.readLine()) != null) {
                switch(line_counter) {
                    case 1: 
                        file_name = line;
                        break;
                    case 2:
                        trial_name = line;
                        break;
                    case 3:
                        brightness_change = Double.parseDouble(line);
                        break;    
                }
                line_counter++;
            }
            System.out.println("Loading trial " + trial_name);
            //Trial import_trial = new Trial(file_name, trial_name, brightness_change);       
            return new Trial(file_name, trial_name, brightness_change);
        } catch (IOException e) {
            //Print("Error reading settings file\n");
            success[0] = false;
        }
        return null; /* unable to import */
    }
    public static boolean WriteTrial(Trial trial) {
        boolean success = true;
        try {
            FileWriter file = new FileWriter(trial.GetFileName());
            BufferedWriter write_data = new BufferedWriter(file);
            /* write settings to file (in the correct order), first converting each value to a char and comma-separating them */
            write_data.write(trial.GetFileName());
            write_data.newLine();
            write_data.write(trial.GetTrialName());
            write_data.newLine();
            write_data.write(Double.toString(trial.GetBrightnessChange()));
            write_data.close();
        } catch(IOException e) {
            //Print("Error writing to file\n");
            success = false;
        }
        return success;
    }
    /* writes trial info to file */
    public static boolean WriteDataFile(String file_name, String trial_name, Double brightness_change) {
        boolean success = true;
        try {
            FileWriter file = new FileWriter(file_name);
            BufferedWriter write_data = new BufferedWriter(file);
            /* write settings to file (in the correct order), first converting each value to a char and comma-separating them */
            write_data.write(file_name);
            write_data.newLine();
            write_data.write(trial_name);
            write_data.newLine();
            write_data.write(Double.toString(brightness_change));
            write_data.close();
        } catch(IOException e) {
            System.out.println("Error writing to file\n");
            success = false;
        }
        return success;
    }
    public static int Compare(Trial compare) {
        int action = 0; /* +1 : move up; 0 : equal; -1 : move down;*/
        if(brightness_change > compare.brightness_change)
            return 1;
        else if(brightness_change < compare.brightness_change)
            return -1;
        else
            return 0;
    }
}
