
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Trial {
    public static String file_name;
    public static String trial_name;
    public static Double brightness_change;
    public static int rank;
    
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
            Trial import_trial = new Trial();
            import_trial.SetTrial(file_name, trial_name, brightness_change);
            return import_trial;
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
            //Print("Error writing to file\n");
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
